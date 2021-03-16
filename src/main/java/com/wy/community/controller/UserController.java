package com.wy.community.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.community.model.ResponseMessage;
import com.wy.community.model.UserInfo;
import com.wy.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register/{verifyCode}")
    public String register(HttpServletRequest request, UserInfo userInfo,
                           @PathVariable("verifyCode") String verifyCode) {
        // 获取之前存入到session中的验证码
        JSONObject json = (JSONObject) request.getSession().getAttribute("verifyCode");
        // 验证验证码
        if (!json.getString("verifyCode").equals(verifyCode)) {
            return ResponseMessage.ErrorMsg("验证码输入错误");
        }
        // 验证时间
        if (System.currentTimeMillis() - json.getLong("createTime") > 1000 * 60 * 5) {
            return ResponseMessage.ErrorMsg("验证码已过期，请重新获取");
        }
        //将获取的注册信息存入到数据库
        Map<String, Object> data = new HashMap<>();
        return ResponseMessage.OkMsg(data, "用户注册成功");
    }


}
