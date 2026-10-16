package com.lyzstack.springmvc.interceptor;

import com.lyzstack.springmvc.entities.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tools.jackson.databind.ObjectMapper;

import java.io.PrintWriter;

@Component
public class LoginProtectInterceptor implements HandlerInterceptor {
    public static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.yanzheng
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        //2.bu fang xing
        if (username == null || username.isEmpty()) {
            // 设置响应格式为JSON，避免前端解析失败
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");

            // 构建统一Result响应体
            Result errorResult = Result.failed(501, "未登录，请先登录！");

            // 核心：用Spring默认的ObjectMapper将Result转为JSON字符串
            PrintWriter writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(errorResult));
            writer.flush();
            writer.close();

            return false; // 拦截请求，不进入Controller
        }

        //3.fang xing
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
