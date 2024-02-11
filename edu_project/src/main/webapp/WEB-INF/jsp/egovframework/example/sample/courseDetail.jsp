<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>강좌 상세보기</title>
	<script
	  	src="https://code.jquery.com/jquery-3.4.1.js"
	  	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	  	crossorigin="anonymous"></script>
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
	#buttons{
		margin-left: 74%;	
	}
	/*버튼 공통*/
	button{
	  display: inline-block;
	  font-weight: 600;
	  text-align: center;
	  line-height: 50px;
	  color: #FFF;
	  border-radius: 5px;
	  transition: all 0.2s ;
	}
	/*위치보기 버튼 - 하늘색*/
	#d1 button{ 
		width: 120px; height: 30px;
		background: #5DC8CD;
  		box-shadow: 0px 5px 0px 0px #007144;
	} 
	#d1 button:hover{
  		margin-top: 2px; margin-bottom: 1px;
  		box-shadow: 0px 0px 0px 0px #1E8185;
	}
	/*신청, 목록 버튼 - 개나리색*/
	#buttons button{
		width: 80px; height: 30px;
		font-size: 20px;
		background: #FFAA40;  
		box-shadow: 0px 5px 0px 0px #A66615;
	}
	#buttons button:hover{
  		margin-top: 2px; margin-bottom: 1px;
        box-shadow: 0px 0px 0px 0px #A66615;      
    }

.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:30px;
	  margin-left:440px;
	}
</style>	
</head>
<body>
	<c:if test="${flag2 == '1'}">
		<script>
			alert("[신청불가] 이미 신청한 강좌입니다.")
			//window.location.href="courseList.do";
		</script>	
	</c:if>	
	<c:if test="${flag2 == '2'}">
		<script>
			alert("강좌가 신청되었습니다.")
			//window.location.href="courseList.do";
		</script>	
	</c:if>
	<c:if test="${flag2 == '3'}">
		<script>
			alert("[신청불가] 정원이 초과되었습니다.")
			//window.location.href="courseList.do";
		</script>	
	</c:if>
	
	<%@ include file="./include/top2.jsp"%>

	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_260/1705367396207Hm6V6_PNG/%BB%F3%BC%BC%BA%B8%B1%E2.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
	<section id="detailzone">
		<div id="content">
			<form class="row g-3" action="requestDone" method="post">
			<div id="buttons">
				<c:if test="${userid != null}">
				<button type="submit" "class="btn btn-primary">
					신청 </button> &nbsp 	
				</c:if>		
				<button type="button" 
					onclick="location.href='courseList?page=${page.page}';"
					class="btn btn-primary">
					 목록 </button> 	 
			</div>
			<table id="d1">
				<tbody>
					<tr>
						<th>강좌명</th>
						<td colspan="5" id="title">&nbsp &nbsp ${nowvo.c_name} (${nowvo.c_student})</td>
					</tr>
					<tr>
						<th>수강기간</th>
						<td colspan="5"><b>${nowvo.c_date}</b></td>
					</tr>
					<tr>
						<th>요일/시간</th>
						<td colspan="5">${nowvo.c_time}</td>
					</tr>
					<tr>
						<th>신청/모집인원</th>
						<td colspan="5">${nowvo.c_now} / ${nowvo.c_full}</td>
					</tr>
					<tr>
						<th>장소</th>
						<td colspan="5">${nowvo.c_place} &nbsp
						<button type="button" onclick="location.href='mapView';"
						class="btn btn-primary"> 위치보기 </button></td>
					</tr>
					<tr>
						<th>내용/준비물</th>
						<td colspan="5">[강의계획서 참조]</td>
					</tr>
					<tr>
						<td colspan="6" style="background-color: #f94327; color: white;"><b>강좌 안내</b></td>
					</tr>
					<tr>
						<td colspan="6" style="text-align: left;">
							<p style="padding-left:5%;">
									 ❍ 수강신청을 하시려면 먼저 회원가입 후 로그인을 해주세요. 
								<br> * 수강당일 온라인 강좌 회의 ID 및 비밀번호 문자 발송 예정 
								<br> ❍ 수강신청 취소는 반드시 수강신청 기간 내에 취소 요망 
								<br> ❍ 원활한 강의 진행을 위해 강의 시작 시간 준수 10분전 입장! 
								<br> ❍ 강의시작 전 ZOOM프로그램 이용방법 사전 숙지 
								<br> ❍ 출결확인을 위해 반드시 수강생 성명 및 소속학교명으로 참여, 수강제한사항 확인 
								<br> ❍ 무단으로 강의내용 및 수강생 송출 영상 캡쳐 및 녹화 금지 </p>
						</td>
					</tr>
				</tbody>
			</table>
			
			<br>  
			<!-- DB에 보낼 데이터 INPUT - hidden으로 세팅 -->
			<input type="hidden" value="${nowvo.c_num}" id="vno" name="c_num">
			<input type="hidden" value="${userid}" name="m_id">
							
		</form>	 
		</div>
	</section>
	<section id="replyzone">
		<div class="comment-box"
			style="margin-left: 25%; margin-right: 25%; margin-bottom: 1%; padding: 10px;">
			<div id="comment-box-title">
				<span style="color:#88A782; font-size:17px;"> &nbsp 댓글 쓰기 </span> <br>
			</div>
			
			<div id="comment-box-form" style="padding: 5px; border: solid 1px #ADC6A9;
				border-radius:10px;">
				&nbsp
				<img src="https://phinf.pstatic.net/memo/20240115_20/1705286266003npe71_PNG/sprout.png?type=w740" 
				alt="Sprout" style="width: 30px; height:30px;" />
				<span style="font-weight:bold; height:30px; color:green;">${username}</span>
				<textarea id="rep_content" name="rep_content" placeholder="&nbsp내용을 입력하세요"
				style="width: 597px; height: 80px; border:none; "> 
				</textarea>	
				<input type="text" placeholder="0/100" id="textLengthCheck"
				style="margin-left: 85%; width: 85px; text-align: right;
				border:none;" readonly>

				<input type="hidden" value="${nowvo.c_num}" id="c_num"> 
				<input type="hidden" value="${userid}" id="m_id" />
				 <br>
			</div>
			<div>
				<button type="button" class="btn btn-primary" id="insertReply"
				style="color: black; margin-left: 85%; margin-top:2%; font-size:17px;
				border: none; background: #ADC6A9; width:15%; color:white;">등록</button>		
			</div>
		</div>
	</section>
	<section id="replyList">
		<div id="comment-box-title">
			<span style="color:#88A782; font-size:17px; margin-left: 25%; 
			margin-right: 25%; padding: 2px;"> 
			&nbsp 댓글 보기 </span>
		</div>

	</section> 
	<%@ include file="./include/bottom2.jsp"%>
