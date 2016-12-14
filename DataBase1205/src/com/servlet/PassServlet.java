

package com.servlet;

import com.dao.User;
import com.dao.UserDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassServlet extends HttpServlet 
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
       
       
       // ��Session �л�øÿͻ����û���
            String username=(String)request.getSession().getAttribute("username");
            System.out.println("username==="+username);
            UserDao userDao=new UserDao();
            System.out.println("userDao==="+userDao);
            System.out.println("connection==="+connection);
            //����û�ע����Ϣ
            User user=userDao.getUser(connection,username);
           String pass=user.getPassword();
           String passed=request.getParameter("Password");
           String pass1=request.getParameter("Password1");
           // ���ݽ���������������û���������бȽ�
           System.out.println("user==="+user);
           System.out.println("pass==="+pass);
           if(pass.equals(passed))
           {
               //�������ֵ��� 
               //UpdatePass ���������޸Ĳ���
               int value=userDao.UpdatePass(connection,pass1,username);
               if(value>0)
               {
                    request.getRequestDispatcher("amendsucceed.jsp").forward(request,response);
               }
               else
               {
                    request.getRequestDispatcher("amendfail.jsp").forward(request,response);
               }
              
           }
           else
           {
               //������벻���
              request.getRequestDispatcher("amenderror.jsp").forward(request,response);
           }
  
        }
}
