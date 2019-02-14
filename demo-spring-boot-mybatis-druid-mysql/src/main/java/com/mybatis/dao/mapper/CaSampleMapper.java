package com.mybatis.dao.mapper;

import com.mybatis.entity.CaSample;
import org.springframework.stereotype.Repository;

@Repository
public interface CaSampleMapper {
    CaSample getSampleById(Integer id);
}