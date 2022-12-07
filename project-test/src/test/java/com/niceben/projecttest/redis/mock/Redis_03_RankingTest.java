package com.niceben.projecttest.redis.mock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * 排行榜
 */
@Slf4j
@SpringBootTest
public class Redis_03_RankingTest {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY_RANKING = "ranking";

    @Test
    public void test() {
        add(1001, (double) 60);
        add(1002, (double) 80);
        add(1003, (double) 100);
        add(1004, (double) 90);
        add(1005, (double) 70);

//        add(1002, (double) 101);
        // 取所有
        Set<DefaultTypedTuple> range = range(0, -1);
        log.info("所有用户排序：{}", range);

        // 前三名
        range = range(0, 2);
        log.info("前三名排序：{}", range);
    }

    /**
     * 添加记录
     * @param userId        用户ID
     * @param score         排行分数
     * @return              是否添加成功
     */
    private Boolean add(Integer userId, Double score) {
        Boolean add = redisTemplate.opsForZSet().add(KEY_RANKING, userId, score);
        return add;
    }

    public Set<DefaultTypedTuple> range(long min, long max) {
        // 降序
        Set<DefaultTypedTuple> set = redisTemplate.opsForZSet().reverseRangeWithScores(KEY_RANKING, min, max);
        // 升序
//        Set<DefaultTypedTuple> set = redisTemplate.opsForZSet().rangeWithScores(KEY_RANKING, min, max);
        return set;
    }
}
