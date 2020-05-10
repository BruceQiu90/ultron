DROP DATABASE IF EXISTS ultron;
CREATE DATABASE IF NOT EXISTS ultron DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

use ultron;

DROP TABLE if exists t_jobs;
CREATE TABLE if not exists t_jobs  (
  id bigint NOT NULL AUTO_INCREMENT COMMENT '自增id',
  pid bigint not null comment '项目id',
  job_name varchar(50) NOT NULL COMMENT '任务名称',
  main_class varchar(80) NOT NULL COMMENT '运行的主类名',
  jar_path varchar(100) NOT NULL COMMENT 'jar包所在路径',
  description varchar(100) NULL COMMENT '任务描述',
  parallelism int NOT NULL COMMENT '任务并行度',
  job_manager_mem int NOT NULL COMMENT 'job manager 内存大小',
  slot_num int NOT NULL COMMENT '槽点数',
  task_manager_mem int NOT NULL COMMENT 'task manager 内存',
  node_num int not null comment 'yarn container 的数量',
  yarn_application_id varchar(300) comment 'yarn 任务id',
  PRIMARY KEY (id)
) COMMENT = '任务表';

DROP TABLE IF EXISTS t_projects;
CREATE TABLE IF NOT EXISTS t_projects (
    id bigint primary key auto_increment comment '自增id',
    project_name varchar(30) not null comment '项目名称',
    description varchar(100) comment '项目描述',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) comment = '项目表';





