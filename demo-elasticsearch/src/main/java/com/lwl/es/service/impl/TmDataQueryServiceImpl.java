package com.lwl.es.service.impl;

import com.google.common.collect.Lists;
import com.lwl.es.em.ESDataType;
import com.lwl.es.entity.search.TmData;
import com.lwl.es.service.TmDataQueryService;
import com.lwl.es.to.MoreConditionTO;
import com.lwl.es.to.SearchTO;
import com.lwl.es.util.ESUtils;
import com.lwl.es.vo.DataVO;
import com.lwl.es.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.index.query.functionscore.ScriptScoreFunctionBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/7/31 14:02
 * desc
 */
@Service
@Slf4j
public class TmDataQueryServiceImpl implements TmDataQueryService {
    @Autowired
    private RestHighLevelClient client;

    private static final String HIGHLIGHT_PRE_TAG = "<span style=\"color:#FF5874\">";
    private static final String HIGHLIGHT_POST_TAG = "</span>";
    private static final int FRAGMENT_SIZE = 3;
    private static final int FRAGMENT_NUMBER = 80;
    private static final int MAX_CONTENT_LENGTH = 100;
    private static final String SCORE_SCRIPT = "def maxScore = _score * 2;" +
            "def praiseMax = maxScore * 0.045;" +
            "def browseMax = maxScore * 0.015;" +
            "def favoriteMax = maxScore * 0.075;" +
            "def refMax = maxScore * 0.045;" +
            "def downloadMax = maxScore * 0.015;" +
            "def commentMax = maxScore * 0.03;" +
            "def maxScores = [praiseMax, browseMax, favoriteMax, refMax, downloadMax, commentMax];" +
            "def praiseNum = doc['praiseNum'].value;" +
            "def readNum = doc['readNum'].value;" +
            "def favoriteNum = doc['favoriteNum'].value;" +
            "def refTimes = doc['refTimes'].value;" +
            "def downloadTimes = doc['downloadTimes'].value;" +
            "def childCommentQuantity = doc['childCommentQuantity'].value;" +
            "def originScores = [praiseNum, readNum, favoriteNum, refTimes, downloadTimes, childCommentQuantity];" +
            "for (int i = 0; i < 6; i++) {" +
            "    if (originScores[i] > 0){" +
            "        originScores[i] = Math.log(originScores[i]);" +
            "    }" +
            "    if (originScores[i] > maxScores[i]) {" +
            "        originScores[i] = maxScores[i];" +
            "    }" +
            "}" +
            "def expertMax = maxScore * 0.075;" +
            "def flagExpert = doc['flagExpert'].value;" +
            "def expertScore = 0;" +
            "if (flagExpert == 1) {" +
            "    expertScore = expertMax" +
            "}" +
            "def attentionUserMax = maxScore * 0.086;" +
            "def attentionUserScore = 0;" +
            "def attentionZoneMax = maxScore * 0.086;" +
            "def updateMax = maxScore * 0.028;" +
            "def finalScore = _score;" +
            "for (int i = 0; i < originScores.size(); i++) {" +
            "    finalScore += originScores[i];" +
            "}" +
            "if (finalScore instanceof Double) {" +
            "    if (finalScore < 0){" +
            "        return 0;" +
            "    }" +
            "    return finalScore" +
            "}";

    @Override
    public boolean indexExist(String indexName) {
        GetIndexRequest request = new GetIndexRequest(indexName);
        try {
            return client.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("查询索引是否存在异常", e);
        }
        return false;
    }

    @Override
    public PageVO<DataVO> search(SearchTO searchTO) {
        String keyword = searchTO.getKeyword();
        if (StringUtils.isEmpty(keyword)) {
            keyword = "";
        }

        Long companyId = searchTO.getCompanyId();
        SearchSourceBuilder sourceBuilder = generateSearchSourceBuilder(searchTO, keyword, companyId);

        SearchRequest dataRequest = new SearchRequest();
        dataRequest.indices(TmData.INDEX_NAME);
        dataRequest.source(sourceBuilder);
        dataRequest.routing(companyId.toString());

        try {
            SearchResponse dataResponse = client.search(dataRequest, RequestOptions.DEFAULT);

            SearchHits searchHits = dataResponse.getHits();
            long count = searchHits.getTotalHits().value;
            List<DataVO> dataList = ESUtils.convertHitList(searchHits.getHits(), DataVO.class);
            shortenContent(dataList);
            return generatePageVO(searchTO, count, dataList);
        } catch (IOException e) {
            log.error("搜索发生io异常", e);
        }
        return new PageVO<>();
    }

