package com.wy.community;


import com.alibaba.fastjson.JSONObject;
import com.wy.community.utils.CommunityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonTest {

    @Test
    public void test() {
        JSONObject json = new JSONObject();
        JSONObject userInfo = new JSONObject();
        userInfo.put("username", "phantom");
        userInfo.put("avatar", "avatar");
        json.put("userInfo", userInfo);
        System.out.println(json.toJSONString());
    }

    @Test
    public void test01() {
        String str = CommunityUtils.stringToMd5("123123");
        System.out.println(str);
    }

}
