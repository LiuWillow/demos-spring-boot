package com.generator.entry;

import java.util.Date;

public class TStoreCollect {
    private Long collectId;

    private Long userId;

    private Integer storeId;

    private String storeName;

    private Byte langType;

    private Date createTime;

    private Integer sGroupId;

    private Date updateTime;

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Byte getLangType() {
        return langType;
    }

    public void setLangType(Byte langType) {
        this.langType = langType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getsGroupId() {
        return sGroupId;
    }

    public void setsGroupId(Integer sGroupId) {
        this.sGroupId = sGroupId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}