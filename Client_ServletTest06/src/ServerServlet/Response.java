package ServerServlet;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Response implements HttpServletResponse {

	 private static final int BUFFER_SIZE = 1024;
	 Request request;
	 OutputStream output;
	 PrintWriter writer;

	 public Response(OutputStream output) {
	 this.output = output;
	 }

	 public void setRequest(Request request) {
	 this.request = request;
	 }

	 //将web文件写入到OutputStream字节流中
	 public void sendStaticResource() throws IOException {
	 byte[] bytes = new byte[BUFFER_SIZE];
	 FileInputStream fis = null;
	 try {
	 /* request.getUri has been replaced by request.getRequestURI */
	 File file = new File(Constants.WEB_ROOT, request.getUri());
	 fis = new FileInputStream(file);
	 /*
	 * HTTP Response = Status-Line(( general-header | response-header |
	 * entity-header ) CRLF) CRLF [ message-body ] Status-Line =
	 * HTTP-Version SP Status-Code SP Reason-Phrase CRLF
	 */
	 int ch = fis.read(bytes, 0, BUFFER_SIZE);
	 while (ch != -1) {
	 output.write(bytes, 0, ch);
	 ch = fis.read(bytes, 0, BUFFER_SIZE);
	 }
	 } catch (FileNotFoundException e) {
	 String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
	  + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
	  + "\r\n" + "<h1>File Not Found</h1>";
	 output.write(errorMessage.getBytes());
	 } finally {
	 if (fis != null)
	 fis.close();
	 }
	 }

	 /** implementation of ServletResponse */
	 public void flushBuffer() throws IOException {
	 }

	 public int getBufferSize() {
	 return 0;
	 }

	 public String getCharacterEncoding() {
	 return null;
	 }

	 public Locale getLocale() {
	 return null;
	 }

	 public ServletOutputStream getOutputStream() throws IOException {
	 return null;
	 }

	 public PrintWriter getWriter() throws IOException {
	 // autoflush is true, println() will flush,
	 // but print() will not.
	 writer = new PrintWriter(output, true);
	 return writer;
	 }

	 public boolean isCommitted() {
	 return false;
	 }

	 public void reset() {
	 }

	 public void resetBuffer() {
	 }

	 public void setBufferSize(int size) {
	 }

	 public void setContentLength(int length) {
	 }

	 public void setContentType(String type) {
	 }

	 public void setLocale(Locale locale) {
	 }

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void addCookie(Cookie cookie) {
		// TODO Auto-generated method stub
		
	}

	public boolean containsHeader(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public String encodeURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeRedirectURL(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public String encodeRedirectUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendError(int sc, String msg) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void sendRedirect(String location) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void setDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	public void addDateHeader(String name, long date) {
		// TODO Auto-generated method stub
		
	}

	public void setHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	public void addHeader(String name, String value) {
		// TODO Auto-generated method stub
		
	}

	public void setIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	public void addIntHeader(String name, int value) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int sc) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(int sc, String sm) {
		// TODO Auto-generated method stub
		
	}

	public void setContentLengthLong(long arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<String> getHeaders(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	}
