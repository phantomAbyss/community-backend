package com.wy.community.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wy.community.model.dto.Result;
import com.wy.community.service.UserService;
import com.wy.community.utils.CommunityConstant;
import com.wy.community.utils.CommunityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class LoginController implements CommunityConstant {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody String params) {
        JSONObject json = JSON.parseObject(params);
        String loginName = json.getString("loginName");
        String password = json.getString("password");
        Boolean rememberMe = json.getBoolean("rememberMe");
        int expiredSeconds = rememberMe ? REMEMBER_EXPIRED_SECONDS : DEFAULT_EXPIRED_SECONDS;
        Map<String, Object> map = userService.login(loginName, password, expiredSeconds);
        if (map.containsKey("token")) {
            return Result.success(map);
        }
        return Result.fail();
    }


}
