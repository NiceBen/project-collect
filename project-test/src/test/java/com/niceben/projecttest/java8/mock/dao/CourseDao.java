package com.niceben.projecttest.java8.mock.dao;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CourseDao {

    private void saveDb(Supplier<Integer> supplier) {
        if (supplier.get() > 0) {
            System.out.println("插入数据库成功");
        } else {
            System.out.println("插入数据库失败");
        }
    }

    @Test
    public void add() throws Exception {
        List<Integer> integers = Arrays.asList(1, 3, 4, 6);

        List<Integer> collect = integers.stream().filter(num -> num > 10).collect(Collectors.toList());

        System.out.println(collect);

        List<Integer> collect1 = collect.stream().filter(num -> num == 10).collect(Collectors.toList());
        System.out.println(collect1);


    }


}
