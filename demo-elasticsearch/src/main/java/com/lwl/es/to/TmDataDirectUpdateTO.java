package com.lwl.es.to;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * author liuweilong
 * date 2019/8/8 15:34
 * desc
 */
@Data
public class TmDataDirectUpdateTO{
    private Long companyId;
    private Long entityId;
    private Byte dataType;
    private String title;
    private String iconUrl;
    private String content;
    private List<Long> contributors;
    private Byte flagExpert;
    private Date sourceUpdateTime;
    private List<Long> whiteDepartmentIdList;
    private List<Long> whitePositionIdList;
    private List<Long> whiteUserGroupIdList;
    private List<Long> whiteUserIdList;
    private Long praiseNum;
    private Long readNum;
    private Long favoriteNum;
    private Long refTimes;
    private Long downloadTimes;
    private Long childCommentQuantity;
}
