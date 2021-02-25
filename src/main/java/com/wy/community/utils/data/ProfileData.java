package com.wy.community.utils.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wy.community.model.BaseInfo;
import com.wy.community.model.JobInfo;
import com.wy.community.model.Tag;
import com.wy.community.model.UserInfo;
import com.wy.community.service.BaseService;
import com.wy.community.service.JobService;
import com.wy.community.service.TagService;
import com.wy.community.service.UserService;
import com.wy.community.utils.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * 从mock.js获取模拟用户的数据
 */

/**
 * 使用@Value的类不能使用new关键字进行实例化对象，必须采用依赖注入的方式进行实例化，
 * 不能使用显示的构造方法,否则将取不到值。
 */
@Component
public class ProfileData {

    @Value("${base-url}")
    private String baseUrl;

    @Value("${api-name.profile-name}")
    private String apiName;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private JobService jobService;

    @Autowired
    private TagService tagService;

    /**
     * 从easymock中获取数据，然后存储到user_info表
     */
    public void addUserInfo() {
        // 请求url
        String url = new StringBuilder(baseUrl).append(apiName).append("/user/info").toString();
        // 通过Get方式获取数据
        String response = HttpClientUtils.getDataByGet(url);
        // 将得到的结果转化为json
        JSONObject json = JSON.parseObject(response);
        UserInfo[] userInfoList = json.getObject("data", UserInfo[].class);
        for (UserInfo userInfo : userInfoList) {
            // 将获取的模拟数据添加到数据库
            userService.addUserInfo(userInfo);
            System.out.println("用户 " + userInfo.getId() + " 添加成功");
//            System.out.println(userService.getUserInfoById(userInfo.getId()).getCreateTime().getTime());
        }
    }

    /**
     * 从easymock中获取数据，然后存储到user_info表
     */
    public void addBaseInfo() {
        // 请求url
        String url = baseUrl + apiName + "/base/info";
        // 通过Get方式获取数据
        String response = HttpClientUtils.getDataByGet(url);
        // 将得到的结果转化为json数据
        JSONObject json = JSON.parseObject(response);
        BaseInfo[] baseInfoList = json.getObject("data", BaseInfo[].class);
        for (BaseInfo baseInfo : baseInfoList) {
            // 将获取的模拟数据添加到数据库
            baseService.addBaseInfo(baseInfo);
            System.out.println("id = " + baseInfo.getId() + ", 信息添加成功");
        }
    }

    /**
     * 从easymock中获取标签数据，然后存储到tag表
     */
    public void addJobInfo() {
        // 请求url
        String url = baseUrl + apiName + "/job/info";
        // 通过Get方式获取数据
        String response = HttpClientUtils.getDataByGet(url);
        // 转化为json数据
        JSONObject json = JSON.parseObject(response);
        JobInfo[] jobInfoList = json.getObject("data", JobInfo[].class);
        for (JobInfo jobInfo : jobInfoList) {
            jobService.addJobInfo(jobInfo);
            System.out.println("工作的id = " + jobInfo.getId() + ", 信息添加成功");
        }
    }

    public void addTag() {
        // 请求url
        String url = baseUrl + apiName + "/tag/list";
        // 通过Get的方式获取数据
        String response = HttpClientUtils.getDataByGet(url);
        // 将其转化为json数据
        JSONObject json = JSON.parseObject(response);
        Tag[] tagList = json.getObject("data", Tag[].class);
        for (Tag tag : tagList) {
            tagService.addTag(tag);
            System.out.println("新添加的标签的id = " + tag.getId() + ", 信息添加成功");
        }
    }
}
