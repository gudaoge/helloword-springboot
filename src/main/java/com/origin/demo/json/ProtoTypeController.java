package com.origin.demo.json;

import com.origin.demo.service.ProtoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-21
 * 测试scope代理
 * 配置了scope-proxy的类都会创建代理对象，注入时注入代理对象，运行时动态获取实际bean
 */
@RequestMapping("/protoType")
@RestController()
public class ProtoTypeController {

    @Autowired
    private ProtoTypeService protoTypeService;

    @RequestMapping("/getIndex")
    public Object getIndex() {
        return protoTypeService.getIndex();
    }


}
