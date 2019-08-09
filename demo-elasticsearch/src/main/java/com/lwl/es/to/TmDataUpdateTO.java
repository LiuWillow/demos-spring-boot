package com.lwl.es.to;

import lombok.Data;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/8/8 11:03
 * desc
 */
@Data
public class TmDataUpdateTO {
    private Long companyId;
    private Map<String, Object> modifyFields;
    private Map<String, Object> queryFields;
}
