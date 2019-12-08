package com.origin.demo.factory;

import com.origin.demo.model.domain.TestDO;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * Created by dengqingling on 2019-07-05
 */
@Component
public class TestFactoryBean implements FactoryBean<TestDO> {

    @Override
    public TestDO getObject() throws Exception {
        System.out.println("testFactoryBean#getObject");
        TestDO testDO = new TestDO();
        testDO.setId(System.currentTimeMillis());
        return testDO;
    }

    @Override
    public Class<?> getObjectType() {
        return TestDO.class;
    }
}
