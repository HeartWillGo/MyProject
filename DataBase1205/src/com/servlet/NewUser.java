package com.servlet;

import com.dao.Tocom;
import com.dao.User;
import com.dao.UserDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class NewUser extends HttpServlet 
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
        
        User user=new User();
        user.setUsername(request.getParameter("Username"));
        user.setPassword(request.getParameter("Password"));
        user.setName(Tocom.toCN(request.getParameter("Name")));
        String Sex=request.getParameter("Sex");
        if(Sex.equals("1"))
        {
            Sex="��";
        }
        else
        {
            Sex="Ů";
        }
        user.setSex(Sex);
        user.setTel(request.getParameter("Tel"));
        user.setEmail(request.getParameter("Email"));
        UserDao userDao=new UserDao();
        // insert���������ݿ�����û���Ϣ
        int value=userDao.insert(connection,user);
        if(value > 0)
		{
			// ע��ɹ�
			RequestDispatcher dispatcher = request.getRequestDispatcher("registerblest.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			// ע��ʧ��
			RequestDispatcher dispatcher = request.getRequestDispatcher("registerfaild.jsp");
			dispatcher.forward(request, response);
		}
       
         
    }

}