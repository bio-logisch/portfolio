package egovframework.example.sample.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.FileDataUtil;
import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.ReviewService;
import egovframework.example.sample.service.ReviewVO;

@Controller
public class ReviewController {
	
	@Resource(name = "ReviewService")
	private ReviewService reviewService;
	
	@Inject
	private FileDataUtil util;
	
	@RequestMapping(value = "/reviewList", method = RequestMethod.GET)
	public String reviewList(Locale locale, Model model, @ModelAttribute PageVO pvo) throws Exception {
		if(pvo.getPage()==null) {
			pvo.setPage(1);
		}
		Integer total = reviewService.totalCnt();
		pvo.setTotalCount(total);
		List<ReviewVO> returnRvo = reviewService.selectPages(pvo);
		model.addAttribute("rlist", returnRvo);
		model.addAttribute("page", pvo);
		model.addAttribute("total", total);
		return "sample/reviewList";
	}
	
	@RequestMapping(value = "/reviewForm", method = RequestMethod.GET)
	public String reviewForm(Locale locale, Model model,HttpSession session,@RequestParam(value="flag", required=false) String a) throws Exception {
		model.addAttribute("flag", a);
		if(session.getAttribute("userid") != null) {
			String id = session.getAttribute("userid").toString();
			List<CourseVO> returncvo = reviewService.myCourse(id);
			model.addAttribute("reviewFlag", returncvo.size());
			model.addAttribute("clist", returncvo);
		}
		return "sample/reviewForm";
	}
	
	@RequestMapping(value = "/reviewDone", method = RequestMethod.POST)
	public String courselist(Locale locale, Model model, @ModelAttribute ReviewVO rvo, 
			MultipartFile[] file) throws IOException {
		String content = rvo.getRev_content();
		content = content.replace("\r\n", "<br>");
		rvo.setRev_content(content);
		String[] originalNames = new String[file.length];
		for (int i = 0; i < file.length; i++) {
		originalNames[i]=file[i].getOriginalFilename();
		//System.out.println("파일명 원본 :"+originalNames[i]);
		}
		String[] convertedNames=util.fileUpload(file);
		rvo.setFiles(convertedNames);
		rvo.setOriginalNames(originalNames);
		//System.out.println("변환된 파일명 :"+rvo.getFiles()[0]);
		//System.out.println("변환된 파일명 :"+rvo.getFiles()[1]);
		reviewService.insertOne(rvo);
		
		return "redirect:/reviewList";
	}
	
	@RequestMapping(value = "/reviewModify", method = RequestMethod.GET)
	public String reviewModify(Locale locale, Model model, @RequestParam("rno") String rno) throws IOException {
		model.addAttribute("review", reviewService.selectOne(rno));
		return "sample/reviewModify";
	}
	
	@RequestMapping(value = "/reviewModifyDone", method = RequestMethod.POST)
	public String reviewModifyDone(Locale locale, Model model, @ModelAttribute ReviewVO rvo) throws IOException {
		String content = rvo.getRev_content();
		content = content.replace("\r\n", "<br>");
		rvo.setRev_content(content);
		reviewService.updateOne(rvo);
		return "redirect:/reviewList";
	}
	
	@RequestMapping(value = "/rdetail", method = RequestMethod.GET)
	public String reviewDetail(Locale locale, Model model, @RequestParam("rno") String rno) throws Exception {
		model.addAttribute("review", reviewService.selectOne(rno));
		model.addAttribute("olist", reviewService.fOriginalList(rno));
		model.addAttribute("clist", reviewService.fConvertedList(rno));
		return "sample/reviewDetail";
	}
	
	@RequestMapping(value = "/reviewDelete", method = RequestMethod.GET)
	public String reviewDelete(Locale locale, Model model, @RequestParam("rno") String rno) throws Exception {
		reviewService.deleteOne(rno);
		return "redirect:/reviewList";
	}
}
