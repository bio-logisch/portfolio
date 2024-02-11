package egovframework.example.sample.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.ReviewService;
import egovframework.example.sample.service.ReviewVO;

@Controller
public class HomeController {
	
	@Resource(name = "ReviewService")
	private ReviewService reviewService;
	
	//메인 페이지 시작
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session, ReviewVO rvo,
			@RequestParam(value="flag", required=false) String a) throws Exception {
		model.addAttribute("flag", a);
		//수강후기 불러오기 
		List<ReviewVO> returnRvo = reviewService.selectThree();
		model.addAttribute("rlist", returnRvo);
				
		return "sample/home";
	}
	//회원가입버튼 클릭 -> 회원가입창 열기
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) throws Exception {

		return "sample/join";
	}
	//기관 안내
	@RequestMapping(value = "/centerInfo", method = RequestMethod.GET)
	public String centerinfo(Locale locale, Model model) throws Exception {

		return "sample/centerInfo";
	}
	//마이페이지
	@RequestMapping(value = "/myPage2", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model) throws Exception {

		return "redirect:/myPage";
	}
	
}
