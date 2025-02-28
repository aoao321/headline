package com.aoao.common;

/**
 * @author aoao
 * @create 2025-02-13-18:53
 */
public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"username error"),
    PASSWORD_ERROR(502,"password error"),
    NOT_LOGIN(503,"not login"),
    USERNAME_EXIST(504,"username exist"),
    USERNAME_USED(505,"username used"),;

    private int code;//自定义状态码
    private String msg;//用于描述状态信息

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
