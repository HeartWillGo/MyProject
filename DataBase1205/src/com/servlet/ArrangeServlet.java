

package com.servlet;

import com.dao.Anpai;
import com.dao.DinDao;
import com.dao.SchedDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class ArrangeServlet extends HttpServlet 
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
          Anpai anpai=new Anpai();
          // ��ù���Ա��ѡ��ĺ����
          anpai.setHao(request.getParameter("Hao"));
          DinDao din=new DinDao();
          // getDate ��ÿͻ��˵ĵ�ǰ����ʱ��
          Date date=din.getDate(connection);
          // ��ҳ���л�ȡ����Ա���ŵ�����ʱ�� ����Date���ʹ���
          Date Rqi=Date.valueOf(request.getParameter("user"));
          anpai.setRqi(Rqi);
              SchedDao schedDao=new SchedDao();
              // check ����õ����ڷ����Ӧ�ĺ�����Ϣ���� 
              int value=schedDao.check(connection,anpai);
              if(value > 0)
		{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("arrangBlest.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("arrangFaild.jsp");
			dispatcher.forward(request, response);
		}
         
          
    }

}
