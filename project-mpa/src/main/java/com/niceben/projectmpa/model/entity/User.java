package com.niceben.projectmpa.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.niceben.projectmpa.constant.enums.SexEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "用户表", excludeProperty = "email")
public class User {
    @TableId(value = "主键", type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "姓名")
    private String name;

    private Integer age;

    private String email;

    @EnumValue
    private SexEnum sex;

    @TableLogic
    private Integer isDel;

    @TableField(value = "地址", exist = false)
    private String address;

    @OrderBy
    @TableField(value = "创建时间", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "创建时间", fill = FieldFill.UPDATE)
    private Date modifyTime;

    @Version
    @TableField(value = "版本号")
    private Integer version;

}