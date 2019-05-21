package com.lwl.rest.wx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * date  2019/5/21
 * author liuwillow
 **/
public class CheckUtils {
    private static final String TOKEN = "lwltoken";

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }

        MessageDigest md;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmpStr != null && tmpStr.equals(signature.toUpperCase());
    }

    private static String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte aByteArray : byteArray) {
            strDigest.append(byteToHexStr(aByteArray));
        }
        return strDigest.toString();
    }

    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        return new String(tempArr);
    }
}
