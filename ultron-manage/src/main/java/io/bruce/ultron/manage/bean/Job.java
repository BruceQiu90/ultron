package io.bruce.ultron.manage.bean;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "t_jobs")
public class Job extends BaseEntity<Long> {
    private String jobName;
    private String mainClass;
    private String jarPath;
    private String description;
    private Integer parallelism;
    private Integer jobManagerMem;
    private Integer slotNum;
    private Integer taskManagerMem;
    private Integer nodeNum;
    private String yarnApplicationId;
}