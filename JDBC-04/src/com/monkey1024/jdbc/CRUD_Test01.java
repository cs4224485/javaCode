package com.monkey1024.jdbc;

import com.monkey1024.jdbc.jbdc.bean.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Test01 {
    public void testInsert() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/food_db", "harry.cai", "123456");
        // 得到执行sql语句的对象statement
        Statement stmt = conn.createStatement();
        // 执行sql语句并得到返回的结果
        int flag = stmt.executeUpdate("insert into(name,password, birthday) values ('cat', '123456', '414804000@qq.com') ");
        if (flag > 0) {
            System.out.println("sql执行成功");
        }
        // 关闭资源
        stmt.close();
        conn.close();
    }

    @Test
    public void testUpdate() throws ClassNotFoundException, SQLException  {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/food_db", "harry.cai", "123456");
        // 得到执行sql语句的对象statement
        Statement stmt = conn.createStatement();
        // 执行sql语句并得到返回的结果
        int flag = stmt.executeUpdate("update  t_user set password='123' where name='cat'");
        if (flag > 0) {
            System.out.println("sql执行成功");
        }
        // 关闭资源
        stmt.close();
        conn.close();
    }

    public void testDelete() throws ClassNotFoundException, SQLException  {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/food_db", "harry.cai", "123456");
        // 得到执行sql语句的对象statement
        Statement stmt = conn.createStatement();
        // 执行sql语句并得到返回的结果
        int flag = stmt.executeUpdate("delete from  t_user set password='123' where name='cat");
        if (flag > 0) {
            System.out.println("sql执行成功");
        }
        // 关闭资源
        stmt.close();
        conn.close();
    }
    public void testSelect() throws ClassNotFoundException, SQLException{
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取链接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.108:3306/food_db", "harry.cai", "123456" );
        // 得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        // 执行sql并返回语句
        ResultSet rs = stmt.executeQuery("SELECT * FROM user");
        // 处理结果
        List<User> userList = new ArrayList<User>();
        while (rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("name"));
            u.setPassword(rs.getString("password"));
            u.setEmail(rs.getNString("email"));
            u.setBirthday(rs.getDate("birthday"));
            userList.add(u);

        }

        // 关闭连接
        rs.close();
        stmt.close();
        conn.close();
    }
}
