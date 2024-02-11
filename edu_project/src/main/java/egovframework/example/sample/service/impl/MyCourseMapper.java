package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.MyCourseVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;


@Mapper("MyCourseMapper")
public interface MyCourseMapper {

	List<CourseVO> selectMyCourseList(String id); //특정 사용자가 신청한 모든 강좌 리스트 조회
	int selectMyCourseListTotCnt(); //특정 사용자가 신청한 강좌의 총 갯수를 조회
	void insertOne(MyCourseVO mcvo); //강좌신청
	void deleteOne(String dvo); //강좌신청취소
	List<MyCourseVO> selectMyCourse(String id); //해당 회원의 신청강좌리스트(이미 신청한 강좌인지 중복체크용)
	void updateCntPlus(String vno); //신청한 강좌의 신청인원 +1 
	void updateCntMinus(String vno); //신청한 강좌의 신청인원 -1 
	int myCourseCnt(String id); //특정 사용자의 신청강좌수 cnt
}
