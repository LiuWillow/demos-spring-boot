package com.lwl.plus.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lwl.plus.entity.Lalal;
import com.lwl.plus.mapper.LalalMapper;
import com.lwl.plus.service.ILalalService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
@Service
public class LalalServiceImpl extends ServiceImpl<LalalMapper, Lalal> implements ILalalService {
    @Autowired
    private LalalMapper lalalMapper;

    @Override
    public void updateByCondition() {
        Lalal lalal = new Lalal();
        lalal.setAge(1);
        //前面的实体用于更新
        //后面的wrapper是查询条件
        lalalMapper.update(lalal, new UpdateWrapper<Lalal>().lambda().eq(Lalal::getName, "lwl"));
    }
}
