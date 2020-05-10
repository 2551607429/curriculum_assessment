package com.zx.common.config.exception;


import com.zx.common.enums.UnicomResponseEnums;

/**
 * @author
 * @title: ParamIsEmptyException
 * @projectName ommup
 * @description: TODO
 * @date 2019/3/2020:06
 */
public class ParamIsEmptyException extends RuntimeException {
    protected String code;

    protected String msg;

    protected String message;

    public ParamIsEmptyException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public ParamIsEmptyException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ParamIsEmptyException() {
        super();
    }

    public ParamIsEmptyException(String message) {
        super(message);
    }

    public ParamIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamIsEmptyException(Throwable cause) {
        super(cause);
    }

    protected ParamIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
