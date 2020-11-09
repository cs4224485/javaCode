package com.harry.pool;

import com.harry.util.DButil;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 遵循数据库连接池的规范， 实现DataSource接口
 */

public class MyPool implements DataSource {

    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
    // 在类加载后就向数据库连接池中添加10个数据库连接对象
    static {
        for (int i=0; i<10; i++){
            try {
                Connection connection = DButil.getConnection();
                // 将创建好的数据库连接放入到池子中
                pool.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        // 判断数据库连接池中是否还有数据库连接对象
        if(pool.size() > 0){
            conn = pool.removeFirst();
        }else {
            // 此时说明数据库连接池中没有可用的数据库连接了
            throw new RuntimeException("服务器忙，请稍后再试");
        }
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
