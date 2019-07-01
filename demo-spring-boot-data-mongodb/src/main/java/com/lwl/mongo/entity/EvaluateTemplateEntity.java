package com.lwl.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 评价模板
 * @author wangyuan
 * @date 2019-04-08 10:59:41
 */
@Data
@Document
public class EvaluateTemplateEntity {
    /**
     * 评价模板id
     */
    @Id
    private Long evalTplId;

    /**
     * 评价模板名称
     */
    private String evalTplName;

    /**
     * 评价模板说明
     */
    private String evalTplDesc;

    /**
     * 评价模板关联业务
     */
    private Long businessId;
    /**
     * 评价模板分数
     */
    private Byte score;

    /**
     * 评价模板分数是否展示：1展示；0不展示
     */
    private Byte scoreShowFlag;

    /**
     * 评价模板默认分数
     */
    private Byte defaultScore;

    /**
     * 评价模板标签： 分数和标签（包含标签 id 和标签名称）
     */
    private List<EvalTplScoreLabel> labels;

    /**
     * 评价模板标签是否展示：1展示；0不展示
     */
    private Byte labelShowFlag;

    /**
     * 评价模板描述
     */
    private String evalTplContent;

    /**
     * 评价模板描述是否展示：1展示；0不展示
     */
    private Byte contentShowFlag;

    /**
     * 评价模板问题配置
     */
    private List<QuestionConfig> questionConfigs;

    /**
     * 评价模板问题是否展示：1展示；0不展示
     */
    private Byte questionShowFlag;

    /**
     * 投放策略 {key:投放策略类型：0 地区；1 角色;value:地区角色列表
     */
    private List<DeliveryStrategy> deliveryStrategies;

    /**
     * 生效起始时间
     */
    private Date effectiveTimeBegin;

    /**
     * 生效截至时间
     */
    private Date effectiveTimeEnd;

    /**
     * 评价超时时间，单位小时，最多七天
     */
    private Integer overTime;

    /**
     * 状态：1 启用；0 禁用
     */
    private Byte evalTplStatus;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建人名称
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人id
     */
    private Integer modifyUserId;

    /**
     * 修改人名称
     */
    private String modifyUserName;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 删除标识：1删除；0未删除
     */
    private Byte isDelete = 0;
}
