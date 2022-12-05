package com.niceben.projecttest.cache.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

    private Long id;

    private String name;

    private Integer age;

    public UserVo(String name) {
        this.name = name;
    }
}
