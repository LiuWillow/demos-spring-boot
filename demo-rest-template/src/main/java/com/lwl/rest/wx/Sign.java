package com.lwl.rest.wx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/21 17:44
 */
public class Sign {
    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<>();
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();
        String string1;
        String signature = "";

        // 注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = WxUtils.getSignature(jsapi_ticket, nonceStr, timestamp, url);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonceStr);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    // 生成签名
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    // 生成nonce_str
    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    // 生成timestamp
    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);

    }
}
