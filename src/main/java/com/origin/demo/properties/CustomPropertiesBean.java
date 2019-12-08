package com.origin.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by dengqingling on 2019-07-04
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom1")
public class CustomPropertiesBean {

    private String name;

    private Integer sex;
}
