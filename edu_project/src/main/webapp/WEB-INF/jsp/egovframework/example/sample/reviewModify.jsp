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
</head>

<body>
	<%@ include file="./include/top.jsp"%>
	
	<article>
		<section>
			<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_131/1705367410857w0Mja_PNG/%C8%C4%B1%E2_%BC%F6%C1%A4.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
			<!-- 입력 폼 -->
			<!-- 파일은 바이너리 타입으로 받기 때문에 encType 꼭 적어줘야 함 -->
			<form class="row g-3" action="reviewModifyDone" method="post">
			<input type="hidden" value="${review.rev_num}" name="rev_num">
				<div class="col-md-4">
					<label for="inputState" class="form-label">수강 강좌</label>
					<input
						type="text" class="form-control" style="width:1140px;"
						id="inputAddress" value="${review.c_name} / ${review.c_place} / ${review.c_date} / ${review.c_time} / ${review.c_teacher}" readonly>
				</div>
				<div class="col-12">
					<label for="inputAddress" class="form-label">제목</label> <input
						type="text" name="rev_title" class="form-control"
						id="inputAddress" value="${review.rev_title}">
				</div>


				<div class="form-floating">
				<label for="inputAddress" class="form-label" style="position:absolute; top: -22%; margin-top:10px;">내용</label>
					<textarea class="form-control"
						id="floatingTextarea2" style="height: 200px; margin-top:10px;" name="rev_content">${review.rev_content}</textarea>
				</div>

				<!-- 파일 첨부 -->
				<div class="mb-3">
					<input class="form-control" type="file" id="formFile" >
					<input class="form-control" type="file" id="formFile" >
				</div>

				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> 회원만 보기 </label>
					</div>
				</div>
				<div class="col-12">
					<button type="submit" class="btn btn-primary"
						onclick="convert()" style="background-color: #f94327; border: #f94327;">수정</button>
				</div>
			</form>
		</section>
	</article>
	<%@ include file="./include/bottom.jsp"%>
</body>
	<script>
			let text = document.getElementById("floatingTextarea2").value;
			text = text.replace(/<br>/g, '\n');
			document.getElementById("floatingTextarea2").value = text;
		function convert(){
			alert("수정되었습니다.\n"+convertedText);
		}
	</script>
</html>