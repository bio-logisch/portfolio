package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.PageVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("CourseMapper")
public interface CourseMapper {
	
	CourseVO selectCourse(String vno) throws Exception; //한 강좌의 상세 정보를 조회
	List<CourseVO> selectCourseList(PageVO pagevo) throws Exception;//전체 강좌 목록을 조회
	int selectCourseListTotCnt(); //전체 강좌정보글의 총 갯수를 조회
	
}
