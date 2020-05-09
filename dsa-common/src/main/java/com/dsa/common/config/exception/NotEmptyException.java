package com.dsa.common.config.exception;

import com.dsa.common.enums.UnicomResponseEnums;

/**
 * @author GUOJIKANG
 * @Title:
 * @ClassName NotEmptyException
 * @Description: TODO
 * @date 2019/5/28  9:00
 * @Version 1.0
 */
public class NotEmptyException extends RuntimeException {

    protected String code;

    protected String msg;

    protected String message;

    public NotEmptyException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public NotEmptyException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public NotEmptyException() {
        super();
    }

    public NotEmptyException(String message) {
        super(message);
    }

    public NotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEmptyException(Throwable cause) {
        super(cause);
    }

    protected NotEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
