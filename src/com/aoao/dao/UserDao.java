package com.aoao.dao;

import com.aoao.bean.User;

/**
 * @author aoao
 * @create 2025-02-17-15:08
 */
public interface UserDao {
    /**
     * 从数据库中以username查询用户信息
     * @param username
     * @return 具体用户
     */
    User findByUsername(String username);

    /**
     * 从数据库中以userId查询用户信息
     * @param userId
     * @return 具体用户
     */
    User findByUserId(Integer userId);

    /**
     * 向数据库中插入该user
     * @param user
     * @return 影响行数
     */
    Integer insertUser(User user);
}
