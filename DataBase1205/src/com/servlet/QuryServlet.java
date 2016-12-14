package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Sched;
import com.dao.SchedDao;
import com.test.JDBconne;

 
public class QuryServlet extends HttpServlet {
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
 
      String Qi=new String(request.getParameter("QiDian").getBytes("iso-8859-1"), "utf-8");
      request.setCharacterEncoding("UTF-8");
      
      String Zhong=new String(request.getParameter("Zhongdian").getBytes("iso-8859-1"), "utf-8"); 
      String Time=request.getParameter("Time");
      System.out.println(" 查询=="+Qi+"   "+Zhong+Time);
      SchedDao schedao=new SchedDao();
      ArrayList<Sched> list = schedao.search(connection, Qi, Zhong,Time);
      
      
      
      
      
      System.out.println("list.size=="+list.size());
      if(list.size()>0)
      {
      //    request.getSession().setAttribute("username", username);
    	  for(int i=0;i<list.size();i++){
          	Sched s=list.get(i);
          	System.out.println(s.getHao()+s.getJiage()+s.getPiaosu()+s.getQifei()+s.getRqi());
          }
          
    	   
    	  request.getSession().setAttribute("list2",list);
    	  request.getSession().setAttribute("QiDian",Qi);
    	  request.getSession().setAttribute("Zhongdian",Zhong);
    	  request.getSession().setAttribute("Time",Time);
    	  
          request.getRequestDispatcher("destineflight.jsp").forward(request,response);
    	  
		 
      }
      else
      {
           
              request.getRequestDispatcher("loginfaild.jsp").forward(request, response);
      } 
      
      
       
  }

}
