package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.Member_DTO;

public class Member_DAO extends FNC_DAO{
	// 회원 가입 메서드
	public void insert(Member_DTO m) { 
		PreparedStatement psmt = null; 
		if (getConn()) { 
			try {
				String sql = "insert into member values (?,?,?,?)"; 
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				psmt.setString(1, m.getId());
				psmt.setString(2, m.getPass());
				psmt.setString(3, m.getName());
				psmt.setString(4, m.getbDate());

				int resultInt = psmt.executeUpdate();
				System.out.println(resultInt + "건 삽입 성공");
			} catch (Exception e) {
				System.out.println("insert 오류");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("커넥션 정보 없음");
		}
	}

	//아이디 활용 매칭되는 회원 튜플의 개수 검색 메서드
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

	//회원 전체보기 메서드 
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

	//아이디 중복확인 메서드 - 조건에 해당하는 튜플 하나만 검색하는 메서드
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
	//비밀번호 중복확인 메서드 - 조건에 해당하는 튜플 하나만 검색하는 메서드
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

	//비밀번호 수정 메서드 - 아이디로 검색 후 수정은 비밀번호만 가능
	public void update(Member_DTO m) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "update member set pass=? where id=?"; 
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				psmt.setString(1, m.getPass());
				System.out.println(m.getPass());
				psmt.setString(2, m.getId());
				// 쿼리 전송하고 리턴값 받기
				int resultInt = psmt.executeUpdate();
				// 리턴값처리하기
				System.out.println(resultInt + "건 수정 성공");
			} catch (Exception e) {
				System.out.println("update 오류");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("커넥션 정보 없음");
		}
	}
	//회원 탈퇴 메서드 - 아이디로 검색 후 탈퇴
	public void delete(String id) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "delete from member where id=?"; 
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				psmt.setString(1, id);
				// 쿼리 전송하고 리턴값 받기
				int resultInt = psmt.executeUpdate();
				// 리턴값처리하기
				System.out.println(resultInt + "건 삭제  성공");
			} catch (Exception e) {
				System.out.println("delete 오류");
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}
		} else {
			System.out.println("커넥션 정보 없음");
		}
	}
}