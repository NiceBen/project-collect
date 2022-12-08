package com.niceben.projectevent.business.event.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.niceben.projectevent.mapper.model.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
 * @since 2022-12-07
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@TableName("biz_account")
@ApiModel(value = "Account对象", description = "")
public class Account extends BaseEntity {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("名称")
    private String name;


}
