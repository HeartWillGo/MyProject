

package com.servlet;

import com.dao.DinDao;
import com.dao.Passage;
import com.dao.PassageDao;
import com.dao.Sched;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AffirmServlet extends HttpServlet 
{
       private Connection connection;
       public void init() throws ServletException
       {
           super.init();
           connection=JDBconne.getConnetion();
       }
       public void destroy()
       {
        super.destroy();
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
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
            DinDao din=new DinDao();
            Sched sch=new Sched();
            //��JSPҳ���л�ȡ��ѡ��ĺ����
            String hao=request.getParameter("hao");
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
            String id=(String)request.getSession().getAttribute("username");
      PassageDao pass=new PassageDao();
        ArrayList<Passage> listpass=new ArrayList<Passage>();
        listpass=pass.getUser(connection, id);
        
            System.out.println(" pass="+listpass.size());
          for(int i=0;i<listpass.size();i++){
        	  System.out.println("name=="+listpass.get(i).getName());
        	  System.out.println("name=="+listpass.get(i).getIdCard());
          }
            
          String[] a=new String[]{"ͷ�Ȳ�","�����","���ò�"};
          
            // ��ø�ϵͳ�иú����Ʊ��,�������0 �򲻿���Ʊ
            if(sch.getPiaosu()==0)
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfailder.jsp");
	        dispatcher.forward(request, response);

            }
            if(sch.getPiaosu()>0)// �������0 �������Ʊ
            {
            	 request.getSession().setAttribute("listpass",listpass);
            	 request.getSession().setAttribute("a",a);
                RequestDispatcher dispatcher = request.getRequestDispatcher("affirmflight.jsp");
	    dispatcher.forward(request, response);

            }
            
    
      

    }

}
