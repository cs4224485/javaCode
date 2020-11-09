package com.harry.test;

import com.harry.util.C3P0Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试C3P0
 */

public class C3P0Test {
    public static void main(String[] args) throws InterruptedException {
        insert();
        Thread.sleep(1000);
        C3P0Util.poolStatus();
    }

    public static void insert(){
        String sql = "insert into t_user(id,name) values(1002, 'jack')";
        Connection conn = C3P0Util.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            // 查看连接池的状态
            C3P0Util.poolStatus();
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
