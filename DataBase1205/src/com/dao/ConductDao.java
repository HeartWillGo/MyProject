package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConductDao {
	 // insert���� �����ݿ��в����û���Ϣ
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
	        //check���� ���ݵ�½���洫����û��������������ݿ���бȽ�
	        // ��������û����򷵻���,ÿ���𷵻ؼ� 
	    public   boolean check(Connection connection, String username, String password)
	    {
			boolean value = false;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			String sql = "select Name from Con where Name = ? and Pass= ?";
			  System.out.println(" ����Աsql==" +sql);;
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
	     // Update ����û��޸ĺ����Ϣ �������ݿ���޸Ĳ���
	        public int Update(Connection connection, Conduct con)
		{
			int value = -1;
			PreparedStatement statement = null;
			String sql = "update Con set  Pass = ?  where Name = ?";

			try
			{
				// ���PreparedStatement����
				statement = connection.prepareStatement(sql);
				// ���statement�Ĳ���
				
				statement.setString(1, con.getUsername());
				statement.setString(2, con.getPassword());
				 		
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
			String sql = "update Con set Pass = ? where Name = ?";

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