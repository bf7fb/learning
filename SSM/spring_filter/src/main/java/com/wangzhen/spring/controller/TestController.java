package com.wangzhen.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wz
 * @ClassName TestController
 * @date 2022/10/19 11:10
 * @Description TODO
 */
@Controller
public class TestController {
    @RequestMapping("/test/exception")
    public String testForException(){
        System.out.println(1/0);
        return "success";
    }
}
