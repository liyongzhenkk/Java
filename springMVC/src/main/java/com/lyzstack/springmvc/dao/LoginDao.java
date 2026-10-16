package com.lyzstack.springmvc.dao;

public interface LoginDao {
    // 新增：登录校验（仅调用工具类，无业务逻辑）
    boolean login(String username, String password);
}
