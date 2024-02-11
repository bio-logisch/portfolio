package egovframework.example.sample.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	
	private String rep_num = null; //댓글고유번호
	private String c_num = null; //댓글을 단 강좌의 고유번호
	private String m_id = null; //댓글 작성자 아이디
	private String rep_date = null; //댓글 작성일
	private String rep_content = null; //댓글 내용
	
}
