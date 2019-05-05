package com.mongo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

/**
 * @author lwl
 * @date 2019/4/8 14:34
 * @description
 */
@Data
public class TemplateForeModel {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long evalTplId;
    private Integer overTime;
    private List<EvalTplScoreLabel> labels;
    private List<QuestionConfig> questionConfigs;
    private Byte contentShowFlag;
    private Byte evalTplStatus;
    private String evalTplContent;
    private Byte defaultScore;
}