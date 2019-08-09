package com.lwl.es.em;

/**
 * author liuweilong
 * date 2019/7/31 10:57
 * desc
 */
public enum ESUpdateType {
    ZONE((byte) 1, "空间（个人空间、非个人空间、手册都属于空间）", "zoneUpdate"),
    USER((byte) 2, "用户（更新用户名或部门、职位信息）", "userUpdate"),
    DOC((byte) 3, "文档", "docUpdate"),
    DEPARTMENT((byte) 4, "部门名称改变", "departmentUpdate"),
    POSITION((byte) 5, "职位名称改变", "positionUpdate");

    ESUpdateType(Byte typeId, String typeDesc, String strategy) {
        this.typeId = typeId;
        this.typeDesc = typeDesc;
        this.strategy = strategy;
    }

    public Byte getTypeId() {
        return typeId;
    }

    public void setTypeId(Byte typeId) {
        this.typeId = typeId;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    private Byte typeId;
    private String typeDesc;
    private String strategy;

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
