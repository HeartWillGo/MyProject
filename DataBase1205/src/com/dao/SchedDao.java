

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;


public class SchedDao 
{
    // inset 将Sched对象中的值插入到航班信息表中
    public int inset(Connection connection,Sched sch)
	{
		int value=-1;
		PreparedStatement statement=null;
		String sql="insert into sch(Hao,Qifei,Rqi,Mudi,Jiage,Piaosu) values(?,?,?,?,?,?)";
		try
		{
			System.out.println(" sch.sql=="+sql);
			statement=connection.prepareStatement(sql);
			System.out.println("statement=="+statement);
			statement.setString(1,sch.getHao());
			System.out.println("sch.getHao()=="+sch.getHao());
			statement.setString(2,sch.getQifei());
			System.out.println("sch.getQifei()=="+sch.getQifei());
			statement.setString(3,sch.getRqi());
			System.out.println("sch.getRqi()=="+sch.getRqi());
			statement.setString(4,sch.getMudi());
			System.out.println("sch.getMudi()=="+sch.getMudi());
			statement.setInt(5,sch.getJiage());
			System.out.println("sch.getJiage()=="+sch.getJiage());
			statement.setInt(6,sch.getPiaosu());
			System.out.println("sch.getPiaosu()"+sch.getPiaosu());
			value=statement.executeUpdate();
			System.out.println("statement.executeUpdate()=="+statement.executeUpdate());
                        return value;
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement!=null)statement.close();
			}
			catch (SQLException ee)
			{
			}
		}
		return value;
	}
        // check 修改该航班号的日期时间
         public int check(Connection connection,Anpai anpai)
	{
		int value=-1;
		PreparedStatement statement=null;
		String sql="update sch set Rqi=? where Hao=?";
		try
		{
			statement=connection.prepareStatement(sql);
			statement.setDate(1,anpai.getRqi());
			statement.setString(2,anpai.getHao());
			value=statement.executeUpdate();
                        return value;
		}
		catch (SQLException e)
		{
		}
		finally
		{
			try
			{
				if(statement!=null)statement.close();
			}
			catch (SQLException ee)
			{
			}
		}
		return value;
	}
         // quest 获得所有航班的信息
        public ArrayList<Sched> quest(Connection connection)
        {
            ArrayList<Sched> array=new ArrayList<Sched>();
            //查询所有定制航班的信息
            // 将查询出的值放入ArrayList动态数组中返回
            String sql="select Hao,Qifei,Rqi,Mudi,Jiage,Piaosu from sch ";
            Statement statement=null;
            ResultSet resultset=null;
            try
            {
                    statement=connection.createStatement();
                    resultset=statement.executeQuery(sql);
                    while(resultset.next())
                    {
                        Sched sch=new Sched();
                        sch.setHao(resultset.getString("Hao"));  
                         sch.setRqi(resultset.getString("Rqi"));
                        sch.setQifei(resultset.getString("Qifei"));
                        sch.setMudi(resultset.getString("Mudi"));
                        sch.setJiage(resultset.getInt("Jiage"));
                        sch.setPiaosu(resultset.getInt("Piaosu"));
                        array.add(sch);
                    }
                    return array;
                    
            }
            catch(SQLException e)
            {
                
            }
            finally
            {
                try
                {
                    if(statement!=null) statement.close();
                    if(resultset!=null) resultset.close();
                }
                catch(SQLException ee)
                {
                    
                }
            }
            return array;
            
        }
        
        
        public ArrayList<Sched>  search(Connection connection, String Qifei, String Mudi,String Rqi)
        {
        	
        	ArrayList<Sched> array=new ArrayList<Sched>();
        	System.out.println("有没有执行到这里=="+Qifei+Mudi+Rqi);
    		boolean value = false;
    		PreparedStatement statement = null;
    		ResultSet resultSet = null;
    		 System.out.println("time1=2=="+Rqi);
    		Date rqi=Date.valueOf( Rqi);
    	      System.out.println("time1=="+rqi);
    		String sql = "select    *from sch where Qifei = ? and Mudi= ? and Rqi=? ";
    		try
    		{
    			// 获得PreparedStatement对象，并填充
    			statement = connection.prepareStatement(sql);
    			statement.setString(1,Qifei);
    			statement.setString(2,Mudi);
    		statement.setDate(3,rqi);
    			System.out.println("statement=="+statement);
    			 System.out.println("time122=="+rqi);
    			resultSet = statement.executeQuery();
    			System.out.println("resultSet=="+resultSet);
    			while(resultSet.next())
    			{
    				value = true;
    			
    				
    				Sched sch=new Sched();
                   
                     
                  System.out.println(" 循环");
                      sch.setHao(resultSet.getString("Hao"));
                      
                      
                      System.out.println("time1222=="+rqi);
                      
                      sch.setRqi(new String ().valueOf(resultSet.getDate("Rqi")));
                      System.out.println("time=new="+ resultSet.getDate("Rqi"));
                      sch.setQifei(resultSet.getString("Qifei"));
                      sch.setMudi(resultSet.getString("Mudi"));
                      sch.setJiage(resultSet.getInt("Jiage"));
                      sch.setPiaosu(resultSet.getInt("Piaosu"));
                      array.add(sch);  
                     
          
                   
    				
    			 
    		}
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
    		return array;
              }
        
        // descry 查询已经安排日期的航班
        // 将航班信息放入 ArrayList动态数组中
        public ArrayList<Sched> descry(Connection connection)
        {
            ArrayList<Sched> array=new ArrayList<Sched>();
            String sql="select Hao,Qifei,Rqi,Mudi,Jiage,Piaosu from sch where Rqi is not null";
            Statement statement=null;
            ResultSet resultset=null;
            try
            {
                    statement=connection.createStatement();
                    resultset=statement.executeQuery(sql);
                    while(resultset.next())
                    {
                        Sched sch=new Sched();
                        // 获得服务器当前日期
//                        Calendar day=Calendar.getInstance();
//                        Date date=Date.valueOf(day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1)+"-"+day.get(Calendar.DATE));
                        Date rqi=Date.valueOf(resultset.getString("Rqi"));
                        // 比较航班日期和当前日期
                       // boolean i=rqi.after(date);
                        // 如果航班日期在当前服务器日期之后 将查询处的值放入Sched对象中
                         
                          sch.setHao(resultset.getString("Hao"));  
                          sch.setRqi(new String ().valueOf(resultset.getDate("Rqi")));
                          sch.setQifei(resultset.getString("Qifei"));
                          sch.setMudi(resultset.getString("Mudi"));
                          sch.setJiage(resultset.getInt("Jiage"));
                          sch.setPiaosu(resultset.getInt("Piaosu"));
                          array.add(sch);  
                       
                        //如果航班日期在当前服务器日期之后 则不将查询的值放入Sched对象中
                        
                        
                        
                    }
              
                    
            }
            catch(SQLException e)
            {
                
            }
            finally
            {
                try
                {
                    if(statement!=null) statement.close();
                    if(resultset!=null) resultset.close();
                }
                catch(SQLException ee)
                {
                    
                }
            }
            return array;
            
        }
        

  
}
