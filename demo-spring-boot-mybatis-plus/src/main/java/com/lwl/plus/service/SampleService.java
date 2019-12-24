package com.lwl.plus.service;

import com.lwl.plus.entity.Sample;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lwl.plus.to.AgePageQueryTO;
import com.lwl.plus.to.BasePageTO;
import com.lwl.plus.vo.PageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
public interface SampleService {
    /**
     * 分页查询 用mybatisPlus的方式
     */
    PageVO<Sample> pageByAge(AgePageQueryTO queryTO);

    /**
     * 分页查询 自己的方式
     */
    PageVO<Sample> pageByAgeCustom(AgePageQueryTO queryTO);

    /**
     * 分页查询 用mybatisPlus xml的方式
     * @param queryTO
     * @return
     */
    PageVO<Sample> pageByAgeXml(AgePageQueryTO queryTO);

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(List<Sample> list);
}
