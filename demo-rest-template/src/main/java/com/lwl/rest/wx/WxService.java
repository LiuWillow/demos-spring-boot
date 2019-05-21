package com.lwl.rest.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/21 17:29
 */
@Service
public class WxService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String ACCESS_TOKE_CACHE_KEY = "wx:access:token";
    /**
     * 两小时过期，但是考虑到网络延迟，过期时间减掉10分钟
     */
    private static final long EXPIRE = 3600 * 1000 * 2 - 60 * 1000 * 10;

    @Value("${wx.appID}")
    private String appID;
    @Value("${wx.appsecret}")
    private String appsecret;

    public WxEntity getWinXinEntity(String url) {
        WxEntity wx = new WxEntity();
        String accessToken = getAccessToken();
        String ticket = getTicket(accessToken);
        Map<String, String> ret = Sign.sign(ticket, url);
        wx.setTicket(ret.get("jsapi_ticket"));
        wx.setSignature(ret.get("signature"));
        wx.setNoncestr(ret.get("nonceStr"));
        wx.setTimestamp(ret.get("timestamp"));
        return wx;
    }

    private String getAccessToken() {
        String accessToken = redisTemplate.opsForValue().get(ACCESS_TOKE_CACHE_KEY);
        if (!StringUtils.isEmpty(accessToken)){
            return accessToken;
        }
        //获取access_token填写client_credential
        String grantType = "client_credential";
        //这个url链接地址和参数皆不能变
        //访问链接
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=" + grantType + "&appid=" + appID + "&secret=" + appsecret;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = requestEntity.getBody();
        System.out.println(body);
        //TODO 解析返回的accessToken
        accessToken = "";
        redisTemplate.opsForValue().set(ACCESS_TOKE_CACHE_KEY, accessToken, EXPIRE);

        return accessToken;
    }


    private String getTicket(String accessToken) {
        String ticket = null;
        // 这个url链接和参数不能变
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?accessToken=" + accessToken + "&type=jsapi";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        System.out.println(responseEntity.getBody());
        return null;
    }
}