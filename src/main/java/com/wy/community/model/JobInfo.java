package com.wy.community.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobInfo {

    private Integer id;
    private Integer userId;
    private String company;
    private String position;
    /* 存储用户的行业的Id */
    private Integer industry;
}
