package com.lwl.es.service;

import com.lwl.es.to.SearchTO;
import com.lwl.es.vo.DataVO;
import com.lwl.es.vo.PageVO;

/**
 * author liuweilong
 * date 2019/7/31 11:50
 * desc
 */
public interface TmDataQueryService {
    /**
     * 查询索引是否存在
     * @param indexName
     * @return
     */
    boolean indexExist(String indexName);
    /**
     * 根据关键词和条件查询
     * @param request
     * @return
     */
    PageVO<DataVO> search(SearchTO request);
}
