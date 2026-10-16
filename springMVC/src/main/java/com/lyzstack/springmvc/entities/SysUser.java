package com.lyzstack.springmvc.entities;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户实体类（对应sys_user表）
 */
@Data // 自动生成get/set/toString/equals/hashCode等方法，需引入lombok依赖
public class SysUser {
    private Long id;         // 用户唯一ID

    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 20, message = "用户名长度需在2-20位之间")
    private String username; // 用户名

    private String password; // 新增时由后端设置默认密码，无需前端传入

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9][0-9]{9}$", message = "手机号格式不正确")
    private String phone;    // 手机号（唯一）

    private String avatar;   // 用户头像URL

    // 允许不传，保存时默认设为1；传入时只能为0或1。
    @Min(value = 0, message = "账号状态只能为0或1")
    @Max(value = 1, message = "账号状态只能为0或1")
    private Integer status;  // 账号状态：0-禁用，1-正常

    @NotNull(message = "角色ID不能为空")
    @Positive(message = "角色ID必须大于0")
    private Long roleId;     // 角色ID（关联角色表）
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间
}
