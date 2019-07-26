package com.lwl.es.controller;

import com.lwl.es.entity.MyIndex;
import com.lwl.es.service.IndexOperateServiceImpl;
import com.lwl.es.service.IndexQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * author liuweilong
 * date 2019/7/26 11:46
 * desc
 */
@RestController
public class ESController {
    @Autowired
    private IndexOperateServiceImpl indexOperateService;
    @Autowired
    private IndexQueryService indexQueryService;

    @GetMapping("/create/index")
    public String createIndex(){
        indexOperateService.create(MyIndex.class);
        return "success";
    }

    @GetMapping("/put/mapping/{indexName}")
    public String putMapping(@PathVariable("indexName") String indexName){
        indexOperateService.putMapping(MyIndex.class, indexName);
        return "success";
    }

    @GetMapping("/delete/{indexName}")
    public String deleteIndex(@PathVariable("indexName") String indexName){
        indexOperateService.delete(indexName);
        return "success";
    }
}
