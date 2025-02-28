package com.aoao.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author aoao
 * @create 2025-02-15-13:18
 */
public abstract class BaseDao<T>{
    private Class<T> clazz = null;
    {
        //获取当前对象父类泛型类型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //获取带参的父类泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取实际泛型
        clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    //增删改通用操作
    public int update(Connection conn,String sql,Object... args){
        int count = 0;
        try {
            QueryRunner queryRunner = new QueryRunner();
            count = queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    //查询单条
    public <T> T getInstance(Connection conn,String sql,Object... args){
        try {
            QueryRunner queryRunner = new QueryRunner();
            BeanHandler<T> beanHandler = new BeanHandler(clazz);
            return queryRunner.query(conn,sql,beanHandler,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询多条
    public <T> List<T> getList(Connection conn, String sql, Object... args){
        try {
            QueryRunner queryRunner = new QueryRunner();
            BeanListHandler<T> beanListHandler = new BeanListHandler(clazz);
            return queryRunner.query(conn,sql,beanListHandler,args);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }

    //查询特殊值
    public <T> T getValue(Connection conn, String sql, Object... args){
        try {
            QueryRunner queryRunner = new QueryRunner();
            ScalarHandler<T> scalarHandler = new ScalarHandler<>();
            return queryRunner.query(conn,sql,scalarHandler,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
