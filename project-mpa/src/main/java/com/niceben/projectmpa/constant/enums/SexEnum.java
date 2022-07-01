package com.niceben.projectmpa.constant.enums;

import lombok.Getter;

@Getter
public enum SexEnum {

    MALE("男", 1),
    FEMALE("女", 2);

    private String name;
    private int code;

    SexEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
