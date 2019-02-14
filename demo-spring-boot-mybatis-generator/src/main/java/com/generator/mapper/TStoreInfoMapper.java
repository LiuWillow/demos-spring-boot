package com.generator.mapper;

import com.generator.entry.TStoreInfo;
import com.generator.entry.TStoreInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoreInfoMapper {
    int countByExample(TStoreInfoExample example);

    int deleteByExample(TStoreInfoExample example);

    int deleteByPrimaryKey(Integer storeId);

    int insert(TStoreInfo record);

    int insertSelective(TStoreInfo record);

    List<TStoreInfo> selectByExample(TStoreInfoExample example);

    TStoreInfo selectByPrimaryKey(Integer storeId);

    int updateByExampleSelective(@Param("record") TStoreInfo record, @Param("example") TStoreInfoExample example);

    int updateByExample(@Param("record") TStoreInfo record, @Param("example") TStoreInfoExample example);

    int updateByPrimaryKeySelective(TStoreInfo record);

    int updateByPrimaryKey(TStoreInfo record);
}