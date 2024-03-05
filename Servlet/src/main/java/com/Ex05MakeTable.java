package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05MakeTable
 */
@WebServlet("/Ex05MakeTable")
public class Ex05MakeTable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int A = Integer.parseInt(request.getParameter("room"));

		out.print("<html>");
		out.print("<body align = 'center'>");
		out.print("<h1>");
		
		// 내 코드 : table 미사용 

//		for (int i = 0; i < A; i++) {
//			out.print("<span style='border: 2px solid black;'>");
//			out.print(i+1);
//			out.print("</span>");
//		}	

		
//		선생님 코드 : table 사용 
		out.print("<table border = '1px solid black', align = 'center'>");
		out.print("<tr>");

		for (int i = 0; i < A; i++) {
			out.print("<td>" + (i + 1) + "</td>");
		}

		out.print("</table>");
		out.print("</h1>");
		out.print("</html>");
		out.print("</body>");

	}
}


