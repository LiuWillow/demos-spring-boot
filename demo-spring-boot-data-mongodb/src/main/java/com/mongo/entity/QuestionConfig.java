package com.mongo.entity;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wangyuan
 */
@Data
public class QuestionConfig {
    @Length(min = 1, max = 100, message = "{question_length_error}")
    private String questionDesc;

    @Max(value = 1, message = "{question_type_error}")
    @Min(value = 0, message = "{question_type_error}")
    private Byte questionType;

    @Size(max = 4, message = "{answer_num_must_less_than_four}")
    private List<AnswerOption> answerOption;
}
