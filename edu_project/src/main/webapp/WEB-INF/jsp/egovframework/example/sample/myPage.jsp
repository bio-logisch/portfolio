<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>마이페이지</title>
<style>
	/*버튼 공통*/
	#title button{
		display: inline-block;
		width: 120px; height: 30px;
		font-weight: 600;
		text-align: center;
		border-radius: 5px;
		transition: all 0.2s ;
		color:white;
		background: #5DC8CD;
  		box-shadow: 0px 5px 0px 0px #007144;
		} 
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
	  text-align: center;
	}
	
	th {
	  border-top: 1px solid black;
	  border-bottom: 1px solid black;
	  color: black;
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
	.main{
	  margin: 15px;
	  text-align: center;
	}
	.button {
	  /* 기본 css */
	  display: inline-block;
	  margin-left:500px;
	}
	
</style>
</head>
<body>
	<%@ include file="./include/top.jsp" %>
	<br>
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_30/1705367389866uXpSA_PNG/%B8%B6%C0%CC%C6%E4%C0%CC%C1%F6_%281%29.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
	<c:if test="${userid != null}">
	<!-- 내용 -->
	<div id="title" style="margin-top:5%; margin-bottom:2%; margin-left:10%;">
		<div id= "top">
 		 <p class="button" style="margin-left:-5px;">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_117/1705368181933GpCJW_PNG/%C8%B8%BF%F8%C1%A4%BA%B8_%B0%FC%B8%AE.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>			 
			<p>회원정보 관리는 해당하는 버튼을 눌러주세요.</p> 
			<button type="button" onclick="location.href='memberModify?m_id=${userid}';">
			회원정보 수정 </button> &nbsp &nbsp  
			<button type="button" onclick="deleteMember('${userid}')">
			회원 탈퇴 </button>  <br> <br>
		</div>
		<div> <br> <br> 
			<div id= "top">
 		 <p class="button" style="margin-left:110px;">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_139/1705368177607fFzSr_PNG/%B3%AA%C0%C7_%B0%AD%C1%C2.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>		
			<span style="margin-left:110px; font-size:20px; color: #f94327; font-weight:bold;">
			${username}</span> 
			<span>님께서 신청하신 강좌목록(총 ${courseCnt}건)입니다.</span> &nbsp 
			<button type="button" onclick="location.href='mapView';"
			class="btn btn-primary" style="color:blue; font-weight:bold;">
			교육장소 위치 < 클릭  </button> 
			<p style="margin-left:110px;">강좌명을 클릭하면 해당 강좌의 상세보기 페이지로 이동합니다.</p> 
		</div>
	<div style="margin-bottom:5%;">
		<table style="font-size: 17px; width: 100%; height: auto; vertical-align:middle;
						color:black;">
			<thead>
				<tr>
					<th style="width: 5%;">번호</th>
					<th style="width: 34%;">강좌명</th>
					<th style="width: 7%;">강사명</th>
					<th style="width: 8%;">장소</th>
					<th style="width: 23%;">수강기간</th>
					<th style="width: 15%;">요일/시간</th>
					<th style="width: 8%;">신청취소</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mclist}" var="mcvo">
					<tr>
						<td style="text-align:center;">${mcvo.c_num}</td>
						<td style="text-align:left;">&nbsp 
						<a href="courseOne?vno=${mcvo.c_num}">${mcvo.c_name}&nbsp(${mcvo.c_student})</a></td>
						<td style="text-align:center;">${mcvo.c_teacher}</td>
						<td style="text-align:center;">${mcvo.c_place}</td>
						<td style="text-align:center;">${mcvo.c_date}</td>
						<td style="text-align:center;">${mcvo.c_time}</td>
						<td style="text-align:center;">
						<a href="#" onclick='delchk(${mcvo.c_num})'>[취소]</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</c:if>
	<script>	
		<!-- 강좌신청 취소 여부 다시 물어보기 -->
		function delchk(dno){
			if(confirm("정말로 취소하시겠습니까?")==true){
				location.href="coursedel?dno="+dno
			}else{
				alert("신청취소를 종료합니다.")
			}
		}
		//탈퇴 여부 다시 물어보기
		function deleteMember(id) {
			console.log("Function called with ID:", id);
			if(confirm("정말로 탈퇴하시겠습니까?")){
				alert("탈퇴가 완료되었습니다.");
				location.href="memberDelete?m_id="+id;
			}else{
				alert("탈퇴를 취소합니다.")
			}
		}
	</script>
	<%@ include file="./include/bottom.jsp" %>
</body>
</html>

