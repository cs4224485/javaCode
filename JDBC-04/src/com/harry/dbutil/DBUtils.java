package com.harry.dbutil;

import java.sql.*;
import java.util.concurrent.locks.Condition;

public class DBUtils {
    private static String url = "jdbc:mysql://192.168.0.108:3306/food_db";
    private static String user = "harry.cai";
    private static String password = "123456";
    private static String driverClass = "com.mysql.jdbc.Driver";
    static {
        // 注册驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        // 连接数据连接
        return DriverManager.getConnection(url, user, password);
    }
    public static void close(ResultSet rs, Statement stmt){
        // 关闭数据库资源
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
