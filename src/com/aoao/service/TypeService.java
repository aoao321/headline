package com.aoao.service;

import com.aoao.bean.Type;

import java.util.List;

/**
 * @author aoao
 * @create 2025-02-17-15:27
 */
public interface TypeService {
    /**
     * 查询所有头条类型的方法
     * @return 以集合返回多个类型
     */
    List<Type> findAll();
}
