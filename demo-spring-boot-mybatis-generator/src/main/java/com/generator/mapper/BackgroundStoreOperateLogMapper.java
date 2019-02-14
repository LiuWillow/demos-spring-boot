package com.generator.mapper;

import com.generator.entry.BackgroundStoreOperateLog;
import com.generator.entry.BackgroundStoreOperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BackgroundStoreOperateLogMapper {
    int countByExample(BackgroundStoreOperateLogExample example);

    int deleteByExample(BackgroundStoreOperateLogExample example);

    int deleteByPrimaryKey(Integer operateId);

    int insert(BackgroundStoreOperateLog record);

    int insertSelective(BackgroundStoreOperateLog record);

    List<BackgroundStoreOperateLog> selectByExample(BackgroundStoreOperateLogExample example);

    BackgroundStoreOperateLog selectByPrimaryKey(Integer operateId);

    int updateByExampleSelective(@Param("record") BackgroundStoreOperateLog record, @Param("example") BackgroundStoreOperateLogExample example);

    int updateByExample(@Param("record") BackgroundStoreOperateLog record, @Param("example") BackgroundStoreOperateLogExample example);

    int updateByPrimaryKeySelective(BackgroundStoreOperateLog record);

    int updateByPrimaryKey(BackgroundStoreOperateLog record);
}