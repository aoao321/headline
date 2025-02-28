package com.aoao.service.impl;

import com.aoao.bean.User;
import com.aoao.dao.UserDao;
import com.aoao.dao.impl.UserDaoImpl;
import com.aoao.service.UserService;
import com.aoao.utlis.MD5Util;

/**
 * @author aoao
 * @create 2025-02-17-15:25
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public Integer registUser(User user) {
        //处理增加的业务
        //将明文密码转换成密文密码
        user.setPassword(MD5Util.encrypt(user.getPassword()));

        return userDao.insertUser(user);
    }
}
