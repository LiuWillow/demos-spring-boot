package com.generator.mapper;

import com.generator.entry.TStoreCollect;
import com.generator.entry.TStoreCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoreCollectMapper {
    int countByExample(TStoreCollectExample example);

    int deleteByExample(TStoreCollectExample example);

    int deleteByPrimaryKey(Long collectId);

    int insert(TStoreCollect record);

    int insertSelective(TStoreCollect record);

    List<TStoreCollect> selectByExample(TStoreCollectExample example);

    TStoreCollect selectByPrimaryKey(Long collectId);

    int updateByExampleSelective(@Param("record") TStoreCollect record, @Param("example") TStoreCollectExample example);

    int updateByExample(@Param("record") TStoreCollect record, @Param("example") TStoreCollectExample example);

    int updateByPrimaryKeySelective(TStoreCollect record);

    int updateByPrimaryKey(TStoreCollect record);
}