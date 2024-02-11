package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.CourseService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("CourseService")
public class CourseServiceImpl extends EgovAbstractServiceImpl implements CourseService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(EgovCourseServiceImpl.class);

	/** CourseDAO */
	@Resource(name="CourseMapper")
	private CourseMapper courseDAO;

//	/** ID Generation */
//	@Resource(name = "egovIdGnrService")
//	private EgovIdGnrService egovIdGnrService;


	//특정 번호의 강좌글을 조회
	@Override
	public CourseVO selectCourse(String vno) throws Exception {
		CourseVO cvo = courseDAO.selectCourse(vno);
//		CourseVO resultVO = courseDAO.selectCourse(cvo);
//		if (cvo == null) {
//			throw processException("info.nodata.msg");
//		}
		return cvo;
	}

	//clist에 보여줄 모든 강좌글 목록을 조회
	@Override
	public List<CourseVO> selectCourseList(PageVO pagevo) throws Exception {
		return courseDAO.selectCourseList(pagevo);
	}

	//강좌글 총 갯수를 조회
	@Override
	public int selectCourseListTotCnt() {
		return courseDAO.selectCourseListTotCnt();
	}

}
