package io.bruce.ultron.manage.controller;

import io.bruce.ultron.manage.bean.Project;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController<Project, Long> {

}
