package com.lwl.es.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * author liuweilong
 * date 2019/7/26 13:44
 * desc
 */
@Data
@IndexName("my_index")
public class MyIndex {
    @ESType("keyword")
    private String myKeyWord;
    private String myText;
    private Long userId;
    private Date date;
    private Byte status;
    private List<String> pages;
    private List<Long> userIdList;
    private Boolean deleted;
    private Integer flag;
    private List<User> users;
}
