package com.lwl.elsatic.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;

/**
 * @author liuweilong
 * @date 2021/3/22
 * @description
 */
@Slf4j
public class Job1 implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                log.info("分片0---------");
                break;
            case 1:
                // do something by sharding item 1
                log.info("分片1---------");
                break;
            case 2:
                log.info("分片2---------");
                // do something by sharding item 2
                break;
            // case n: ...
        }
    }
}
