package com.niceben.projecttest.java8;

import com.niceben.projecttest.java8.function.StringLengthFunction;
import com.niceben.projecttest.java8.model.entity.UserInfo;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaTest {

    @Test
    public void testStream() {

        supportSupplier(() -> "hello world");

//        testSupplier();

//        testPredicate2();

//        testComsumer();
    }

    private void testSupplier() {
        Supplier<Integer> supplier = () -> Integer.valueOf("666");
        System.out.println(supplier.get());
    }


    private void supportSupplier(Supplier<String> supplier) {
        String s = supplier.get();
        System.out.println(s);
    }

    private void testPredicate() {
        //获取每个字符串的长度，并且返回
        Predicate<Integer> predicate = a -> a > 18;
        UserInfo userInfo = new UserInfo(2L, "程序员田螺", 27);
        System.out.println(predicate.test(userInfo.getAge()));
    }

    private void testPredicate2() {
        //获取每个字符串的长度，并且返回
        Predicate<String> predicate = a -> a.length() > 5;
        Stream<String> stream = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩");
        stream.forEach(str -> {
            System.out.println(predicate.test(str));
        });
    }

    private void testComsumer() {
        //获取每个字符串的长度，并且返回
        Consumer<String> comsumer = System.out::println;
        Stream<String> stream = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩");
        stream.forEach(comsumer);
    }

    private void testFunction() {
        //获取每个字符串的长度，并且返回
        Function<String, Integer> function = String::length;
        Stream<String> stream = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩");
        Stream<Integer> resultStream = stream.map(function);
        resultStream.forEach(System.out::println);
    }

    private void testFunction2() {
        //获取每个字符串的长度，并且返回
        Stream<String> stream = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩");
        Stream<Integer> resultStream = stream.map(str -> toFunction().apply(str));
        resultStream.forEach(System.out::println);
    }

    private void testFunction3() {
        StringLengthFunction stringLengthFunction = new StringLengthFunction();
        //获取每个字符串的长度，并且返回
        Stream<String> stream = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩");
        Stream<Integer> resultStream = stream.map(stringLengthFunction);
        resultStream.forEach(System.out::println);
    }

    private Function<String, Integer> toFunction() {
        return String::length;
    }
}
