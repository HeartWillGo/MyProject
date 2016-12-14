package ServerServlet;

import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map; 
import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Mapping;
import javax.servlet.http.Part;
import javax.servlet.http.PushBuilder; 
public class Request implements HttpServletRequest  {

	 private InputStream input;
	 private String uri;
	 private StringBuffer request;
	 
	 public String getMethod(){
		 System.out.println("sssssssssssssss");
		 String method = null;
		 
         String line = request.toString();
			System.out.println("sssssssssssssss1");
			method = line.substring(0, 4).trim();
			System.out.println("the method -------------" + method);
			
		System.out.println("sssssssssssssss");
		return method;
	 }

	 public Request(InputStream input) {
	 this.input = input;
	 }

	 public String getUri() {
	 return uri;
	 }
	 /**
	 * 
	 * requestString形式如下：
	 * GET /index.html HTTP/1.1
	 * Host: localhost:8080
	 * Connection: keep-alive
	 * Cache-Control: max-age=0
	 * ...
	 * 该函数目的就是为了获取/index.html字符串
	 */
	 private String parseUri(String requestString) {
	 int index1, index2;
	 index1 = requestString.indexOf(' ');
	 if (index1 != -1) {
	 index2 = requestString.indexOf(' ', index1 + 1);
	 if (index2 > index1)
	 return requestString.substring(index1 + 1, index2);
	 }
	 return null;
	 }
	 //从InputStream中读取request信息，并从request中获取uri值
	 public void parse() {
	 // Read a set of characters from the socket
	 request = new StringBuffer(2048);
	 int i;
	 byte[] buffer = new byte[2048];
	 try {
	 i = input.read(buffer);
	 } catch (IOException e) {
	 e.printStackTrace();
	 i = -1;
	 }
	 for (int j = 0; j < i; j++) {
	 request.append((char) buffer[j]);
	 }
	 System.out.print(request.toString());
	 uri = parseUri(request.toString());
	 System.out.println("uri = " + uri);
	 }

	 /* implementation of the ServletRequest */
	 public Object getAttribute(String attribute) {
	 return null;
	 }

	 public Enumeration<String> getAttributeNames() {
	 return null;
	 }

	 public String getRealPath(String path) {
	 return null;
	 }

	 public RequestDispatcher getRequestDispatcher(String path) {
	 return null;
	 }

	 public boolean isSecure() {
	 return false;
	 }

	 public String getCharacterEncoding() {
	 return null;
	 }

	 public int getContentLength() {
	 return 0;
	 }

	 public String getContentType() {
	 return null;
	 }

	 public ServletInputStream getInputStream() throws IOException {
	 return null;
	 }

	 public Locale getLocale() {
	 return null;
	 }

	 public Enumeration<Locale> getLocales() {
	 return null;
	 }

	 public String getParameter(String name) {
	 return null;
	 }

	 public Map<String, String[]> getParameterMap() {
	 return null;
	 }

	 public Enumeration<String> getParameterNames() {
	 return null;
	 }

	 public String[] getParameterValues(String parameter) {
	 return null;
	 }

	 public String getProtocol() {
	 return null;
	 }

	 public BufferedReader getReader() throws IOException {
	 return null;
	 }

	 public String getRemoteAddr() {
	 return null;
	 }

	 public String getRemoteHost() {
	 return null;
	 }

	 public String getScheme() {
	 return null;
	 }

	 public String getServerName() {
	 return null;
	 }

	 public int getServerPort() {
	 return 0;
	 }

	 public void removeAttribute(String attribute) {
	 }

	 public void setAttribute(String key, Object value) {
	 }

	 public void setCharacterEncoding(String encoding)
	 throws UnsupportedEncodingException {
	 }

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAuthType() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cookie[] getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getDateHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaders(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enumeration getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIntHeader(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public String getPathInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPathTranslated() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContextPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRemoteUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return false;
	}

	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestedSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

	public StringBuffer getRequestURL() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletPath() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession(boolean create) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isRequestedSessionIdValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromCookie() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromURL() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRequestedSessionIdFromUrl() {
		// TODO Auto-generated method stub
		return false;
	}

	public AsyncContext getAsyncContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getContentLengthLong() {
		// TODO Auto-generated method stub
		return 0;
	}

	public DispatcherType getDispatcherType() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAsyncStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAsyncSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	public AsyncContext startAsync() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1)
			throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean authenticate(HttpServletResponse arg0) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		return false;
	}

	public String changeSessionId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mapping getMapping() {
		// TODO Auto-generated method stub
		return null;
	}

	public Part getPart(String arg0) throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Part> getParts() throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	public PushBuilder getPushBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPushSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	public void login(String arg0, String arg1) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void logout() throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public <T extends HttpUpgradeHandler> T upgrade(Class<T> arg0)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		return null;
	}

	
	}