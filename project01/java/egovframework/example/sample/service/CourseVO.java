package egovframework.example.sample.service;

import lombok.Data;


@Data
public class CourseVO {
	//extends CourseDefaultVO
	//private static final long serialVersionUID = 1L;

	private String c_num = null; //강좌고유번호
	private String c_name = null; //강좌명
	private String c_place = null; //기관명(강의장소)
	private String c_date = null; //수강기간
	private String c_time = null; //수강시간
	private String c_full = null; //모집인원
	private String c_now = null; //신청인원
	private String c_teacher = null; //강사명
	private String c_student = null; //수강대상
	
//	public String getC_num() {
//		return c_num;
//	}
//	public void setC_num(String c_num) {
//		this.c_num = c_num;
//	}
//	public String getC_name() {
//		return c_name;
//	}
//	public void setC_name(String c_name) {
//		this.c_name = c_name;
//	}
//	public String getC_place() {
//		return c_place;
//	}
//	public void setC_place(String c_place) {
//		this.c_place = c_place;
//	}
//	public String getC_date() {
//		return c_date;
//	}
//	public void setC_date(String c_date) {
//		this.c_date = c_date;
//	}
//	public String getC_time() {
//		return c_time;
//	}
//	public void setC_time(String c_time) {
//		this.c_time = c_time;
//	}
//	public String getC_full() {
//		return c_full;
//	}
//	public void setC_full(String c_full) {
//		this.c_full = c_full;
//	}
//	public String getC_now() {
//		return c_now;
//	}
//	public void setC_now(String c_now) {
//		this.c_now = c_now;
//	}
//	public String getC_teacher() {
//		return c_teacher;
//	}
//	public void setC_teacher(String c_teacher) {
//		this.c_teacher = c_teacher;
//	}
//	public String getC_student() {
//		return c_student;
//	}
//	public void setC_student(String c_student) {
//		this.c_student = c_student;
//	}
}
