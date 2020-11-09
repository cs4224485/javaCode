package com.monkey1024.jdbc;

import java.sql.*;

public class JDBC_Test01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/food_db", "harry.cai", "123456" );
        // 得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        // 执行sql并返回语句
        ResultSet rs = stmt.executeQuery("SELECT * FROM user");
        // 处理结果
        while (rs.next()){
            System.out.println(rs.getObject("uid"));
            System.out.println(rs.getObject("nickname"));
            System.out.println(rs.getObject("email"));
        }

        // 关闭连接
        rs.close();
        stmt.close();
        conn.close();
    }
}
