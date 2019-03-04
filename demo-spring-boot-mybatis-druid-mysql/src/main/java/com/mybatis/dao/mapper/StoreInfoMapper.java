package com.mybatis.dao.mapper;

import com.mybatis.entity.CaSample;
import com.mybatis.entity.StoreInfoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreInfoMapper {
    void batchInsert(List<StoreInfoEntity> list);
}