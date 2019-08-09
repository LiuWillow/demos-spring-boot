package com.lwl.es.service.impl.strategy;

import com.lwl.es.entity.search.TmData;
import com.lwl.es.service.UpdateStrategy;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/8/8 17:01
 * desc
 */
@Service("departmentUpdate")
public class DepartmentStrategyImpl implements UpdateStrategy {
    @Override
    public void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap) {
        //更新部门的名字
        queryMap.put(TmData.OWNER_DEPARTMENT_ID, updateTO.getEntityId());
        fieldMap.put(TmData.OWNER_DEPARTMENT_NAME, updateTO.getTitle());
    }
}
