package com.mongo;

import com.mongo.entity.GoodsTest;
import com.mongo.entity.PageModule;

import java.util.Date;

/**
 * @author lwl
 * @date 2018/10/18 16:03
 * @description
 */
public interface MongoService {
    void saveGoodsTest(GoodsTest goodsTest);
    void updateGoodsTestSelective(GoodsTest goodsTest);
    PageModule<GoodsTest> pageGoodsTestByCreateTime(Date createTime, int page, int pageSize);
}