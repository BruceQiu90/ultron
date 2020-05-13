package io.bruce.ultron.manage.bean;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "t_projects")
public class Project extends BaseEntity<Long> {

    private String projectName;
    private String description;

}
