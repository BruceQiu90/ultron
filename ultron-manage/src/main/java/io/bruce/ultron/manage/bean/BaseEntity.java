package io.bruce.ultron.manage.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseEntity<PK> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PK id;
    private Date createTime;
    private Date updateTime;
}
