package com.servlet;

import java.io.*;
import java.sql.Connection;
import java.util.Properties;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ConductDao;
import com.test.JDBconne;


public class AdminServlet extends HttpServlet 
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
       }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        doPost(request, response);
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    ///public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {

//        ServletConfig config=getServletConfig();
//        //����ServletConfig����
//        String value=config.getInitParameter("name");
//        //���·��
//        Properties properties=new Properties();
//        //�����ı� �������Դ
//        System.out.println("propertice=="+properties);
//        properties.load(config.getServletContext().getResourceAsStream(value));
//        // ��������ļ��е�name��pass��ֵ
//      
//       
//        String name=properties.getProperty("name");
//        String pass=properties.getProperty("pass"); 
//        System.out.println(name+pass);
//        
    	ConductDao conDao=new ConductDao();
        
        // �ӽ����л�ȡ�û������ֵ
        String username=request.getParameter("Username");
        String password= request.getParameter("password");
        // ����õ�ֵ�������ļ���ֵ���бȽ�   
       // if(username.equals(name)&&password.equals(pass))
        System.out.println(" ����Ա=="+username+"   "+password);
        boolean value = conDao.check(connection, username, password);
if(value)
        {
             request.getRequestDispatcher("adminMain.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("adminfaild.jsp").forward(request,response);
        }
       
    
    }

}
