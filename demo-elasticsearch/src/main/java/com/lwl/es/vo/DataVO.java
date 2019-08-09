package com.lwl.es.vo;

import com.lwl.es.entity.search.ESDoc;
import com.lwl.es.entity.search.ESZone;
import com.lwl.es.entity.search.Owner;
import lombok.Data;

import java.util.Date;

/**
 * author liuweilong
 * date 2019/7/31 11:11
 * desc
 */
@Data
public class DataVO {
    private Long entityId;
    private Byte dataType;
    private String title;
    private ESZone zoneBelong;
    private ESDoc docBelong;
    private String content;
    private Owner owner;
    private Date sourceCreateTime;
    private Date sourceUpdateTime;
    private String iconUrl;
}