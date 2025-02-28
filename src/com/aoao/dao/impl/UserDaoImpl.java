package com.aoao.dao.impl;

import com.aoao.bean.User;
import com.aoao.dao.BaseDao;
import com.aoao.dao.UserDao;
import com.aoao.utlis.JDBCUtil;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author aoao
 * @create 2025-02-17-15:10
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User findByUsername(String username) {
        try (Connection connection = JDBCUtil.getConnection()) { // 自动关闭连接
            String sql = "select uid as uid, username as userName, user_pwd as password, nick_name as nickName from news_user where username = ?";
            return getInstance(connection, sql, username);
        } catch (SQLException e) {
            e.printStackTrace(); // 处理异常
            return null; // 根据需求返回默认值或抛出异常
        }
    }

    @Override
    public User findByUserId(Integer userId) {
        try (Connection connection = JDBCUtil.getConnection()) { // 自动关闭连接
            String sql = "select uid as uid, username as userName, user_pwd as password, nick_name as nickName from news_user where uid = ?";
            return getInstance(connection, sql, userId);
        } catch (SQLException e) {
            e.printStackTrace(); // 处理异常
            return null; // 根据需求返回默认值或抛出异常
        }
    }

    @Override
    public Integer insertUser(User user) {
        try (Connection connection = JDBCUtil.getConnection()) { // 自动关闭连接
            String sql = "insert into news_user(username, user_pwd, nick_name) values (?, ?, ?)";
            return update(connection, sql, user.getUsername(), user.getPassword(), user.getNickName());
        } catch (SQLException e) {
            e.printStackTrace(); // 处理异常
            return 0; // 根据需求返回默认值或抛出异常
        }
    }
}
