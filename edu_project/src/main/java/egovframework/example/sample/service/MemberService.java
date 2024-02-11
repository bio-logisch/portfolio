package egovframework.example.sample.service;

public interface MemberService {
	void insertOne(MemberVO mvo);
	MemberVO selectOne(MemberVO mvo);
	void deleteOne(String id);
	void updateOne(MemberVO mvo);
	MemberVO selectOneforModify(String id);
}
