package ServerServlet;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;


public class ServletProcessor {

	 public void process(Request request, Response response) {
		System.out.println("processing");

	 String uri = request.getUri();
	 String servletName = uri.substring(uri.lastIndexOf("/") + 1);
	 System.out.println(uri+"  "+servletName);
	 //������������ڴ�ָ��JAR�ļ���Ŀ¼������
	 URLClassLoader loader = null;
	 try {
	 URLStreamHandler streamHandler = null;
	 //�����������
	 loader = new URLClassLoader(new URL[]{new URL(null, "file:" + Constants.WEB_SERVLET_ROOT, streamHandler)});
	 } catch (IOException e) {
	 System.out.println(e.toString());
	 }
	 
	 Class<?> myClass = null;
	 try {
	 //���ض�Ӧ��servlet��
//		 System.out.println("the servletName is " + servletName);
		 //lassLoader.loadClass(String name)�ӿ�name����Ϊȫ�޶�����
		 System.out.println("loading");
	 myClass = loader.loadClass("ServerServlet."+servletName);
	 System.out.println("load complete!");
	 } catch (ClassNotFoundException e) {
		 System.out.println("out");
	 System.out.println(e.toString());
	 }

	 HttpServlet servlet = null;

	 try {
	 //����servletʵ��
	 servlet = (HttpServlet) myClass.newInstance();
	 System.out.println("indtance created");
	 if(servlet==null)System.out.println("servlet is null");
	 //ִ��servlet��service����
	 servlet.service((ServletRequest)request, (ServletResponse)response);
	 System.out.println("service process complete");
	 } catch (Exception e) {
		 System.out.println("catch");
	 System.out.println(e.toString());
	 } catch (Throwable e) {
	 System.out.println(e.toString());
	 }

	 }
	}

