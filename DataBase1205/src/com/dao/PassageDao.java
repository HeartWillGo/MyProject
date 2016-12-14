package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PassageDao {

	public int insert(Connection connection, Passage user)
    {

	int value=-1;
	PreparedStatement statement=null;
	String sql="insert into Passage(Id,name,sex,IdCard) values(?,?,?,?)";
            try 
            {

                statement=connection.prepareStatement(sql);
                statement.setString(1,user.getId());
                statement.setString(2,user.getName());
                statement.setString(3,user.getSex());
                statement.setString(4,user.getIdCard());
               
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
 

//getUser方法  根据username 进行数据库查询操作
// 将查询出的值放入User对象中 并返回该对象
 public ArrayList<Passage> getUser(Connection connection, String username)
 {
	
       String sql="select *from Passage where Id=?";
       PreparedStatement statement=null;
       ResultSet result=null;
       System.out.println("pass==="+username);
       ArrayList<Passage> list=new ArrayList<Passage>();
       try
       {
           statement=connection.prepareStatement(sql);
           System.out.println("pass statement==="+statement);
           statement.setString(1,username);
           result=statement.executeQuery();
           System.out.println("pass result==="+result);
           while(result.next())
           {
        	   Passage user=new Passage();
               user.setId(result.getString("Id"));
               user.setName (result.getString("name"));
              
               System.out.println("pass==="+result.getString("name"));
               user.setSex(result.getString("Sex"));
                ;
               user.setIdCard(result.getString("IdCard"));
               list.add(user);
               
           }
           
            
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
       return list;
 }
 // Update 获得用户修改后的信息 进行数据库的修改操作
    public int Update(Connection connection, Passage user)
{
	int value = -1;
	PreparedStatement statement = null;
	String sql = "update Passage set  name = ?, sex = ?, IdCard = ? where Id = ?";

	try
	{
		// 获得PreparedStatement对象
		statement = connection.prepareStatement(sql);
		// 填充statement的参数
		
		statement.setString(1, user.getName());
		statement.setString(2, user.getSex());
		statement.setString(3, user.getIdCard());
		statement.setString(4, user.getId());
		 	
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
    
    public  Passage  getPass(Connection connection, String name)
    {
    	 Passage user=new Passage();
          String sql="select *from Passage where IdCard=?";
          PreparedStatement statement=null;
          ResultSet result=null;
          System.out.println("pass==="+name);
          ArrayList<Passage> list=new ArrayList<Passage>();
          try
          {
              statement=connection.prepareStatement(sql);
              System.out.println("pass statement==="+statement);
              statement.setString(1,name);
              result=statement.executeQuery();
              System.out.println("pass result==="+result);
              while(result.next())
              {
           	  
                  user.setId(result.getString("Id"));
                  user.setName (result.getString("name"));
                 
                  System.out.println("pass==="+result.getString("name"));
                  user.setSex(result.getString("Sex"));
                   ;
                  user.setIdCard(result.getString("IdCard"));
                  
                 
              }
              return user;
               
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
          return user;
    } 
     


	
	
}
