package com.origin.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by dengqingling on 2019-07-04
 */
@Data
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {

    private String name;

    private Integer sex;
}
