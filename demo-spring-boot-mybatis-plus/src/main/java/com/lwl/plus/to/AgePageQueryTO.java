package com.lwl.plus.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author liuweilong
 * date 2019/12/24 2:23 下午
 * desc
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AgePageQueryTO extends BasePageTO{
    /**
     * 查询大于该年龄的记录
     */
    private Integer ageLeft;
}
