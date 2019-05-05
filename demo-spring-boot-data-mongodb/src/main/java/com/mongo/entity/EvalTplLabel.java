package com.mongo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author wangyuan
 */
@Data
public class EvalTplLabel {
    @NotNull(message = "{eval_tpl_label_not_null}")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long labelId;

    @NotNull(message = "{eval_tpl_label_not_null}")
    private String labelName;

    @Min(value = 0, message = "{default_value_error}")
    @Max(value = 1, message = "{default_value_error}")
    private Byte defaultFlag;
}
