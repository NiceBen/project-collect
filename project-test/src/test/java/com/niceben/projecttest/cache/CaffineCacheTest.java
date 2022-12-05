package com.niceben.projecttest.cache;

import com.niceben.projecttest.cache.generator.CacheKeyGenerator;
import com.niceben.projecttest.cache.model.vo.UserVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@EnableCaching
public class CaffineCacheTest {

    private static Map<String, UserVo> map = new HashMap<>();

    @Autowired
    CacheKeyGenerator cacheKeyGenerator;

    @BeforeEach
    public void init() {
        map.put("zs", new UserVo("zhangsan"));
        map.put("ls", new UserVo("lisi"));
    }

    @Cacheable(value = "brand", keyGenerator = "cacheKeyGenerator")
    public UserVo getUserVo(String key) {
        System.out.println("getUserVo 被调用");
        return getPrivateUserVo(key);
    }

    private UserVo getPrivateUserVo(String key) {
        System.out.println("getPrivateUserVo 被调用");
        return map.get(key);
    }

    @Test
    public void testCache() {
        getUserVo("zs");
        getUserVo("zs");
        getUserVo("zs");
        getUserVo("zs");
    }

    @Test
    public void getGeneratorKey() {
        Class<? extends CaffineCacheTest> aClass = this.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Method declaredMethod = declaredMethods[0];
        cacheKeyGenerator.generate(this, declaredMethod, "hello", "world");
    }
}
