package com.lwl.es_spring.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;
import java.util.List;

/**
 * author liuweilong
 * date 2019/7/31 18:49
 * desc
 */
@Data
@Document(indexName = "es_data", shards = 3, replicas = 2)
public class ESData {
    public static final String INDEX_NAME = "tm_data";
    public static final String ENTITY_ID = "entityId";
    public static final String CONTENT = "content";
    public static final String TITLE = "title";
    public static final String ICON_URL = "icon_url";
    public static final String DATA_CREATE_TIME = "dataCreateTime";
    public static final String DATA_UPDATE_TIME = "dataUpdateTime";
    public static final String COMPANY_ID = "companyId";
    public static final String DATA_TYPE = "dataType";
    public static final String WHITE_DEPARTMENT_ID_LIST = "whiteDepartmentIdList";
    public static final String WHITE_USER_GROUP_ID_LIST = "whiteUserGroupIdList";
    public static final String WHITE_USER_ID_LIST = "whiteUserIdList";
    public static final String WHITE_POSITION_ID_LIST = "whitePositionIdList";
    public static final String CONTRIBUTORS = "contributors";
    public static final String CREATOR_ID = "owner.userId";
    public static final String ZONE_BELONG_ID = "zoneBelong.zoneId";
    public static final String DOC_BELONG_TITLE = "docBelong.docTitle";
    public static final String FLAG_EXPERT = "flagExpert";
    public static final String SOURCE_UPDATE_TIME = "sourceUpdateTime";
    public static final String PRAISE_NUM = "praiseNum";
    public static final String READ_NUM = "readNum";
    public static final String FAVORITE_NUM = "favoriteNum";
    public static final String REF_TIMES = "refTimes";
    public static final String DOWNLOAD_TIMES = "downloadTimes";
    public static final String CHILD_COMMENT_QUANTITY = "childCommentQuantity";
    public static final String OWNER_USERNAME = "owner.username.";
    public static final String ZONE_BELONG_NAME = "zoneBelong.zoneName";
    public static final String OWNER_ID = "owner.userId";
    public static final String DOC_BELONG_ID = "docBelong.docId";
    public static final String OWNER_DEPARTMENT_ID = "owner.departmentList.departmentId";
    public static final String OWNER_DEPARTMENT_NAME = "owner.departmentList.departmentName";
    public static final String OWNER_POSITION_ID = "owner.positionList.positionId";
    public static final String OWNER_POSITION_NAME = "owner.positionList.positionName";

    private Long companyId;
    private Long entityId;
    private Byte dataType;
    @Field()
    private String title;
    private String iconUrl;
    private String content = "";
    private List<Long> contributors;
    private List<Long> whiteDepartmentIdList;
    private List<Long> whitePositionIdList;
    private List<Long> whiteUserGroupIdList;
    private List<Long> whiteUserIdList;
    private Date dataCreateTime;
    private Date dataUpdateTime;
    private Date sourceCreateTime;
    private Date sourceUpdateTime;
    private Long praiseNum = 0L;
    private Long readNum = 0L;
    private Long favoriteNum = 0L;
    private Byte flagExpert = 0;
    private Long refTimes = 0L;
    private Long downloadTimes = 0L;
    private Long childCommentQuantity = 0L;

    public static void main(String[] args) {
        Thread thread = new Thread();
    }
}
