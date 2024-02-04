package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Member_DTO;
import DTO.Plan_DTO;

//Ŭ���� ���� : ���� ���, ����, ����, �˻���� ����
public class Plan_DAO extends FNC_DAO{
	int resultCnt=0; //��ϵ� ������ ī����
	int NumMax = 0; //������ȣ �ִ밪

	// ������� �޼���
	public void insert(Plan_DTO p) { 
		chkCnt();//������ϰǼ� ī����
		chkMaxP_num(); //������ϰ��� num�÷��� �� �� max�� ����
		PreparedStatement psmt = null; 
		if (getConn()) { 
			try {
				String sql = "insert into plan values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
				psmt = conn.prepareStatement(sql);
				// �����ϱ�
				if(resultCnt == 0) psmt.setInt(1, resultCnt+1); //������ �ϳ��� ������
				else psmt.setInt(1, NumMax+1); //������ 1���̻��̸� �ִ밪+1�� ���� ����
				psmt.setString(2, p.getTitle());
				psmt.setString(3, p.getType());
				psmt.setInt(4, p.getImp());
				psmt.setInt(5, p.getAllday());
				//��¥,�ð�����
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
				//���� �ۼ��� ���̵�
				psmt.setString(16, p.getW_id());
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
	//������� �� ���Ե� num�÷��� �� �� max�� ����
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
	//���� ���� ������ϰǼ� Ȯ���ϴ� �޼���
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

	//������ ���� ��¥ Ȱ�� ��Ī�Ǵ� Ʃ���� ���� �˻� �޼���
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

	//���� ��ü���� �޼��� //�Է� �ȹ��� �� 77�̶� �ҷ��� �� 77�� ���� ������ �ʵ��� ���� �ɾ����
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

	//�ش� ������ȣ�� �´� ����ã�� - ���� ����, ���� �� Ȱ��
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
	//����� ���� ���� �������� �ٲ����
	//��й�ȣ ���� �޼��� - ���̵�� �˻� �� ������ ��й�ȣ�� ����
	public void update(Member_DTO m) {
		PreparedStatement psmt = null; 
		if (getConn()) {  
			try {
				String sql = "update plan set pass=? where id=?"; 
				psmt = conn.prepareStatement(sql);
				// �����ϱ�
				psmt.setString(1, m.getPass());
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
				String sql = "delete from plan where id=?"; 
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