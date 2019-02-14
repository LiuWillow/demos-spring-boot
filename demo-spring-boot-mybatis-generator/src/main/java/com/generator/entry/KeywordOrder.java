package com.generator.entry;

import java.util.Date;

public class KeywordOrder {
    private Integer keywordOrderId;

    private String keywordOrderSid;

    private String keywordBasicSid;

    private Integer ranking;

    private String orderSn;

    private Date orderTime;

    private Date effectiveTimeBegin;

    private Date effectiveTimeEnd;

    private Integer effectiveDuration;

    private Integer gid;

    private Boolean status;

    private Long unitPrice;

    private Long totalMoney;

    private Long totalPayMoney;

    private Integer currency;

    private Long userId;

    private Long mainUserId;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private Integer platform;

    private Boolean isDelete;

    public Integer getKeywordOrderId() {
        return keywordOrderId;
    }

    public void setKeywordOrderId(Integer keywordOrderId) {
        this.keywordOrderId = keywordOrderId;
    }

    public String getKeywordOrderSid() {
        return keywordOrderSid;
    }

    public void setKeywordOrderSid(String keywordOrderSid) {
        this.keywordOrderSid = keywordOrderSid == null ? null : keywordOrderSid.trim();
    }

    public String getKeywordBasicSid() {
        return keywordBasicSid;
    }

    public void setKeywordBasicSid(String keywordBasicSid) {
        this.keywordBasicSid = keywordBasicSid == null ? null : keywordBasicSid.trim();
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getEffectiveTimeBegin() {
        return effectiveTimeBegin;
    }

    public void setEffectiveTimeBegin(Date effectiveTimeBegin) {
        this.effectiveTimeBegin = effectiveTimeBegin;
    }

    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }

    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }

    public Integer getEffectiveDuration() {
        return effectiveDuration;
    }

    public void setEffectiveDuration(Integer effectiveDuration) {
        this.effectiveDuration = effectiveDuration;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Long getTotalPayMoney() {
        return totalPayMoney;
    }

    public void setTotalPayMoney(Long totalPayMoney) {
        this.totalPayMoney = totalPayMoney;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMainUserId() {
        return mainUserId;
    }

    public void setMainUserId(Long mainUserId) {
        this.mainUserId = mainUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}