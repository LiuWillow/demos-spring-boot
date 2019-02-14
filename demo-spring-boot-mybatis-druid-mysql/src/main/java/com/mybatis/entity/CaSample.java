package com.mybatis.entity;

import lombok.Data;

/**
 * @author lwl
 * @date 2018/10/18 15:53
 * @description
 */
@Data
public class CaSample {
    private Integer id;
    private String nameCn;
    private String nameEn;
    private Byte isUse;
}