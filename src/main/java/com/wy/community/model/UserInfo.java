package com.wy.community.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfo {

    /* 用户Id */
    private Integer id;

    /* 用户名 */
    private String username;

    /* 用户密码 */
    private String password;

    /* 用户密码加密使用的salt */
    private String salt;

    /* 用户邮箱 */
    private String email;

    /* 用户手机 */
    private String mobile;

    /* 用户性别：0-男，1-女 */
    private Integer gender;

    /* 账户类型：0-普通用户，1-管理员 */
    private Integer type;

    /* 用户的账号状态：0-未激活，1-已激活 */
    private Integer status;

    /* 用户头像地址 */
    private String headerUrl;

    /* 用户创建的时间 */
    private Date createTime;

    /* 用户最近的更新时间 */
    private Date updateTime;

    /* 用户的户龄 */
    private Integer familyAge;

}
