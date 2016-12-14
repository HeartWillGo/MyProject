package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DinDao;
import com.dao.Sched;
import com.test.JDBconne;

 
public class userSerchServlet extends HttpServlet {
	         
    private Connection connection;
    public void init() throws ServletException
    {
        super.init();
                  //������ݿ�����
       connection=JDBconne.getConnetion();
    }
    public void destroy()
    {
     super.destroy();
           //�ر����ݿ����� 
         JDBconne.closeConnection();
    }


 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
     doPost(request, response);
 }
 
 
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
     //��ý�������������
	 String hao=request.getParameter("param");
	 System.out.println(" hao="+hao);
	 DinDao din=new DinDao();
	 System.out.println(" din="+din);
	 ArrayList list=din.search(connection, hao);
	 
      
   
     
   
     
    Sched sch=new Sched();
    //��JSPҳ���л�ȡ��ѡ��ĺ����
      
   // check ��ѯ��ѡ�񺽰����Ϣ
    sch=din.check(connection,hao);
    // ��ú����ƱƱ��
    int value=sch.getPiaosu();
    // ��JSPҳ�����������˵�����ѡ��Ʊ��
    String[] abc=new String[value];
    for(int i=0;i<value;i++)
    {
        abc[i]=String.valueOf(i+1);
    }
    request.getSession().setAttribute("abc",abc);
    request.getSession().setAttribute("sch",sch);
    // ��ø�ϵͳ�иú����Ʊ��,�������0 �򲻿���Ʊ
 
    request.getSession().setAttribute("list",list);
    System.out.println("����"+list.size());
    for(int i=0;i<list.size();i++){
    	System.out.println(list.get(i));
    }
    request.getRequestDispatcher("UserSearch.jsp").forward(request,response);
     



}
    
    
    
    
    
    
      
 }

