package io.bruce.ultron.manage.controller;

import io.bruce.ultron.manage.bean.JobInfo;
import io.bruce.ultron.manage.service.JobService;
import io.bruce.ultron.manage.web.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public BaseResponse create(@RequestBody JobInfo jobInfo){
        jobService.createJob(jobInfo);
        return BaseResponse.success();
    }

    @PutMapping
    public BaseResponse update(@RequestBody JobInfo jobInfo) {
        jobService.update(jobInfo);
        return BaseResponse.success();
    }


    @GetMapping("{id}")
    public BaseResponse<JobInfo> selectById(@PathVariable("id") Long id) {
        return BaseResponse.success(jobService.selectById(id));
    }

    @GetMapping("/all")
    public BaseResponse<List<JobInfo>> selectAllByProjectName(@RequestParam("projectName") String projectName) {
        return BaseResponse.success(jobService.selectAllByProjectName(projectName));
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteById(@PathVariable("id") Long id) {
        jobService.deleteById(id);
        return BaseResponse.success();
    }
}
