package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class  FNC_DAO {

	//����̹� �ε� ���� 
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String username = "system";
	String pass = "1111";
	Connection conn = null;
	PreparedStatement psmt = null; 

	public FNC_DAO() {
		//����̹� �ε� �� Ŀ�ؼ� �ڿ� �޾ƿ��� �޼���
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			System.out.println("����̹� �ε� ����"); 
		} catch (Exception e1) {
			System.out.println("����̹� �ε� ����");
		}
	}

	//Ŀ�ؼ� �ڿ� �޾ƿ��� �޼���
	public boolean getConn() {
		try {
			conn = DriverManager.getConnection(url, username, pass);
			System.out.println("Ŀ�ؼ� ����");
			return true;
		} catch (Exception e) {
			System.out.println("Ŀ�ؼ� ����");
		}
		return false;
	}	

	//�ڿ��ݳ� �޼��� - Connection(conn) �ݳ�
	public void returnResources1() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
		}
	}

	//�ڿ��ݳ� �޼��� - PreparedStatement(psmt), Connection(conn) �ݳ�
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
