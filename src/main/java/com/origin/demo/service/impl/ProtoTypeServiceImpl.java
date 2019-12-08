package com.origin.demo.service.impl;

import com.origin.demo.service.ProtoTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * Created by dengqingling on 2019-07-21
 * 测试多例
 */
@Slf4j
@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
public class ProtoTypeServiceImpl implements ProtoTypeService {

    private static int INDEX = 0;

    public ProtoTypeServiceImpl() {
        log.info("ProtoTypeServiceImpl {} created...", INDEX++);
    }

    @Override
    public int getIndex() {
        return INDEX;
    }
}
