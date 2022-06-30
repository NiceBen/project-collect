package com.niceben.projectjpa.mapper;

import com.niceben.projectjpa.model.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRepository extends PagingAndSortingRepository<SysUser, Integer> {

    List<SysUser> findAllByDepartment(String devDept);

    List<SysUser> findAllByDepartmentAndRole(String devDept, String admin);



}
