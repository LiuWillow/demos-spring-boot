package com.mongo;

import com.mongo.entity.GoodsTest;
import com.mongo.entity.PageModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author lwl
 * @date 2018/10/18 16:04
 * @description
 */
@Service
public class MongoServiceImpl implements MongoService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveGoodsTest(GoodsTest goodsTest) {
        mongoTemplate.save(goodsTest);
    }

    @Override
    public void updateGoodsTestSelective(GoodsTest goodsTest) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(goodsTest.getId()));
        Update update = new Update();
        if (goodsTest.getCreateTime() != null){
            update.set("createTime", goodsTest.getCreateTime());
        }
        if (goodsTest.getEndTime() != null){
            update.set("endTime", goodsTest.getEndTime());
        }
        if (goodsTest.getGoodsName() != null){
            update.set("goodsName", goodsTest.getGoodsName());
        }
        if (goodsTest.getPrice() != null){
            update.set("price", goodsTest.getPrice());
        }
        if (goodsTest.getStoreId() != null){
            update.set("storeId", goodsTest.getStoreId());
        }
        if (goodsTest.getType() != null){
            update.set("type", goodsTest.getType());
        }
        mongoTemplate.updateFirst(query, update, GoodsTest.class);
    }

    @Override
    public PageModule<GoodsTest> pageGoodsTestByCreateTime(Date createTime, int page, int pageSize) {
        Query query = new Query();
        query.skip((page - 1) * pageSize);
        query.limit(pageSize);
        Criteria criteria = Criteria.where("createTime").lt(createTime);
        query.addCriteria(criteria);
//        query.with(Sort.by(Sort.Order.asc("createTime")));
        List<GoodsTest> list = mongoTemplate.find(query, GoodsTest.class);
        PageModule<GoodsTest> pageModule = new PageModule<>();
        pageModule.setCurrentPage(page);
        pageModule.setCurrentCount(list.size());
        pageModule.setData(list);
        return pageModule;
    }
}