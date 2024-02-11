<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<title>강좌 보기 리스트</title>
<style>
***바꾼 부분***
	.table {
	  border-collapse: collapse;
	  width: 500px;
	  margin: 1rem auto;
	  border: 5px solid;
	  border-image: linear-gradient(to right, #fbd7c4, black);
	  border-image-slice: 1;
	}
	
	/* 테이블 행 */
	th, td {
	  padding: 8px;
	  text-align: left;
	  border-bottom: 1px solid #ddd;
	  text-align: center;
	}
	
	th {
	  color: #ddd;
	}
	
	/* 테이블 올렸을 때 */
	tbody tr:hover {
	  background-color: #d3d3d3;
	  opacity: 0.9;
	  cursor: pointer;
	}

	tr:nth-child(even) {
	  background-color: #fff6f6;
	}
	
	.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:80px;
	  margin-left:400px;
	}
	
</style>
 <script type="text/javaScript" language="javascript" defer="defer">
     
    </script>
</head>
<body>
	<%@ include file="./include/top.jsp"%>
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_196/1705367374042tBp8L_PNG/%B0%AD%C1%C2%BA%B8%B1%E2_%281%29.png?type=w740"
			style="width:100%; height:100%;">
        </span>
  		</p>
		</div>
		<input type="text" id="search" name="m_phone" placeholder="검색할 강좌명 입력" 
		style="width:20%; margin-left:30px;text-align:left;">
		<!-- <button type="button" id="searchBtn" style="width:50px; text-align:center;"> 
		찾기</button>
	<!-- 강좌보기 테이블 -->
	<article>
		<section>
			<div id="article_table">
				<table class="table"
					style="font-size: 17px; width: 100%; height: auto; vertical-align:middle;">
					<thead class="table-dark">
						<tr style="text-align: center">
							<th scope="col" width=5% style="text-align: center">번호</th>
							<th scope="col" width=35% style="text-align: center">강좌명</th>
							<th scope="col" width=7% style="text-align: center">장소</th>
							<th scope="col" width=20% style="text-align: center">수강기간</th>
							<th scope="col" width=15% style="text-align: center">요일/시간</th>
							<th scope="col" width=15% style="text-align: center">신청/모집인원</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clist}" var="cvo">
							<tr>
								<td scope="row" style="text-align: center">${cvo.c_num}</td>
								<td style="text-align: left">&nbsp 
								<a href="courseOne?vno=${cvo.c_num}&page=${page.page}">
								${cvo.c_name}(${cvo.c_student})</a></td>
								<td style="text-align: center">${cvo.c_place}</td>
								<td style="text-align: center">${cvo.c_date}</td>
								<td style="text-align: center">${cvo.c_time}</td>
								<td style="text-align: center">${cvo.c_now}/${cvo.c_full}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</section>
	</article>
	<br><br>
	<div class="col-12 d-flex justify-content-center">
		<c:if test="${page.prev}">
			<a href="courseList?page=${page.startPage-1}">
			<button class="btn btn-primary" style="background-color:white; border:solid #f94327 1px; color:#f94327; margin-right:5px;">
			이전</button></a>
		</c:if>
			<c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
				<c:choose>
					<c:when test="${idx == page.page}">
						<button class="btn btn-primary" style="background-color:black; border:black; margin-right:5px;">
						${idx}</button>
					</c:when>
					<c:otherwise>
						<a href="courseList?page=${idx}">
						<button class="btn btn-primary" style="background-color:#f94327; border:#f94327; margin-right:5px;">
						${idx}</button></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		<c:if test="${page.next}">
			<a href="courseList?page=${page.endPage+1}">
			<button class="btn btn-primary" style="background-color:white; border:solid #f94327 1px; color:#f94327;">
			다음</button></a>
		</c:if>
	</div>
	<br><br>
	<%@ include file="./include/bottom.jsp"%>
</body>
</html>