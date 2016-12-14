

package com.servlet;

import com.dao.DinDao;
import com.dao.Passage;
import com.dao.PassageDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class ExamineSerlvet extends HttpServlet 
{
    
        private Connection connection;
       public void init() throws ServletException
       {
           super.init();
           //获得数据库连接
           connection=JDBconne.getConnetion();
       }
       public void destroy()
       {
        super.destroy();
        //关闭数据库连接 
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
          DinDao dinDao=new DinDao();
          String id=(String)request.getSession().getAttribute("username");
          // 获得客户用户名 查询用户订购的所有航班
          Passage pas=new Passage();
          PassageDao padao=new PassageDao();
        String  namePass=(String)request.getSession().getAttribute("namePass");
        System.out.println("id=="+namePass);
        pas=padao.getPass(connection, namePass);
          ArrayList ary=dinDao.quest(connection,id);
          request.getSession().setAttribute("ary",ary);
          request.getSession().setAttribute("pas",pas);
          System.out.println("aaa=="+ary.size());
          request.getRequestDispatcher("examineshopping.jsp").forward(request,response);

    }

}
