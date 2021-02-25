package com.wy.community.service;

import com.wy.community.dao.TagDao;
import com.wy.community.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagDao tagDao;

    /**
     * 此接口主要用于添加mock的模拟数据
     * @param tag
     * @return
     */
    public int addTag(Tag tag) {
        return tagDao.insertTag(tag);
    }

}
