package egovframework.example.sample.service;

import java.util.List;

public interface ReplyService {
	
	void insertOne(ReplyVO revo); //댓글 추가
	List<ReplyVO> selectAll(String vno) throws Exception; //모든 댓글 조회 
	void updateOne(ReplyVO revo); //댓글내용 수정
	void deleteOne(String rep_num); //댓글 삭제

}
