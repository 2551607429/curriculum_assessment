package com.dsa.common.config.exception;


import com.dsa.common.enums.UnicomResponseEnums;

/**
 * @author
 * @Title: DeleteDataException
 * @ProjectName ommup
 * @Description: 删除失败异常类
 * @date 2019/3/26  20:18
 */
public class DeleteDataException extends RuntimeException {
    protected String code;

    protected String msg;

    protected String message;

    public DeleteDataException(UnicomResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public DeleteDataException(UnicomResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public DeleteDataException() {
        super();
    }

    public DeleteDataException(String message) {
        super(message);
    }

    public DeleteDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteDataException(Throwable cause) {
        super(cause);
    }

    protected DeleteDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
