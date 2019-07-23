package com.wwd.main.mybatis.dao;

import com.wwd.main.mybatis.model.User;

public  interface UserDao {
    public User get(String id);
}
