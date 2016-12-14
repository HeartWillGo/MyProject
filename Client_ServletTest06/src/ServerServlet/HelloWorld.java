package ServerServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	 
	  private String message;

	  public void init() throws ServletException
	  {
	      // 执行必需的初始化
	      message = "Hello World";    
	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  System.out.println("doget!");
	      // 设置响应内容类型
		  message = "Hello World";
	      response.setContentType("text/html");

	      // 实际的逻辑是在这里
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	      out.println("<h1>" + message + "</h1>");
	      
	  }
	  
	  public void destroy()
	  {
	      // 什么也不做
	  }
	}
