package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DinDao;
import com.dao.Sched;
import com.test.JDBconne;

 
public class userSerchServlet extends HttpServlet {
	         
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
     //获得界面中输入数据
	 String hao=request.getParameter("param");
	 System.out.println(" hao="+hao);
	 DinDao din=new DinDao();
	 System.out.println(" din="+din);
	 ArrayList list=din.search(connection, hao);
	 
      
   
     
   
     
    Sched sch=new Sched();
    //从JSP页面中获取所选择的航班号
      
   // check 查询错选择航班的信息
    sch=din.check(connection,hao);
    // 获得航班机票票数
    int value=sch.getPiaosu();
    // 在JSP页面中以下拉菜单进行选择票数
    String[] abc=new String[value];
    for(int i=0;i<value;i++)
    {
        abc[i]=String.valueOf(i+1);
    }
    request.getSession().setAttribute("abc",abc);
    request.getSession().setAttribute("sch",sch);
    // 获得该系统中该航班的票数,如果等于0 则不可售票
 
    request.getSession().setAttribute("list",list);
    System.out.println("长度"+list.size());
    for(int i=0;i<list.size();i++){
    	System.out.println(list.get(i));
    }
    request.getRequestDispatcher("UserSearch.jsp").forward(request,response);
     



}
    
    
    
    
    
    
      
 }

