package com.niceben.projecttest.java8.function;

import java.util.function.Function;

public class StringLengthFunction implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
