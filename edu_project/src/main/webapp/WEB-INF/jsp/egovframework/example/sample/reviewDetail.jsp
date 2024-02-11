<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강후기 상세보기</title>
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
<style>
table {
	margin-top: 20px;
	margin-left: 130px;
	width: 1000px;
}

th {
	border: 1px solid #f94327;
	background-color: white;
	color: #f94327;
	width: 150px;
}

td {
	border: 1px solid #aaa;
	background-clip: padding-box;
	scroll-snap-align: start;
}

thead {
	z-index: 1000;
	position: relative;
}

th, td {
	padding: 0.6rem;
	min-width: 6rem;
	text-align: center;
}

thead th.pin {
	left: 0;
	z-index: 1001;
	border-left: 0;
}

tbody {
	z-index: 10;
	position: relative;
}
.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:80px;
	  margin-left:400px;
	}
	
</style>
<body>
	<%@ include file="./include/top.jsp"%>
	
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_260/1705367396207Hm6V6_PNG/%BB%F3%BC%BC%BA%B8%B1%E2.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
	<main>
		<div role="region" aria-label="data table" tabindex="0"
			class="primary">
			<!-- Note: use the aria-label attribute above to describe this keyboard-focusable region appropriately, per your implementation. Alternatively, it could instead be an aria-labelledby attribute that points to a table caption's ID attribute. Thx for thoughts, @aardrian  -->
			<c:if test="${userid.equals(review.m_id)}">
				<div style="position: relative;">
					<a href="reviewModify?rno=${review.rev_num}">
						<button type="submit" class="btn btn-primary"
							style="background-color: #f94327; border: #f94327; position: absolute; left: 950px; top: 0px; width: 80px; height: 40px; font-size: 20px;">수정</button>
					</a>
				</div>
				<div>
					<button type="submit" class="btn btn-primary" onclick="reviewChk()"
						style="background-color: #f94327; border: #f94327; margin-left: 1050px; width: 80px; height: 40px; font-size: 20px;">삭제</button>
				</div>
			</c:if>
			<table>
				<tbody>
					<tr>
						<th>작성자 / 작성일</th>
						<td colspan="5" id="idTD"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="5"><b>${review.rev_title}</b></td>
					</tr>
					<tr>
						<th>강좌명 / 강사</th>
						<td colspan="5">${review.c_name} / ${review.c_teacher} 강사</td>
					</tr>
					<tr>
						<th>강좌 정보</th>
						<td colspan="5">${review.c_place} / ${review.c_date} /
							${review.c_time}</td>
					</tr>
					<tr>
						<td colspan="6" style="background-color: #f94327; color: white;"><b>내용</b></td>
					</tr>
					<tr>
						<td colspan="6" style="text-align: left;">
							${review.rev_content}
						</td>
					</tr>
					<tr>
						<td colspan="6" style="background-color: #f94327; color: white;"><b>첨부파일</b></td>
					</tr>
					<tr>
						<td colspan="5" style="text-align: left;">
						<c:forEach items="${olist}" var="oname">${oname}<br>
							</c:forEach>
							</td>
						<td style="width: 10%;">
						<c:forEach items="${clist}" var="fname">
								<a href="download?rno=${review.rev_num}&filename=${fname}">
									<button
										style="border: solid black 1px; background-color: lightgray;">다운로드</button>
										<br>
								</a>
								<!-- <img src="<c:url value='download?filename=${fname}'/>" alt="myFOTO"/>-->
							</c:forEach>
							</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div>
			<a href="reviewList">
				<button class="btn btn-primary"
					style="background-color: #f94327; border: #f94327; margin-left: 150px; margin-top: 20px; width: 80px; height: 40px; font-size: 20px;">목록</button>
			</a>
		</div>
	</main>
	<%@ include file="./include/bottom.jsp"%>
</body>
<script>
	let masking = {
		id : function(str){
	    let originStr = str; //원래 아이디(아이디는 이메일주소라서 나중에 수정필요@이전문자에 대한 마스킹)
	    let maskingStr; //마스킹 처리한 아이디
	    let strLength; //아이디 길이
	    
	    strLength = originStr.length; //문자길이 저장
			maskingStr = originStr.charAt(0) + '*'.repeat(strLength - 1);//2번째부터 마스킹표시
	
			return maskingStr;
		}
	};
	
	// 날짜와 시간 새로운 형식에 맞게 리턴받는 함수 - 댓글 조회 시 사용
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
    let reviewId = '${review.m_id}';
    let reviewDate = '${review.rev_date}';
    
    if (reviewId && reviewDate) {
        let tdElement = document.getElementById('idTD');
        let maskedID = masking.id(reviewId);
        let maskedDATE = formatDateTime(reviewDate);

        tdElement.innerHTML = maskedID + ' / ' + maskedDATE;
    } 
    function reviewChk() {
        let chk = confirm("정말로 삭제하시겠습니까?");
        if (chk) {
            alert("삭제가 완료되었습니다.")
            window.location.href = "reviewDelete?rno=${review.rev_num}";
        }
    }
</script>
</html>