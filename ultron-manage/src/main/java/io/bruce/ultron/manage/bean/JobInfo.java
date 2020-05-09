package io.bruce.ultron.manage.bean;

import lombok.Data;

@Data
public class JobInfo {
    private Long id;
    private String projectName;
    private String jobName;
    private String mainClass;
    private String jarPath;
    private String description;
    private Integer parallelism;
    private Integer jobManagerMem;
    private Integer slotNum;
    private Integer taskManagerMem;
    private String applicationId;
}