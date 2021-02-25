package com.wy.community.service;

import com.wy.community.dao.UserDao;
import com.wy.community.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /* 该接口用于添加模拟用户数据到数据库 */
    public int addUserInfo(UserInfo userInfo) {
        return userDao.insertUserInfo(userInfo);
    }

    /* 根据用户id查询用户的信息 */
    public UserInfo getUserInfoById(Integer userId) {
        return userDao.getUserInfoById(userId);
    }

}
