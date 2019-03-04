package com.mybatis.service;

import com.mybatis.dao.mapper.StoreInfoMapper;
import com.mybatis.entity.StoreInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lwl
 * @date 2019/2/23 10:17
 * @description
 */
@Service
public class PerformService {
    @Autowired
    private StoreInfoMapper storeInfoMapper;
    public void push() throws ParseException {
        long userIdBegin = 100050000;
        Date current = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date chargeExpireDate = simpleDateFormat.parse("2020-02-23");
        List<StoreInfoEntity> list = new ArrayList<>();
        for (long userId = userIdBegin; userId <= 100099999; userId++) {
            StoreInfoEntity storeInfoEntity = generateEntity(current, userId, chargeExpireDate);
            list.add(storeInfoEntity);
            if ((userId - userIdBegin + 1) % 5000 == 0){
                storeInfoMapper.batchInsert(list);
                System.out.println("----------------------插入" + (userId - userIdBegin + 1) + "条数据----------");
                list.clear();
            }
        }
        System.out.println("--------------全部插入完成----------------------");
    }

    private StoreInfoEntity generateEntity(Date current, long userId, Date chargeExpireDate) {
        StoreInfoEntity storeInfoEntity = new StoreInfoEntity();
        //店铺id  5000开始
        int storeId = (int) (userId - 100000000);
        storeInfoEntity.setStoreId(storeId);
        //用户id，供应商100050000-100099999
        storeInfoEntity.setUserId(userId);
        storeInfoEntity.setStoreSid(storeId + "perform");
        //userSid CATEST+userId
        storeInfoEntity.setUserSid("CATEST" + userId);
        //企业名称  zhongfei + userId
        storeInfoEntity.setStoreName("zhongfei" + userId);
        //企业名称 zhongfei + userId
        storeInfoEntity.setStoreNameZh("zhongfei" + userId);
        storeInfoEntity.setHomePhotoCount((byte) 0);
        storeInfoEntity.setTransactionAmount("< ￥1,000,000");
        storeInfoEntity.setTransactionAmountPlusedRmb(0L);
        storeInfoEntity.setTransactionAmountDisplayUsd("< $1,000,000");
        storeInfoEntity.setTransactionAmountDisplayRmb("< ￥1,000,000");
        storeInfoEntity.setTransactionAmountRealUsd(0L);
        storeInfoEntity.setTransactionAmountRealRmb(0L);
        storeInfoEntity.setInquiryReplyTimeAvg(0);
        storeInfoEntity.setInquiryReplyPercent("0");
        storeInfoEntity.setStoreScore(0 + "");
        storeInfoEntity.setStoreGoodsPv(0);
        storeInfoEntity.setStorePv(0);
        //qq userId
        storeInfoEntity.setQq(userId + "");
        storeInfoEntity.setStatus((byte) 1);
        storeInfoEntity.setOpenTime(current);
        storeInfoEntity.setCreateTime(current);
        //供应商全为国内（119-中国（China））
        storeInfoEntity.setCountryId(119);
        //供应商全为国内（119-中国（China））
        storeInfoEntity.setCountryName("China");
        //海关认证待定
        storeInfoEntity.setCiqValidated((byte) 1);
        //企业经营的主要产品
        storeInfoEntity.setCorpProduct("");
        //是否开通银联线上
        storeInfoEntity.setIsCp((byte) 1);
        //是否开通银联线下
        storeInfoEntity.setIsCpTt((byte) 1);
        storeInfoEntity.setGoodsReleasedCount(0);
        storeInfoEntity.setCorpLogo("https://ca-files-1256126199.cos.ap-chengdu.myqcloud.com/108022E4FEC5B7BA/2019-01/大宗logo1546498463316.jpg");
        //客户经理
        storeInfoEntity.setCustomerServiceManagerId(1);
        //客户经理用户名
        storeInfoEntity.setCustomerServiceManagerName("admin");
        //统一2020-02-23到期
        storeInfoEntity.setChargeExpiredTime(chargeExpireDate);
        storeInfoEntity.setStatusNotice((byte) 1);
        return storeInfoEntity;
    }
}