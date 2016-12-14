package com.servlet;

import com.dao.SchedDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class IntercalateServlet extends HttpServlet 
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
        SchedDao sched=new SchedDao();
        ArrayList tes=new ArrayList();
        // quest ������ж��ƺ������Ϣ 
        tes=sched.quest(connection);
        //�����к�����Ϣ����Session��  ������JSPҳ���е������˵�����ʾ���еĺ����
        request.getSession().setAttribute("tes",tes);
        request.getRequestDispatcher("arrangTime.jsp").forward(request,response);
        
        
      
         
    }

}
