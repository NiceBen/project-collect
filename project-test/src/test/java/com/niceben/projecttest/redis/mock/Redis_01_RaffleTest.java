package com.niceben.projecttest.redis.mock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * 抽奖
 */
@Slf4j
@SpringBootTest
public class Redis_01_RaffleTest {

    private final String KEY_RAFFLE_PREFIX = "raffle:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        Integer raffleId = 1;
        join(raffleId, 1000, 1001, 2233, 7890, 44556, 74512);
        List<Object> lucky = luck(raffleId, 2);
        log.info("活动：{} 的中奖用户是:{}", raffleId, lucky);
    }


    private void join(Integer raffleId, Integer... userIds) {
        String key = KEY_RAFFLE_PREFIX + raffleId;
        redisTemplate.opsForSet().add(key, userIds);
    }

    private List<Object> luck(Integer raffleId, long num) {
        String key = KEY_RAFFLE_PREFIX + raffleId;
        // 随机抽取 抽完之后将用户移除奖池
        List<Object> list = redisTemplate.opsForSet().pop(key, num);
        // 随机抽取 抽完之后用户保存在奖池
//        List<Object> list  = redisTemplate.opsForSet().randomMembers(key, num);
        return list ;
    }
}
