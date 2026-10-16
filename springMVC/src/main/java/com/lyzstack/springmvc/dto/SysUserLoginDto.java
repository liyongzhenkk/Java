package com.lyzstack.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * projectName: 01_springmvc_part
 * description: 登录参数接收DTO
 */
@Data
public class SysUserLoginDto {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名长度需在2-20位之间")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "用户名长度需在6-20位之间")
    private String password;
}
