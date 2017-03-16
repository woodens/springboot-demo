package com.stooges.springboot.service;

import com.stooges.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张超
 * @date 2017/3/15.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findUserList() {
        List<User> list = jdbcTemplate.query("select * from t_user", new Object[]{}, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into t_user(name, age) values(?, ?)", name, age);
    }

    @Override
    public void updateUser(Long id, User user) {
        jdbcTemplate.update("update t_user set ");
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
