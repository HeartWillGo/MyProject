

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
    // inset ��Sched�����е�ֵ���뵽������Ϣ����
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
        // check �޸ĸú���ŵ�����ʱ��
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
         // quest ������к������Ϣ
        public ArrayList<Sched> quest(Connection connection)
        {
            ArrayList<Sched> array=new ArrayList<Sched>();
            //��ѯ���ж��ƺ������Ϣ
            // ����ѯ����ֵ����ArrayList��̬�����з���
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
        	System.out.println("��û��ִ�е�����=="+Qifei+Mudi+Rqi);
    		boolean value = false;
    		PreparedStatement statement = null;
    		ResultSet resultSet = null;
    		 System.out.println("time1=2=="+Rqi);
    		Date rqi=Date.valueOf( Rqi);
    	      System.out.println("time1=="+rqi);
    		String sql = "select    *from sch where Qifei = ? and Mudi= ? and Rqi=? ";
    		try
    		{
    			// ���PreparedStatement���󣬲����
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
                   
                     
                  System.out.println(" ѭ��");
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
        
        // descry ��ѯ�Ѿ��������ڵĺ���
        // ��������Ϣ���� ArrayList��̬������
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
                        // ��÷�������ǰ����
//                        Calendar day=Calendar.getInstance();
//                        Date date=Date.valueOf(day.get(Calendar.YEAR)+"-"+(day.get(Calendar.MONTH)+1)+"-"+day.get(Calendar.DATE));
                        Date rqi=Date.valueOf(resultset.getString("Rqi"));
                        // �ȽϺ������ں͵�ǰ����
                       // boolean i=rqi.after(date);
                        // ������������ڵ�ǰ����������֮�� ����ѯ����ֵ����Sched������
                         
                          sch.setHao(resultset.getString("Hao"));  
                          sch.setRqi(new String ().valueOf(resultset.getDate("Rqi")));
                          sch.setQifei(resultset.getString("Qifei"));
                          sch.setMudi(resultset.getString("Mudi"));
                          sch.setJiage(resultset.getInt("Jiage"));
                          sch.setPiaosu(resultset.getInt("Piaosu"));
                          array.add(sch);  
                       
                        //������������ڵ�ǰ����������֮�� �򲻽���ѯ��ֵ����Sched������
                        
                        
                        
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
