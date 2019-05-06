package com.mybatis.dao.mapper;

import com.mybatis.entity.Sample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleMapper {
    @Select("SELCT * FROM sample WHERE id = #{id}")
    Sample getSampleById(@Param("id") Integer id);

    @Insert("INSERT INTO sample (id, name) VALUES (#{sample.id}, #{sample.name})")
    void insertOne(@Param("sample") Sample sample);

    @Update("UPDATE sample set name = #{sample.name} WHERE id = #{sample.id}")
    void updateOne(@Param("sample") Sample sample);
}