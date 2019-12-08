package com.origin.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by dengqingling on 2019-07-31
 */
@Data
@Component
@ConfigurationProperties(prefix = "custom3")
@PropertySource("/config/custom.properties")
public class OutCustomPropertiesBean {

    private String name;

    private Integer sex;
}
