package com.harry.test;

import com.harry.pool.MyClosePool;
import com.harry.pool.MyPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoolTest  {
    public static void main(String[] args) {
        MyClosePool ds = new MyClosePool();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ds.getConnectionFromPool();
            ps =  conn.prepareStatement("....");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                // 这里会调用我们自定的MyConnection类中的close方法将连接放回到数据库连接池中
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
