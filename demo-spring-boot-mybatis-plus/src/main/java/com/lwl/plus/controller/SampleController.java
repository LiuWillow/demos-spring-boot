package com.lwl.plus.controller;


import com.lwl.plus.entity.Sample;
import com.lwl.plus.service.SampleService;
import com.lwl.plus.to.AgePageQueryTO;
import com.lwl.plus.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lwl
 * @since 2019-07-01
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @GetMapping("page")
    public PageVO<Sample> pageSample(AgePageQueryTO queryTO){
        return sampleService.pageByAge(queryTO);
    }

    @GetMapping("page/custom")
    public PageVO<Sample> pageSampleCustom(AgePageQueryTO queryTO){
        return sampleService.pageByAgeCustom(queryTO);
    }
    @GetMapping("page/xml")
    public PageVO<Sample> pageSampleXml(AgePageQueryTO queryTO){
        return sampleService.pageByAgeXml(queryTO);
    }
}
