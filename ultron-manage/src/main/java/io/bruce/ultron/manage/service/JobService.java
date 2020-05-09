package io.bruce.ultron.manage.service;

import io.bruce.ultron.manage.bean.JobInfo;

import java.util.List;

public interface JobService {

    void createJob(JobInfo jobInfo);
    void update(JobInfo jobInfo);
    void deleteById(Long id);
    JobInfo selectById(Long id);
    List<JobInfo> selectAllByProjectName(String projectName);
}
