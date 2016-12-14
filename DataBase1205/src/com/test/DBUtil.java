package com.test;

import java.sql.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * 数据库工具类（采用了tomcat jdbc pool）
 * @author zhong
 *
 */
public class DBUtil {
    
    private static DataSource ds;
    
    static {
        //配置tomcat jdbc pool (连接池)
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:sqlserver://localhost:1433; DatabaseName=BookTicket");    //设置连接的url
        p.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    //载入数据库驱动
        p.setUsername("sa");    //用于远程连接的用户名
        p.setPassword("zp19960217");    //密码
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        ds = new DataSource();
        ds.setPoolProperties(p);
    }
    
    private DBUtil() {}
    
    /**
     * 获取一个数据库连接（Connection）；
     * @return Database Connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        
        try {            
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
    /**
     * 关闭传入的Connection；
     * @param conn 待关闭的Connection
     */
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭传入的Statement；
     * @param stmt    待关闭的Statement
     */
    public static void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 关闭传入的ResultSet；
     * @param rs    待关闭的ResultSet
     */
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}