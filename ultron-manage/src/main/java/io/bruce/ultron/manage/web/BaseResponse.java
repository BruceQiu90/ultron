package io.bruce.ultron.manage.web;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private int code;
    private String message;
    private T data;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse() {
    }

    public static <T> BaseResponse<T> success() {
        return new BaseResponse<T>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), null);
    }

    public static <T> BaseResponse<T> success(String message) {
        return new BaseResponse<T>(StatusCode.SUCCESS.getCode(), message, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<T>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResponse<T> error() {
        return new BaseResponse<T>(StatusCode.INTERNAL_SERVER_ERROR.getCode(), StatusCode.INTERNAL_SERVER_ERROR.getMessage(), null);
    }
    public static <T> BaseResponse<T> error(String message) {
        return new BaseResponse<T>(StatusCode.INTERNAL_SERVER_ERROR.getCode(), message, null);
    }
    public static <T> BaseResponse<T> error(T data) {
        return new BaseResponse<T>(StatusCode.INTERNAL_SERVER_ERROR.getCode(), StatusCode.INTERNAL_SERVER_ERROR.getMessage(), data);
    }
    public static <T> BaseResponse<T> error(String message, T data) {
        return new BaseResponse<T>(StatusCode.INTERNAL_SERVER_ERROR.getCode(), message, data);
    }

}
