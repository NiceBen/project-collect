package com.niceben.projecttest.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("name", "zsl");
        System.out.println(operations.get("name"));
    }
}
