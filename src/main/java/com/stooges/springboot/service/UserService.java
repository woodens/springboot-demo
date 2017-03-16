package com.stooges.springboot.service;

import com.stooges.springboot.domain.User;

import java.util.List;

/**
 * @author 张超
 * @date 2017/3/15.
 */
public interface UserService {
    public List<User> findUserList();
    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name ,Integer age);

    /**
     * 更新用户
     * @param id
     * @param user
     */
    void updateUser(Long id,User user);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     * @return
     */
    Integer getUserCount();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
