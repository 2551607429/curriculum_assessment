package com.zx.config;


/**
 * 系统级错误
 * 错误范围0-999
 *
 * 通用错误
 * 错误范围1000-1999
 */
public class ErrorNumberSystem {
	
	public static final String PARAMETERS_ERROR_NUMBER="900";

    public enum ERROR_ENUM implements IUtilErrorNumberEnum {

        //=============系统级错误=================
        SUCCESS(1, "操作成功","error.number.success"),
        ERROR(0, "操作失败","error.number.error"),
        SUCCESS_DATA_NULL(5, "操作成功,暂无数据","error.number.success.data.null"),
        ERROR_SYSTEM(10, "系统严重错误","error.number.system.error"),
        ERROR_NOT(50, "未知错误","error.number.not.error"),
        PARAMETERS_ERROR(Integer.parseInt(PARAMETERS_ERROR_NUMBER), "必须参数错误或缺失","error.number.parameter.error"),
        PARAMETERS_TYPE_ERROR(910, "参数类型错误","error.number.parameter.type.error"),

        //==============通用错误=========================
        PAGE_DATA_NULL(840, "查无符合要求数据",""), // 分页数据为空
        NOT_POWER(850, "无权限操作",""),
        NOT_LOGIN(860, "未登录",""),
        DATA_VERSION_ERROR(890, "数据版本无法解析",""),
        DATA_VERSION_PARSE_ERROR(895,"数据无法解析,与版本无法匹配",""),
        NOT_BH_ACCOUNT(800,"无补货账号",""),




        ;

        private String msg;
        private int eid;
        private String locale;

        private ERROR_ENUM(int eid, String msg,String locale) {
            this.eid = eid;
            this.msg = msg;
            this.locale=locale;
        }

        public String getMsg() {
            return this.msg;
        }

        public int getErrorId() {
            return this.eid;
        }

        public String getLocale(){
            return this.locale;
        }

    }
}
