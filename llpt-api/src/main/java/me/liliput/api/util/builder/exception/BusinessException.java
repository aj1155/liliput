package me.liliput.api.util.builder.exception;

/**
 * Created by 1002731 on 2017. 1. 4..
 * Email : eenan@sk.com
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}