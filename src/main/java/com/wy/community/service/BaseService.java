package com.wy.community.service;

import com.wy.community.dao.BaseDao;
import com.wy.community.model.BaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private BaseDao baseDao;

    /* 此接口用于将mock的模拟数据存储到数据库 */
    public int addBaseInfo(BaseInfo baseInfo) {
        return baseDao.insertBaseInfo(baseInfo);
    }

}
