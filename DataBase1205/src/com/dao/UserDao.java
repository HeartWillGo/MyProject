package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDao 
{
    // insert���� �����ݿ��в����û���Ϣ
	public int insert(Connection connection, User user)
        {
	
		int value=-1;
		PreparedStatement statement=null;
		String sql="insert into users(Username,Pass,Name,Sex,Tel,Email) values(?,?,?,?,?,?)";
                try 
                {

                    statement=connection.prepareStatement(sql);
                    statement.setString(1,user.getUsername());
                    statement.setString(2,user.getPassword());
                    statement.setString(3,user.getName());
                    statement.setString(4,user.getSex());
                    statement.setString(5,user.getTel());
                    statement.setString(6,user.getEmail());
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
        //check���� ���ݵ�½���洫����û��������������ݿ���бȽ�
        // ��������û����򷵻���,ÿ���𷵻ؼ� 
    public boolean check(Connection connection, String username, String password)
    {
		boolean value = false;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "select Username from users where Username = ? and Pass= ?";
		try
		{
			// ���PreparedStatement���󣬲����
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
  
// getUser����  ����username �������ݿ��ѯ����
    // ����ѯ����ֵ����User������ �����ظö���
     public User getUser(Connection connection, String username)
     {
           User user=new User();
           String sql="select Username,Pass,Name,Sex,Tel,Email from users where Username=?";
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
                   user.setUsername(result.getString("Username"));
                   user.setPassword(result.getString("Pass"));
                   user.setName(result.getString("Name"));
                   user.setSex(result.getString("Sex"));
                   user.setTel(result.getString("Tel"));
                   user.setEmail(result.getString("Email"));
               }
               System.out.println("user==="+user);
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
     // Update ����û��޸ĺ����Ϣ �������ݿ���޸Ĳ���
        public int Update(Connection connection, User user)
	{
		int value = -1;
		PreparedStatement statement = null;
		String sql = "update users set  Name = ?, Sex = ?, Tel = ?, Email = ? where Username = ?";

		try
		{
			// ���PreparedStatement����
			statement = connection.prepareStatement(sql);
			// ���statement�Ĳ���
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getSex());
			statement.setString(3, user.getTel());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getUsername());			
			// ִ���޸Ĳ���
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
        
        // UpdatePass  �����û���������� �������������޸Ĳ���
        public int UpdatePass(Connection connection,String Password,String username)
	{
		int value = -1;
		PreparedStatement statement = null;
		String sql = "update users set Pass = ? where Username = ?";

		try
		{
			// ���PreparedStatement����
			statement = connection.prepareStatement(sql);
			// ���statement�Ĳ���
			statement.setString(1, Password);
			statement.setString(2, username);
			// ִ���޸Ĳ���
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