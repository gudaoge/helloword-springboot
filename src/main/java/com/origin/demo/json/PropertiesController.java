package com.origin.demo.json;

import com.origin.demo.properties.CustomProperties;
import com.origin.demo.properties.CustomPropertiesBean;
import com.origin.demo.properties.OutCustomPropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-04
 * 自定义配置文件使用测试
 *
 * 目前来看 只添加@ConfigurationProperties注解是无效的
 * 需要配合@Component或者@EnableConfigurationProperties注解才能注入
 * @EnableConfigurationProperties 使用时需要指定配置类
 * @Component 则不需要
 * 看起来@Component更方便一些,@EnableConfigurationProperties的意义在于啥
 * 个人猜测是@Component通过包扫描，任何带有注解的都会被注入
 * 而@EnableConfigurationProperties通常用于配置类上，可以指定加载对应配置，通过springboot的自动配置所以无需包扫描
 *
 */
@EnableConfigurationProperties(CustomProperties.class)
@RequestMapping("/properties")
@RestController
public class PropertiesController {

    @Autowired
    private CustomProperties customProperties;
    @Autowired
    private CustomPropertiesBean customPropertiesBean;
    @Autowired
    private OutCustomPropertiesBean outCustomPropertiesBean;
    @Autowired
    private Environment environment;

    @RequestMapping("/getCustomProperties")
    public Object getCustomProperties() {
        return customProperties;
    }

    @RequestMapping("/getCustomPropertiesBean")
    public Object getCustomPropertiesBean() {
        return customPropertiesBean;
    }

    @RequestMapping("/getOutCustomPropertiesBean")
    public Object getOutCustomPropertiesBean() {
        return outCustomPropertiesBean;
    }

    @RequestMapping("/getEnvironmentProperties")
    public Object getEnvironmentProperties(@RequestParam("key") String key) {
        return environment.getProperty(key);
    }

}
