package com.wy.community.model.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Result implements Serializable {

    /* 状态码 */
    private Integer code;
    /* 状态消息 */
    private String msg;

    /* 返回封装的数据 */
    private Object data;


    /**
     * 不返回数据
     * @param codeEnum
     */
    public Result(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }

    /**
     * 返回数据
     * @param codeEnum
     * @param data
     */
    public Result(CodeEnum codeEnum, Object data) {
        this(codeEnum);
        this.data = data;
    }


    /**
     * 请求成功，不返回数据
     * @return
     */
    public static Result success() {
        return new Result(CodeEnum.SUCCESS);
    }

    /**
     * 请求成功，返回数据
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return new Result(CodeEnum.SUCCESS, data);
    }

    /**
     * 请求失败，不返回数据
     * @return
     */
    public static Result fail() {
        return new Result(CodeEnum.FAIL);
    }

    /**
     * 请求失败，返回数据
     * @param data
     * @return
     */
    public static Result fail(Object data) {
        return new Result(CodeEnum.FAIL, data);
    }
}
