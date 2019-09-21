package com.czn.fcpms.enums;

public enum ResultEnum {
    TOKEN_ERROR(9999,"token失效"),
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功");

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
