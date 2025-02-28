package com.aoao.dao;

import com.aoao.bean.Type;

import java.util.List;

/**
 * @author aoao
 * @create 2025-02-17-15:08
 */
public interface TypeDao {
    /**
     * 从数据库查询所有的头条类型
     * @return 以集合返回多个类型
     */
    List<Type> findAll();
}