    private PageVO<DataVO> generatePageVO(SearchTO searchTO, long count, List<DataVO> dataList) {
        PageVO<DataVO> pageVO = new PageVO<>();
        pageVO.setDatas(dataList);
        pageVO.setPageNo(searchTO.getPageNum());
        pageVO.setPageSize(dataList.size());
        pageVO.setTotal(count);
        return pageVO;
    }

    private void shortenContent(List<DataVO> dataList) {
        if (!dataList.isEmpty()) {
            for (DataVO dataVO : dataList) {
                String content = dataVO.getContent();
                if (StringUtils.isEmpty(content) || content.length() < MAX_CONTENT_LENGTH) {
                    continue;
                }
                dataVO.setContent(content.substring(0, MAX_CONTENT_LENGTH));
            }
        }
    }

    private SearchSourceBuilder generateSearchSourceBuilder(SearchTO searchTO, String keyword, Long companyId) {
        ////无论什么请求都要符合的查询条件
        BoolQueryBuilder baseQueryBuilder = generateBaseQueryBuilder(keyword, companyId);
        if (!ESDataType.ALL.getTypeId().equals(searchTO.getDataType())) {
            baseQueryBuilder.must(QueryBuilders.termQuery(TmData.DATA_TYPE, searchTO.getDataType()));
        }

        //注入高级查询条件
        MoreConditionTO moreCondition = searchTO.getMoreCondition();
        injectMoreCondition(baseQueryBuilder, moreCondition);

        //组装评分函数
        ScriptScoreFunctionBuilder scriptFunctionBuilder = ScoreFunctionBuilders.scriptFunction(SCORE_SCRIPT);
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(baseQueryBuilder, scriptFunctionBuilder);
        //设置用评分函数代替es的评分
        functionScoreQueryBuilder.boostMode(CombineFunction.REPLACE);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(functionScoreQueryBuilder);

        highlightSetting(sourceBuilder);

        Integer pageSize = searchTO.getPageSize();
        sourceBuilder.from((searchTO.getPageNum() - 1) * pageSize);
        sourceBuilder.size(pageSize);

        return sourceBuilder;
    }

    private void highlightSetting(SearchSourceBuilder sourceBuilder) {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(TmData.TITLE, FRAGMENT_SIZE, FRAGMENT_NUMBER).preTags(HIGHLIGHT_PRE_TAG).postTags(HIGHLIGHT_POST_TAG);
        highlightBuilder.field(TmData.CONTENT, FRAGMENT_SIZE, FRAGMENT_NUMBER).preTags(HIGHLIGHT_PRE_TAG).postTags(HIGHLIGHT_POST_TAG);
        sourceBuilder.highlighter(highlightBuilder);
    }

    private void injectMoreCondition(BoolQueryBuilder baseQueryBuilder, MoreConditionTO moreCondition) {
        if (Objects.isNull(moreCondition)) {
            log.debug("用户没有过滤条件");
            return;
        }
        Date begin = moreCondition.getBegin();
        Date end = moreCondition.getEnd();

        injectDateCondition(baseQueryBuilder, begin, end);

        List<Long> contributors = moreCondition.getContributors();
        injectContributorsCondition(baseQueryBuilder, contributors);

        List<Long> zoneIds = moreCondition.getZoneIds();
        injectZoneIdCondition(baseQueryBuilder, zoneIds);
    }

    private void injectZoneIdCondition(BoolQueryBuilder baseQueryBuilder, List<Long> zoneIds) {
        if (CollectionUtils.isEmpty(zoneIds)) {
            return;
        }
        BoolQueryBuilder zoneIdBuilder = QueryBuilders.boolQuery();
        // 文档/评论/附件类型，过滤所属空间，  空间/手册/成员类型，直接匹配entityId
        List<Byte> firstTypeList = Lists.newArrayList(ESDataType.DOC.getTypeId(), ESDataType.COMMENT.getTypeId(),
                ESDataType.APPENDIX.getTypeId());
        zoneIdBuilder.should(QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery(TmData.DATA_TYPE, firstTypeList))
                .must(QueryBuilders.termsQuery(TmData.ZONE_BELONG_ID, zoneIds)));

