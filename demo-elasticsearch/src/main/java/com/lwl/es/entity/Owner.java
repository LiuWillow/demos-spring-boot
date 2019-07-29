package com.lwl.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author liuweilong
 * date 2019/7/27 10:14
 * desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    /**
     * 拥有者id
     */
    private Long userId;
    /**
     * 拥有者用户名
     */
    private String username;
    /**
     * 拥有者所属部门
     */
    private List<Department> departmentList;
    /**
     * 职位id
     */
    private Long positionId;
    /**
     * 职位名
     */
    private String positionName;
}
