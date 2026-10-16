package com.lyzstack.springmvc.dao;

import com.lyzstack.springmvc.entities.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    boolean deleteById(Long id);
    boolean updateById(Long id, SysUser sysUser);
    SysUser save(SysUser sysUser);
    SysUser getById(Long id);
    List<SysUser> list(String username, String phone, Integer status);
    boolean login(String username, String password);
}
