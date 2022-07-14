package com.niceben.projectmpa.business.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.niceben.projectmpa.mapper.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author NiceBen
 * @since 2022-07-01
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User extends BaseEntity {

    private Long id;

    private String name;

    private Integer age;

    private String email;

//    @FieldBind(type = "user_sex", target = "sexText")
    @TableField("user_sex")
    private Integer sex;

    @TableField(exist = false)
    private String sexType;

    @TableField(exist = false)
    private String account;

//    @FieldEncrypt(algorithm = Algorithm.BASE64)
    @TableField(exist = false)
    private String password;

//    @FieldEncrypt(algorithm = Algorithm.AES, password = "123")
    @TableField(exist = false)
    private String phoneNum;

//    @TableField(typeHandler = AESEncryptHandler.class)
    @TableField(exist = false)
    private String identityCard;
}
