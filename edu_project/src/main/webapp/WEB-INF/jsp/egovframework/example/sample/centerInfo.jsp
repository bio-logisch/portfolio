<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>기관안내</title>
</head>
<style>
.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:40px;
	  margin-left:440px;
	}
</style>
<body>
	<%@ include file="./include/top.jsp" %>
	
	<!-- 내용 -->
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_14/1705369158056E0JgM_PNG/%B1%E2%B0%FC%BE%C8%B3%BB_%281%29.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
	</div>
	<div id= "middle" style="text-align: center; display:block;">
		<img alt="center1"
		src="https://phinf.pstatic.net/memo/20240116_147/1705400270251Cd5H7_PNG/%B1%E2%B0%FC%BE%C8%B3%BB1.PNG?type=w740"
		style="width:550px; height:600px;">
		<br>
		<img alt="center2"
		src="https://mirae.dankook.ac.kr/html_portlet_repositories/images/ExtImgFile/10158/58475/3030387/82438.png"
		style="width:680px; height:870px;">
		<br>
		<img alt="center3"
		src="https://50plus.or.kr/upload/im/2020/09/8025bafe-ed22-4309-b996-f754fa3d95cd.jpg"
		style="width:900px; height:750px;">	
		<br>
		<img alt="center4"
		src="https://50plus.or.kr/upload/im/2020/09/265e408f-ea80-4a2e-9b33-9f799e0d2eba.jpg"
		style="width:900px; height:750px;">	
		<br>
		<img alt="center5"
		src="https://50plus.or.kr/upload/im/2021/04/5acc6bb5-5d4e-421c-87af-eed05e2d3f0b.png"
		style="width:900px; height:750px;">	
		<br> <br> <br>
	</div>
	
	<%@ include file="./include/bottom.jsp" %>
</body>
</html>

