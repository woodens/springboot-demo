package com.stooges.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 张超
 * @date 2017/3/15.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(name, age) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from t_user where name=?",name);
    }

    @Override
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("select count(1) from t_user",Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from t_user");
    }
}
