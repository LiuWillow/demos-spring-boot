package com.lwl.es.controller;

import com.lwl.es.entity.Owner;
import com.lwl.es.entity.TestData;
import com.lwl.es.entity.Zone;
import com.lwl.es.service.IndexOperateService;
import com.lwl.es.service.IndexQueryService;
import com.lwl.es.service.TmDataOperateService;
import com.lwl.es.util.SnowFlakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * author liuweilong
 * date 2019/7/26 11:46
 * desc
 */
@RestController
@Slf4j
public class ESController {
    private static final String[] TITLE_CANDIDATES = new String[]{
            "周杰伦", "日报", "超人", "强子", "唱歌", "跳", "rap", "1.8",
            "22", "interesting", "v", "淘宝", "中台", "日志", "研究",
            "调研", "2019.07.22", "从前", "有一个人", "的", "关于", "蔡徐坤",
            "电竞选手"
    };
    private static final String[] CONTENT_CANDIDATES = new String[]{
            "周杰伦喜欢喝奶茶", "日报写的很烂", "这是一个表格, ", "超人不会飞", "强子", "，", "唱歌", "跳", "rap", "1.8",
            "22", "interesting", "，", "v", "淘宝", "中台", "日志", "研究", "！",
            "调研", "2019.07.22", "从前", "！", "有一个人", "的", "？", "跟京东有关的这件事", "蔡徐坤",
            "电竞选手油贼爱好像出了一点问题", "？", "他说：哈哈哈哈哈你可真牛逼", "撞色啊上都这里至少有一万字计算机两地分居黑黑的风格",
            "有一个姑娘他的是的会计分录家螺丝刀lk", "刘德华的小弟弟了深刻的解放路几毛钱玩儿二儿童如图", "东软集团索拉卡大姐夫里就开始代理费啊",
            "索拉卡大姐夫落实到家乐福口红为伍尔特", "！", "。"
    };
    public static final List<Zone> ZONE_CANDIDATES = new ArrayList<>(11);

