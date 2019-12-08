package com.origin.demo.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dengqingling on 2019-07-02
 * redis相关使用测试
 */
@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    @Resource(name = "redisTemplate")
    private SetOperations<Object, Object> setOperations;


    @RequestMapping("/setString")
    public String setString(@RequestParam() String key, @RequestParam() String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/getString")
    public String getString(@RequestParam() String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/pushList")
    public List<String> pushList(@RequestParam() String key, @RequestParam() String value) {
        stringRedisTemplate.opsForList().leftPush(key, value);
        return stringRedisTemplate.opsForList().range(key, 0, 10000);
    }

    @RequestMapping("/popList")
    public String popList(@RequestParam() String key) {
        return stringRedisTemplate.opsForList().leftPop(key);
    }

    @RequestMapping("/getHash")
    public Object getHash(@RequestParam() String key, @RequestParam() String hashKey) {
        return stringRedisTemplate.opsForHash().get(key, hashKey);
    }

    @RequestMapping("/setHash")
    public Object setHash(@RequestParam() String key, @RequestParam() String hashKey, @RequestParam() String hashValue) {
        stringRedisTemplate.opsForHash().put(key, hashKey, hashValue);
        return stringRedisTemplate.opsForHash().entries(key);
    }


}
