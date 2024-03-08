package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "HR";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

			if (conn != null) {
				System.out.println("Connection 연결 성공");
			} else {
				System.out.println("Connection 연결 실패");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
				System.out.println("연결 종료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int join(MemberDTO dto) {

		getConnection();

		int cnt = 0;

		try {

			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql); // connection 을 통해서 sql 문장 검열
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNick());
			psmt.setString(4, dto.getPhone());
			cnt = psmt.executeUpdate();

			System.out.println("회원 정보 삽입 성공");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public MemberDTO login(MemberDTO dto) {
		// TODO Auto-generated method stub

		getConnection();

		MemberDTO info = null;

		try {

			String sql = "SELECT * FROM MEMBER WHERE ID =  ?  AND PW = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {

				// 로그인이 성공했을 때

				String id = rs.getString("ID");
				String pw = rs.getString("PW");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");

				info = new MemberDTO(id, pw, nick, phone);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			close();
		}

		return info;
	}

	public ArrayList<MemberDTO> memberList() {

		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		getConnection();

		try {
			String sql = "SELECT * FROM MEMBER WHERE NOT ID ='admin'";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("ID");
				String pw = rs.getString("PW");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				MemberDTO dto = new MemberDTO(id, pw, nick, phone);
				list.add(dto);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

}
