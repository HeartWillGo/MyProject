package com.servlet;

import com.dao.SchedDao;
import com.test.JDBconne;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class FlightServlet extends HttpServlet 
{
        private Connection connection;
       public void init() throws ServletException
       {
           super.init();
           connection=JDBconne.getConnetion();
       }
       public void destroy()
       {
        super.destroy();
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
        // �ƶ������ �������˵�����ʽ��ʾ
           String[] a=new String[100];
            for(int i=0,j=100;i<100;i++,j++)
            {
                a[i]="T"+String.valueOf(j+1);
            }
           // �ƶ��������ʱ��  �������˵�����ʽ��ʾ
        String[] b=new String[24];
        for(int i=0;i<24;i++)
        {
            b[i]=String.valueOf(i+1);
        }
        // �ƶ�����۸� �������˵�����ʽ��ʾ
        String[] c=new String[100];
        for(int i=0;i<100;i++)
        {
            c[i]=String.valueOf(i+1)+"0";
        }
        // �ƶ�����Ʊ�� �������˵�����ʽ��ʾ
        String[] d=new String[200];
        for(int i=0;i<200;i++)
        {
            d[i]=String.valueOf(i+1);
        }
           request.getSession().setAttribute("a",a);
            request.getSession().setAttribute("b",b);
             request.getSession().setAttribute("c",c);
              request.getSession().setAttribute("d",d);
       // request.getSession().setAttribute("flight",flight);
        request.getRequestDispatcher("estaflight.jsp").forward(request,response);
        
        
      
         
    }

}
