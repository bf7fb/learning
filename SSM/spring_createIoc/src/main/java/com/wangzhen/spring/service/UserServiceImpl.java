package com.wangzhen.spring.service;

import com.wangzhen.spring.Dao.UserDao;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
