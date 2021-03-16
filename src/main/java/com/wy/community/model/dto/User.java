package com.wy.community.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class User {

    private Integer userId;
    private String username;
    private String avatar;

}
