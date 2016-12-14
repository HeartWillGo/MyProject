package ServerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadParams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "��ȡ���еı�����";
		String docType =
			"<!doctype html public \"-//w3c//dtd html 4.0 " +
			"transitional//en\">\n";
			out.println(docType +
			"<html>\n" +
			"<head><title>" + title + "</title></head>\n" +
			"<body bgcolor=\"#f0f0f0\">\n" +
			"<h1 align=\"center\">" + title + "</h1>\n" +
			"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
			"<tr bgcolor=\"#949494\">\n" +
			"<th>��������</th><th>����ֵ</th>\n"+
			"</tr>\n");

		Enumeration paramNames = request.getParameterNames();

		while(paramNames.hasMoreElements()) {
			String paramName = (String)paramNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String[] paramValues =
			request.getParameterValues(paramName);
			// ��ȡ����ֵ������
			if (paramValues.length == 1) {
				String paramValue = paramValues[0];
				if (paramValue.length() == 0)
					out.println("<td><i>û��ֵ</i></td>");
				else
					out.println("<td>" + paramValue + "</td>");
			} else {
				// ��ȡ���ֵ������
				out.println("<td><ul>");
				for(int i=0; i < paramValues.length; i++) {
				out.println("<li>" + paramValues[i]);
			}
				out.println("</ul></td>");
			}
			out.print("</tr>");
		}
		out.println("\n</table>\n</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
