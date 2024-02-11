package egovframework.example.sample.web;

import java.util.List;
import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmodules.validation.commons.DefaultBeanValidator;
import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.CourseService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class CourseController {

	@Resource(name = "CourseService")
	private CourseService courseService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	//강좌 목록 보기
	@RequestMapping(value = "/courseList", method = RequestMethod.GET)
	public String courselist(Locale locale, Model model, @ModelAttribute PageVO pvo,
			@RequestParam(value="pvo", required=false) String a) throws Exception {
		//Locale locale, Model model, @ModelAttribute PageVO pvo에서 
		//클라이언트에서 받은 게 뭔지 정의하는 것이고 동시에 이 컨트롤러에서 뭘 사용할지를 보여주는 부분임
		if(pvo.getPage() == null) {
			pvo.setPage(1); //지정된 페이지가 없으면 1페이지부터 시작
		}
		pvo.setTotalCount(courseService.selectCourseListTotCnt()); //course테이블 전체튜플수 cnt해서 넣기
		pvo.prt(); //test
		//page값에 따라 현재 페이지 시작글번호와 끝번호 출력테스트
		System.out.println(pvo.getStartNo()+"/"+pvo.getEndNo());
		List<CourseVO> clist = courseService.selectCourseList(pvo);
		//System.out.println(clist);
		model.addAttribute("clist", clist);
		model.addAttribute("page", pvo);
		//model.addAttribute("flag2", a);
		return "sample/courseList";
	}
	
	//강좌 상세 보기
	@RequestMapping(value = "/courseOne", method = RequestMethod.GET)
	public String courseOne(Locale locale, Model model, @RequestParam("vno") String vno, 
			@RequestParam(value="flag2", required=false) String a, PageVO pvo) throws Exception {
		model.addAttribute("flag2", a);
		model.addAttribute("nowvo", courseService.selectCourse(vno));
		model.addAttribute("page", pvo);
		return "sample/courseDetail";
	}
	
	//강좌 상세보기 - 지도 보기
	@RequestMapping(value = "/mapView", method = RequestMethod.GET)
	public String map(Locale locale, Model model) throws Exception {
		
		return "sample/map";
	}

}
