package com.origin.demo.json;

import com.origin.demo.dao.TestMapper;
import com.origin.demo.model.domain.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by dengqingling on 2019-07-03
 * mybatis相关使用测试
 * 目前来看，在springboot中mapper接口需要添加@Mapper注解
 * 查看官方文档发现， mybatis-springboot是扫描路径下所有标有@Mapper注解的接口
 */
@RequestMapping("/mybatis")
@RestController
public class MybatisController {

    private final TestMapper testMapper;

    public MybatisController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @RequestMapping("/getById")
    public Object getById(Long id) {
        return testMapper.getById(id);
    }

    @RequestMapping("/getList")
    public Object getList(Long id) {
        return testMapper.getList();
    }

    @RequestMapping("/insert")
    public Object insert(String name) {
        TestDO testDO = new TestDO();
        testDO.setName(name);
        testDO.setSex(1);
        testDO.setCreateTime(new Date());
        testDO.setUpdateTime(new Date());
        testMapper.insert(testDO);
        return testDO;
    }

    @RequestMapping("/update")
    public Object update(Long id, String name) {
        TestDO testDO = new TestDO();
        testDO.setId(id);
        testDO.setName(name);
        return testMapper.update(testDO);
    }


    @RequestMapping("/delete")
    public Object delete(Long id) {
        return testMapper.delete(id);
    }

}
