package com.niceben.projectmpa.mapper;

import com.niceben.projectmpa.model.entity.User;
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

}
