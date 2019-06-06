package com.lwl.common.pool.key;

import lombok.Data;

/**
 * @author liuweilong
 * @description
 * @date 2019/6/6 15:17
 */
@Data
public class KeyDbConnection {
    private Boolean active;
    private String url;
}
