package egovframework.example.sample.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import egovframework.example.sample.service.CourseVO;
import egovframework.example.sample.service.PageVO;
import egovframework.example.sample.service.ReviewVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("ReviewMapper")
public interface ReviewMapper {
	List<CourseVO> selectList(String id);
	void insertOne(ReviewVO rvo);
	void saveFile(@Param("oname") String oname, @Param("fname") String fname);
	List<ReviewVO> selectPages(PageVO pvo);
	List<String> fOriginalList(String rno);
	List<String> fConvertedList(String rno);
	ReviewVO selectOne(String rno);
	void deleteOne(String rno);
	void updateOne(ReviewVO rvo);
	Integer totalCnt();
	List<ReviewVO> selectThree();
}
