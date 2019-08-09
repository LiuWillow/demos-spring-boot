package com.lwl.es.service.impl.strategy;

import com.lwl.es.entity.search.TmData;
import com.lwl.es.service.UpdateStrategy;
import com.lwl.es.to.TmDataInDirectUpdateTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/8/8 17:01
 * desc
 */
@Service("userUpdate")
public class UserStrategyImpl implements UpdateStrategy {
    @Override
    public void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap) {
        queryMap.put(TmData.OWNER_ID, updateTO.getEntityId());
        if (!StringUtils.isEmpty(updateTO.getTitle())) {
            fieldMap.put(TmData.OWNER_USERNAME, updateTO.getTitle());
        }
    }
}
