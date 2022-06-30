package com.niceben.projectjpa.controller;

import com.niceben.projectjpa.model.entity.SysUser;
import com.niceben.projectjpa.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findAllByDepartment")
    public List<SysUser> findAllByDepartment() {
        return userService.findAllByDepartment();
    }

    @GetMapping("/findAllByDepartmentAndRole")
    public List<SysUser> findAllByDepartmentAndRole() {
        return userService.findAllByDepartmentAndRole();
    }
}
