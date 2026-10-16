package com.lyzstack.springmvc.service;

import com.lyzstack.springmvc.dao.UserMapper;
import com.lyzstack.springmvc.entities.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public boolean deleteById(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public boolean updateById(Long id, SysUser sysUser) {
        return userDao.updateById(id, sysUser);
    }

    @Override
    public SysUser save(SysUser sysUser) {
        return userDao.save(sysUser);
    }

    @Override
    public SysUser getById(Long id) {
        if(userDao.getById(id) == null){
            return null;
        }
        return userDao.getById(id);
    }

    @Override
    public List<SysUser> list(String username, String phone, Integer status) {
        return userDao.list(username, phone, status);
    }
}
