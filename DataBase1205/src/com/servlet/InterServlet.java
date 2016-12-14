

package com.servlet;

import com.dao.Anpai;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class InterServlet extends HttpServlet 
{
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
        // ��ð��ź���ĺ����
        String hao=request.getParameter("param");
        Anpai ter=new Anpai();
        ter.setHao(hao);// ������ŷ���Session��������ҳ������ʾ�����
        request.getSession().setAttribute("ter",ter);
       request.getRequestDispatcher("intercaTime.jsp").forward(request,response);
        
        
      
         
    }

}
