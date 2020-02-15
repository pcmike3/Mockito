package com.pc.mybatis.dao;

import com.pc.mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
