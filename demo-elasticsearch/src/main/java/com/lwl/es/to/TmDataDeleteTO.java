package com.lwl.es.to;

import lombok.Data;

/**
 * author liuweilong
 * date 2019/8/1 14:20
 * desc
 */
@Data
public class TmDataDeleteTO {
    private Long entityId;
    private Long companyId;
    private Byte dataType;
}
