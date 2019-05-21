package com.lwl.rest.wx;

import lombok.Data;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/21 17:29
 */
@Data
public class WxEntity {
    private String accessToken;
    private String ticket;
    private String noncestr;
    private String timestamp;
    private String str;
    private String signature;
}
