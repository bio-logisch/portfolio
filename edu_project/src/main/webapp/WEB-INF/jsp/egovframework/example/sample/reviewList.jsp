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
<title>수강후기 보기</title>
<style>
	.table {
  border-collapse: collapse;
  width: 500px;
  margin: 1rem auto;
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
</head>
<body>
	<%@ include file="./include/top.jsp"%>
	
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_198/1705367401312pmi1K_PNG/%BC%F6%B0%AD%C8%C4%B1%E2_%281%29.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
		<input type="text" id="search" name="m_phone" placeholder="검색할 강좌명 입력" 
		style="width:20%; margin-left:30px;text-align:left;">
		<!-- <button type="button" id="searchBtn" style="width:50px; text-align:center;"> 
		찾기</button> -->
	<c:if test="${userid != null}">
		<div class="col-12">
			<a href="reviewForm">
				<button type="submit" class="btn btn-primary" onclick="reviewChk()"
					style="background-color: #f94327; border: #f94327; margin-left: 1100px; width: 100px; height: 50px; font-size: 24px;">작성</button>
			</a>
		</div>
	</c:if>
	<br>
	<br>
	<!-- 수강후기 테이블 -->
	<article>
		<section>
			<div>
				<table class="table"
					style="font-size: 17px; width: 100%; height: auto; vertical-align:middle;">
					<thead class="table-dark">
						<tr style="text-align: center">
							<th scope="col" width=5% style="text-align: center">번호</th>
							<th scope="col" width=15% style="text-align: center">등록일시</th>
							<th scope="col" width=7% style="text-align: center">작성자</th>
							<th scope="col" width=30% style="text-align: center">제목</th>
							<th scope="col" width=20% style="text-align: center">수강 강좌명</th>
							<th scope="col" width=7% style="text-align: center">강사</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${rlist}" var="rvo" varStatus="status">
						<c:set var="desc" value="${(total-(page.page-1)*page.perPageNum)-status.index}"/>
							<tr>
								<td scope="row" style="text-align: center">${desc}</td>
								<td style="text-align: center" class="mask-date">${rvo.rev_date}</td>
								<td style="text-align: center" class="mask-me">${rvo.m_id}</td>
								<td style="text-align: left"><a
									href="rdetail?rno=${rvo.rev_num}">${rvo.rev_title}</a></td>
								<td style="text-align: center">${rvo.c_name}</td>
								<td style="text-align: center">${rvo.c_teacher}</td>
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
			<a href="reviewList?page=${page.startPage-1}">
			<button class="btn btn-primary" style="background-color:white; border:solid #f94327 1px; color:#f94327; margin-right:5px;">
			이전</button>
			</a>
		</c:if>
			<c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
				<c:choose>
					<c:when test="${idx == page.page}">
						<button class="btn btn-primary" style="background-color:black; border:black; margin-right:5px;">
						${idx}</button>
					</c:when>
					<c:otherwise>
						<a href="reviewList?page=${idx}">
						<button class="btn btn-primary" style="background-color:#f94327; border:#f94327; margin-right:5px;">
						${idx}</button></a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		<c:if test="${page.next}">
			<a href="reviewList?page=${page.endPage+1}">
			<button class="btn btn-primary" style="background-color:white; border:solid #f94327 1px; color:#f94327;">
			다음</button></a>
		</c:if>
	</div>
	<br><br>
	<%@ include file="./include/bottom.jsp"%>
</body>
<script>
	document.addEventListener('DOMContentLoaded', function () {
	    let masking = {
	        id: function (str) {
	            let originStr = str;
	            let maskingStr;
	            let strLength;
	
	            strLength = originStr.length;
	            if(strLength == undefined || strLength == null || strLength == ""){
	            	maskingStr = "탈퇴회원"
	            }else {
		            maskingStr = originStr.charAt(0) + '*'.repeat(strLength - 1);
	            }
	
	            return maskingStr;
	        }
	    };
	
	    let tdElements = document.querySelectorAll('.mask-me');
	
	    tdElements.forEach((tdElement) => {
	        let originalContent = tdElement.textContent;
	        let maskedID = masking.id(originalContent);
	        tdElement.textContent = maskedID;
	        
	    });
	    
	    let dateElements = document.querySelectorAll('.mask-date');
	
	    dateElements.forEach((dateElement) => {
	        let originalContent = dateElement.innerText;
	        let maskedDate = formatDateTime(originalContent);
	        dateElement.innerText = maskedDate;
	    });
	
	    function formatDateTime(value) {
	        var dateParts = value.substring(0, 10).split(/[\-\.]/g);
	        var timeParts = value.split(".");
	        var year, month, day, hour, minute;
	
	        year = dateParts[0];
	        month = dateParts[1].padStart(2, '0');
	        day = dateParts[2].padStart(2, '0');
	        hour = timeParts[1].padStart(2, '0');
	        minute = timeParts[2].padStart(2, '0');
	
	        return year + "." + month + "." + day + ".  " + hour + ":" + minute;
	    }
	});
</script>
</html>