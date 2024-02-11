package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.ReviewService;
import egovframework.example.sample.service.ReviewVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("ReviewService")
public class ReviewServiceImpl extends EgovAbstractServiceImpl implements ReviewService{
	@Resource(name="ReviewMapper")
	private ReviewMapper reviewDAO;

	@Override
	public List<CourseVO> myCourse(String id) {
		return reviewDAO.selectList(id);
	}

	@Override
	public void insertOne(ReviewVO rvo) {
		reviewDAO.insertOne(rvo);
		String[] filenames=rvo.getFiles();
		String[] original=rvo.getOriginalNames();
		for (int i = 0; i < filenames.length; i++) {
			if(filenames[i] != null && !original[i].equals("")) {//null이 아닌 파일명만 쿼리 실행, 쿼리에 null값 들어가면 오류남
				reviewDAO.saveFile(original[i],filenames[i]);
			}
		}
	}

	@Override
	public ReviewVO selectOne(String rno) {
		return reviewDAO.selectOne(rno);
	}

	@Override
	public void deleteOne(String rno) {
		reviewDAO.deleteOne(rno);
	}

	@Override
	public void updateOne(ReviewVO rvo) {
		reviewDAO.updateOne(rvo);
	}

	@Override
	public List<String> fConvertedList(String rno) {
		return reviewDAO.fConvertedList(rno);
	}

	@Override
	public List<String> fOriginalList(String rno) {
		return reviewDAO.fOriginalList(rno);
	}

	@Override
	public List<ReviewVO> selectPages(PageVO pvo) {
		return reviewDAO.selectPages(pvo);
	}

	@Override
	public Integer totalCnt() {
		return reviewDAO.totalCnt();
	}

	@Override
	public List<ReviewVO> selectThree() {
		return reviewDAO.selectThree();
	}
}
