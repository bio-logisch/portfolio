package egovframework.example.sample.service;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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
	
	@Override
	public String toString() {
		return "ReviewVO [rev_num=" + rev_num + ", rev_date=" + rev_date + ", rev_title=" + rev_title + ", rev_content="
				+ rev_content + ", m_id=" + m_id  + ", c_num=" + c_num + ", c_name=" + c_name
				+ ", c_place=" + c_place + ", c_date=" + c_date + ", c_time=" + c_time + ", c_teacher=" + c_teacher
				+ ", files=" + Arrays.toString(files) + ", originalNames=" + Arrays.toString(originalNames) + "]";
	}
}
