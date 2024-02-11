package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.ReplyService;
import egovframework.example.sample.service.ReplyVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("ReplyService")
public class ReplyServiceImpl extends EgovAbstractServiceImpl implements ReplyService{
	
	@Resource(name="ReplyMapper")
	private ReplyMapper replyDAO;
	
	@Override
	public void insertOne(ReplyVO revo) {
		replyDAO.insertOne(revo);
	}

	@Override
	public List<ReplyVO> selectAll(String vno) throws Exception {
		return replyDAO.selectAll(vno);
	}

	@Override
	public void updateOne(ReplyVO revo) {
		replyDAO.updateOne(revo);
	}

	@Override
	public void deleteOne(String rep_num) {
		replyDAO.deleteOne(rep_num);
	}
}
