

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
             response.setContentType("text/html;charset=UTF-8");
             PrintWriter out = response.getWriter();
            DinDao din=new DinDao();  
            // ��ú�����Ϣ
            Sched sch=(Sched)request.getSession().getAttribute("sch");
            System.out.println("request.getSession().getAttribute('sch')=="+request.getSession().getAttribute("sch"));
            
            // ����û�����Ʊ��
            int bal=1;
            System.out.println("request.getParameter('piao')=="+request.getParameter("piao"));
            // ����û���
            String id=(String) request.getSession().getAttribute("username");
            System.out.println("(String) request.getSession().getAttribute('username')"+(String) request.getSession().getAttribute("username"));
            // inset �����û������򺽰�Ʊ����Ϣ
            
            String name=(String) request.getParameter("namePass");
            
            String sit=(String) request.getParameter("type");
            System.out.println("sit=="+sit);
           PassageDao pass=new PassageDao();
           Passage pa=pass.getPass(connection, name);
           System.out.println("pa=="+pa.getId()+pa.getIdCard()+pa.getName()+pa.getSex());
           int value=din.inset(connection,sch,bal,id,pa.getName(),pa.getIdCard(),pa.getSex());
           System.out.println("value=="+value);
           
           System.out.println("value=="+sch);
           if(value>0) //�жϲ����Ƿ�ɹ�
           {
               // ����ɹ�  update�޸ĸú����Ʊ��
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
               // ����ʧ��
             RequestDispatcher dispatcher = request.getRequestDispatcher("affirmfaild.jsp");
			dispatcher.forward(request, response);
         }
         

    }

}
