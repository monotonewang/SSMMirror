package com.demo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 需求：用户访问系统的资源(url)，如果用户没有进行身份认证，进行拦截，系统跳转登陆页面，
 * 如果用户已经认证通过，用户可以继续访问系统的资源。
 * <p>
 * Created by dell on 2017/2/20.
 */
@Controller
public class LoginController {

    //登录系统方法
    @RequestMapping("/login")
    public String login(HttpSession session, String username) {
        //调用service方法验证用户名和密码

        //登录成功之后将用户名存储到session中
        session.setAttribute("username", username);
        System.out.println("login method");
        return "redirect:/item/queryItem.action";
    }

    //退出登录方法
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            //session失效
            session.invalidate();
        }
        //重定向到商品查询页面
        return "redirect:/item/queryItem.action";
    }
}
