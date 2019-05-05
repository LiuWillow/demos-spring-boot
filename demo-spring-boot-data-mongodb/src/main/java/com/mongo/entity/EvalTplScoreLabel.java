package com.mongo.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: wangyuan
 * @Date: 2019/4/11 14:11
 * @description
 */
@Data
public class EvalTplScoreLabel {
    private Byte defaultScore;
    private List<EvalTplLabel> evalTplLabels;
}
