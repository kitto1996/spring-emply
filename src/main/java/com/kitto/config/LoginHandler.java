package com.kitto.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kitto
 * 拦截器
 * @create 2022-04-09-15:29
 */
public class LoginHandler implements HandlerInterceptor {
    //之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功，获取用户session
        Object loginUser = request.getSession().getAttribute("loginUser");
        //如果没有登录
        if (loginUser == null) {
            request.setAttribute("msg", "用户没有登录，不能访问!");
            //返回到登录界面
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        } else {
            //登录成功，返回true
            return true;
        }
    }

}
