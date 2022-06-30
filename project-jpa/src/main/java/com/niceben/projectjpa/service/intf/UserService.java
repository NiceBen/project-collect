package com.niceben.projectjpa.service.intf;

import com.niceben.projectjpa.model.entity.SysUser;

import java.util.List;

public interface UserService {

    List<SysUser> findAllByDepartment();

    List<SysUser> findAllByDepartmentAndRole();
}
