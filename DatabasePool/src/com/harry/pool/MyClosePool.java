package com.harry.pool;

import com.harry.connection.MyConnection;
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
 * 模拟编写一个数据库连接池
 */

public class MyClosePool implements DataSource {

    // 创建一个存放连接的池子, 需要保证线程安全
    // 因为会频繁的对数据库连接池进行取出和放回的操作，所以使用LinkedList作为连接池
    private static LinkedList<Connection> pool = (LinkedList<Connection>)Collections.synchronizedList(new LinkedList<Connection>());
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
    // 从连接池获取一个数据库连接
    public static Connection getConnectionFromPool(){
        Connection conn = null;
        // 判断数据库连接池中是否还有数据库连接对象
        if(pool.size() > 0){
            conn = pool.removeFirst();
            MyConnection myConn = new MyConnection(conn, pool);
            return myConn;
        }else {
            // 此时说明数据库连接池中没有可用的数据库连接了
            throw new RuntimeException("服务器忙，请稍后再试");
        }

    }

    // 当程序用完连接之后，将链接重新放入到连接池
    public static void release(Connection conn){
        pool.addLast(conn);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
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
