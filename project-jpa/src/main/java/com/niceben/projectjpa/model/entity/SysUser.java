package com.niceben.projectjpa.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@ToString
@Entity
public class SysUser {
    @Id
    private Integer id;
    private String userName;
    private String department;
    private String role;
}
