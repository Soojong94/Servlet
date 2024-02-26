package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex03URLMAPPING
 */

// @ : annotation 
// URLMAPPING 값은 따로 설정하지 않으면 클래스명과 동일함 
// url 값은 중복불가
// 현재는 URLMAPPING이 그대로 URLMAPPING 값임(자바파일에 url을 달아놓음) / 수정가능
// 클래스명과 다르게 설정할 수 있기 때문에 보안에 강력함

/*
 * 데이터 전송
 * 
 * action : 값을 어디로 보낼지(주소값)
 * action = "주소"
 * 
 * name : 어떤 값을 보내는지
 * name ="id"
 * 
 * submit : 값을 보내는 시점
 * type= "submit"
 * 
 * */


@WebServlet("/Ex03URLMAPPING")
public class Ex03URLMAPPING extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	
	}

}
