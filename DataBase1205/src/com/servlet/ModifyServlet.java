

package com.servlet;

import com.dao.User;
import com.dao.UserDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class ModifyServlet extends HttpServlet 
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
        String param=request.getParameter("param");
        if(param.equalsIgnoreCase("0"))
        {
            String username=(String)request.getSession().getAttribute("username");
            UserDao userDao=new UserDao();
            // ����username �������ݿ�Ĳ�ѯ
            // �����ص��û���Ϣ����User������
            User user=userDao.getUser(connection,username);
            String ho=user.getSex();
            String mo;
            if(ho.equals("��"))
            {
                mo="Ů";
            }
            else
            {
                 mo="��";
            }
            // ���Ա����session �� 
             request.getSession().setAttribute("ho",ho);
             request.getSession().setAttribute("mo",mo);
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("info.jsp").forward(request, response);
        }
        
         
    }

}
