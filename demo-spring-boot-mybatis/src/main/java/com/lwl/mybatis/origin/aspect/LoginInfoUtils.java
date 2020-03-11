package com.lwl.mybatis.origin.aspect;

/**
 * author liuweilong
 * date 2020/3/11 11:40 下午
 * desc
 */
public class LoginInfoUtils {
    private static ThreadLocal<String> currentDomain = new ThreadLocal<>();

    public static void setDomain(String domain) {
        currentDomain.set(domain);
    }

    public static void release() {
        currentDomain.remove();
    }

    public static String getDomain(){
        return currentDomain.get();
    }
}
