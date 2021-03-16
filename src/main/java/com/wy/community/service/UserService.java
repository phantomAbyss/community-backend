package com.wy.community.service;

import com.alibaba.fastjson.JSONObject;
import com.wy.community.dao.LoginTicketDao;
import com.wy.community.dao.UserDao;
import com.wy.community.model.LoginTicket;
import com.wy.community.model.UserInfo;
import com.wy.community.model.dto.User;
import com.wy.community.utils.CommunityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginTicketDao loginTicketDao;

    /* 该接口用于添加模拟用户数据到数据库 */
    public int addUserInfo(UserInfo userInfo) {
        return userDao.insertUserInfo(userInfo);
    }

    /* 根据用户id查询用户的信息 */
    public UserInfo getUserInfoById(Integer userId) {
        return userDao.getUserInfoById(userId);
    }

    public Map<String, Object> login(String loginName, String password, int expiredSeconds) {
        Map<String, Object> map = new HashMap<>();
        // 做空值处理
        if (StringUtils.isBlank(loginName)) {
            map.put("loginNameMsg", "账号不能为空");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空");
            return map;
        }

        // 验证用户名和密码是否正确
        UserInfo userInfo = userDao.getUserInfoByLoginName(loginName);
        if (null == userInfo) {
            map.put("loginNameMsg", "账号还未注册，请注册后登录");
            return map;
        }
        if (userInfo.getStatus() == 0) {
            map.put("loginNameMsg", "该账号还未激活，请激活后在尝试登录");
            return map;
        }
        // 验证密码
        password = CommunityUtils.stringToMd5(password + userInfo.getSalt());
        if (!password.equals(userInfo.getPassword())) {
            map.put("passwordMsg", "密码输入错误");
            return map;
        }
        // 生成登录凭证
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userInfo.getId());
        loginTicket.setTicket(CommunityUtils.generateUUID());
        loginTicket.setExpired(new Date(System.currentTimeMillis() + expiredSeconds * 1000));
        loginTicketDao.insertLoginTicket(loginTicket);
        map.put("token", loginTicket.getTicket());
        User user = new User(userInfo.getId(), userInfo.getUsername(), userInfo.getHeaderUrl());
        map.put("userInfo", user);
        return map;
    }

}
