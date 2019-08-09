package com.lwl.es.to;

import com.lwl.es.em.ESUpdateType;
import com.lwl.es.entity.search.ESDepartment;
import com.lwl.es.entity.search.ESPosition;
import lombok.Data;

import java.util.List;

/**
 * author liuweilong
 * date 2019/8/8 16:19
 * desc TmData间接相关更新实体
 */
@Data
public class TmDataInDirectUpdateTO {
    private Long companyId;
    private Long entityId;
    private String title;
    private List<ESDepartment> departmentList;
    private List<ESPosition> positionList;
    private ESUpdateType updateType;
}
