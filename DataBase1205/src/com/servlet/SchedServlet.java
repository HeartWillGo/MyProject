

package com.servlet;

import com.dao.Sched;
import com.dao.SchedDao;
import com.dao.Tocom;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchedServlet extends HttpServlet 
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
         Sched sch=new Sched();
         // 从制定航班界面获得的值放入Sched对象中
         sch.setHao(request.getParameter("Hao"));
         System.out.println("request.getParameter('Hao')=="+request.getParameter("Hao"));
         sch.setQifei(Tocom.toCN(request.getParameter("Qifei")));
         System.out.println("Tocom.toCN(request.getParameter('Qifei'))=="+Tocom.toCN(request.getParameter("Qifei")));
         sch.setMudi(Tocom.toCN(request.getParameter("Mudi")));
         System.out.println("Tocom.toCN(request.getParameter('Mudi'))=="+Tocom.toCN(request.getParameter("Mudi")));
         
         sch.setRqi( request.getParameter("Time"));
         System.out.println("Integer.parseInt(request.getParameter('Time'))=="+ request.getParameter("Time"));
         
         sch.setJiage(Integer.parseInt(request.getParameter("Jiage")));
         System.out.println("Integer.parseInt(request.getParameter('Jiage'))=="+Integer.parseInt(request.getParameter("Jiage")));
         sch.setPiaosu(Integer.parseInt(request.getParameter("Piaosu")));
         System.out.println("Integer.parseInt(request.getParameter('Piaosu'))=="+Integer.parseInt(request.getParameter("Piaosu")));
         SchedDao schedDao= new SchedDao();
         
         // inset  将获得的值插入航班信息表中
         int value=schedDao.inset(connection,sch);
         System.out.println("connection=="+connection.toString()+"sch=="+sch.toString());
         System.out.println("Schedule=value=="+value);
         System.out.println("Schedule==="+schedDao.inset(connection,sch));
         if(value > 0)
		{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("estaBlest.jsp");
			dispatcher.forward(request, response);
			
			
			
			
			
		}
		else
		{
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("estaFaild.jsp");
			dispatcher.forward(request, response);
		}

    }

}
