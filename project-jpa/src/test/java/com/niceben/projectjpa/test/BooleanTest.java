package com.niceben.projectjpa.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class BooleanTest {

    public static void main(String[] args) {
        Boolean reality = true;
        if(reality) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    @Test
    public void test() {
        System.out.println("hello world");
    }


    @Test
    public void testList() {
        List<String> strings = Arrays.asList("zhangsan", "lisi", "wangwu");
        strings.forEach(System.out::println);
    }


    @Test
    public void testList2() {
        List<String> strings = Arrays.asList("zhangsan", "lisi", "wangwu");
        strings.forEach(System.out::println);
    }


    static {
        try {
            Field trueField = Boolean.class.getDeclaredField("TRUE");
            trueField.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(trueField, trueField.getModifiers() & ~Modifier.FINAL);

            trueField.set(null, false);
        } catch(IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
