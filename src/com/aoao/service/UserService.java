package com.aoao.service;

import com.aoao.bean.User;

/**
 * @author aoao
 * @create 2025-02-17-15:24
 */
public interface UserService {
    /**
     * 通过username查询是否有该user
     * @param username
     * @return 返回user
     */
    User findByUsername(String username);

    /**
     * 通过userId查询是否有该user
     * @param userId
     * @return 返回user
     */
    User findByUserId(Integer userId);

    /**
     *
     * @param user
     * @return 影响行数
     */
    Integer registUser(User user);
}
