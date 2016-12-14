package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConductDao {
	 // insert方法 向数据库中插入用户信息
		public int insert(Connection connection, Conduct con)
	        {
		
			int value=-1;
			PreparedStatement statement=null;
			String sql="insert into Con(Name,Pass) values(?,?)";
	                try 
	                {

	                    statement=connection.prepareStatement(sql);
	                    statement.setString(1,con.getUsername());
	                    statement.setString(2,con.getPassword());
	                   
	                    value=statement.executeUpdate();
	                } 
	                catch (SQLException ex)
	                {
	                    ex.printStackTrace();
	                }
			finally
			{
	                	try
				{
					if(statement != null) statement.close();
				}
				catch (SQLException ex)
				{
				}
			}
	                return value;
	        }
	        //check方法 根据登陆界面传输的用户名和密码与数据库进行比较
	        // 如果有这用户名则返回真,每有责返回假 
	    public   boolean check(Connection connection, String username, String password)
	    {
			boolean value = false;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			String sql = "select Name from Con where Name = ? and Pass= ?";
			  System.out.println(" 管理员sql==" +sql);;
			try
			{
				// 获得PreparedStatement对象，并填充
				statement = connection.prepareStatement(sql);
				statement.setString(1,username);
				statement.setString(2,password);
				resultSet = statement.executeQuery();
				while(resultSet.next())
				{
					value = true;
				}
				return value;
			}
			catch (SQLException e)
			{
			}
			finally
			{
				try
				{
					if(resultSet != null) resultSet.close();
					if(statement != null) statement.close();
				}
				catch (SQLException e)
				{
				}
			}
			return value;
	          }
	  
	// getUser方法  根据username 进行数据库查询操作
	    // 将查询出的值放入User对象中 并返回该对象
	     public Conduct getUser(Connection connection, String username)
	     {
	           Conduct Con=new Conduct();
	           String sql="select Name,Pass  from Con where Name=?";
	           PreparedStatement statement=null;
	           ResultSet result=null;
	           
	           try
	           {
	               statement=connection.prepareStatement(sql);
	               System.out.println("statement==="+statement);
	               statement.setString(1,username);
	               result=statement.executeQuery();
	               System.out.println("result==="+result);
	               while(result.next())
	               {
	                   Con.setUsername(result.getString("Nameame"));
	                   Con.setPassword(result.getString("Pass"));
	                  
	               }
	               System.out.println("Con==="+Con);
	               return Con;
	           }
	          catch (SQLException e)
	          {
	          }
	           finally
	           {
	              try
	              {
	                  if(statement!=null)statement.close();
	                  if(result!=null)result.close();
	              }
	              catch(SQLException e)
	              {
	              }
	           }
	           return Con;
	     }
	     // Update 获得用户修改后的信息 进行数据库的修改操作
	        public int Update(Connection connection, Conduct con)
		{
			int value = -1;
			PreparedStatement statement = null;
			String sql = "update Con set  Pass = ?  where Name = ?";

			try
			{
				// 获得PreparedStatement对象
				statement = connection.prepareStatement(sql);
				// 填充statement的参数
				
				statement.setString(1, con.getUsername());
				statement.setString(2, con.getPassword());
				 		
				// 执行修改操作
				value = statement.executeUpdate();
			}
			catch (SQLException e)
			{
			}
			finally
			{
				try
				{
					if(statement != null) statement.close();
					//if(connection != null) connection.close();
				}
				catch (SQLException e)
				{
				}
			}
			return value;
		}
	        
	        // UpdatePass  根据用户输入的密码 进行输入密码修改操作
	        public int UpdatePass(Connection connection,String Password,String username)
		{
			int value = -1;
			PreparedStatement statement = null;
			String sql = "update Con set Pass = ? where Name = ?";

			try
			{
				// 获得PreparedStatement对象
				statement = connection.prepareStatement(sql);
				// 填充statement的参数
				statement.setString(1, Password);
				statement.setString(2, username);
				// 执行修改操作
				value = statement.executeUpdate();
			}
			catch (SQLException e)
			{
			}
			finally
			{
				try
				{
					if(statement != null) statement.close();
					//if(connection != null) connection.close();
				}
				catch (SQLException e)
				{
				}
			}
			return value;
		}
	 
	}