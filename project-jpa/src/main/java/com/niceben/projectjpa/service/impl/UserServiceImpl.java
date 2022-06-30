package com.niceben.projectjpa.service.impl;

import com.niceben.projectjpa.mapper.SysUserRepository;
import com.niceben.projectjpa.model.entity.SysUser;
import com.niceben.projectjpa.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public List<SysUser> findAllByDepartment() {
        List<SysUser> devDept = sysUserRepository.findAllByDepartment("DevDept");
        return devDept;
    }


    @Override
    public List<SysUser> findAllByDepartmentAndRole() {
        List<SysUser> devDept = sysUserRepository.findAllByDepartmentAndRole("DevDept", "Admin");
        return devDept;
    }
}
