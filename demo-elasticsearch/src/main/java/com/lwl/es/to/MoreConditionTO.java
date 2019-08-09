package com.lwl.es.to;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * author liuweilong
 * date 2019/7/30 19:14
 * desc 筛选条件
 */
@Data
public class MoreConditionTO {
    private Date begin;
    private Date end;
    private List<Long> contributors;
    private List<Long> zoneIds;
}
