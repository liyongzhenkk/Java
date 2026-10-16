package com.lyzstack.springmvc.dao;

import com.lyzstack.springmvc.util.SysUserDataUtil;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {
    @Override
    public boolean login(String username, String password) {
        return SysUserDataUtil.login(username, password);
    }
}
