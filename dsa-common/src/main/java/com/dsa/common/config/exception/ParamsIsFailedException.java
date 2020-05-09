package com.dsa.common.config.exception;

import com.dsa.common.enums.UnicomResponseEnums;

/**
 * @author
 * @Title: ParamsIsFailedException
 * @ProjectName ommup-parent
 * @Description: TODO
 * @date 2019/4/25  11:20
 */
public class ParamsIsFailedException extends RuntimeException {

    protected String code;

    protected String msg;

    protected String message;

    public ParamsIsFailedException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public ParamsIsFailedException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ParamsIsFailedException() {
        super();
    }

    public ParamsIsFailedException(String message) {
        super(message);
    }

    public ParamsIsFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamsIsFailedException(Throwable cause) {
        super(cause);
    }

    protected ParamsIsFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
