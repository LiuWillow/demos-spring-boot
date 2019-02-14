package com.generator.mapper;

import com.generator.entry.KeywordOrder;
import com.generator.entry.KeywordOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KeywordOrderMapper {
    int countByExample(KeywordOrderExample example);

    int deleteByExample(KeywordOrderExample example);

    int deleteByPrimaryKey(Integer keywordOrderId);

    int insert(KeywordOrder record);

    int insertSelective(KeywordOrder record);

    List<KeywordOrder> selectByExample(KeywordOrderExample example);

    KeywordOrder selectByPrimaryKey(Integer keywordOrderId);

    int updateByExampleSelective(@Param("record") KeywordOrder record, @Param("example") KeywordOrderExample example);

    int updateByExample(@Param("record") KeywordOrder record, @Param("example") KeywordOrderExample example);

    int updateByPrimaryKeySelective(KeywordOrder record);

    int updateByPrimaryKey(KeywordOrder record);
}