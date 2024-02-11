package egovframework.example.sample.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	String m_id=null;
	String m_pw=null;
	String m_name=null;
	String m_phone=null;
	
	public void prt() {
		System.out.println(m_id);
		System.out.println(m_pw);
		System.out.println(m_name);
		System.out.println(m_phone);
	}
}
