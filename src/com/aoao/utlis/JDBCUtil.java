package com.aoao.utlis;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author aoao
 * @create 2025-02-13-19:04
 */
public final class JDBCUtil {

    //获取druid连接池连接
    public static Connection getConnection() {
        try {
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    //关闭资源
//    public static void colseResource(Connection conn, Statement stmt, ResultSet rs) {
//        DbUtils.closeQuietly(stmt);
//        DbUtils.closeQuietly(rs);
//        DbUtils.closeQuietly(conn);
//    }
}
