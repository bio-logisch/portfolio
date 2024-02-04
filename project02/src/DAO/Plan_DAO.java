package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Member_DTO;
import DTO.Plan_DTO;

//클래스 정의 : 일정 등록, 수정, 삭제, 검색기능 구현
public class Plan_DAO extends FNC_DAO{
	int resultCnt=0; //등록된 차량수 카운팅
	int NumMax = 0; //차량번호 최대값

	// 일정등록 메서드
	public void insert(Plan_DTO p) { 
		chkCnt();//일정등록건수 카운팅
		chkMaxP_num(); //일정등록건의 num컬럼의 값 중 max값 리턴
		PreparedStatement psmt = null; 
		if (getConn()) { 
			try {
				String sql = "insert into plan values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				if(resultCnt == 0) psmt.setInt(1, resultCnt+1); //일정이 하나도 없으면
				else psmt.setInt(1, NumMax+1); //일정이 1개이상이면 최대값+1인 값을 삽입
				psmt.setString(2, p.getTitle());
				psmt.setString(3, p.getType());
				psmt.setInt(4, p.getImp());
				psmt.setInt(5, p.getAllday());
				//날짜,시간관련
				psmt.setInt(6, p.getS_year()); 
				psmt.setInt(7, p.getS_month());
				psmt.setInt(8, p.getS_day());
				psmt.setInt(9, p.getE_year());
				psmt.setInt(10, p.getE_month());
				psmt.setInt(11, p.getE_day());
				psmt.setInt(12, p.getS_hour());
				psmt.setInt(13, p.getS_min());
				psmt.setInt(14, p.getE_hour());
				psmt.setInt(15, p.getE_min());
				//일정 작성자 아이디
				psmt.setString(16, p.getW_id());
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
	//일정등록 시 삽입된 num컬럼의 값 중 max값 산출
	public int chkMaxP_num(){
		PreparedStatement psmt = null; 
		ResultSet rs = null;
		if(getConn()) {
			try {  
				String sql = "select MAX(num) max from plan";
				psmt = conn.prepareStatement(sql);  
				rs = psmt.executeQuery();
				if(rs.next()) {
					NumMax = rs.getInt("max");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				returnResources2(psmt);
			}	
		}
		return NumMax;
	}
	//현재 기준 일정등록건수 확인하는 메서드
	public int chkCnt(){
		ResultSet rs =null;
		if(getConn()) {
			try {
				PreparedStatement psmt = null;  
				String sql = "select count(*) cnt from plan";
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				if(rs.next()) {
					resultCnt = rs.getInt("cnt");
				}
			} catch (Exception e) {
			}finally {
				returnResources1();
			}
		}
		return resultCnt;
	}

	//시작일 기준 날짜 활용 매칭되는 튜플의 개수 검색 메서드
	public int chkDate(int year, int month, int day) { 
		ResultSet rs = null;
		int resultCnt = 0;
		if (getConn()) { 
			try {
				PreparedStatement psmt = null; 
				String sql = "select count(*) cnt from plan where s_year =? and s_month=? and s_day=?";
				psmt = conn.prepareStatement(sql);  
				psmt.setInt(1,year);
				psmt.setInt(2,month);
				psmt.setInt(3,day);
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
	
	public int cntPlan(int num) { 
		ResultSet rs = null;
		int resultCnt = 0;
		if (getConn()) { 
			try {
				PreparedStatement psmt = null; 
				String sql = "select count(*) cnt from plan where num =?";
				psmt = conn.prepareStatement(sql);  
				psmt.setInt(1,num);
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

	//일정 전체보기 메서드 //입력 안받은 건 77이라 불러올 때 77인 값은 보이지 않도록 조건 걸어야함
	public ArrayList<Plan_DTO> selectAll(){
		PreparedStatement psmt = null; 
		ArrayList<Plan_DTO> list = new ArrayList<>();
		ResultSet rs = null;
		if(getConn()) {
			try {  
				String sql = "select * from plan order by num";
				psmt = conn.prepareStatement(sql);  
				rs = psmt.executeQuery();
				while(rs.next()) {
					Plan_DTO temp = new Plan_DTO();
					temp.setNum(rs.getInt("num"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setImp(rs.getInt("imp"));
					temp.setAllday(rs.getInt("allday"));
					temp.setS_year(rs.getInt("s_year"));
					temp.setS_month(rs.getInt("s_month"));
					temp.setS_day(rs.getInt("s_day"));
					temp.setE_year(rs.getInt("e_year"));
					temp.setE_month(rs.getInt("e_month"));
					temp.setE_day(rs.getInt("e_day"));
					temp.setS_hour(rs.getInt("s_hour"));
					temp.setS_min(rs.getInt("s_min"));
					temp.setE_hour(rs.getInt("e_hour"));
					temp.setE_min(rs.getInt("e_min"));
					temp.setW_id(rs.getString("w_id"));
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
	
	public ArrayList<Plan_DTO> selectsearch1(int year, int month, int day){
		PreparedStatement psmt = null; 
		ArrayList<Plan_DTO> list = new ArrayList<>();
		ResultSet rs = null;
		if(getConn()) {
			try {  
				String sql = "select * from plan where s_year =? and s_month=? and s_day=?";
				psmt = conn.prepareStatement(sql);  
				psmt.setInt(1, year);
				psmt.setInt(2, month);
				psmt.setInt(3, day);
				rs = psmt.executeQuery();
				while(rs.next()) {
					Plan_DTO temp = new Plan_DTO();
					temp.setNum(rs.getInt("num"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setImp(rs.getInt("imp"));
					temp.setAllday(rs.getInt("allday"));
					temp.setS_year(rs.getInt("s_year"));
					temp.setS_month(rs.getInt("s_month"));
					temp.setS_day(rs.getInt("s_day"));
					temp.setE_year(rs.getInt("e_year"));
					temp.setE_month(rs.getInt("e_month"));
					temp.setE_day(rs.getInt("e_day"));
					temp.setS_hour(rs.getInt("s_hour"));
					temp.setS_min(rs.getInt("s_min"));
					temp.setE_hour(rs.getInt("e_hour"));
					temp.setE_min(rs.getInt("e_min"));
					temp.setW_id(rs.getString("w_id"));
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
	
	public ArrayList<Plan_DTO> selectsearch2(String w_id){
		PreparedStatement psmt = null; 
		ArrayList<Plan_DTO> list = new ArrayList<>();
		ResultSet rs = null;
		if(getConn()) {
			try {  
				String sql = "select * from plan where w_id =?";
				psmt = conn.prepareStatement(sql);  
				psmt.setString(1, w_id);
				rs = psmt.executeQuery();
				while(rs.next()) {
					Plan_DTO temp = new Plan_DTO();
					temp.setNum(rs.getInt("num"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setImp(rs.getInt("imp"));
					temp.setAllday(rs.getInt("allday"));
					temp.setS_year(rs.getInt("s_year"));
					temp.setS_month(rs.getInt("s_month"));
					temp.setS_day(rs.getInt("s_day"));
					temp.setE_year(rs.getInt("e_year"));
					temp.setE_month(rs.getInt("e_month"));
					temp.setE_day(rs.getInt("e_day"));
					temp.setS_hour(rs.getInt("s_hour"));
					temp.setS_min(rs.getInt("s_min"));
					temp.setE_hour(rs.getInt("e_hour"));
					temp.setE_min(rs.getInt("e_min"));
					temp.setW_id(rs.getString("w_id"));
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
	
	public ArrayList<Plan_DTO> selectsearch3(String word, String w_id){
		ArrayList<Plan_DTO> list = new ArrayList<>();
		ResultSet rs = null;
		Plan_DTO temp = null;
		if(getConn()) {
			try {  
				PreparedStatement psmt = null; 
				String sql = "select * from plan where title like '%"+word+"%' and w_id=?";
				psmt = conn.prepareStatement(sql);  
				psmt.setString(1, w_id);
				rs = psmt.executeQuery();
				while(rs.next()) {
					temp = new Plan_DTO();
					temp.setNum(rs.getInt("num"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setImp(rs.getInt("imp"));
					temp.setAllday(rs.getInt("allday"));
					temp.setS_year(rs.getInt("s_year"));
					temp.setS_month(rs.getInt("s_month"));
					temp.setS_day(rs.getInt("s_day"));
					temp.setE_year(rs.getInt("e_year"));
					temp.setE_month(rs.getInt("e_month"));
					temp.setE_day(rs.getInt("e_day"));
					temp.setS_hour(rs.getInt("s_hour"));
					temp.setS_min(rs.getInt("s_min"));
					temp.setE_hour(rs.getInt("e_hour"));
					temp.setE_min(rs.getInt("e_min"));
					temp.setW_id(rs.getString("w_id"));
					list.add(temp);	
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				returnResources1();
			}	
		}
		return list;
	}

	//해당 일정번호에 맞는 일정찾기 - 일정 삭제, 수정 시 활용
	public Plan_DTO selectOne1(int num) { 
		Plan_DTO temp = null;
		ResultSet rs = null;  
		if(getConn()) {
			try {
				PreparedStatement psmt = null;   
				String sql = "select * from plan where num=?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, num);

				rs = psmt.executeQuery(); 
				if(rs.next()) {
					temp = new Plan_DTO();
					temp.setNum(rs.getInt("num"));
					temp.setTitle(rs.getString("title"));
					temp.setType(rs.getString("type"));
					temp.setImp(rs.getInt("imp"));
					temp.setAllday(rs.getInt("allday"));
					temp.setS_year(rs.getInt("s_year"));
					temp.setS_month(rs.getInt("s_month"));
					temp.setS_day(rs.getInt("s_day"));
					temp.setE_year(rs.getInt("e_year"));
					temp.setE_month(rs.getInt("e_month"));
					temp.setE_day(rs.getInt("e_day"));
					temp.setS_hour(rs.getInt("s_hour"));
					temp.setS_min(rs.getInt("s_min"));
					temp.setE_hour(rs.getInt("e_hour"));
					temp.setE_min(rs.getInt("e_min"));
					temp.setW_id(rs.getString("w_id"));
				}		
			} catch (Exception e) {
			}finally {
				returnResources1();
			}
		}
		return temp;
	}
	//참고용 일정 관련 내용으로 바꿔야함
	//비밀번호 수정 메서드 - 아이디로 검색 후 수정은 비밀번호만 가능
	public void update(Member_DTO m) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "update plan set pass=? where id=?"; 
				psmt = conn.prepareStatement(sql);
				// 매핑하기
				psmt.setString(1, m.getPass());
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
				String sql = "delete from plan where id=?"; 
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