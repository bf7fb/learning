package com.wangzhen.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wz
 * @ClassName TestRestController
 * @date 2022/10/12 18:01
 * @Description
 * 查询所有---->get
 * 根据id查询---->get
 * 添加---->put
 * 修改---->
 * 删除----delete
 */
@Controller
public class TestRestController {
    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public String selectAll(){
        System.out.println("selectAll method = RequestMethod.GET");
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String selectById(@PathVariable("id") Integer id){
        System.out.println("selectById  id = " + id + "method = RequestMethod.GET");
        return "success";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String UpdateUser(){
        System.out.println("addUser RequestMethod.PUT ");
        return "success";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") Integer id){
        System.out.println("deleteById + id = " + id + "RequestMethod.DELETE");
        return "success";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(){
        System.out.println("addUser RequestMethod.POST ");
        return "success";
    }

}
