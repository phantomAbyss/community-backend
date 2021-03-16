package com.wy.community.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public enum CodeEnum {

    /**
     * 成功
     */
    SUCCESS(0, "请求数据成功"),
    /**
     * 失败
     */
    FAIL(1, "请求数据失败"),
    /**
     * 参数不全或者参数错误
     */
    BAD_REQUEST(400, "参数不正确");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
