package egovframework.example.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("MemberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService{
	@Resource(name="MemberMapper")
	private MemberMapper memberDAO;
	
	@Override
	public void insertOne(MemberVO mvo) {
		memberDAO.insertOne(mvo);
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return memberDAO.selectOne(mvo);
	}
	
	@Override
	public void deleteOne(String id) {
		memberDAO.deleteOne(id);
	}

	@Override
	public void updateOne(MemberVO mvo) {
		memberDAO.updateOne(mvo);
	}

	@Override
	public MemberVO selectOneforModify(String id) {
		return memberDAO.selectOneforModify(id);
	}

	@Override
	public int selectCnt(String id) {
		return memberDAO.selectCnt(id);
	}

}
