package com.wangzhen.spring.controller;

import com.wangzhen.spring.service.UserService;

public class UserController {
    private UserService userService;

    public UserController() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void saveUser(){
        userService.saveUser();
    }
}
