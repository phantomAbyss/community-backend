package com.wy.community.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseInfo {

    private Integer id;
    private Integer userId;
    private String realName;
    /**
     * 存储县和城市的id，返回给前端时查找到对应的县和城市
     */
    private String area;
    private String description;
    private Date birthday;
    private Date startWork;
    private Date updateTime;

}
