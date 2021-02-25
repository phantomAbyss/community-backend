package com.wy.community.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tag {

    private Integer id;
    /**
     * 父级Id，0-表示无父级，否则为父级的id
     */
    private Integer parentId;
    private String tagName;
    /**
     * 0-表示该标签可用，1表示该标签不可用
     */
    private Integer status;

}
