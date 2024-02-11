package egovframework.example.sample.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
	
}
