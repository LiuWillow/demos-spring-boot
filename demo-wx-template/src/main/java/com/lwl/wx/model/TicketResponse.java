package com.lwl.wx.model;

import lombok.Data;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/22 13:24
 */
@Data
public class TicketResponse {
    /**
     * 错误码，详情见微信官方文档"
     */
    private int errcode;
    /**
     * 错误信息，详情见微信官方文档
     */
    private String errmsg;
    private String ticket;
    private long expires_in;
}
