

package com.servlet;

import com.dao.DinDao;
import com.dao.Sched;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class RecedeServlet extends HttpServlet 
{
        Connection connection;
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
       Sched reced=new Sched();
       DinDao din=new DinDao();
       //����û���ѡ��ĺ����
       reced=(Sched) request.getSession().getAttribute("sed");
       // ��������˵����û���ѡ����Ʊ������
       int rec=1;
       // ��ø��û����û���
       String id=(String)request.getSession().getAttribute("username");
       // amendReced �޸��û��ڸú����ϵ���������Ʊ��
       int value=din.amendReced(connection,reced,rec,id);
       if(value>0)
        {
            // �����Ʊ�ɹ�
           // Upreced �޸ĸú����Ʊ��
              int wat=din.Upreced(connection,reced,rec);
                 if(wat > 0)
		 {	//�޸ĳɹ�
			RequestDispatcher dispatcher = request.getRequestDispatcher("ExamineSerlvet");
			dispatcher.forward(request, response);
		 }
		 else
		 {
		   //�޸�ʧ��
			RequestDispatcher dispatcher = request.getRequestDispatcher("recedfaild.jsp");
			dispatcher.forward(request, response);
		 }
         }
         else
         {
           //��Ʊʧ��
             RequestDispatcher dispatcher = request.getRequestDispatcher("recedfaild.jsp");
			dispatcher.forward(request, response);
         }

    
    }
}
