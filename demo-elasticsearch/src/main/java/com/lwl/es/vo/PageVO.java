package com.lwl.es.vo;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @auther lwl
 * @date 2019-08-01 11:59
 * @Description 封装分页的数据
 * @Version 1.0
 */

@Data
public class PageVO<T> {
    private Integer pageSize= 10;
    private int pageNo = 1;
    private long total;
    private int pages;
    private List<T> datas;

    public int getPages(){
        if (Objects.nonNull(pages)){
            return pages;
        }
        if (Objects.isNull(pageSize) || pageSize.equals(0L)){
            pageSize = 10;
        }
        Double pageDouble = Math.ceil(total / pageSize * 1.0);
        pages = pageDouble.intValue();
        return pages;
    }
}
