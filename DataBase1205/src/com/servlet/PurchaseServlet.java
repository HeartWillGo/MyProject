

package com.servlet;

import com.dao.DinDao;
import com.dao.Passage;
import com.dao.PassageDao;
import com.dao.Sched;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;

import javax.servlet.*;
import javax.servlet.http.*;

public class PurchaseServlet extends HttpServlet 
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
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
            DinDao din=new DinDao();  
            // 获得航班信息
            Sched sch=(Sched)request.getSession().getAttribute("sch");
            System.out.println("request.getSession().getAttribute('sch')=="+request.getSession().getAttribute("sch"));
            
            // 获得用户所订票数
            int bal=1;
            System.out.println("request.getParameter('piao')=="+request.getParameter("piao"));
            // 获得用户名
            String id=(String) request.getSession().getAttribute("username");
            System.out.println("(String) request.getSession().getAttribute('username')"+(String) request.getSession().getAttribute("username"));
            // inset 插入用户所购买航班票的信息
            
            String name=(String) request.getParameter("namePass");
            
            String sit=(String) request.getParameter("type");
            System.out.println("sit=="+sit);
           PassageDao pass=new PassageDao();
           Passage pa=pass.getPass(connection, name);
           System.out.println("pa=="+pa.getId()+pa.getIdCard()+pa.getName()+pa.getSex());
           int value=din.inset(connection,sch,bal,id,pa.getName(),pa.getIdCard(),pa.getSex());
           System.out.println("value=="+value);
           
           System.out.println("value=="+sch);
           if(value>0) //判断插入是否成功
           {
               // 插入成功  update修改该航班的票数
                 int wat=din.update(connection,sch,bal);
                 if(wat > 0)
		 {	
			RequestDispatcher dispatcher = request.getRequestDispatcher("ExamineSerlvet");
			dispatcher.forward(request, response);
		 }
		 else
		 {
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfaild.jsp");
			dispatcher.forward(request, response);
		 }
         }
         else
         {
               // 插入失败
             RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfaild.jsp");
			dispatcher.forward(request, response);
         }
         

    }

}
