package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01FirstServlet
 */
@WebServlet("/Ex01FirstServlet")

//웹에서 실행할 수 있게 해주는 클래스
public class Ex01FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * service
		 * 
		 * request / response 는 Interface
		 * 
		 * request(요청 객체) 접속하면 client 접속 정보를 받아옴 client가 요청한 모든 정보를 가지고 있음
		 * 
		 * response(응답 객체) 어떤 걸 응답할 건지에 대한 정보(pdf 다운 등)
		 * 
		 * 
		 */

		//System.out.println("Hello World!");

		// context server : 220.80.88.103(본인 IP)
		// 220.80.88.103:8081/Servelt/Ex01FirstServlet>> 복잡해서 http:www. 으로 바꿈

		// request
		String ip = request.getRemoteAddr();
		System.out.println(ip + "님이 접속했습니다");
		
		// 한글 인코딩
		// PrintWriter 전에 인코딩 진행
		
		response.setCharacterEncoding("EUC-KR");
		
		// 응답시 Web 페이지에 글자를 작성할 수 있는 객체
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>" + ip+ "님 반가워요" + "</h1>");
		
		// Servlet 이 실행되면 webapp 아래에 자리를 잡고 있음(상대경로)
		out.print("<img src='pic2.png'>");
		
		out.print("</body>");
		out.print("</html>");
	}

}
