package com.lyzstack.springmvc.controller;


import ch.qos.logback.core.util.StringUtil;
import com.lyzstack.springmvc.entities.Result;
import com.lyzstack.springmvc.entities.SysUser;
import com.lyzstack.springmvc.service.UserService;
import com.lyzstack.springmvc.util.SysUserDataUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class SysuserController {

    @Autowired
    UserService userService;

    // 列表没有匹配结果时，仍然查询成功，data 为 []。
    @GetMapping("/list")
    public Result fingUserList(@RequestParam(required = false) String username,
                               @RequestParam(required = false) String phone,
                               @RequestParam(required = false) Integer status
                               ){
//        List<SysUser> users = SysUserDataUtil.listUsers(username, phone, status);
        List<SysUser> users = userService.list(username, phone, status);
        return Result.success("查询成功", users);
    }

    @GetMapping("/{id}")
    public Result findByID(@PathVariable Long id){
//        SysUser sysUser = SysUserDataUtil.getUserById(id);
        SysUser sysUser = userService.getById(id);
        if (sysUser == null) {
            return Result.failed(404, "用户不存在，ID：" + id);
        }
        return Result.success("查询成功", sysUser);
    }

//    @GetMapping("hobby")
//    public void hobby(@RequestParam List<String> hbs){
//        System.out.println(hbs);
//    }

    @PostMapping()
    public Result create(@Valid @RequestBody SysUser sysUser, BindingResult bindingResult){
        // BindingResult 紧跟被校验的参数，用于接收字段校验错误。
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            String errorMessage = fieldErrors.stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .collect(Collectors.joining(";"));
            return Result.failed(400, errorMessage);
        }

        sysUser.setPassword("1234556"); // 按示例设置默认密码
        SysUser savedUser = userService.save(sysUser);
        if (savedUser != null && savedUser.getId() != null) {
            return Result.success("新增用户成功", savedUser);
        }
        return Result.failed("新增用户失败");
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody SysUser sysUser) {
//        boolean updated = SysUserDataUtil.updateUserById(id, sysUser);
        boolean updated = userService.updateById(id, sysUser);
        if (!updated) {
            return Result.failed(404, "更新失败，用户不存在，ID：" + id);
        }
        // 返回保存后的完整用户，包含 ID、保留的字段和新的更新时间。
        SysUser updatedUser = userService.getById(id);
        return Result.success("更新用户成功", updatedUser);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
//        boolean deleted = SysUserDataUtil.deleteUserById(id);
        boolean deleted = userService.deleteById(id);
        if (!deleted) {
            return Result.failed(404, "删除失败，用户不存在，ID：" + id);
        }
        // code 和 message 已说明结果，删除后没有用户数据需要返回。
        return Result.success("删除用户成功", null);
    }
}
