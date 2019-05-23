package com.lwl.wx;

import com.lwl.wx.model.WxConfig;
import com.lwl.wx.model.WxRequest;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/22 14:22
 */
public interface WxService {
    /**
     * 根据当前页面的link获取签名、时间戳、随机字符串
     * @param link
     * @return
     */
    WxConfig getWxConfig(String link);

    /**
     * 验证微信发过来的内容，用于token和服务器资源验证
     * @param wxRequest
     * @return
     */
    String validToken(WxRequest wxRequest);
}
