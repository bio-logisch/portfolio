package egovframework.example.sample.service.impl;

import egovframework.example.sample.service.MemberVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("MemberMapper")
public interface MemberMapper {
	void insertOne(MemberVO mvo);
	MemberVO selectOne(MemberVO mvo);
	void deleteOne(String id); //회원탈퇴
	void updateOne(MemberVO mvo); //회원정보 수정(비밀번호, 전화번호)
	MemberVO selectOneforModify(String id); //회원정보 조회(정보수정 시 사용)
}
