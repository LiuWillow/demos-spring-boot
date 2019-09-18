package com.lwl.es.service.impl.strategy;

import com.lwl.es.entity.search.ESData;
import com.lwl.es.service.UpdateStrategy;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * author liuweilong
 * date 2019/8/8 17:01
 * desc
 */
@Service("userUpdate")
public class UserStrategyImpl implements UpdateStrategy {
    @Override
    public void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap) {
        queryMap.put(ESData.OWNER_ID, updateTO.getEntityId());
        if (!StringUtils.isEmpty(updateTO.getTitle())) {
            fieldMap.put(ESData.OWNER_USERNAME, updateTO.getTitle());
        }
    }
}
