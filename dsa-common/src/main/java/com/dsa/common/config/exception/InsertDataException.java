package com.dsa.common.config.exception;

import com.dsa.common.enums.UnicomResponseEnums;

/**
 * @author
 * @title: InsertDataException
 * @projectName ommup
 * @description: 插入数据库异常
 * @date 2019/3/2113:27
 */
public class InsertDataException extends RuntimeException {

    protected String code;

    protected String msg;

    protected String message;

    public InsertDataException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public InsertDataException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public InsertDataException() {
        super();
    }

    public InsertDataException(String message) {
        super(message);
    }

    public InsertDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertDataException(Throwable cause) {
        super(cause);
    }

    protected InsertDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
