package io.bruce.ultron.manage.dao;

import io.bruce.ultron.manage.bean.JobInfo;

import java.util.List;

public interface JobInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);

    List<JobInfo> selectAllByProjectName(String projectName);
}