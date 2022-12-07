package com.niceben.projecttest.redis.mock;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 文章点赞
 */
@Slf4j
@SpringBootTest
public class Redis_02_LikeTest {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY_LIKE_ARTICLE_PREFIX = "like:article:";

    @Test
    public void test() {
        long articleId = 100;
        Long likeNum = like(articleId, 1001, 1002, 2001, 3005, 4003);
        unLike(articleId, 2001);
        likeNum = likeNum(articleId);
        boolean b2001 = isLike(articleId, 2001);
        boolean b3005 = isLike(articleId, 3005);
        log.info("文章：{} 点赞数量：{} 用户2001的点赞状态：{}，用户2001的点赞状态：{}", articleId, likeNum, b2001, b3005);
    }

    /**
     * 点赞
     * @param articleId     文章ID
     * @param userIds       用户ID
     * @return              点赞数量
     */
    private Long like(long articleId, Integer... userIds) {
        String key = KEY_LIKE_ARTICLE_PREFIX + articleId;
        Long add = redisTemplate.opsForSet().add(key, userIds);
        return add;
    }

    /**
     * 移除点赞
     * @param articleId     文章ID
     * @param userId        用户ID
     * @return              是否成功解除点赞
     */
    private Long unLike(long articleId, Integer userId) {
        String key = KEY_LIKE_ARTICLE_PREFIX + articleId;
        Long remove = redisTemplate.opsForSet().remove(key, userId);
        return remove;
    }

    /**
     * 获取某篇文章点赞总数
     * @param articleId         文章ID
     * @return                  点赞总数
     */
    private Long likeNum(long articleId) {
        String key = KEY_LIKE_ARTICLE_PREFIX + articleId;
        Long size = redisTemplate.opsForSet().size(key);
        return size;
    }

    /**
     * 判断某个用户是否点赞某篇文章
     * @param articleId     文章ID
     * @param userId        用户ID
     * @return              是否是成员
     */
    private boolean isLike(long articleId, Integer userId) {
        String key = KEY_LIKE_ARTICLE_PREFIX + articleId;
        Boolean isMember = redisTemplate.opsForSet().isMember(key, userId);
        return isMember;
    }
}
