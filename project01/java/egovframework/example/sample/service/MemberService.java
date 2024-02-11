package egovframework.example.sample.service;

public interface MemberService {
	void insertOne(MemberVO mvo);
	MemberVO selectOne(MemberVO mvo);
	void deleteOne(String id);
	void updateOne(MemberVO mvo);
	MemberVO selectOneforModify(String id);
	int selectCnt(String m_id); //해당 아이디로 가입한 회원이 있는지 cnt 체크(1혹은 0)
}
