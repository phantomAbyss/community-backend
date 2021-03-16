package com.wy.community.model;


import com.alibaba.fastjson.JSONObject;
import lombok.*;

import java.util.Map;

/**
 * 该类不再使用，使用Result类代替该类返回
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Deprecated
public class ResponseMessage {
    private static final String OK = "0";
    private static final String ERROR = "1";

    /**
     * 状态值
     */
    private String code;
    /**
     * 返回值集合
     */
    private Map<String, Object> data;
    /**
     * 异常类捕获
     */
    private Exception exception;
    /**
     * 自定义信息
     */
    private String msg;

    /**
     * 成功的消息
     * @param data
     * @return
     */
    public static String OkMsg(Map<String, Object> data, String msg) {
        return JSONObject.toJSONString(new ResponseMessage(ResponseMessage.OK, data, null, msg));
    }


    /**
     * 失败的结果
     * @param msg 返回信息
     * @return
     */
    public static String ErrorMsg(String msg) {
        return JSONObject.toJSONString(new ResponseMessage(ResponseMessage.ERROR, null, null, msg));
    }

    /**
     * 失败的结果
     * @param msg 返回信息
     * @return
     */
    public static String ErrorMsg(Exception exception, String msg) {
        return JSONObject.toJSONString(new ResponseMessage(ResponseMessage.ERROR, null, exception, msg));
    }

}
