package ServerServlet;

import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class HttpServer {

	 // �رշ�������
	 private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	 public static void main(String[] args) {
	 HttpServer server = new HttpServer();
	 //�ȴ���������
	 server.await();
	 }

	 @SuppressWarnings("unused")
	public void await() {
	 ServerSocket serverSocket = null;
	 int port = 8080;
	 try {
	 //�������׽��ֶ���
	 serverSocket = new ServerSocket(port, 1, InetAddress.getByName("192.168.1.126"));
	 System.out.println("socket="+serverSocket);
	 } catch (IOException e) {
	 e.printStackTrace();
	 System.exit(1);
	 }

	 // ѭ���ȴ�����
	 while (true) {
	 Socket socket = null;
	 InputStream input = null;
	 OutputStream output = null;
	 try {
	 //�ȴ����ӣ����ӳɹ��󣬷���һ��Socket����
	 socket = serverSocket.accept();
	 input = socket.getInputStream();
	 output = socket.getOutputStream();

	 // ����Request���󲢽���
	 Request request = new Request(input);
	 request.parse();
	 // ����Ƿ��ǹرշ�������
	 if(request==null)System.out.println("request is null");
	 else System.out.println("not null");
	 if (request.getUri().equals(SHUTDOWN_COMMAND)) {
	  break;
	 }
	 
	 // ���� Response ����
	 Response response = new Response(output);
	 response.setRequest(request);

	 if (request.getUri().startsWith("/servlet/")) {
		 System.out.println("process!");
	  //����uri��/servlet/��ͷ����ʾservlet����
	  ServletProcessor processor = new ServletProcessor();
	  processor.process(request, response);
	 } else {
	  //��̬��Դ����
	  StaticResourceProcessor processor = new StaticResourceProcessor();
	  processor.process(request, response);
	 }

	 // �ر� socket
	 socket.close();

	 } catch (Exception e) {
	 e.printStackTrace();
	 System.exit(1);
	 }
	 }
	 }
	}

