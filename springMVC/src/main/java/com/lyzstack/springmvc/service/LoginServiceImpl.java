package com.lyzstack.springmvc.service;

import com.lyzstack.springmvc.dao.LoginDao;
import com.lyzstack.springmvc.dao.LoginDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean login(String username, String password) {
        return loginDao.login(username, password);
    }

}
