package com.lyzstack.springmvc.controller;

import com.lyzstack.springmvc.dao.UserMapperImpy;
import com.lyzstack.springmvc.entities.SysUser;
import com.lyzstack.springmvc.service.UserServiceImpl;
import com.lyzstack.springmvc.util.SysUserDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class SysuserControllerValidationTests {
    private SysuserController controller;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        controller = new SysuserController();
        controller.userService = new UserServiceImpl() {
            @Override
            public SysUser save(SysUser user) {
                throw new AssertionError("校验失败时不应调用保存方法");
            }
        };
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void invalidFieldsReturnAllErrorsWithoutSaving() throws Exception {
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"username":" ","phone":"123","status":2,"roleId":0}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message", containsString("username:")))
                .andExpect(jsonPath("$.message", containsString("phone:")))
                .andExpect(jsonPath("$.message", containsString("status:")))
                .andExpect(jsonPath("$.message", containsString("roleId:")));
    }

    @Test
    void missingRequiredFieldsAreRejected() throws Exception {
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.message", containsString("用户名不能为空")))
                .andExpect(jsonPath("$.message", containsString("手机号不能为空")))
                .andExpect(jsonPath("$.message", containsString("角色ID不能为空")));
    }

    @Test
    void validUserIsSavedWithDefaultPasswordAndStatus() throws Exception {
        controller.userService = new UserServiceImpl();
        ReflectionTestUtils.setField(controller.userService, "userDao", new UserMapperImpy());
        String username = "validation_test";
        assertTrue(SysUserDataUtil.listUsers(username, null, null).isEmpty());
        try {
            mockMvc.perform(post("/user")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("""
                                    {"username":"validation_test","phone":"13800138000","roleId":1}
                                    """))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.code").value(200))
                    .andExpect(jsonPath("$.data.id").isNumber())
                    .andExpect(jsonPath("$.data.password").value("1234556"))
                    .andExpect(jsonPath("$.data.status").value(1));
        } finally {
            SysUserDataUtil.listUsers(username, null, null)
                    .forEach(user -> SysUserDataUtil.deleteUserById(user.getId()));
        }
    }
}
