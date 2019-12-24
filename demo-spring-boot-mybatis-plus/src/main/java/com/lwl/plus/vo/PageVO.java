package com.lwl.plus.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * author liuweilong
 * date 2019/12/24 2:20 下午
 * desc
 */
@Data
public class PageVO<T> {
    /**
     * 数据
     */
    private List<T> dataList;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页面的记录总数
     */
    private int currentPageCount;

    public static <T> PageVO<T> wrapper(IPage<T> pageResult){
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setDataList(pageResult.getRecords());
        pageVO.setCurrentPageCount(pageResult.getRecords().size());
        pageVO.setTotalPage((int) pageResult.getPages());
        return pageVO;
    }
}
