package com.lwl.rest.wx.model;

import lombok.Data;

/**
 * date  2019/5/21
 * author liuwillow
 **/
@Data
public class WxRequest {
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
}
