package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.model.MemberDAO;
import com.model.MemberDTO;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("EUC-KR");
		String input_id = request.getParameter("id");
		String input_pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		
		MemberDTO dto = new MemberDTO(input_id, input_pw);
		MemberDAO dao = new MemberDAO();
		MemberDTO info = dao.login(dto);
		

		if (info == null){
			// 로그인 실패
			response.sendRedirect("Login.jsp");
		}else{
			// 로그인 성공
			session.setAttribute("info", info);
			response.sendRedirect("loginSuccess.jsp");
		}

	}
}