</body>
<script> 
	$(document).ready(function() { 	//처음 실행 시 1번 호출
	    // 댓글 등록
	    $('#insertReply').click(function() {    	
	    	//비회원일 경우 댓글등록 불가하도록 조건 걸기 
	    	var M_id = $("#m_id").val(); //작성자 아이디
	    	var C_num = $("#c_num").val(); //댓글 남기는 페이지의 강좌글번호
		    var M_id = $("#m_id").val(); //작성자 아이디
		    var Rep_content = $("#rep_content").val(); //댓글내용, 댓글고유번호와 작성일은 default
	    	if(M_id == null || M_id == undefined || M_id == ""){ //비회원이면 등록불가
	    		alert("[등록 불가] 로그인을 먼저 해주세요.")
	    	}else {  //회원이면 등록진행
	    		$.ajax({
		            method: 'POST',
		            data: JSON.stringify({
		                c_num: C_num,
		                m_id: M_id,
		                rep_content: Rep_content
		            }),
		            url: 'replyDone',
		            contentType: "application/json; charset=UTF-8",
		            //dataType이 서버로부터 받는 데이터타입이라서 데이터를 리턴받는게 아니면 생략(post방식일 땐 생략하자)
		            success: function(data) {
		                alert("댓글이 등록되었습니다.")
		                $("#rep_content").val(""); //입력한 텍스트 비우기
			            $("#replyList").empty(); //기존 댓글리스트 삭제
			            selectReply(); //새로운 댓글리스트 불러오기
		            },
		            error: function(error) {
		                alert("[오류] 댓글등록 실패")
		            }
		        });
	    	}
 
	    });

	    // 모든 댓글 조회
	    function selectReply() {
	        var Vno = $("#vno").val(); // 보낼 값
	        $.ajax({
	            method: 'GET',
	            url: 'replySelect/' + Vno,
	            contentType: 'application/json; charset=UTF-8', // 데이터 타입 설정
	            dataType: 'json', // 응답 데이터 타입 설정
	            success: function(data) { // 성공 시 실행할 코드
	                //alert("댓글 전체조회 성공");
	                console.log(data);
	                // 여기서 response를 사용하여 필요한 작업을 수행
	                displayResults(data); // 댓글 목록을 화면에 표시하는 함수 호출
	            },
	            error: function(error) { // 실패 시 실행할 코드
	                alert("[오류] 댓글 전체조회 실패");
	            }
	        });
	    }
	    
	    // 댓글 조회 함수 호출
	    selectReply();

	    // 조회해서 받아온 데이터를 jsp에 보내기
	    function displayResults(replyList) {
	        // 댓글 목록을 반복하면서 동적으로 HTML 생성
	        for (var i = 0; i < replyList.length; i++) {
	            var revo = replyList[i];

	            var commentBox = $("<div>").attr({
	                id: "r" + i, //댓글마다 고유 id생성
	                style: "border: solid 1px #ADC6A9; border-radius:10px; width:630px; height:auto; margin-left:25%; margin-top:10px; padding: 1% 3% 1% 3%;"
	            });
				//var contextPath = '${pageContext.servletContext.contextPath}';
				//var imgURL = contextPath+'/src/main/webapp/images/egovframework/example/'+'sprout.png';
	            var sproutImage = $("<img>").attr({
	                src: "https://phinf.pstatic.net/memo/20240115_20/1705286266003npe71_PNG/sprout.png?type=w740",
	                alt: "Sprout",
	                style: "width: 30px; height:30px;"
	            });
	            var idSpan = $("<span>").attr({ style: "font-weight:bold;" }).addClass("idSpan").text(" " + (revo.m_id).substring(0,2) + "*** ");
	            
	            var contentSpan1 = $("<span>").attr({ 
	            	style: "color:green; display:block;" 
	            }).addClass("contentSpan").text(revo.rep_content);
	            
	            var contentSpan2 = $("<span>").attr({ 
	            	style: "color:green; display:block;" 
	            }).addClass("contentSpan").text("내용없음");
	            
	            var line = $("<p>").attr({style:"color: white;"}).text(" ");
	           	
	         	// 정규표현식을 사용하여 날짜에 해당하는 값만 추출하고, 그 값으로 span생성(dateSpan1)
	         	var dateSpan1 = $("<span>").addClass("dateSpan").text(formatDateTime(revo.rep_date));           
	            var rep_numInput = $("<input>").attr({ type: "hidden" }).val(revo.rep_num).addClass("rep_numInput");
	            var c_numInput = $("<input>").attr({ type: "hidden" }).val(revo.c_num).addClass("c_numInput");
	            var rep_numSpan = $("<span>").attr({ style: "color:white;" }).addClass("rep_numSpan").text(revo.rep_num); 
	            
	            var updateButton = $("<button>").addClass("updateButton").attr({
	                type: "button",
	                style: "margin-left:60%; border-radius:5px; background:#5DC8CD;"
	            }).text("수정");
	                        

	            var deleteButton = $("<button>").addClass("deleteButton").attr({
	                type: "button",
	                style: "margin-left:1%; border-radius:5px; background:#FFAA40;"
	            }).text("삭제");

	            // commentBox에 생성한 요소들 추가
	            commentBox.append(sproutImage, idSpan, rep_numSpan, rep_numInput);

	            //수정, 삭제버튼은 자신이 쓴 댓글일 경우만 추가
	            if ("${userid}" === revo.m_id) {
    					commentBox.append(updateButton, deleteButton);
				}
	            if(revo.rep_content == "" || revo.rep_content == undefined){
	            	commentBox.append(contentSpan2, line);
	            }else{
	            	commentBox.append(contentSpan1, line);
	            }
	            
	            commentBox.append(dateSpan1);
	            //날짜(월)부분 10이상일때 substring문제 해결필요
	            //시간부분 10보다 작은 경우 숫자+.형태로 나오는 것 수정필요
	            $("#replyList").append(commentBox);
	        }
	    }
	    //댓글내용 수정할 수 있는 textarea 생성 함수
	    $(document).on('click', '.updateButton', function () {
		    var commentBox = $(this).closest('div[id^="r"]');
		    // 해당 commentBox의 위치를 유지하기 위해, commentBox를 제거하지 않고 내부의 내용만 갱신
		    updateCommentBox(commentBox);
		});
		
		function updateCommentBox(commentBox) {
		    // textarea가 이미 존재하는지 확인
		    if (!commentBox.find('.contentUpdate').length) {
		        // 댓글 내용을 수정할 수 있는 textarea 생성
		        var updateText = $("<textarea>").attr({
		            placeholder: "내용 입력 후 저장버튼을 눌러주세요.(최대 100자)",
		            style: "width:500px; height:80px; border: solid 1px #88A782; border-radius:5px; display:block;"
		        }).addClass("contentUpdate");
		
		        // 수정을 저장하는 "저장" 버튼 생성
		        var saveButton = $("<button>").addClass("saveButton").attr({
		            type: "button",
		            style: "margin-left:5px; margin-top:5px; border-radius:5px; background:#E73E15;"
		        }).text("저장");
		
		        // textarea와 "저장"버튼, 날짜 span을 commentBox에 추가
		        commentBox.append(updateText, saveButton);
		
		        // 업데이트된 commentBox를 replyList에 추가
		        $("#replyList").append(commentBox);
		
		        // 스크롤 위치 조정
		        // commentBox의 위치로 스크롤 조정
		        $('html, body').scrollTop(commentBox.offset().top);
		    }
		}
	    
		//댓글 내용 수정
		$(document).on('click', '.saveButton', function () {
		    var commentBox = $(this).closest('div[id^="r"]');
		    var C_num = commentBox.find(".c_numInput").val();
		    var M_id = commentBox.find(".idSpan").text();
		    var Rep_content = commentBox.find(".contentUpdate").val(); //수정된 내용 텍스트 
		    var Rep_num = commentBox.find(".rep_numInput").val();
		    var Rep_date = commentBox.find(".dateSpan").text();

		    if (Rep_content.length >= 100) {
		        alert("[글자수 초과]100자까지만 작성가능합니다.")
		    }

		    $.ajax({
		        method: 'PUT',
		        data: JSON.stringify({
		            c_num: C_num,
		            m_id: M_id,
		            rep_content: Rep_content,
		            rep_num: Rep_num,
		            rep_date: Rep_date
		        }),
		        url: 'replyUpdate',
		        contentType: "application/json; charset=UTF-8",
		        success: function (data) {
		            alert("댓글이 수정되었습니다.");
		            //저장 후 textarea와 "저장" 버튼 제거
		            commentBox.find('.contentUpdate').remove();
		            commentBox.find('.saveButton').remove();

		            // 기존 댓글리스트 모두 지우고 댓글 조회 함수 호출
		            $("#rep_content").val(""); //등록란에 입력한 텍스트 비우기
		            $("#replyList").empty();
		            selectReply();
		        },
		        error: function (error) {
		            alert("[오류] 댓글수정 실패");
		        }
		    });
		});

	 	// 댓글 삭제
		$(document).on('click', '.deleteButton', function () {
		    var commentBox = $(this).closest('div[id^="r"]');
		    var Rep_num = commentBox.find('.rep_numInput').val();
		
		    $.ajax({
		        method: 'DELETE',
		        url: 'replyDelete/' + Rep_num,
		        contentType: "application/json; charset=UTF-8",
		        success: function (data) {
		            alert("댓글이 삭제되었습니다.");
		            $("#rep_content").val(""); //등록란에 입력한 텍스트 비우기
		            $("#replyList").empty(); //기존 댓글리스트 삭제
		            selectReply(); //새로 갱신된 리스트 추가
		        },
		        error: function (error) {
		            alert("[오류] 댓글삭제 실패");
		        }
		    });
		});
     
     	// 날짜와 시간 새로운 형식에 맞게 리턴받는 함수 - 댓글 조회 시 사용
        function formatDateTime(value) {
     		//원래 DB에서 받는 값 예시 var a = "2024-1-12.8.26. 15. 0";
            // 년, 월, 일, 시, 분을 추출
            var dateParts = value.substring(0, 10).split(/[\-\.]/g);       
            var timeParts = value.split(".");
            var year, month, day, hour, minute;

            // 인덱스가 0인 값 (년) 처리
            year = dateParts[0];

            // 인덱스가 1인 값 (월) 처리
            month = dateParts[1].padStart(2, '0');

            // 인덱스가 2인 값 (일) 처리
            day = dateParts[2].padStart(2, '0');

            // 인덱스가 0인 값 (시) 처리
            hour = timeParts[1].padStart(2, '0');

            // 인덱스가 1인 값 (분) 처리
            minute = timeParts[2].padStart(2, '0');

            return year + "." + month + "." + day + ".  " + hour + ":" + minute;
        }
	 	

	    // 실시간 글자수 길이 반영 함수
	    $("#rep_content").keyup(function(e) {
	        var content = $(this).val();
	        $("#textLengthCheck").val(content.length + " / 100"); // 실시간 글자수 카운팅

	        if (content.length > 99) { // 100자까지인데 에러로 인해 99로 처리
	            alert("최대 100자까지 입력 가능합니다.");
	            $(this).val(content.substring(0, 99));
	            $('#textLengthCheck').text("(100 / 최대 100자)");
	        }
	    });

	    // 실시간 텍스트 길이 카운팅
	    function getTextLength(str) {
	        var len = 0;
	        for (var i = 0; i < str.length; i++) {
	            if (escape(str.charAt(i)).length == 6) {
	                len++;
	            }
	            len++;
	        }
	        return len;
	    }

	});
	</script>
</html>
	