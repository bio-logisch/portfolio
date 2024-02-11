package egovframework.example.sample.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.CourseService;
import egovframework.example.sample.service.MyCourseService;
import egovframework.example.sample.service.MyCourseVO;
import egovframework.example.sample.service.ReplyService;
import egovframework.example.sample.service.ReplyVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@RestController
public class ReplyController {
	
	@Resource(name = "ReplyService")
	private ReplyService replyservice;
	
	@Resource(name = "MyCourseService")
	private MyCourseService mycourseService;
	
	@Resource(name = "CourseService")
	private CourseService courseService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@PostMapping("/replyDone")
	public String replydone(@RequestBody ReplyVO revo) { 
		System.out.println("체크:" + revo.getC_num());

		replyservice.insertOne(revo);
		return "success"; 
	}
	
	@PutMapping("/replyUpdate")
	public String replyUpdate(@RequestBody ReplyVO revo) { 
		System.out.println("수정할 댓글번호:" + revo.getRep_num());
		replyservice.updateOne(revo);
		return "success"; 
	}
	
	@DeleteMapping("/replyDelete/{rep_num}")
	public String replyDelete(@PathVariable("rep_num") String rep_num) { 
		System.out.println("삭제할 댓글번호:" + rep_num);
		replyservice.deleteOne(rep_num);
		return "success"; 
	}
	
	
	@GetMapping("/replySelect/{vno}")
	public List<ReplyVO> replySelect(@PathVariable String vno) throws Exception {
	    try {
	        List<ReplyVO> relist = replyservice.selectAll(vno);
	        System.out.println(relist.get(0).getRep_num());
	        return relist;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}
	
}
