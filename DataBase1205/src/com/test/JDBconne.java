package com.test;

import java.sql.*;


public final class JDBconne 
{
    
  private static Connection connection = null;
  
      public static Connection getConnetion()
      {	
    	  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
          String url = "jdbc:sqlserver://localhost:1433;DatabaseName=BookTicket";
          String user = "sa";
          String password = "zp19960217";

                    try
                    {
                    	Class.forName(driverName);
                            // 注册驱动
                            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                            // 获得连接对象
                            connection = DriverManager.getConnection(url, user, password);
                    }
                    catch (SQLException e)
                    {
                    } catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    return connection;
      }
      public static void closeConnection()
	{
		try
		{
			if(connection != null) connection.close();
		}
		catch (SQLException e)
		{
		}
	}
    
}
