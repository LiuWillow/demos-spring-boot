package com.mybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: ca-store-proj
 * @description: ${description}
 * @author: wangjx
 * @create: 2018-09-08 15:00
 **/
@Data
public class StoreInfoEntity {
    private Integer storeId;
    private Long userId;
    private String storeSid;
    private String userSid;
    private String storeName;
    private String storeNameZh;
    private Byte homePhotoCount;
    private String transactionAmount;
    private Long transactionAmountPlusedRmb;
    private String transactionAmountDisplayRmb;
    private String transactionAmountDisplayUsd;
    private Long transactionAmountRealRmb;
    private Long transactionAmountRealUsd;
    private Integer inquiryReplyTimeAvg;
    private String inquiryReplyPercent;
    private String storeScore;
    private Integer storeGoodsPv;
    private Integer storePv;
    private String qq;
    private Byte status;
    private Date openTime;
    private Date createTime;
    private String productPresentation;
    private Integer countryId;
    private String countryName;
    private Byte ciqValidated;
    private String corpProduct;
    private String payWay;
    private Integer goodsReleasedCount;
    private String corpLogo;
    private Integer customerServiceManagerId;
    private String customerServiceManagerName;
    private Integer operateUserId;
    private String operateUserName;
    private Date operateTime;
    private Date rectifyTimeBegin;
    private Date rectifyTimeEnd;
    private Date chargeExpiredTime;
    private Byte statusNotice;
    private Date noticeSubmitTime;
    private Date noticeBeginTime;
    private Date noticeEndTime;
    private Byte noticeSubmitUserType;
    private Byte isCp;
    private Byte isCpTt;
}
