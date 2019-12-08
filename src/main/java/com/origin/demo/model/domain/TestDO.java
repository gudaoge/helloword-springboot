package com.origin.demo.model.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by dengqingling on 2019-07-03
 */
@Data
public class TestDO {

    private Long id;

    private String name;

    private Integer sex;

    private Date createTime;

    private Date updateTime;
}
