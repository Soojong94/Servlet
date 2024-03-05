package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EX08Join
 */
@WebServlet("/EX08Join")
public class EX08Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		// Client 가 입력한 ID , PW 를 콘솔창에 출력
		String id  = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("gender : " + gender);
		System.out.print("hobby : ");
		for(String i : hobby) {
			System.out.print(i + "\t");
		}
	
		
	}

}
