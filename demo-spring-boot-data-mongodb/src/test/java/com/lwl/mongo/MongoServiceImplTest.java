package com.lwl.mongo;

import com.lwl.mongo.entity.GoodsTest;
import com.lwl.mongo.entity.PageModule;
import com.lwl.mongo.service.MongoService;
import com.lwl.mongo.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoServiceImplTest {
    @Autowired
    private MongoService mongoService;
    private String[] words = new String[]{
            "牛仔", "棉", "土司", "裤子", "夹克", "风衣", "外套", "内裤",
            "面条", "蔬菜", "玉米", "北京", "成都", "悠悠球", "奔驰", "中非"
    };

    @Test
    public void testGoodsSave(){
        GoodsTest goodsTest = new GoodsTest();
        goodsTest.setCreateTime(new Date());
        goodsTest.setEndTime(DateUtils.getSpecifiedTimeFromBegin(DateUtils.TYPE_AFTER, 10, goodsTest.getCreateTime()));
        goodsTest.setGoodsName("牛仔夹克");
        goodsTest.setPrice(450.00);
        goodsTest.setStoreId("1");
        goodsTest.setType((byte) 1);
        mongoService.saveGoodsTest(goodsTest);
    }

    @Test
    public void testUpdate(){
        GoodsTest goodsTest = new GoodsTest();
        goodsTest.setId("5bc854eb8bfa53225c874a2b");
        goodsTest.setPrice(11.11);
        mongoService.updateGoodsTestSelective(goodsTest);
    }


    Executor executor = new ThreadPoolExecutor(400, 600, 1000,
            TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
    CountDownLatch countDownLatch = new CountDownLatch(200);

    /**
     * 插入两百万条数据
     * @throws InterruptedException
     */
    @Test
    public void batchSaveGoods() throws InterruptedException {
        for (int i = 0; i < 200; i++){
            Runnable runnable = this::task;
            executor.execute(runnable);
        }
        countDownLatch.await();
    }

    private void task() {
        for (int i = 0; i < 10000; i++){
            GoodsTest goodsTest = new GoodsTest();
            int beforeDays = (int) (Math.random() * 50);
            goodsTest.setCreateTime(DateUtils.getSpecifiedTimeFromNow(DateUtils.TYPE_BEFORE, beforeDays));
            int afterDays = (int) (Math.random() * 40);
            goodsTest.setEndTime(DateUtils.getSpecifiedTimeFromBegin(DateUtils.TYPE_AFTER, afterDays, goodsTest.getCreateTime()));
            String goodsName = words[(int) (Math.random() * (words.length - 1))] + words[(int) (Math.random() * (words.length - 1))]
                    + words[(int) (Math.random() * (words.length - 1))];
            goodsTest.setGoodsName(goodsName);
            goodsTest.setPrice(Math.random() * 800);
            goodsTest.setStoreId((((byte) (Math.random() * 4)) + 1) + "");
            goodsTest.setType((byte) (Math.random() * 5 + 1));
            mongoService.saveGoodsTest(goodsTest);
        }
        countDownLatch.countDown();
    }

    @Test
    public void testPage(){
        long begin = System.currentTimeMillis();
        PageModule<GoodsTest> pageModule = mongoService.pageGoodsTestByCreateTime(new Date(), 1, 200000);
        List<GoodsTest> list = pageModule.getData();
        System.out.println("耗时" + (System.currentTimeMillis() - begin));
        list.forEach(System.out::println);
    }
}