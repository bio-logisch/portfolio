package egovframework.example.sample.service;

import java.util.List;

public interface CourseService {

	CourseVO selectCourse(String vno) throws Exception; //특정번호의 강좌 글 하나를 조회
	List<CourseVO> selectCourseList(PageVO pagevo) throws Exception; //모든 강좌글 목록을 조회
	int selectCourseListTotCnt(); //강좌글 총 개수를 조회
}
