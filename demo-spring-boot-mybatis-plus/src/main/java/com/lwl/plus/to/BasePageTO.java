package com.lwl.plus.to;

import lombok.Data;

/**
 * author liuweilong
 * date 2019/12/24 2:19 下午
 * desc
 */
@Data
public class BasePageTO {
    /**
     * 查询第几页，默认第一页
     */
    private int page = 1;
    /**
     * 每一页返回的数量，默认10
     */
    private int pageSize = 10;

    /**
     * 是否需要count，默认true
     */
    private boolean needCount = true;
}
