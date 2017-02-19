package com.demo.springmvc.exception;

/**
 *
 * 1.自定义异常类型，实际开发中可能会定义多种异常类型
 * Created by WangTest on 2017/2/19.
 */
public class CustomException extends Exception {


    //异常信息
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
