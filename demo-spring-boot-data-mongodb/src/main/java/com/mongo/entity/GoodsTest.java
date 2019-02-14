package com.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author lwl
 * @date 2018/10/18 16:27
 * @description
 */
@Data
public class GoodsTest {
    @Id
    private String id;
    private String goodsName;
    private Date createTime;
    private Date endTime;
    private String storeId;
    private Double price;
    private Byte type;
}