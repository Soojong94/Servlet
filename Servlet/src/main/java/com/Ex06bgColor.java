package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06bgColor
 */
@WebServlet("/Ex06bgColor")
public class Ex06bgColor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String color = request.getParameter("color");
		int fdan = Integer.parseInt(request.getParameter("fdan"));
		int ldan = Integer.parseInt(request.getParameter("ldan"));

		out.print("<html>");
		out.print("<body>");
		out.print("<table border = '1px solid black' , align = 'center ' bgcolor = ' " + color + "' >");
		for (int i = fdan; i <= ldan; i++) {
			out.print("<tr>");
			for (int j = 1; j <= 9; j++) {
				out.print("<td>" + i  +"*"+ j + "=" + (i * j) + "</td>");
			}
			out.print("</tr>");
		}
		out.print("</table >");
		out.print("</body>");
		out.print("</html>");

	}

}
