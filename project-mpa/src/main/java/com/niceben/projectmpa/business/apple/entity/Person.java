package com.niceben.projectmpa.business.apple.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.niceben.projectmpa.mapper.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
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
@Accessors(chain = true)
@TableName("t_person")
@ApiModel(value = "Person对象", description = "")
public class Person extends BaseEntity {

    @ApiModelProperty("主键")
    @TableId(value = "person_id", type = IdType.AUTO)
    private Integer personId;

    private String personName;

    private Integer age;

    private String sex;

    private String mobile;

    private String address;


}
