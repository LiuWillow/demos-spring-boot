package com.mongo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author wangyuan
 */
@Data
public class AnswerOption {
    @Length(max = 40, message = "{answer_length_error}")
    private String answer;

    private Byte defaultFlag = 0;
}
