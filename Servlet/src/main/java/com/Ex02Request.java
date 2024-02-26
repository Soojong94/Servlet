package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex02Request
 */
@WebServlet("/Ex02Request")
public class Ex02Request extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ip = request.getRemoteAddr();
		System.out.println(ip + "님이 접속했습니다");
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<body>");

		if (ip.equals("211.48.213.178")) {
			out.print("<h1>" + "PBK_MK1 환영합니다" + "</h1>");
			out.print("<img src='pic3.png'>");
		} else if (ip.equals("59.0.234.65")) {
			out.print("<h1>" + "현빈이 ㅎㅇ" + "</h1>");	
			out.print("<img src='pic2.png'>");
		} else if (ip.equals("211.33.239.179")) {
			out.print("<h1>" + "지석이 ㅎㅇ" + "</h1>");
			out.print("<img src='pic2.png'>");
		}else if (ip.equals("0:0:0:0:0:0:0:1")) {
				out.print("<h1 align = 'center'  >" + "안녕 나야" + "</h1>");
				out.print("<img src='pic2.png'>");
		} else {
			out.print("<h1>" + "자니?" + "</h1>");
			out.print("<img src='pic2.png'>");
		}
		out.print("</body>");
		out.print("</html>");

	}

}
