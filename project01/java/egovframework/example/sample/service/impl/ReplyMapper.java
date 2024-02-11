package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.service.ReplyVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("ReplyMapper")
public interface ReplyMapper {
	
	void insertOne(ReplyVO revo);//댓글 추가
	List<ReplyVO> selectAll(String vno);//모든 댓글 조회 
	void updateOne(ReplyVO revo); //댓글 내용 수정
	void deleteOne(String rep_num); //댓글 삭제
}
