package io.bruce.ultron.manage.web;

public enum StatusCode {

    SUCCESS(200, "ok"),
    INTERNAL_SERVER_ERROR(500, "error");

    private Integer code;
    private String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
