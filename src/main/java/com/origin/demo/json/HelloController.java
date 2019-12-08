package com.origin.demo.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-02
 */
@RequestMapping("/hello")
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/helloZN")
    public String helloZN() {
        return "你好 世界";
    }
}
