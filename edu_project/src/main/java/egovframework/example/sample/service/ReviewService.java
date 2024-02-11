package egovframework.example.sample.service;

import java.util.List;

public interface ReviewService {
	List<CourseVO> myCourse(String id);
	void insertOne(ReviewVO rvo);
	List<ReviewVO> selectPages(PageVO pvo);
	List<String> fConvertedList(String rno);
	List<String> fOriginalList(String rno);
	ReviewVO selectOne(String rno);
	void deleteOne(String rno);
	void updateOne(ReviewVO rvo);
	Integer totalCnt();
	List<ReviewVO> selectThree();
}
