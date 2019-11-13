package com.lwl.shardingsphere.vo;

import lombok.Data;

/**
 * author liuweilong
 * date 2019/11/12 17:54
 * desc
 */
@Data
public class Response<T> {
    public static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_MSG = "success";
    private String msg;
    private int code;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        response.setData(data);
        return response;
    }
    public static <T> Response<T> success() {
        return success(null);
    }
}
