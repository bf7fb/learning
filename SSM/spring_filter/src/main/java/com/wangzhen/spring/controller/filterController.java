package com.wangzhen.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wz
 * @ClassName filterController
 * @date 2022/10/18 20:26
 * @Description TODO
 */
@Controller
public class filterController {
    @RequestMapping("/test/filter")
    public String testFilter(){
        return "success";
    }
    @RequestMapping("/test/exclude")
    public String testFilterExclude(){
        return "success";
    }


}
