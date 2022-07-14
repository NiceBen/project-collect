package com.niceben.projectmpa.mapper;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.niceben.projectmpa.business.rbac.entity.User;
import com.niceben.projectmpa.business.rbac.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelectList() {
        System.out.println(("----- selectAll method test ------"));
        List<User> users = userMapper.selectList(null);
        Assertions.assertEquals(2, users.size());
        users.forEach(System.out::println);
    }

    @Test
    void contextLoads() {
        // 更新全表数据
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();

        User user = new User();
        user.setSex(3);

        int result = userMapper.update(user, wrapper);
        System.out.println("result=" + result);
    }

}
