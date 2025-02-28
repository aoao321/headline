package com.aoao.dao.impl;

import com.aoao.bean.Type;
import com.aoao.dao.BaseDao;
import com.aoao.dao.TypeDao;
import com.aoao.utlis.JDBCUtil;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * @author aoao
 * @create 2025-02-17-15:10
 */
public class TypeDaoImpl extends BaseDao<Type> implements TypeDao {

    @Override
    public List<Type> findAll() {
        try (Connection connection = JDBCUtil.getConnection()) { // 自动关闭连接
            String sql = "select tid,tname from news_type";
            return getList(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // 根据实际需求处理异常
        }
    }
}