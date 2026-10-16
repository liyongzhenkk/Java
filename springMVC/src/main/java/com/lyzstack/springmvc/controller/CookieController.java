package com.lyzstack.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 测试入口：/cookie/set?username=zhangsan
 * 流程：写 Cookie → 浏览器保存 Cookie → 重定向到 HTML → 页面读取 Cookie。
 */
@Controller
@RequestMapping("/cookie")
public class CookieController {

    private static final String COOKIE_NAME = "demo_username";

    @GetMapping("/set")
    public void setCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 原生 request 读取 URL 中的参数。
        String username = request.getParameter("username");
        if (username == null || username.isBlank()) {
            username = "zhangsan";
        }
        if (username.length() > 100) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "username must be at most 100 characters");
            return;
        }

        // 2. 中文、空格等先编码，再放入 Cookie。
        Cookie cookie = new Cookie(COOKIE_NAME, URLEncoder.encode(username, StandardCharsets.UTF_8));
        cookie.setMaxAge(10 * 60); // 浏览器保存 10 分钟，单位是秒。
        cookie.setPath(request.getContextPath() + "/"); // 页面和读取接口都能收到这个 Cookie。
        cookie.setHttpOnly(false); // 为了演示 document.cookie；登录凭证通常应设为 true。
        cookie.setSecure(request.isSecure());
        cookie.setAttribute("SameSite", "Lax");
        response.addCookie(cookie); // 写入响应的 Set-Cookie 头，让浏览器保存。
        response.setHeader("Cache-Control", "no-store");

        // 3. 返回 302。浏览器保存 Cookie 后，重新请求 cookie.html。
        // 新写入的 Cookie 要等浏览器下一次请求时，才会出现在 request.getCookies() 中。
        response.sendRedirect(request.getContextPath() + "/cookie.html");
    }

    @GetMapping("/read")
    public void readCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.setHeader("Cache-Control", "no-store");

        // 浏览器通过请求头 Cookie 携带数据；没有 Cookie 时，返回值可能是 null。
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_NAME.equals(cookie.getName())) {
                    try {
                        String username = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                        response.getWriter().write(username); // 原生 response 输出文本给页面。
                    } catch (IllegalArgumentException e) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        response.getWriter().write("Cookie 编码无效，请重新设置。");
                    }
                    return;
                }
            }
        }
        response.getWriter().write("尚未找到 demo_username，请先设置 Cookie。");
    }
}
