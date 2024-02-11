package egovframework.example.sample.service;

import lombok.Data;

@Data
public class ReplyVO {
	
	private String rep_num = null; //댓글고유번호
	private String c_num = null; //댓글을 단 강좌의 고유번호
	private String m_id = null; //댓글 작성자 아이디
	private String rep_date = null; //댓글 작성일
	private String rep_content = null; //댓글 내용
	
//	public String getRep_num() {
//		return rep_num;
//	}
//	public void setRep_num(String rep_num) {
//		this.rep_num = rep_num;
//	}
//	public String getC_num() {
//		return c_num;
//	}
//	public void setC_num(String c_num) {
//		this.c_num = c_num;
//	}
//	public String getM_id() {
//		return m_id;
//	}
//	public void setM_id(String m_id) {
//		this.m_id = m_id;
//	}
//	public String getRep_date() {
//		return rep_date;
//	}
//	public void setRep_date(String rep_date) {
//		this.rep_date = rep_date;
//	}
//	public String getRep_content() {
//		return rep_content;
//	}
//	public void setRep_content(String rep_content) {
//		this.rep_content = rep_content;
//	}
	
	
}
