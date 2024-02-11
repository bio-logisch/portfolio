<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kor">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
section {
	display: inline-block;
	width: 90%;
	margin: 0px auto;
	margin-left: 70px;
}
.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:80px;
	  margin-left:340px;
	}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<!-- 회원의 수강 강좌 유무 체크 -->
<c:if test="${reviewFlag == '0'}">
	<script>
		alert("수강하신 강좌가 없습니다.");
		window.location.href = "reviewList";
	</script>
</c:if>
<c:if test="${userid == null}">
	<script>
		alert("먼저 로그인해 주세요.");
		window.location.href = "home";
	</script>
</c:if>

	<%@ include file="./include/top.jsp"%>
	
	<article>
		<section>
			<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_72/1705367414735oLEPW_PNG/%C8%C4%B1%E2_%C0%DB%BC%BA.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
			<!-- 입력 폼 -->
			<!-- 파일은 바이너리 타입으로 받기 때문에 encType 꼭 적어줘야 함 -->
			<form class="row g-3" action="reviewDone" method="post" encType="multipart/form-data">
				<div class="col-md-4">
					<label for="inputState" class="form-label">수강 강좌</label> 
					<select id="inputState" class="form-select" name="c_num">
						<c:forEach items="${clist }" var="cvo">
							<option value="${cvo.c_num}">
							    ${cvo.c_name}/ ${cvo.c_place} / ${cvo.c_date} /
								${cvo.c_time} / ${cvo.c_teacher}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-12">
				<input type="hidden" value="${userid}" name="m_id">
					<label for="inputAddress" class="form-label">제목</label> <input
						type="text" name="rev_title" class="form-control"
						id="title" placeholder="제목을 입력하세요">
				</div>


				<div class="form-floating">
					<textarea class="form-control" placeholder="Leave a comment here"
						id="content" style="height: 200px" name="rev_content"></textarea>
					<label for="floatingTextarea2">내용을 입력하세요</label>
				</div>

				<!-- 파일 첨부 -->
				<div class="mb-3">
					<input class="form-control" type="file" id="formFile" name="file">
					<input class="form-control" type="file" id="formFile" name="file">
				</div>

				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> 회원만 보기 </label>
					</div>
				</div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary"
						onclick="reviewChk()" style="background-color: #f94327; border: #f94327;">등록</button>
				</div>
			</form>
		</section>
	</article>
	<%@ include file="./include/bottom.jsp"%>
</body>
	<script>
		function reviewChk(){
			alert("수강 후기가 등록되었습니다.")
		}
	</script>
</html>