package com.lwl.es.em;

/**
 * author liuweilong
 * date 2019/7/31 10:57
 * desc
 */
public enum ESDataType {
    ALL((byte) 0, "全部"),
    DOC((byte) 1, "文档"),
    ZONE((byte) 2, "空间"),
    MANUAL((byte) 3, "手册"),
    USER((byte) 4, "成员"),
    COMMENT((byte) 5, "评论"),
    APPENDIX((byte) 6, "附件");

    ESDataType(Byte typeId, String typeDesc) {
        this.typeId = typeId;
        this.typeDesc = typeDesc;
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
}
