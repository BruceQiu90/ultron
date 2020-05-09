package io.bruce.ultron.manage.service.impl;

import io.bruce.ultron.manage.bean.JobInfo;
import io.bruce.ultron.manage.dao.JobInfoMapper;
import io.bruce.ultron.manage.service.JobService;
import io.bruce.ultron.manage.service.YarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobInfoMapper jobInfoMapper;
    @Autowired
    private YarnService yarnService;


    @Transactional
    public void createJob(JobInfo jobInfo) {
        jobInfoMapper.insert(jobInfo);
    }

    @Transactional
    public void update(JobInfo jobInfo) {
        jobInfoMapper.updateByPrimaryKeySelective(jobInfo);
    }

    @Transactional
    public void deleteById(Long id) {
        jobInfoMapper.deleteByPrimaryKey(id);
    }

    public JobInfo selectById(Long id) {
        return jobInfoMapper.selectByPrimaryKey(id);
    }

    public List<JobInfo> selectAllByProjectName(String projectName) {
        return jobInfoMapper.selectAllByProjectName(projectName);
    }
}
