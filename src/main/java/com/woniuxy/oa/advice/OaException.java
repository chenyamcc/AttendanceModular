package com.woniuxy.oa.advice;

import com.woniuxy.oa.enums.ExceptionEnum;
import com.woniuxy.oa.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @program: WoniuOA
 * @description: 统一的异常处理
 * @author: Carl
 * @create: 2019-09-04 16:27
 **/
@ControllerAdvice
public class OaException {

    @ExceptionHandler(UserException.class)
    public ModelAndView handleUserException(UserException e){
        ModelAndView modelAndView = new ModelAndView();
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        modelAndView.setStatus(exceptionEnum.getCode());
        modelAndView.addObject("message",exceptionEnum.getMessage());
        modelAndView.setViewName(exceptionEnum.getResultPath());
        return modelAndView;
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ModelAndView handleUserName(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("message", "用户名不存在");
        return modelAndView;
    }
}
