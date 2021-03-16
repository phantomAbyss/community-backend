package com.wy.community.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * 用于生成验证码的工具类
 */
public class CaptchaUtils {


    private static String accessKeyId;

    /**
     *  @Value 不可以直接把值注入到静态属性变量，但是可以通过给其对应的set方法添加@Value来赋值
     * 但是不可以set方法不能添加static
     * @param accessKeyId
     */
    @Value("${aliyun-sms.AccessKey-ID}")
    public void setAccessKeyId(String accessKeyId) {
        CaptchaUtils.accessKeyId = accessKeyId;
    }


    private static String accessKeySecret;

    @Value("${aliyun-sms.AccessKey-Secret}")
    public void setAccessKeySecret(String accessKeySecret) {
        CaptchaUtils.accessKeySecret = accessKeySecret;
    }

    private static String signName;
    @Value("${aliyun-sms.signName}")
    public void setSignName(String signName) {
        CaptchaUtils.signName = signName;
    }

    /**
     * 通过手机号发送验证码
     * @param mobile
     */
    public static void sendVerifyCodeByMobile(String mobile) {
        // 生成6位验证码
        int code = new Random().nextInt(999999);
        if (code < 100000) {
            code += 100000;
        }
        String verifyCode = String.valueOf(code);
        // 默认配置项
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        // 客户端对象
        DefaultAcsClient client = new DefaultAcsClient(profile);

        // 请求参数配置
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.PUT);

        // 阿里云服务器配置
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");

        // 手机号码
        request.putQueryParameter("mobile", mobile);
        // 签名名称
        request.putQueryParameter("SignName", signName);
        // 模板code
        request.putQueryParameter("TemplateCode", null);
    }


}
