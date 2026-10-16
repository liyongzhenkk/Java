package com.lyzstack.springmvc.dao;

import com.lyzstack.springmvc.entities.SysUser;
import com.lyzstack.springmvc.util.SysUserDataUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //持久化层注解
public class UserMapperImpy implements UserMapper {
    @Override
    public boolean login(String username, String password) {
        return SysUserDataUtil.login(username, password);
    }

    @Override
    public boolean deleteById(Long id) {
        return SysUserDataUtil.deleteUserById(id);
    }

    @Override
    public boolean updateById(Long id, SysUser sysUser) {
        return SysUserDataUtil.updateUserById(id, sysUser);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        return SysUserDataUtil.saveUser(sysUser);
    }

    @Override
    public SysUser getById(Long id) {
        return SysUserDataUtil.getUserById(id);
    }

    @Override
    public List<SysUser> list(String username, String phone, Integer status) {
        return SysUserDataUtil.listUsers(username, phone, status);
    }
}
