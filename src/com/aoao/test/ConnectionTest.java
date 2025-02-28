package com.aoao.test;

import com.aoao.utlis.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;

/**
@author aoao
@create 2025-02-13-19:41
*/

public class ConnectionTest {

    @Test
    public void test() {
        Connection connection = JDBCUtil.getConnection();
        System.out.println(connection);

    }

}
