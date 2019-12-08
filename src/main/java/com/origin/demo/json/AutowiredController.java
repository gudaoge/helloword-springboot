package com.origin.demo.json;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dengqingling on 2019-07-05
 */
@RequestMapping("/autowired")
@RestController
public class AutowiredController {

    private final HelloController helloController;

    private final JDBCController jdbcController;

    public AutowiredController(HelloController helloController, JDBCController jdbcController) {
        this.helloController = helloController;
        this.jdbcController = jdbcController;
    }
}
