package egovframework.example.sample.web;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;

@RestController
public class LoginChk {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Inject
	MemberService memberservice;
	//회원가입 메소드
	@PostMapping("/user")
	public String join(@RequestBody MemberVO mvo) {//ajax에서 전송한 data MemberVO에 매핑
		//비밀번호 암호화
				String pw = mvo.getM_pw();
				System.out.println("원래 비번 :"+pw);
					pw = encoder.encode(pw);
					mvo.setM_pw(pw);
				System.out.println("암호화된 비번 :"+pw);
				mvo.toString();//lombok적용
		if(mvo.getM_id()!=null) {//MemberVO 객체 id가 null이 아니다 = 매핑 성공
			memberservice.insertOne(mvo); //회원 insert 쿼리 진행
			System.out.println("쿼리실행됨");
			return "success";
		}else {
			return "mvo is null";
		}
	}
	
	//회원 조회 메소드
	@GetMapping("/userlist/{userid}")//{userid} = ajax url에 붙인 값(ajax에서 쓴것과 이름 같아야 매핑됨)
	public String loginPreChk(@PathVariable String userid) {//url에 붙인 값(ajax에서 쓴것과 이름 같아야 매핑됨)
		MemberVO returnmvo = memberservice.selectOneforModify(userid); //회원 조회 쿼리 실행
		//System.out.println("해당 id 회원가입 여부");
		//System.out.println(returnmvo!=null);
		if(returnmvo!=null) {//MemberVO 객체 아이디가 null이 아님 = 디비에 존재하므로 이미 가입된 아이디
			return "login"; //ajax에 전달될 result
		}else {//MemberVO 객체 아이디가 null = 디비에 존재하지 않므로 가입되지 않은 아이디
			return "signup";//ajax에 전달될 result
		}
	}
	
	//회원정보 수정 메소드
	@PutMapping("/user")
	public String memberModify(@RequestBody MemberVO mvo) {//ajax에서 전송한 data MemberVO에 매핑
		if(mvo.getM_id()!=null) {//MemberVO 객체 id가 null이 아니다 = 매핑 성공
			if(mvo.getM_pw()==null) {
				mvo.setM_pw("sns");
			}
			String pw = mvo.getM_pw();
			System.out.println("원래 비번 :"+pw);
			pw = encoder.encode(pw);
			mvo.setM_pw(pw);
			memberservice.updateOne(mvo); //회원 insert 쿼리 진행
			return "success";
		}else {
			return "mvo is null";
		}
	}
}
