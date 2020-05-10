package com.zx.common.enums;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * @author
 * @title: ResponseBean
 * @projectName ommup
 * @description: 统一返回格式
 * @date 2019/2/2816:05
 */
@JsonSerialize
public class ResponseBean<T> {
    private String code;
    private T data;
    private String msg;
    private boolean success = true;


    public ResponseBean(){}

    public ResponseBean(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseBean(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public ResponseBean( boolean success,String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public ResponseBean(boolean success, UnicomResponseEnums enums) {
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
