package com.wy.community.dao;

import com.wy.community.model.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao {

    /**
     * 添加标签
     * @param tag
     * @return
     */
    int insertTag(Tag tag);
}
