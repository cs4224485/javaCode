package com.harry.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid工具类
 */

public class DruidUtil {
    private static DruidDataSource dataSource = null;
    static {
        Properties properties = new Properties();
        try {
            // 加载配置文件
           // properties.load(new FileInputStream("dbconfig.properties")); 不方便
            properties.load(DruidUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties"));
            // 得到一个数据源
           dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // 从数据源中获取一个链接对象
    public static Connection getCoonection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接异常");
        }
    }
}