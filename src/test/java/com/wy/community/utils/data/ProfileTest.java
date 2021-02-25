package com.wy.community.utils.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfileTest {

    @Autowired
    private ProfileData profileData;

    /**
     * 添加模拟用户数据到数据库
     * 一次性添加10条
     */
    @Test
    public  void addUserInfo() {
        profileData.addUserInfo();
    }

    /**
     * 添加用户数据base_info到数据库
     */
    @Test
    public void addBaseInfo() {
        profileData.addBaseInfo();
    }

    /**
     * 添加用户数据job_info信息
     */
    @Test
    public void addJobInfo() {
        profileData.addJobInfo();
    }

    /**
     * 添加标签的数据tag_info信息
     */
    @Test
    public void addTag() {
        profileData.addTag();
    }
}
