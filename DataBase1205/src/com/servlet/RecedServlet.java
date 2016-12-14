

package com.servlet;

import com.dao.DinDao;
import com.dao.Sched;

import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class RecedServlet extends HttpServlet 
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
        // ����û���Ҫ�˵ĺ����
        String hao=request.getParameter("hao");
       DinDao dinDao=new DinDao();
       Sched  sed=new Sched();
        String id=(String)request.getSession().getAttribute("username");
        // ����û���Ҫ��Ʊ�ĺ������Ϣ 
       sed=dinDao.reced(connection,hao,id);
       //compareDate �жϺ��������Ƿ��ڷ���������֮��
       boolean j=dinDao.compareDate(sed.getRqi());
       
       if(j==true)
       {
           //������������ڷ�����֮���������Ʊ 
             int value=sed.getPiaosu();
             String[] abc=new String[value];
             for(int i=0;i<value;i++)
             {
                    abc[i]=String.valueOf(i+1);
             }
           request.getSession().setAttribute("id",id);
           request.getSession().setAttribute("abc",abc);
           request.getSession().setAttribute("sed",sed);
           RequestDispatcher dispatcher = request.getRequestDispatcher("recedeticket.jsp");
           dispatcher.forward(request, response);
       }
       if(j==false)
       {
           //���������ʱ�䳬����������ʱ�� ���ܽ�����Ʊ����
            RequestDispatcher dispatcher = request.getRequestDispatcher("recedfaild.jsp");
           dispatcher.forward(request, response);
       }
     
       
       

    }

}
