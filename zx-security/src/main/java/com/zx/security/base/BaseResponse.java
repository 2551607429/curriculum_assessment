package com.zx.security.base;

/**
 * API接口的基础返回类
 */
public class BaseResponse<T> {
    /**
     * 是否成功0成功 -1失败
     */
    private Integer code;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T token;

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T token) {
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getToken() {
        return token;
    }

    public void setToken(T token) {
        this.token = token;
    }

}
