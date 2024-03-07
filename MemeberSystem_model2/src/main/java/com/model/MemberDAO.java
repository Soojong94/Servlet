package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {

	public int join(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int cnt = 0;

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

			String sql = "INSERT INTO MEMBER VALUES (?,?,?,?)";
			psmt = conn.prepareStatement(sql); // connection 을 통해서 sql 문장 검열
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getNick());
			psmt.setString(4, dto.getPhone());
			cnt = psmt.executeUpdate();

			System.out.println("회원 정보 삽입 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {

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
		return cnt;
	}

}
