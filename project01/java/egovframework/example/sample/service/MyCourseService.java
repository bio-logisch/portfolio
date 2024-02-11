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
package egovframework.example.sample.service;

import java.util.List;

public interface MyCourseService {
	List<CourseVO> selectMyCourseList(String id) throws Exception; //신청강좌 목록조회
	void insertOne(MyCourseVO mcvo) throws Exception; //강좌 신청
	void deleteOne(String dno) throws Exception; //강좌 신청 취소
	int selectMyCourseListTotCnt(String id) throws Exception; //로그인한 사용자가 신청한 강좌의 총 갯수를 조회
	List<MyCourseVO> selectMyCourse(String id) throws Exception; //해당 회원의 신청강좌리스트(이미 신청한 강좌인지 중복체크용)
	void updateCntPlus(String c_num) throws Exception; //신청 강좌의 신청인원 +1
	void updateCntMinus(String c_num) throws Exception; //신청 강좌의 신청인원 -1
	int myCourseCnt(String id) throws Exception; //특정 사용자의 신청강좌수 
}