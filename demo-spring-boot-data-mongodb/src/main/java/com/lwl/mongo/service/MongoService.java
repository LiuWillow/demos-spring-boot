package com.lwl.mongo.service;

import com.lwl.mongo.code.CommonConstants;
import com.lwl.mongo.code.MongoCollections;
import com.lwl.mongo.code.TemplateConstants;
import com.lwl.mongo.entity.EvaluateTemplateEntity;
import com.lwl.mongo.entity.GoodsTest;
import com.lwl.mongo.entity.PageModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author lwl
 * @date 2018/10/18 16:04
 * @description
 */
@Service
public class MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加或更新
     * @param goodsTest
     */
    public void saveGoodsTest(GoodsTest goodsTest) {
        mongoTemplate.save(goodsTest);
    }

    /**
     * 选择更新
     * @param goodsTest
     */
    public void updateGoodsTestSelective(GoodsTest goodsTest) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(goodsTest.getId()));
        Update update = new Update();
        if (goodsTest.getCreateTime() != null){
            update.set("createTime", goodsTest.getCreateTime());
        }
        if (goodsTest.getEndTime() != null){
            update.set("endTime", goodsTest.getEndTime());
        }
        if (goodsTest.getGoodsName() != null){
            update.set("goodsName", goodsTest.getGoodsName());
        }
        if (goodsTest.getPrice() != null){
            update.set("price", goodsTest.getPrice());
        }
        if (goodsTest.getStoreId() != null){
            update.set("storeId", goodsTest.getStoreId());
        }
        if (goodsTest.getType() != null){
            update.set("type", goodsTest.getType());
        }
        mongoTemplate.updateFirst(query, update, GoodsTest.class);
    }

    /**
     * 分页
     * @param createTime
     * @param page
     * @param pageSize
     * @return
     */
    public PageModule<GoodsTest> pageGoodsTestByCreateTime(Date createTime, int page, int pageSize) {
        Query query = new Query();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        Criteria criteria = Criteria.where("createTime").lt(createTime);
        query.addCriteria(criteria);
//        query.with(Sort.by(Sort.Order.asc("createTime")));
        List<GoodsTest> list = mongoTemplate.find(query, GoodsTest.class);
        PageModule<GoodsTest> pageModule = new PageModule<>();
        pageModule.setCurrentPage(page);
        pageModule.setCurrentCount(list.size());
        pageModule.setData(list);
        return pageModule;
    }

    /**
     * 匹配数组元素
     * @param businessId
     * @param now
     * @param countryId
     * @param roleId
     * @return
     */
    public List<EvaluateTemplateEntity> listTplEntity(Long businessId, Date now, Integer countryId, Integer roleId) {
        Criteria finalCriteria = new Criteria();
        Criteria criteria1Strategies = getStrategiesCriteria(countryId, roleId);
        Criteria baseCriteria = Criteria.where("businessId").is(businessId).and("effectiveTimeBegin").lte(now).and("effectiveTimeEnd").gte(now).and("isDelete").is(CommonConstants.NOT_DELETE);

        finalCriteria.andOperator(baseCriteria, criteria1Strategies);
        Query query = Query.query(finalCriteria);
        return mongoTemplate.find(query, EvaluateTemplateEntity.class,
                MongoCollections.EVALUATE_TEMPLATE);
    }

    private Criteria getStrategiesCriteria(Integer countryId, Integer roleId) {
        Criteria matchCountry = Criteria.where("deliveryStrategies").elemMatch(Criteria.where("deliveryStrategyType").is(CommonConstants.DELIVERY_STRATEGY_PLACE)
                .and("deliveryStrategyValues.deliveryStrategyValueId").is(countryId));
        Criteria matchRole = Criteria.where("deliveryStrategies").elemMatch(Criteria.where("deliveryStrategyType").is(CommonConstants.DELIVERY_STRATEGY_ROLE)
                .and("deliveryStrategyValues.deliveryStrategyValueId").is(roleId));

        Criteria strategiesAllMatch = new Criteria().andOperator(matchCountry, matchRole);

        Criteria strategiesEmpty = Criteria.where("deliveryStrategies").is(Collections.emptyList());

        Criteria strategiesSingle = getSingleStrategyCriteria(matchCountry, matchRole);

        return new Criteria().orOperator(strategiesAllMatch, strategiesEmpty, strategiesSingle);
    }

    private Criteria getSingleStrategyCriteria(Criteria matchCountry, Criteria matchRole) {
        Criteria allAreaRoleOnly = new Criteria().andOperator(Criteria.where("deliveryStrategies").elemMatch(
                Criteria.where("deliveryStrategyType").is(TemplateConstants.DELIVERY_STRATEGY_TYPE_AREA)
                        .and("deliveryStrategyValues").size(0)),
                matchRole);

        Criteria allRoleAreaOnly = new Criteria().andOperator(Criteria.where("deliveryStrategies").elemMatch(
                Criteria.where("deliveryStrategyType").is(TemplateConstants.DELIVERY_STRATEGY_TYPE_ROLE)
                        .and("deliveryStrategyValues").size(0)),
                matchCountry);

        return new Criteria().orOperator(allAreaRoleOnly, allRoleAreaOnly);
    }
}