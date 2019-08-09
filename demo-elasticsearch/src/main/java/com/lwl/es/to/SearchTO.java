package com.lwl.es.to;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * author liuweilong
 * date 2019/7/30 19:13
 * desc
 */
@Data
public class SearchTO extends PageTO{
    private String keyword;
    @Min(0)
    @Max(6)
    @NotNull
    private Byte dataType;
    private MoreConditionTO moreCondition;
    private Long companyId;
}
