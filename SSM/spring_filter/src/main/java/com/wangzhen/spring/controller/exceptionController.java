package com.wangzhen.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author wz
 * @ClassName exceptionController
 * @date 2022/10/19 11:04
 * @Description TODO
 */
@ControllerAdvice
public class exceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public String handleException(Model model, Exception ex){
        model.addAttribute("ex",ex);
        return "error";
    }
}
