package com.wy.community.dao;

import com.wy.community.model.JobInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao {

    /**
     * 添加用户的job_info代码
     * @param jobInfo
     * @return
     */
    int insertJobInfo(JobInfo jobInfo);
}