        List<Byte> secondTypeList = Lists.newArrayList(ESDataType.ZONE.getTypeId(), ESDataType.MANUAL.getTypeId(),
                ESDataType.USER.getTypeId());
        zoneIdBuilder.should(QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery(TmData.DATA_TYPE, secondTypeList))
                .must(QueryBuilders.termsQuery(TmData.ENTITY_ID, zoneIds)));

        baseQueryBuilder.must(zoneIdBuilder);
    }

    private void injectDateCondition(BoolQueryBuilder baseQueryBuilder, Date begin, Date end) {
        BoolQueryBuilder dateQuery = QueryBuilders.boolQuery();
        if (Objects.nonNull(begin)) {
            dateQuery.must(QueryBuilders.rangeQuery(TmData.DATA_CREATE_TIME).gte(begin.getTime()));
            dateQuery.must(QueryBuilders.rangeQuery(TmData.DATA_UPDATE_TIME).gte(begin.getTime()));
        }
        if (Objects.nonNull(end)) {
            dateQuery.must(QueryBuilders.rangeQuery(TmData.DATA_CREATE_TIME).lte(end.getTime()));
            dateQuery.must(QueryBuilders.rangeQuery(TmData.DATA_UPDATE_TIME).lte(end.getTime()));
        }
        baseQueryBuilder.must(dateQuery);
    }

    private void injectContributorsCondition(BoolQueryBuilder baseQueryBuilder, List<Long> contributors) {
        if (CollectionUtils.isEmpty(contributors)) {
            return;
        }
        BoolQueryBuilder contributorBuilder = QueryBuilders.boolQuery();

        //文档、手册匹配贡献者，空间、个人空间、评论、文件都匹配创建者
        List<Byte> firstTypeList = Lists.newArrayList(ESDataType.DOC.getTypeId(), ESDataType.MANUAL.getTypeId());
        contributorBuilder.should(QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery(TmData.DATA_TYPE, firstTypeList))
                .must(QueryBuilders.termsQuery(TmData.CONTRIBUTORS, contributors)));

        List<Byte> secondTypeList = Lists.newArrayList(ESDataType.ZONE.getTypeId(), ESDataType.USER.getTypeId(),
                ESDataType.COMMENT.getTypeId(), ESDataType.APPENDIX.getTypeId());
        contributorBuilder.should(QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery(TmData.DATA_TYPE, secondTypeList))
                .must(QueryBuilders.termsQuery(TmData.CREATOR_ID, contributors)));

        baseQueryBuilder.must(contributorBuilder);
    }

    private void injectAuthorityCondition(BoolQueryBuilder baseQueryBuilder, List<Long> departmentIds,
                                          List<Long> positionIdList, List<Long> userGroupIds, Long loginUserId) {
        BoolQueryBuilder whiteIdQueryBuilder = QueryBuilders.boolQuery();
        if (!CollectionUtils.isEmpty(departmentIds)) {
            departmentIds.forEach(departmentId -> whiteIdQueryBuilder.should(QueryBuilders.termQuery(TmData.WHITE_DEPARTMENT_ID_LIST, departmentId)));
        } else {
            log.warn("当前用户 {} 没有部门信息", loginUserId);
        }
        if (!CollectionUtils.isEmpty(positionIdList)) {
            positionIdList.forEach(positionId -> whiteIdQueryBuilder.should(QueryBuilders.termQuery(TmData.WHITE_POSITION_ID_LIST, positionId)));
        } else {
            log.warn("当前用户 {} 没有职位信息", loginUserId);
        }
        if (!CollectionUtils.isEmpty(userGroupIds)) {
            userGroupIds.forEach(userGroupId -> whiteIdQueryBuilder.should(QueryBuilders.termQuery(TmData.WHITE_USER_GROUP_ID_LIST, userGroupId)));
        } else {
            log.warn("当前用户 {} 没有用户组信息", loginUserId);
        }
        whiteIdQueryBuilder.should(QueryBuilders.termQuery(TmData.WHITE_USER_ID_LIST, loginUserId));

        baseQueryBuilder.must(whiteIdQueryBuilder);
    }

    private BoolQueryBuilder generateBaseQueryBuilder(String keyword, Long companyId) {
        return QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery(TmData.COMPANY_ID, companyId))
                .must(QueryBuilders.boolQuery()
                        .should(QueryBuilders.matchQuery(TmData.TITLE, keyword).boost(2))
                        .should(QueryBuilders.matchQuery(TmData.CONTENT, keyword).boost(1)));
    }
}
