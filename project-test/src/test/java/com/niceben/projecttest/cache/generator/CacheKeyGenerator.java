package com.niceben.projecttest.cache.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;


@Slf4j
@Component
public class CacheKeyGenerator implements KeyGenerator {
    private static final String UNDERLINE = "_";
    private static final String COMMA = ",";

    @Override
    public Object generate(Object target, Method method, Object... params) {
        String key = target.getClass().getSimpleName() + UNDERLINE + method.getName() + COMMA + StringUtils.arrayToDelimitedString(params, COMMA);
        log.info("新生成的key=[{}]", key);
        return key;
    }
}
