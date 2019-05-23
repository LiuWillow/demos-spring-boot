package com.lwl.wx.model;

import lombok.Data;

/**
 * date  2019/5/21
 * author liuwillow
 * 微信验证url的时候会发给我们的数据
 **/
@Data
public class WxRequest {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
