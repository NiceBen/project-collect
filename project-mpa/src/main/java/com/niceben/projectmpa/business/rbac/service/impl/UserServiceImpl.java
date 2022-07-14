package com.niceben.projectmpa.business.rbac.service.impl;

import com.niceben.projectmpa.business.rbac.entity.User;
import com.niceben.projectmpa.business.rbac.mapper.UserMapper;
import com.niceben.projectmpa.business.rbac.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author NiceBen
 * @since 2022-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
