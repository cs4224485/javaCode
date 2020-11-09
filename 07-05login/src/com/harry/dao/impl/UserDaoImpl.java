package com.harry.dao.impl;

import com.harry.javabean.User;
import com.harry.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class UserDaoImpl  implements UserDao{
    private Connection conn = null;
    private PreparedStatement ps = null;

    public void addUser(User user) throws Exception{
        conn = DBUtil.getConnection();
        ps = conn.prepareStatement("insert into  t_user(name,password,email,birthday) values (?,?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(user.getBirthday());
        ps.setString(4, birthday);
        ps.executeUpdate();
    }

    @Override
    public User findUserByNameAndPassword(User user) throws Exception {
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        ps = conn.prepareStatement("select name from t_user where name=? and password=?");
        ps.setString(1,user.getName());
        ps.setString(2,user.getPassword());
        rs = ps.executeQuery();
        User u = null;
        if(rs.next()){
            u = new User();
            u.setName(rs.getString("name"));
        }
        return u;
    }

    @Override
    public User findUserByName(User user) throws Exception {
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        ps = conn.prepareStatement("select name,password,email,birthday from t_user where name=? ");
        ps.setString(1,user.getName());
        rs = ps.executeQuery();
        User u = null;
        // 将查询出的结果数据封装到User对象中
        System.out.println(rs);
        if(rs.next()){
            u = new User();
            u.setName(rs.getString("name"));
            u.setPassword(rs.getString("password"));
            u.setBirthday(rs.getDate("birthday"));
            u.setEmail(rs.getString("email"));
        }
        return u;
    }
}
