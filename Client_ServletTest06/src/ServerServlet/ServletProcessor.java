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
	 //类加载器，用于从指定JAR文件或目录加载类
	 URLClassLoader loader = null;
	 try {
	 URLStreamHandler streamHandler = null;
	 //创建类加载器
	 loader = new URLClassLoader(new URL[]{new URL(null, "file:" + Constants.WEB_SERVLET_ROOT, streamHandler)});
	 } catch (IOException e) {
	 System.out.println(e.toString());
	 }
	 
	 Class<?> myClass = null;
	 try {
	 //加载对应的servlet类
//		 System.out.println("the servletName is " + servletName);
		 //lassLoader.loadClass(String name)接口name参数为全限定包名
		 System.out.println("loading");
	 myClass = loader.loadClass("ServerServlet."+servletName);
	 System.out.println("load complete!");
	 } catch (ClassNotFoundException e) {
		 System.out.println("out");
	 System.out.println(e.toString());
	 }

	 HttpServlet servlet = null;

	 try {
	 //生产servlet实例
	 servlet = (HttpServlet) myClass.newInstance();
	 System.out.println("indtance created");
	 if(servlet==null)System.out.println("servlet is null");
	 //执行servlet的service方法
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

