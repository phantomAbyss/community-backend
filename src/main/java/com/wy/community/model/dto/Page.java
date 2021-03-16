package com.wy.community.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Page<T> {

    private Integer total;
    private List<T> rows;

}
