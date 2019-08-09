package com.lwl.es.entity.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * author liuweilong
 * date 2019/7/31 10:14
 * desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private Long userId;
    private Long ownerZoneId;
    private String username;
    private List<ESDepartment> departmentList;
    private List<ESPosition> positionList;
}
