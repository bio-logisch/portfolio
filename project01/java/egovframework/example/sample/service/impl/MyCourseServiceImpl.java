/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.MyCourseService;
import egovframework.example.sample.service.MyCourseVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MyCourseService")
public class MyCourseServiceImpl extends EgovAbstractServiceImpl implements MyCourseService {

	/** CourseDAO */
	@Resource(name="CourseMapper")
	private CourseMapper courseDAO;
	
	/** MyCourseDAO */
	@Resource(name="MyCourseMapper")
	private MyCourseMapper mycourseDAO;

	@Override
	public List<CourseVO> selectMyCourseList(String id) throws Exception {

		return mycourseDAO.selectMyCourseList(id); //특정 사용자가 신청한 강좌리스트를 조회(course table)
	}
	
	@Override
	public void insertOne(MyCourseVO mcvo) { //특정 사용자가 특정 번호의 강좌를 신청
		mycourseDAO.insertOne(mcvo);
	}
	
	@Override
	public void updateCntPlus(String vno) { //신청 강좌의 신청인원수+1
		//vno로 다시 select c_now, c_full해서 두 조건 비교 후 해당하면 +1 및 insert허용
		mycourseDAO.updateCntPlus(vno);
	}
	
	@Override
	public void updateCntMinus(String vno) { //신청 강좌의 신청인원수+1
		mycourseDAO.updateCntMinus(vno);
	}

	@Override
	public void deleteOne(String dno) throws Exception { //특정 사용자가 특정 번호의 강좌신청을 취소
		mycourseDAO.deleteOne(dno);
	}
	
	@Override
	public int selectMyCourseListTotCnt(String id) { //특정 사용자가 신청한 강좌의 튜플 수를 조회
		int myCourseCnt = mycourseDAO.selectMyCourseListTotCnt();
		return myCourseCnt;
	}

	@Override
	public List<MyCourseVO> selectMyCourse(String id) {
		return mycourseDAO.selectMyCourse(id); //특정 사용자가 신청한 강좌리스트를 조회(mycourse table)
	}

	@Override
	public int myCourseCnt(String id) throws Exception {
		return mycourseDAO.myCourseCnt(id); //특정 사용자가 신청한 강좌의 개수 리턴
	}

}
