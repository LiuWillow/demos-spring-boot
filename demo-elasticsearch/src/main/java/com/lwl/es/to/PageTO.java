package com.lwl.es.to;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @auther lwl
 * @date 2019-07-18 11:24
 * @Description
 * @Version 1.0
 */
@Data
@Valid
public class PageTO {

    @NotNull
    @Min(1)
    protected Integer pageNum = 1;
    @NotNull
    @Min(1)
    protected Integer pageSize = 10;
}
