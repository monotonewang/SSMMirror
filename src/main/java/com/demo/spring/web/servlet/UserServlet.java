package com.demo.spring.web.servlet;

import com.demo.spring.web.service.UserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2017/1/13.
 */
@WebServlet(name = "UserServlet", urlPatterns = "/UserServlet")//servlet 3.0 urlPatterns 路径需要带 /    <----
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

		UserService userService = (UserService) applicationContext.getBean("webUserService");
		userService.sayHello();
	}
}
