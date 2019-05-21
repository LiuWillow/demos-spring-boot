package com.lwl.rest.wx;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/21 17:47
 */
public class WxUtils {
    public static String getSignature(String jsapiTicket, String nonceStr, String timestamp, String url) {
        // 注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
                + url;

        String signature = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return signature;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

}
