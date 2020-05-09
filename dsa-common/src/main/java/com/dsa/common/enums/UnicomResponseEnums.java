package com.dsa.common.enums;

/**
 * @author
 * @title: UnicomResponseEnums
 * @projectName ommup
 * @description: TODO
 * @date 2019/2/2816:07
 */
public enum UnicomResponseEnums {
    /**
     * agree
     */
    SYSTEM_ERROR("-001", "系统异常"),
    SUCCESS("200", "请求成功！"),
    /**
     * agree
     */
    BAD_REQUEST("-002", "错误的请求参数"),
    NOT_FOUND("-003", "找不到请求路径！"),
    /**
     * agree
     */
    METHOD_NOT_ALLOWED("-005", "不合法的请求方式"),
    /**
     * agree
     */
    CONNECTION_ERROR("-004","网络连接请求失败！"),
    /**
     * agree
     */
    DATABASE_ERROR("-004", "数据库异常"),
    /**
     * agree
     */
    BOUND_STATEMENT_NOT_FOUNT("-006", "找不到方法！"),
    /**
     * agree
     */
    REPEAT_REGISTER("001", "重复注册"),
    /**
     * agree
     */
    NO_USER_EXIST("002", "用户不存在"),
    INVALID_PASSWORD("003", "密码错误"),
    NO_PERMISSION("004", "非法请求！"),
    SUCCESS_OPTION("005", "操作成功！"),
    NOT_MATCH("-007", "用户名和密码不匹配"),
    FAIL_GETDATA("-008", "获取信息失败"),
    BAD_REQUEST_TYPE("-009", "错误的请求类型"),
    REPEAT_DATA("-010", "重复的数据"),
    NO_RECORD("016", "没有查到相关记录"),
    LOGIN_SUCCESS("017", "登录成功"),
    LOGOUT_SUCCESS("018", "已退出登录"),
    EDITPWD_SUCCESS("020", "修改密码成功"),
    No_FileSELECT("021", "未选择文件"),
    FILEUPLOAD_SUCCESS("022", "上传成功"),
    NOLOGIN("023", "未登录或登录已失效"),
    UNAUTHORIZED("401", "token 不匹配"),
    ILLEGAL_ARGUMENT("024", "参数不合法"),
    HEADER_ERROR("025", "错误的HTTP请求"),
    UPDATE_DATA("036", "更新数据失败");


    private String code;
    private String msg;

    private UnicomResponseEnums(String code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
