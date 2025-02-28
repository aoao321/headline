package com.aoao.service.impl;

import com.aoao.bean.Type;
import com.aoao.dao.TypeDao;
import com.aoao.dao.impl.TypeDaoImpl;
import com.aoao.service.TypeService;

import java.util.Collections;
import java.util.List;

/**
 * @author aoao
 * @create 2025-02-17-15:25
 */
public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao = new TypeDaoImpl();

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }
}
