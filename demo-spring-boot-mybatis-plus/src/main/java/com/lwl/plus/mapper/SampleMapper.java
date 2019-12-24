package com.lwl.plus.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lwl.plus.entity.Sample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwl.plus.to.AgePageQueryTO;
import com.lwl.plus.vo.PageVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
public interface SampleMapper extends BaseMapper<Sample> {

    /**
     * 批量插入
     * @param list
     */
    void insertBatch(@Param("list") List<Sample> list);

    /**
     * 分页查询
     * @return
     */
    PageVO<Sample> pageByAge(@Param("queryTO") AgePageQueryTO queryTO);

    /**
     * 分页查询
     * @return
     */
    IPage<Sample> pageByAgeXml(IPage<Sample> iPage, @Param("ageLeft") int ageLeft);
}
