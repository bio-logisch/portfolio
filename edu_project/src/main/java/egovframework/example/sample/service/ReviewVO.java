package egovframework.example.sample.service;

import java.util.Arrays;

import lombok.Data;

@Data
public class ReviewVO {
	private String rev_num=null;
	private String rev_date=null;
	private String rev_title=null;
	private String rev_content=null;
	private String m_id=null;
	private String c_num=null;
	private String c_name=null;
	private String c_place=null;
	private String c_date=null;
	private String c_time=null;
	private String c_teacher=null;
	String[] files=null; //현재 client 첨부파일은 multipart 자료형으로 받아와 자동매핑하면 안되므로 변수명 다르게 설정
	String[] originalNames=null;
	
//	@Override
//	public String toString() {
//		return "ReviewVO [rev_num=" + rev_num + ", rev_date=" + rev_date + ", rev_title=" + rev_title + ", rev_content="
//				+ rev_content + ", m_id=" + m_id  + ", c_num=" + c_num + ", c_name=" + c_name
//				+ ", c_place=" + c_place + ", c_date=" + c_date + ", c_time=" + c_time + ", c_teacher=" + c_teacher
//				+ ", files=" + Arrays.toString(files) + ", originalNames=" + Arrays.toString(originalNames) + "]";
//	}
//
//	public String getRev_num() {
//		return rev_num;
//	}
//
//	public void setRev_num(String rev_num) {
//		this.rev_num = rev_num;
//	}
//
//	public String getRev_date() {
//		return rev_date;
//	}
//
//	public void setRev_date(String rev_date) {
//		this.rev_date = rev_date;
//	}
//
//	public String getRev_title() {
//		return rev_title;
//	}
//
//	public void setRev_title(String rev_title) {
//		this.rev_title = rev_title;
//	}
//
//	public String getRev_content() {
//		return rev_content;
//	}
//
//	public void setRev_content(String rev_content) {
//		this.rev_content = rev_content;
//	}
//
//	public String getM_id() {
//		return m_id;
//	}
//
//	public void setM_id(String m_id) {
//		this.m_id = m_id;
//	}
//
//	public String getC_num() {
//		return c_num;
//	}
//
//	public void setC_num(String c_num) {
//		this.c_num = c_num;
//	}
//
//	public String getC_name() {
//		return c_name;
//	}
//
//	public void setC_name(String c_name) {
//		this.c_name = c_name;
//	}
//
//	public String getC_place() {
//		return c_place;
//	}
//
//	public void setC_place(String c_place) {
//		this.c_place = c_place;
//	}
//
//	public String getC_date() {
//		return c_date;
//	}
//
//	public void setC_date(String c_date) {
//		this.c_date = c_date;
//	}
//
//	public String getC_time() {
//		return c_time;
//	}
//
//	public void setC_time(String c_time) {
//		this.c_time = c_time;
//	}
//
//	public String getC_teacher() {
//		return c_teacher;
//	}
//
//	public void setC_teacher(String c_teacher) {
//		this.c_teacher = c_teacher;
//	}
//
//	public String[] getFiles() {
//		return files;
//	}
//
//	public void setFiles(String[] files) {
//		this.files = files;
//	}
//
//	public String[] getOriginalNames() {
//		return originalNames;
//	}
//
//	public void setOriginalNames(String[] originalNames) {
//		this.originalNames = originalNames;
//	}

}
