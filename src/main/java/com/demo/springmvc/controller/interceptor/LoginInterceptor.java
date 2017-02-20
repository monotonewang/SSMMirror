package com.demo.springmvc.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by dell on 2017/2/20.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取请求的地址
        String requestURI = httpServletRequest.getRequestURI();
        //判断地址是公开的
        if (requestURI.contains("login.action")) {
            //如果是公开的，则放行
            return true;
        }
        //判断session是否有用户
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute("username");
        if(username!=null){
            return true;
        }

        //跳转到登录页面。进行登录验证

//        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(httpServletRequest,httpServletResponse);

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
