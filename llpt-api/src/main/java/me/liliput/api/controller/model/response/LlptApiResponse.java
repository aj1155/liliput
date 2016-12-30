package me.liliput.api.controller.model.response;

/**
 * Created by 1002731 on 2016. 12. 30..
 * Email : eenan@sk.com
 */
public class LlptApiResponse<T> {
    //Common
    public static final Integer OK = 200;

    public static final Integer INVALID_USERPASSWORD = 1002;
    public static final Integer INVALID_COOKIE = 1003;

    public static final Integer EXCEPTION = 3001;
    public static final Integer NOT_FOUND_RECOMMENDATION = 3002;
    public static final Integer INVALID_STATUS = 3003;

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Integer code;
    private T result;

    public LlptApiResponse() {
        this.code = OK;
    }

    public LlptApiResponse(Integer code) {
        this.code = code;
    }

    public LlptApiResponse(T result) {
        this.code = OK;
        this.result = result;
    }

    public LlptApiResponse(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public T getResult() {
        return result;
    }
}