    public static final long[] COMPANY_CANDIDATES = new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L, 13L};

    static {
        ZONE_CANDIDATES.add(new Zone(1L, "成都牛逼空间"));
        ZONE_CANDIDATES.add(new Zone(2L, "亦可赛艇哈哈"));
        ZONE_CANDIDATES.add(new Zone(3L, "淘宝空间"));
        ZONE_CANDIDATES.add(new Zone(4L, "艾比邻空间"));
        ZONE_CANDIDATES.add(new Zone(5L, "英雄联盟团队"));
        ZONE_CANDIDATES.add(new Zone(6L, "从前从前有一个人爱你很久的空间"));
        ZONE_CANDIDATES.add(new Zone(7L, "有趣的空间"));
        ZONE_CANDIDATES.add(new Zone(8L, "蔡徐坤的空间"));
        ZONE_CANDIDATES.add(new Zone(9L, "电竞选手的空间"));
        ZONE_CANDIDATES.add(new Zone(10L, "周杰伦的qq空间"));
        ZONE_CANDIDATES.add(new Zone(11L, "阿里达摩团队"));
    }

    public static final List<Owner> OWNER_CANDIDATES = new ArrayList<>(8);

    static {
        OWNER_CANDIDATES.add(new Owner(1L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(2L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(3L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(4L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(5L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(6L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(7L, null, null, null, null));
        OWNER_CANDIDATES.add(new Owner(8L, null, null, null, null));
    }

    public static final List<Long> LIST = new ArrayList<>();

    static {
        LIST.add(1L);
        LIST.add(2L);
        LIST.add(3L);
        LIST.add(4L);
        LIST.add(5L);
        LIST.add(6L);
        LIST.add(7L);
        LIST.add(8L);
        LIST.add(9L);
        LIST.add(10L);
        LIST.add(11L);
        LIST.add(12L);
    }

    @Autowired
    private IndexOperateService indexOperateService;
    @Autowired
    private IndexQueryService indexQueryService;
    @Autowired
    private TmDataOperateService tmDataOperateService;

    @GetMapping("/create/index")
    public String createIndex() {
        indexOperateService.create(TestData.class);
        return "success";
    }

    @GetMapping("/put/mapping")
    public String putMapping() {
        indexOperateService.putMapping(TestData.class);
        return "success";
    }

    @GetMapping("/delete/{indexName}")
    public String deleteIndex(@PathVariable("indexName") String indexName) {
        indexOperateService.delete(indexName);
        return "success";
    }

    @GetMapping("/insert/batch")
    public String insertBatch(Integer count) {
        if (count > 100000) {
            for (int i = 100000; i < count; i += 100000) {
                List<TestData> list = generateTmDataList(100000);
                tmDataOperateService.insertBatch(list);
                log.info("成功插入{}条数据", i);
            }
            log.info("全部插入完成");
            return "success";
        }
        List<TestData> list = generateTmDataList(count);
        tmDataOperateService.insertBatch(list);
        log.info("全部插入完成");
        return "success";
    }

    private List<TestData> generateTmDataList(int count) {
        List<TestData> tmDataList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            TestData tmData = new TestData();
            tmData.setCompanyId(COMPANY_CANDIDATES[new Random().nextInt(13)]);
            tmData.setEntityId(SnowFlakeIdWorker.getInstance().nextId());
            Random random = new Random();
            tmData.setDataType((byte) (random.nextInt(6) + 1));
            tmData.setTitle(generateRandomTitle(6));
            tmData.setZoneBelong(ZONE_CANDIDATES.get(random.nextInt(11)));
            tmData.setContent(generateRandomContent(20));
            tmData.setOwner(OWNER_CANDIDATES.get(random.nextInt(8)));
            tmData.setPraiseCount((long) (random.nextInt(100) + 20));
            tmData.setWhiteDepartmentIdList(generateRandomIdList(4));
            tmData.setWhiteUserGroupIdList(generateRandomIdList(1));
            tmData.setWhiteUserIdList(generateRandomIdList(7));

            tmData.setDataCreateTime(generateRandomDate(300));
            tmData.setDataUpdateTime(tmData.getDataCreateTime());
            tmData.setSourceCreateTime(generateRandomDate(288));
            tmData.setSourceUpdateTime(tmData.getSourceCreateTime());
            tmData.setBrowseTimes(generateInt(200, 20000));
            tmData.setCollectTimes(generateInt(20, 400));
            tmData.setFlagExpert(generateInt(0, 2).byteValue());
            tmData.setRefTimes(generateInt(10, 50));
            tmData.setDownloadTimes(generateInt(0, 50));
            tmData.setChildCommentQuantity(generateInt(0, 10));
            tmData.setChildCommentQuantity(generateInt(0, 10));

            tmDataList.add(tmData);
        }
        return tmDataList;
    }

    private Integer generateInt(int min, int max) {
        return new Random().nextInt(max) + min;
    }

    private Date generateRandomDate(int maxDistanceDays) {
        LocalDateTime now = LocalDateTime.now();
        int randomDistanceDays = new Random().nextInt(maxDistanceDays);
        LocalDateTime resultDateTime;
        if (randomDistanceDays % 2 == 0) {
            resultDateTime = now.plusDays(randomDistanceDays);
        } else {
            resultDateTime = now.minusDays(randomDistanceDays);
        }
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = resultDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }

    private List<Long> generateRandomIdList(int maxCount) {
        Random random = new Random();
        int listCount = random.nextInt(maxCount);
        if (listCount == 0) {
            return Collections.emptyList();
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < listCount; i++) {
            list.add(LIST.get(random.nextInt(12)));
        }
        return list;
    }

    private String generateRandomTitle(int maxLength) {
        int titleLength = new Random().nextInt(maxLength) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        int length = TITLE_CANDIDATES.length;
        for (int i = 0; i < titleLength; i++) {
            int random = new Random().nextInt(length);
            stringBuilder.append(TITLE_CANDIDATES[random]);
        }
        return stringBuilder.toString();
    }

    private String generateRandomContent(int maxLength) {
        int titleLength = new Random().nextInt(maxLength) + 1;
        StringBuilder stringBuilder = new StringBuilder();
        int length = CONTENT_CANDIDATES.length;
        for (int i = 0; i < titleLength; i++) {
            int random = new Random().nextInt(length);
            stringBuilder.append(CONTENT_CANDIDATES[random]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(6) + 1);
        }
    }
}
