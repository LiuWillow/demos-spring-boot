package com.lwl.mybatis.origin.mapper;

import com.lwl.mybatis.origin.entity.Sample;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwl
 * @since 2019-12-01
 */
public interface SampleMapper{
    /**
     * 根据id查询
     * @param id
     * @return
     */
    Sample findById(@Param("id") Long id);

    /**
     * 根据id随便更新一下
     * @param id
     */
//    @Transactional
    void updateById(Long id);
}
