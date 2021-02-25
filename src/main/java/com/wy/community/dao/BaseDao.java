package com.wy.community.dao;

import com.wy.community.model.BaseInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao {

    /* 插入用户的基本信息 */
    int insertBaseInfo(BaseInfo baseInfo);

}
