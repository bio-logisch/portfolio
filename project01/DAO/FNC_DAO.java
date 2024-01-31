package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class  FNC_DAO {

	//드라이버 로드 세팅 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "system";
	String pass = "1111";
	Connection conn = null;
	PreparedStatement psmt = null; 

	public FNC_DAO() {
		//드라이버 로드 및 커넥션 자원 받아오기 메서드
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			System.out.println("드라이버 로드 성공"); 
		} catch (Exception e1) {
			System.out.println("드라이버 로드 실패");
		}
	}

	//커넥션 자원 받아오기 메서드
	public boolean getConn() {
		try {
			conn = DriverManager.getConnection(url, username, pass);
			System.out.println("커넥션 성공");
			return true;
		} catch (Exception e) {
			System.out.println("커넥션 실패");
		}
		return false;
	}	

	//자원반납 메서드 - Connection(conn) 반납
	public void returnResources1() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
		}
	}

	//자원반납 메서드 - PreparedStatement(psmt), Connection(conn) 반납
	public void returnResources2(PreparedStatement psmt) {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
		}
	}
}
