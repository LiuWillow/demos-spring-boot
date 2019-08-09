package com.lwl.es.entity.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author liuweilong
 * date 2019/7/31 16:22
 * desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ESDoc {
    private Long docId;
    private String docTitle;
}
