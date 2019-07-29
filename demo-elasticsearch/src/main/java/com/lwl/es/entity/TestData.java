package com.lwl.es.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * author liuweilong
 * date 2019/7/26 18:49
 * desc
 */
@ESIndex("test_data")
@Data
public class TestData {
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 该条记录对应的数据库实体id，如文档id，空间id
     */
    private Long entityId;
    /**
     * 数据类型 1 文档  2 空间  3 手册  4 成员 5 评论 6 附件
     */
    private Byte dataType;
    /**
     * 文档标题/空间名称/手册名称/成员名称/附件名称/评论未定
     */
    private String title;
    /**
     * 文档/手册/评论  属于哪个空间
     */
    private Zone zoneBelong;
    /**
     * 数据内容  文档内容/空间描述/手册描述/成员描述/
     */
    private String content;
    /**
     * 拥有者个人信息
     */
    private Owner owner;
    /**
     * 点赞数
     */
    private Long praiseCount;
    /**
     * 部门id白名单
     */
    private List<Long> whiteDepartmentIdList;
    /**
     * 用户组白名单
     */
    private List<Long> whiteUserGroupIdList;
    /**
     * 用户白名单
     */
    private List<Long> whiteUserIdList;
    /**
     * es创建时间
     */
    private Date dataCreateTime;
    /**
     * es更新时间
     */
    private Date dataUpdateTime;
    /**
     * 源数据创建时间
     */
    private Date sourceCreateTime;
    /**
     * 源数据更新时间
     */
    private Date sourceUpdateTime;
    /**
     * 浏览量
     */
    private Integer browseTimes;
    /**
     * 收藏次数
     */
    private Integer collectTimes;
    /**
     * 是否是专家参与贡献的文档，1 专家参与了贡献  0 没有专家参与
     */
    private Byte flagExpert;
    /**
     * 收录次数
     */
    private Integer refTimes;
    /**
     * 附件下载次数
     */
    private Integer downloadTimes;
    /**
     * 评论的子评论数量
     */
    private Integer childCommentQuantity;
}
