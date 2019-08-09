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
@Service("zoneUpdate")
public class ZoneStrategyImpl implements UpdateStrategy {
    @Override
    public void generateUpdateMap(TmDataInDirectUpdateTO updateTO, Map<String, Object> queryMap, Map<String, Object> fieldMap) {
        queryMap.put(TmData.ZONE_BELONG_ID, updateTO.getEntityId());
        //更新zoneBelong的名字
        fieldMap.put(TmData.ZONE_BELONG_NAME, updateTO.getTitle());
    }
}
