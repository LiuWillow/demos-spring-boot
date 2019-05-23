package com.lwl.wx.service;

import com.alibaba.fastjson.JSONObject;
import com.lwl.wx.model.AccessTokenResponse;
import com.lwl.wx.model.TicketResponse;
import com.lwl.wx.model.WxConfig;
import com.lwl.wx.model.WxRequest;
import com.lwl.wx.util.CheckUtils;
import com.lwl.wx.util.WxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/22 14:24
 */
@Service
@Slf4j
public class WxServiceImpl implements WxService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String ACCESS_TOKE_CACHE_KEY = "access:token";
    /**
     * 根据微信文档，获取access_token时，grant_type固定为该值
     */
    private static final String GRANT_TYPE = "client_credential";
    /**
     * 两小时过期，但是考虑到网络延迟和微信辣鸡文档，设置过期时间为一小时
     */
    private static final long EXPIRE = 3600 * 1000;
    private static final String ACCESS_TOKEN_REQ_BASE_URL = "https://api.weixin.qq.com/cgi-bin/token";
    private static final String TICKET_BASE_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";


    @Value("${wx.appID}")
    private String appID;
    @Value("${wx.appsecret}")
    private String appsecret;
    @Value("${wx.token}")
    private String token;

    @Override
    public WxConfig getWxConfig(String link) {
        String accessToken = getAccessToken();
        String ticket = getTicket(accessToken);
        return WxUtils.getConfig(ticket, link);
    }

    @Override
    public String validToken(WxRequest request) {
        System.out.println("请求进入");
        log.info("token验证请求进入");
        if (request == null){
            log.error("request参数为空");
            return "error";
        }
        String signature = request.getSignature();
        String timestamp = request.getTimestamp();
        String nonce = request.getNonce();
        String echostr = request.getEchostr();
        log.info("signature为{}，timestamp为{}，nonce为{}，echostr为{}", signature, timestamp, nonce, echostr);
        boolean success = CheckUtils.checkSignature(signature, timestamp, nonce, token);
        if (success){
            return echostr;
        }
        return "";
    }

    /**
     * 根据appid和secret获取access_token，顺便缓存
     */
    private String getAccessToken() {
        String accessToken = redisTemplate.opsForValue().get(ACCESS_TOKE_CACHE_KEY);
        if (!StringUtils.isEmpty(accessToken)){
            return accessToken;
        }
        log.info("accessToken已过期，正在重新获取");

        //这个url链接地址和参数皆不能变
        //访问链接
        String accessTokenUrl = generateAccessTokenUrl();
        HttpEntity<String> requestEntity = generateHttpEntity();
        ResponseEntity<String> responseEntity = restTemplate.exchange(accessTokenUrl, HttpMethod.GET, requestEntity, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (!HttpStatus.OK.equals(statusCode)){
            log.error("获取accessToken异常");
            return "";
        }

        String body = responseEntity.getBody();
        AccessTokenResponse tokenResponse = JSONObject.parseObject(body, AccessTokenResponse.class);
        accessToken = tokenResponse.getAccess_token();
        if (!StringUtils.isEmpty(accessToken)){
            log.info("token获取成功");
            redisTemplate.opsForValue().set(ACCESS_TOKE_CACHE_KEY, accessToken, EXPIRE, TimeUnit.MILLISECONDS);
        }
        return accessToken;
    }

    private HttpEntity<String> generateHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        return new HttpEntity<>(null, headers);
    }

    private String generateAccessTokenUrl() {
        return ACCESS_TOKEN_REQ_BASE_URL
                + "?grant_type=" + GRANT_TYPE
                + "&appid=" + appID
                + "&secret=" + appsecret;
    }


    private String getTicket(String accessToken) {
        // 这个url链接和参数不能变
        String url = generateTicketUrl(accessToken);

        HttpEntity<String> requestEntity = generateHttpEntity();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        if (!HttpStatus.OK.equals(statusCode)){
            log.error("请求ticket异常");
            return "";
        }
        String body = responseEntity.getBody();
        TicketResponse ticketResponse = JSONObject.parseObject(body, TicketResponse.class);
        return ticketResponse.getTicket();
    }

    private String generateTicketUrl(String accessToken) {
        return TICKET_BASE_URL + "?access_token=" + accessToken + "&type=jsapi";
    }
}
