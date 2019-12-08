package com.origin.demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by dengqingling on 2019-07-21
 */
@Component
@Slf4j
public class LifeCycleBean implements InitializingBean, DisposableBean {

    public LifeCycleBean() {
        log.info("LifeCycleBean created");
    }

    @PostConstruct
    public void init1() {
        log.info("LifeCycleBean PostConstruct");
    }

    @PreDestroy
    public void destroy1() {
        log.info("LifeCycleBean PreDestroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("LifeCycleBean afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("LifeCycleBean destroy");
    }
}
