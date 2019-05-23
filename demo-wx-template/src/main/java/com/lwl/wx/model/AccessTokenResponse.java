package com.lwl.wx.model;

import lombok.Data;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/22 11:46
 * 请求access_token时返回的内容
 */
@Data
public class AccessTokenResponse {
    private String access_token;
    private long expires_in;
}
