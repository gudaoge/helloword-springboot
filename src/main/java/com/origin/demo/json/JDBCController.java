package com.origin.demo.json;

import com.origin.demo.model.domain.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-03
 * 测试jdbc
 *
 */
@RequestMapping("/jdbc")
@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping("/select")
    public Object select() {
        String sql = "select * from test";
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(TestDO.class));
    }

    @RequestMapping("/insert")
    public Object insert() {
        String sql = "insert into test (name, sex, create_time, update_time)\n" +
                "values ('tom', 1, now(), now())";
        return jdbcTemplate.update(sql);
    }

    @RequestMapping("/update")
    public Object update(String name) {
        String sql = "update test set `name` = ? where  id = 1";
        return jdbcTemplate.update(sql, name);
    }
}
