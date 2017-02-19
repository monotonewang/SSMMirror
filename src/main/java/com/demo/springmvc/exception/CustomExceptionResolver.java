package com.demo.springmvc.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义异常处理
 * Created by WangTest on 2017/2/19.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    //前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
    //handler最终要执行的Handler，它的真实身份是HandlerMethod
    //Exception ex就是接收到异常信息
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //输出异常
        e.printStackTrace();

        //统一异常处理代码
        //针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
        //异常信息
        String message = null;

        CustomException customException = null;
        //如果ex是系统 自定义的异常，直接取出异常信息
        if(e instanceof CustomException){
            customException = (CustomException)e;
        }else{
            //针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
            customException = new CustomException("未知错误");
        }

        //错误 信息
        message = customException.getMessage();

        httpServletRequest.setAttribute("message", message);


        try {
            //转向到错误 页面
            httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return new ModelAndView();

    }
}
