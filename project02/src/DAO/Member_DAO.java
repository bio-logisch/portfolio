package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.Member_DTO;

public class Member_DAO extends FNC_DAO{
	// ȸ�� ���� �޼���
	public void insert(Member_DTO m) { 
		PreparedStatement psmt = null; 
		if (getConn()) { 
			try {
				String sql = "insert into member values (?,?,?,?)"; 
				psmt = conn.prepareStatement(sql);
				// �����ϱ�
				psmt.setString(1, m.getId());
				psmt.setString(2, m.getPass());
				psmt.setString(3, m.getName());
				psmt.setString(4, m.getbDate());

				int resultInt = psmt.executeUpdate();
				System.out.println(resultInt + "�� ���� ����");
			} catch (Exception e) {
				System.out.println("insert ����");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("Ŀ�ؼ� ���� ����");
		}
	}

	//���̵� Ȱ�� ��Ī�Ǵ� ȸ�� Ʃ���� ���� �˻� �޼���
	public int chkId(String id) { 
		ResultSet rs = null;
		int resultCnt = 0;
		if (getConn()) { 
			try {
				PreparedStatement psmt = null; 
				String sql = "select count(*) cnt from member where id =?";
				psmt = conn.prepareStatement(sql);  
				psmt.setString(1,id);
				int resultInt = psmt.executeUpdate();
				rs = psmt.executeQuery();
				if(rs.next()) {
					resultCnt = rs.getInt("cnt"); 
				}				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				returnResources1();
			}
		}
		return resultCnt;
	}

	//ȸ�� ��ü���� �޼��� 
	public ArrayList<Member_DTO> selectAll(){
		PreparedStatement psmt = null; 
		ArrayList<Member_DTO> list = new ArrayList<>();
		ResultSet rs = null;
		if(getConn()) {
			try {  
				String sql = "select * from member";
				psmt = conn.prepareStatement(sql);  
				rs = psmt.executeQuery();
				while(rs.next()) {
					Member_DTO temp = new Member_DTO();
					temp.setId(rs.getString("id"));
					temp.setPass(rs.getString("pass"));
					temp.setName(rs.getString("name"));
					temp.setbDate(rs.getString("bDate"));
					list.add(temp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}	
		}
		return list;
	}

	//���̵� �ߺ�Ȯ�� �޼��� - ���ǿ� �ش��ϴ� Ʃ�� �ϳ��� �˻��ϴ� �޼���
	public Member_DTO selectOne1(String id) { 
		Member_DTO temp = null;
		ResultSet rs = null;  
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   
				String sql = "select * from member where id=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);

				rs = psmt.executeQuery(); 
				if(rs.next()) {
					temp = new Member_DTO();
					temp.setId(rs.getString("id"));
					temp.setName(rs.getString("name"));
					temp.setPass(rs.getString("pass"));
					temp.setbDate(rs.getString("bDate"));
				}		
			} catch (Exception e) {
			}finally {
				returnResources1();
			}
		}
		return temp;
	}
	//��й�ȣ �ߺ�Ȯ�� �޼��� - ���ǿ� �ش��ϴ� Ʃ�� �ϳ��� �˻��ϴ� �޼���
	public Member_DTO selectOne2(String pass) {  
		Member_DTO temp = null;
		ResultSet rs = null;  
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   
				String sql = "select * from member where pass=?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, pass);

				rs = psmt.executeQuery(); 
				if(rs.next()) {
					temp.setId(rs.getString("id"));
					temp.setName(rs.getString("name"));
					temp.setPass(rs.getString("pass"));
					temp.setbDate(rs.getString("bDate"));
				}		
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				returnResources1();
			}
		}
		return temp;
	}

	//��й�ȣ ���� �޼��� - ���̵�� �˻� �� ������ ��й�ȣ�� ����
	public void update(Member_DTO m) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "update member set pass=? where id=?"; 
				psmt = conn.prepareStatement(sql);
				// �����ϱ�
				psmt.setString(1, m.getPass());
				System.out.println(m.getPass());
				psmt.setString(2, m.getId());
				// ���� �����ϰ� ���ϰ� �ޱ�
				int resultInt = psmt.executeUpdate();
				// ���ϰ�ó���ϱ�
				System.out.println(resultInt + "�� ���� ����");
			} catch (Exception e) {
				System.out.println("update ����");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("Ŀ�ؼ� ���� ����");
		}
	}
	//ȸ�� Ż�� �޼��� - ���̵�� �˻� �� Ż��
	public void delete(String id) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "delete from member where id=?"; 
				psmt = conn.prepareStatement(sql);
				// �����ϱ�
				psmt.setString(1, id);
				// ���� �����ϰ� ���ϰ� �ޱ�
				int resultInt = psmt.executeUpdate();
				// ���ϰ�ó���ϱ�
				System.out.println(resultInt + "�� ����  ����");
			} catch (Exception e) {
				System.out.println("delete ����");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("Ŀ�ؼ� ���� ����");
		}
	}
}