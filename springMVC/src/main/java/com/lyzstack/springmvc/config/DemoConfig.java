package com.lyzstack.springmvc.config;


import com.lyzstack.springmvc.interceptor.LoginProtectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoConfig implements WebMvcConfigurer {
    @Autowired
    private LoginProtectInterceptor loginProtectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginProtectInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns(
                "/auth/login", "/auth/logout", // 放行登录/退出
                "/**.html", "/**.css", "/**.js"); // 放行静态资源)
    }
}
