package io.bruce.ultron.manage.controller;

import io.bruce.ultron.manage.bean.Job;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("job")
public class JobController extends BaseController<Job, Long> {

}
