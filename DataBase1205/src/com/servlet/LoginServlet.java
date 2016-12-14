 package com.servlet;

import com.dao.UserDao;
import com.test.JDBconne;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet 
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
        //��ý�������������
        String username=request.getParameter("Username");
        String password=request.getParameter("Password");
        System.out.println(" �û�=="+username+"   "+password);
       UserDao userDao = new UserDao();
       //check����  �������ݿ�Ƚ� �ж���û���û�
       boolean value = userDao.check(connection, username, password);
        if(value)
        {
            request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("userMain.jsp").forward(request, response);
        }
        else
        {
             
                request.getRequestDispatcher("loginfaild.jsp").forward(request, response);
        }
        
        
        
        
         
    }

}
