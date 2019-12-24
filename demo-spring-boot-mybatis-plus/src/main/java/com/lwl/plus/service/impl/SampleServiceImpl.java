package com.lwl.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.plus.entity.Sample;
import com.lwl.plus.mapper.SampleMapper;
import com.lwl.plus.service.SampleService;
import com.lwl.plus.to.AgePageQueryTO;
import com.lwl.plus.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public PageVO<Sample> pageByAge(AgePageQueryTO queryTO) {
        IPage<Sample> pageParam = new Page<>(queryTO.getPage(), queryTO.getPageSize());
        IPage<Sample> pageResult = sampleMapper.selectPage(pageParam, new QueryWrapper<Sample>().lambda()
                .ge(Sample::getAge, queryTO.getAgeLeft()));
        return PageVO.wrapper(pageResult);
    }

    @Override
    public PageVO<Sample> pageByAgeCustom(AgePageQueryTO queryTO) {
        return sampleMapper.pageByAge(queryTO);
    }

    @Override
    public PageVO<Sample> pageByAgeXml(AgePageQueryTO queryTO) {
        IPage<Sample> pageParam = new Page<>(queryTO.getPage(), queryTO.getPageSize());
        IPage<Sample> pageResult = sampleMapper.pageByAgeXml(pageParam, queryTO.getAgeLeft());
        return PageVO.wrapper(pageResult);
    }

    @Override
    public void insertBatch(List<Sample> list) {
        sampleMapper.insertBatch(list);
    }
}