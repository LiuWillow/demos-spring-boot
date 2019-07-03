package com.lwl.mybatis.multi.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.function.Supplier;

/**
 * @author liuweilong
 * @description
 * @date 2019/7/2 14:57
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<DataSourceType> DATA_SOURCE_TYPE_HOLDER = ThreadLocal.withInitial(() -> DataSourceType.MASTER);

    /**
     * type作为map的key，动态判断使用哪一种
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DATA_SOURCE_TYPE_HOLDER.get();
    }

    public static void setMaster(){
        DATA_SOURCE_TYPE_HOLDER.set(DataSourceType.MASTER);
    }

    public static void setSlave(){
        DATA_SOURCE_TYPE_HOLDER.set(DataSourceType.SLAVE);
    }

    public static DataSourceType getType(){
        return DATA_SOURCE_TYPE_HOLDER.get();
    }

    public static enum DataSourceType{
        MASTER, SLAVE
    }
}
