package com.origin.demo.json;

import com.origin.demo.factory.TestFactoryBean;
import com.origin.demo.model.domain.TestDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-05
 */
@RequestMapping("/factory")
@RestController
public class FactoryController {

    @Autowired
    private TestDO testDO;
    @Autowired
    private TestFactoryBean testFactoryBean;


    @RequestMapping("/getBean")
    public TestDO getBean() {
        return testDO;
    }

    @RequestMapping("/getFactory")
    public TestFactoryBean getFactory() {
        return testFactoryBean;
    }
}
