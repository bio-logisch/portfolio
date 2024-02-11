package egovframework.example.sample.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.MyCourseService;
import egovframework.example.sample.service.MyCourseVO;
import egovframework.example.sample.service.CourseService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class MyCourseController {

	@Resource(name = "CourseService")
	private CourseService courseService;

	@Resource(name = "MyCourseService")
	private MyCourseService mycourseService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	//내가 신청한 강좌 상세보기(리스트) >> 마이페이지
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String courselist(Locale locale, Model model, HttpSession session) throws Exception {
		//System.out.println(session);
		//System.out.println(session.getAttribute("userid"));
		Object id = session.getAttribute("userid");
		if(id != null) { //회원이 로그인을 했을 때
			id = id.toString();
		}else { //비회원 상태일 때
			return "redirect:/home?flag=3";
		}
		System.out.println(id);
		List<CourseVO> returncvo = mycourseService.selectMyCourseList(id.toString());
		model.addAttribute("mclist", returncvo);
		int totalCnt = mycourseService.myCourseCnt(id.toString());
		model.addAttribute("courseCnt", totalCnt);
		return "sample/myPage";
	}

	//강좌 신청
	@RequestMapping(value = "/requestDone", method = RequestMethod.POST)
	public String String (Locale locale, Model model, @ModelAttribute MyCourseVO mcvo, HttpSession session) throws Exception {
		String flag2="0"; //사용자에게 알림전하기 위한 변수
		String nowid = mcvo.getM_id(); //현재 사용자의 아이디
		String nowC_num = mcvo.getC_num(); //현재 신청하려고 하는 강좌번호
		int cnt = 0; // 신청하려는 강좌번호와 이미 신청한 강좌 중 강좌번호가 같은 경우 +1

		//신청가능 여부 체크1(회원인지 아닌지) >> JSP에서 처리

		//신청가능 여부 체크2(이미 신청한 강좌인지)	
		List<MyCourseVO> mclist = mycourseService.selectMyCourse(nowid); //현재사용자의 신청강좌리스트
		//model.addAllAttributes(mclist);		
		System.out.println("신청강좌수 : "+mclist.size());
		for(int i=0; i < mclist.size(); i++) {
			if(mclist != null) { //해당 사용자가 이전에 신청한 강좌가 있다면
				//신청하려는 강좌의 강좌번호와 해당 사용자가 이미 신청한 강좌들의 강좌번호 중 같은 게 있는지 체크
				System.out.println("현재신청번호 : "+nowC_num);
				System.out.println("이미신청한번호 : "+mclist.get(i).getC_num());
				if(nowC_num.equals(mclist.get(i).getC_num())) { 
					cnt++;
					flag2 = "1";
					System.out.println("중복강좌임");
					model.addAttribute("flag2", flag2);
					System.out.println("flag2 : " + flag2);
					//return "courseList.do?flag2=1";
					return "redirect:/courseOne?vno="+nowC_num;
				}else {
					System.out.println("중복강좌 아님");
				}
			}
		}
		System.out.println("중복횟수 : " + cnt);
		if(cnt == 1)  { //이미 신청한 강좌면 cnt=1임
			flag2 = "1";
			model.addAttribute("flag2", flag2);
			return "redirect:/courseOne"; //현재페이지에 머물기
		}else { //지금 신청강좌가 이전에 신청한 강좌와 중복아니면 >> 신청가능 여부 체크3(모집정원이 모두 찼는지)
			int c_now = Integer.parseInt(courseService.selectCourse(mcvo.getC_num()).getC_now()); //해당강좌 현재 신청인원
			int c_full = Integer.parseInt(courseService.selectCourse(mcvo.getC_num()).getC_full()); //해당강좌 모집정원
			System.out.println("신청인원/모집인원 : "+c_now+"/"+c_full);
			if(c_now < c_full) { //해당강좌의 신청인원 < 모집인원
				mycourseService.updateCntPlus(mcvo.getC_num()); //신청인원+1
				mycourseService.insertOne(mcvo); //mycourse테이블에 튜플 삽입
				flag2 = "2";
				System.out.println("강좌신청완료");
				model.addAttribute("flag2", flag2);
				return "redirect:/courseOne?vno="+nowC_num; //현재페이지에 머물기
			}else {
				System.out.println("신청불가 - 정원초과");
				flag2 = "3";
				model.addAttribute("flag2", flag2);
			}	
			model.addAttribute("flag2", flag2);
			return "redirect:/courseOne?vno="+nowC_num; //현재페이지에 머물기
		}
	}	
	
	//강좌 신청 취소
	@RequestMapping(value = "/coursedel", method = RequestMethod.GET)
	public String coursedel(Locale locale, Model model, 
			@RequestParam("dno") String ddno) throws Exception {
		mycourseService.deleteOne(ddno);
		mycourseService.updateCntMinus(ddno);
		return "redirect:/myPage";
	}
}
