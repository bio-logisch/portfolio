package DTO;

import java.awt.Component;

public class Plan_DTO { //EditGUI, Plan_DAO와 연결 

	int num = 0; //일정고유번호 - 시퀀스 없이 별도 자바코드로 가기
	String title = null; //일정 제목
	int allday = 0; //종일일정인지 여부 체크 - 0이면 종일x 1이면 종일o(boolean으로 안함)
	String type = null; //일정 분류(Task, Event, Appointment, etc.) 4가지중 하나만 선택
	int imp = 0; //중요일정 여부체크 - 기본값0, 0이면 안중요, 1이면 중요
	int s_year = 0; //일정 시작연도 
	int s_month = 0; //일정 시작월 
	int s_day = 0; //일정 시작일 
	int e_year = 0; //일정 종료연도 
	int e_month = 0; //일정 종료월 
	int e_day = 0; //일정 종료일 
	int s_hour = 0; //일정 시작시간 
	int s_min = 0; //일정 시작분 
	int e_hour = 0; //일정 종료시간 
	int e_min = 0; //일정 종료분 
	String w_id = null; //해당 일정 저장한 사람의 아이디
	
	//일정 출력용 메서드
	public String prt() {
		//일정 등록 시 경우의 수 4가지(필요없는 컴포넌트 비활성화로 처리)
		//1) 종일 일정O + 하루일정O + 중요 일정O/X : 시작일자
		//2) 종일 일정O + 기간일정O + 중요 일정O/X : 시작일자 / 종료일자
		//3) 종일 일정X + 하루일정O + 중요 일정O/X: 시작일자 / 시작시간 / 종료시간 
		//4) 종일 일정X + 기간일정O + 중요 일정O/X: 시작일자 /종료일자 / 시작시간 / 종료시간 - 4번 제외하고 입력받음
		//경우에 따라 입력받지 않는 값은 null을 입력할 수 없어서 77을 입력값으로 DB에 전송함
		String prtPlan1 = num+"번 >> 제목 : " + title;
		String prtPlan12 = "\n분류 : "+type;
		String prtPlan21 = "\n종일여부 : O";
		String prtPlan22 = "\n종일여부 : X";
		String prtPlan31 = "  중요일정 : O";
		String prtPlan32 = "  중요일정 : X";
		String prtPlan33 = "  하루일정 : O";
		String prtPlan34 = "  기간일정 : O";
		String prtPlan4 = "\n시작일 : " +s_year+"년 "+s_month+"월 "+s_day+"일";
		String prtPlan5 = "\n시작시간 : " +s_hour+"시 "+s_min+"분";
		String prtPlan6 = "\n종료일 : " +e_year+"년 "+e_month+"월 "+e_day+"일";
		String prtPlan7 = "\n종료시간 : " +e_hour+"시 "+e_min+"분";
		String prtPlanAll = null;
		if(allday == 0) { //종일일정 아니면
			if(prtPlan6.contains("77")) { //종일 일정인데 종료일자를 입력받지 않았다면, 하루일정에 해당
				//3번 경우(시작일자, 시작시간, 종료시간)
				if(imp == 0) { //중요일정 아니면
					prtPlanAll = prtPlan1+prtPlan12+prtPlan22+prtPlan32+prtPlan33+prtPlan4+prtPlan5+prtPlan7+"\n";
				}else if(imp == 1) { //중요일정이면
					prtPlanAll = prtPlan1+prtPlan12+prtPlan22+prtPlan31+prtPlan33+prtPlan4+prtPlan5+prtPlan7+"\n";
				}	
			}//else의 경우 4번 경우라서 제외함
		}else if(allday == 1) {//종일일정이면, 시간필요x
			if(prtPlan6.contains("77")) { //종료일자를 받지 않은 경우 - 1번 경우(시작일자)
				if(imp == 0) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan32+prtPlan33+prtPlan4+"\n";
				}else if(imp == 1) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan31+prtPlan33+prtPlan4+"\n";	
				}
			} else { //종료일자를 받은 경우 - 2번 경우(시작일자, 종료일자)
				if(imp == 0) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan32+prtPlan34+prtPlan4+prtPlan6+"\n";
				}else if(imp == 1) {
					prtPlanAll = prtPlan1+prtPlan12+prtPlan21+prtPlan31+prtPlan34+prtPlan4+prtPlan6+"\n";
				}
			}
		}
		return prtPlanAll;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAllday() {
		return allday;
	}
	public void setAllday(int allday) {
		this.allday = allday;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getImp() {
		return imp;
	}
	public void setImp(int imp) {
		this.imp = imp;
	}
	public int getS_year() {
		return s_year;
	}
	public void setS_year(int s_year) {
		this.s_year = s_year;
	}
	public int getS_month() {
		return s_month;
	}
	public void setS_month(int s_month) {
		this.s_month = s_month;
	}
	public int getS_day() {
		return s_day;
	}
	public void setS_day(int s_day) {
		this.s_day = s_day;
	}
	public int getE_year() {
		return e_year;
	}
	public void setE_year(int e_year) {
		this.e_year = e_year;
	}
	public int getE_month() {
		return e_month;
	}
	public void setE_month(int e_month) {
		this.e_month = e_month;
	}
	public int getE_day() {
		return e_day;
	}
	public void setE_day(int e_day) {
		this.e_day = e_day;
	}
	public int getS_hour() {
		return s_hour;
	}
	public void setS_hour(int s_hour) {
		this.s_hour = s_hour;
	}
	public int getS_min() {
		return s_min;
	}
	public void setS_min(int s_min) {
		this.s_min = s_min;
	}
	public int getE_hour() {
		return e_hour;
	}
	public void setE_hour(int e_hour) {
		this.e_hour = e_hour;
	}
	public int getE_min() {
		return e_min;
	}
	public void setE_min(int e_min) {
		this.e_min = e_min;
	}

	public String getW_id() {
		return w_id;
	}

	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	
}
