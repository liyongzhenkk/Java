package com.lyzstack.springmvc.controller;

import com.lyzstack.springmvc.dto.SysUserLoginDto;
import com.lyzstack.springmvc.entities.Result;
import com.lyzstack.springmvc.service.LoginService;
import com.lyzstack.springmvc.service.LoginServiceImpl;
import com.lyzstack.springmvc.util.SysUserDataUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /*
       登录接口
       /auth/login  post方式 请求体传递参数 username password
       验证成功以后，将账号存储在session!
       返回 {code:200,message:"登录成功",data:null}
     */
    @PostMapping("login")
    public Result login(HttpSession session, @Valid @RequestBody SysUserLoginDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return Result.failed(500,"账号和密码不符合规则,登录失败！");
        }
        //登录校验
//        boolean logined = SysUserDataUtil.login(user.getUsername(), user.getPassword());
        boolean logined = loginService.login(user.getUsername(), user.getPassword());
        if(!logined){
            return Result.failed("账号或者密码错误！");
        }
        //存储到session共享域
        session.setAttribute("username", user.getUsername());
//        System.out.println(session.getAttribute("username"));
        return Result.success("登录成功！");
    }

    /*
       退出登录接口
       /auth/logout  get方式  没有参数
       然后清空session数据
       返回 {code:200,message:"退出登录成功",data:null}
     */
    @GetMapping("logout")
    public Result logout(HttpSession session) {
        //删除数据
        session.removeAttribute("username");
        //让session失效
        session.invalidate();
        return Result.success("退出登录成功！");
    }
}