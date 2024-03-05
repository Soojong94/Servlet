package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex07GetPost
 */
@WebServlet("/Ex07GetPost")
public class Ex07GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Get 방식(QueryString 방식)
		// 전송하려고 하는 URL 뒤에 name 과 value  형태로 보내는 방식
		// url? name = value & name2 = value2
		// 특징
		// 1. 데이터 전송 용량의 한계가 있다(1024byte)
		// 2. url 뒤에 데이터가 노출되어 보안에 좋지 않다
		
		
		// Post 방식
		// 전송하려고 하는 데이터를 패킷의 바디 안에 저장해서 보내는 방식
		// 특징
		// 1. 보안에 강력(상대적)
		// 2. 많은 양의 데이터를 보낼 수 있다
		// 3. 공유가 불가능(쇼핑몰 상품 등)
		
		
		
		// Post 방식 한글 인코딩		
		// 서버에서 인코딩을 했어도 
		// 포스트 방식으로 하면 숨겨져 오기 때문에 다시 인코딩을 해야함
		request.setCharacterEncoding("EUC_KR");
		
		String text = request.getParameter("text");
		System.out.println(text);
		
		
	}
}
	
	

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Get방식 요청");
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 System.out.println("Post 방식 요청");
//	}
//
//}
