package com.lyzstack.springmvc.service;

import com.lyzstack.springmvc.entities.SysUser;

import java.util.List;

public interface UserService {
    boolean deleteById(Long id);
    boolean updateById(Long id, SysUser sysUser);
    SysUser save(SysUser sysUser);
    SysUser getById(Long id);
    List<SysUser> list(String username, String phone, Integer status);
}
