package com.wy.community.dao;

import com.wy.community.model.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /* 添加用户 */
    int insertUserInfo(UserInfo userInfo);

    /* 根据用户id查找用户的信息 */
    UserInfo getUserInfoById(Integer id);

    /* 根据用户手机或者邮箱得到用户信息 */
    UserInfo getUserInfoByLoginName(String loginName);
}
