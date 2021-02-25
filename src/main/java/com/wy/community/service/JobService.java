package com.wy.community.service;

import com.wy.community.dao.JobDao;
import com.wy.community.model.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobDao jobDao;

    public int addJobInfo(JobInfo jobInfo) {
        return jobDao.insertJobInfo(jobInfo);
    }
}
