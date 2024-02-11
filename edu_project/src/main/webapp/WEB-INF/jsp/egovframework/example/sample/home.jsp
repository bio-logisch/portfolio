<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>새싹청소년교육복지센터</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
/* zocial */
[class*="entypo-"]:before {
	font-family: 'entypo', sans-serif;
}

*, *:before, *:after {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

/*로그인 글씨*/
h2 {
	color: black;
	margin-left: 12px;
}

/*로그인 입력창*/
input {
	padding: 16px;
	border-radius: 7px;
	border: 0px;
	background: lightgray;
	display: block;
	margin: 15px;
	width: 300px;
	color: gray;
	font-size: 18px;
	height: 54px;
}

/*로그인 입력창 클릭시*/
input:focus {
	outline-color: rgba(0, 0, 0, 0);
	background: rgba(255, 255, 255, .95);
	color: #f94327;
}

/*로그인, 회원가입 버튼*/
#join, #login {
	float: right;
	border: 0px;
	background: #f94327;
	border-radius: 7px;
	padding: 10px;
	color: white;
	font-size: 20px;
}

/*회원가입 버튼*/
#join {
	width: 400px;
	height: 50px;
	position: absolute;
	top: 600%;
	left: 6%;
}

/*로그인 버튼*/
#login {
	width: 80px;
	height: 120px;
	margin-left: 10px;
}

/*로그인 입력창 글씨*/
input::-webkit-input-placeholder {
	color: white;
}

/*로그인 입력창 글씨 클릭시*/
input:focus::-webkit-input-placeholder {
	color: #f94327;
}

*, *:before, *:after {
	box-sizing: border-box;
}

/*로그인창 div*/
#loginForm {
	position: absolute;
	top: 200%;
	left: 5%;
}

/*슬라이드쇼*/
#slideshow {
	width: 650px;
	height: 300px;
	margin-top: 200px;
	position: absolute;
	top: 10%;
	left: 70%;
	transform: translate(-50%, -50%);
	border: white solid 1px;
}

#slideshow, .loginForm {
	display: inline-block;
}

#slideshow #slidewindow {
	position: relative;
	overflow: hidden;
}

#slideshow #slidewindow div {
	position: absolute;
	top: 5%;
	width: 100%;
	transition: transform .5s ease;
}

#slideshow #slidewindow div img {
	display: block;
	width: 100%;
}

/* Controls */
#slideshow #controls {
	text-align: center;
	transition: all 200ms ease-in-out;
}

#slideshow #controls #next, #slideshow #controls #prev {
	position: relative;
	width: 48px;
	height: 48px;
	margin: 8px;
	cursor: pointer;
}

#slideshow #controls #next {
	float: right;
}

#slideshow #controls #prev {
	float: left;
}

#slideshow #controls #next div, #slideshow #controls #prev div {
	position: absolute;
	pointer-events: none;
	border-style: solid;
	border-color: #383838;
	border-width: 2px 2px 0 0;
	content: '';
	display: inline-block;
	left: 18px;
	top: 18px;
	transform: rotate(45deg);
	vertical-align: top;
	width: 8px;
	height: 8px;
}

#slideshow #controls #prev div {
	transform: rotate(-135deg);
}

#slideshow #controls #dots {
	margin: auto;
	display: inline-block;
	padding: 0;
	list-style-type: none;
	width: auto;
}

#slideshow #controls #dots li {
	display: inline-block;
	border: 2px solid #383838;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	cursor: pointer;
	margin: 26px 4px;
}

#slideshow #controls #dots .active {
	background: #383838;
}

#slideshow #controls #dots li:hover, #slideshow #controls #next:hover,
	#slideshow #controls #prev:hover {
	transform: scale(1.125);
}

#slideshow #controls #dots li:active, #slideshow #controls #next:active,
	#slideshow #controls #prev:active {
	transform: scale(1);
}

#logo {
	width: 500px;
	height: 80px;
	display: inline-block;
	position: absolute;
	top: 0;
	left: 20%;
	transform: translateX(-50%);
}

/*네브바*/
.w3-top {
	position: absolute;
	top: 10%;
}

/*버튼메뉴 div*/
#team {
	background-color: lightgray;
	margin-top: 600px;
	height: 250px;
}
/*버튼 전체*/
button {
	border: none;
	background: none;
	cursor: pointer;
}

/*메뉴버튼 전체*/
.menubtn {
	transition: transform 0.3s ease;
}
/*메뉴버튼 커서 댈시*/
.menubtn:hover {
	transform: scale(1.2);
}
/*배너 div*/
#banner {
	margin-top: 20px;
	margin-left: 20px;
	margin-bottom: 20px;
	height: 100px;
}
/*배너 버튼 전체*/
.banner {
	width: 200px;
	height: 100px;
	border: 1px solid #ccc;
}
/*배너 버튼 이미지 전체*/
.banner img {
	width: 100%;
	height: 100%;
	object-fit: contain;
}
#kakao{
	background-image: url("https://t1.daumcdn.net/cfile/tistory/99BEE8465C3D7D1214");
            background-repeat:no-repeat;
            background-size: 100% 100%;
            width:400px;
            height:70px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
//회원가입 함수
function signup(user){
	 $.ajax({
    	 url:'user',
    	 method:'POST',
    	 data:JSON.stringify(user),
    	 contentType:"application/json; charset=UTF-8",
    	 success:function(result){
    		 console.log('통신 성공:'+result);
    		 alert("회원가입이 완료되었습니다.\n카카오 로그인을 다시 눌러 주세요.");
    	 },
    	 error:function(){
    		 alert("오류");
    	 }
      });
}
Kakao.init('7d2e6414fd2f7670fa131b7f5e5b3e8c'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  //내 카카오 계정 id, 닉네임
        	  const userId = response.id;
              const nickname = response.properties.nickname;
              //객체 변수에 저장, 변수명은 MemberVO에 매핑될수 있도록 필드명과 동일하게 작성
              //비밀번호와 연락처는 임시로 튜플값 설정, 연락처는 마이페이지에서 수정 가능하게 하면 좋을듯
              const user = {m_id:userId,m_pw:'sns',m_name:nickname,m_phone:'연락처 미등록'};
              console.log(user);
              //비동기 처리 시작
              $.ajax({
          		url:'userlist/'+userId,//카카오 id url에 붙여서 전송
          		method:'GET',
          		contentType : "application/json; charset=UTF-8", //서버로 보내는 데이터 타입(json)
          		dataType : 'text', //서버로부터 받을 데이터 타입
          		success: function(result){
          			console.log(result);
          			if(result==='login'){//이미 가입된 카카오 id라면 로그인 진행
              		  console.log('로그인 진행');
              		  var password = "sns";
          			//아이디와 비밀번호를 post 방식으로 서버에 전송해야 하므로 동적 form 생성
              		  // FormData 객체 생성
              		  var formData = new FormData();
          			//append 함수로 form에 작성할 데이터 붙이기(input 태그 name, input 태그 value)
              		  formData.append("m_id", userId);
              		  formData.append("m_pw", password);

              		  // 폼 동적 생성
              		  var form = document.createElement("form");
              		  form.method = "POST"; //폼의 메소드
              		  form.action = "login";  //클라이언트 요청 url(컨트롤러 value)

              		  // FormData를 폼에 추가
              		  for (var pair of formData.entries()) {
              		    var input = document.createElement("input");
              		    input.type = "hidden";
              		    input.name = pair[0]; //input 태그의 name 설정 : formData의 첫번째 요소(m_id, m_pw)
              		    input.value = pair[1];//input 태그의 value 설정 : formData의 두번째 요소(userId, password)
              		    form.appendChild(input);//폼에 자식 태그 추가(input)
              		    console.log('pair[0]:'+pair[0]);
              		  	console.log('pair[1]:'+pair[1]);
              		  }

              		  // 폼을 body 태그의 자식으로 추가하고 전송
              		  document.body.appendChild(form);
              		  form.submit();
              	  }else{//가입되지 않은 카카오 id라면(result==='signup')
              		  console.log('회원가입 진행');
              		  signup(user);//회원정보(카카오 id, 임시 비번, 카카오 닉네임, 임시 연락처)를 가지고 회원가입 함수 호출
              	  }
          		},
          		error : function(){
          			alert("오류");
          		}
          	});
              
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
<body id="myPage">

	<!-- 로그인 유효성 체크 -->
	<c:if test="${flag == '1'}">
		<script>
		alert("아이디 혹은 비밀번호가 틀렸습니다.")
	</script>
	</c:if>
	<c:if test="${flag == '3'}">
		<script>
		alert("[오류]먼저 로그인을 해주세요.")
	</script>
	</c:if>


	<!-- 최상단 기관 로고  -->
	<div id="logo">
		<img alt="logotest"
			src="https://phinf.pstatic.net/memo/20240115_80/1705286116047rbs54_PNG/%BB%F5%BD%CF%C3%BB%BC%D2%B3%E2%B1%B3%C0%B0%BA%B9%C1%F6%BC%BE%C5%CD.png?type=w740"
			style="width:380px; height:90px;">
	</div>

	<!-- 상단 메뉴  -->
	<div id="body">
		<div class="w3-top">
			<div class="w3-bar w3-red w3-card w3-left-align w3-large">
				<a
					class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
					href="javascript:void(0);" onclick="myFunction()"
					title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> <a
					href="home"
					class="w3-bar-item w3-button w3-padding-large w3-white">홈</a> <a
					href="courseList"
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">강좌보기</a>

				<a href="reviewList"
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">수강후기</a>

				<a href="centerInfo"
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">기관안내</a>

				<a href="myPage2"
					class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">마이페이지</a>
			</div>

			<!-- 이미지 슬라이드 -->
			<section id="slideshow">
				<div id="slidewindow">
					<div>
						<img alt="Slideshow Image 1"
							src="https://educator.edunet.net/pluginfile.php/700312/course/overviewfiles/1.png">
					</div>
					<div>
						<img alt="Slideshow Image 2"
							src="https://educator.edunet.net/pluginfile.php/700316/course/overviewfiles/%EC%8D%B8%EB%84%A4%EC%9D%BC.jpg">
					</div>
					<div>
						<img alt="Slideshow Image 3"
							src="https://educator.edunet.net/pluginfile.php/699683/course/overviewfiles/%EC%A0%9C%EB%AA%A9%EC%9D%84-%EC%9E%85%EB%A0%A5%ED%95%B4%EC%A3%BC%EC%84%B8%EC%9A%94_-001%20(42).jpg">
					</div>
					<div>
						<img alt="Slideshow Image 4"
							src="https://imgprism.ehyundai.com/derivedImage/fileValue/202310/23/ad19973d-bfda-4672-9d86-73f3b80261ef.jpg">
					</div>
				</div>
				<div id="controls">
					<a id="next">
						<div></div>
					</a>
					<ul id="dots"></ul>
					<a id="prev">
						<div></div>
					</a>
				</div>
			</section>

			<!-- 로그인 폼 -->
			<c:if test="${userid == null}">
				<form id="loginForm" action="login" method="post">
					<h2>
						<span class="entypo-login"><i class="fa fa-sign-in"></i></span>
						로그인
					</h2>
					<button id="login" class="submit">로그인</button>
					<input type="text" class="user" name="m_id" placeholder="아이디" /> <input
						type="password" class="pass" name="m_pw" placeholder="비밀번호" />
						<input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/>
				</form>
				<div style="position:absolute; top:740%; left:6%;">
      <a href="javascript:void(0)">
	<button id="kakao" onclick="kakaoLogin();">
	</button>
      </a>
       
      <a href="javascript:void(0)">
	<button onclick="kakaoLogout();">
          <span></span>
	</button>
      </a>
       
      </div>
				<button id="join" onclick="location.href='join';">회원가입</button>
			</c:if>
			<c:if test="${userid != null}">
				<form id="loginForm">
					<h2>
						<span class="entypo-login"><i class="fa fa-sign-in"></i></span> <b>${username}</b>님,
						반갑습니다.
					</h2>
				</form>
				<button id="join" onclick="location.href='logout';">로그아웃</button>
			</c:if>
		</div>

		<!-- 상단 아이콘 버튼 4개 -->
		<div class="w3-container w3-padding-64 w3-center" id="team">
			<div class="w3-row">
				<br>

				<div class="w3-quarter">
					<button class="menubtn">
						<img alt="course"
						 src="https://phinf.pstatic.net/memo/20240115_248/1705286269641nLdh2_PNG/%B0%AD%C1%C2%BE%C6%C0%CC%C4%DC.png?type=w740"
						 style="width:100%;">
					</button>
					<h3>강좌보기</h3>
				</div>

				<div class="w3-quarter">
					<button class="menubtn">
						<img alt="review"
						 src="https://phinf.pstatic.net/memo/20240115_33/1705286280185fCpHh_PNG/%BC%F6%B0%AD%C8%C4%B1%E2.png?type=w740"
						 style="width:100%;">
					</button>
					<h3>수강후기</h3>
				</div>

				<div class="w3-quarter">
					<button class="menubtn">
						<img alt="center"
						 src="https://phinf.pstatic.net/memo/20240115_11/1705286273293FSWNE_PNG/%B1%E2%B0%FC%BE%C8%B3%BB.png?type=w740"
						 style="width:100%;">
					</button>
					<h3>기관안내</h3>
				</div>

				<div class="w3-quarter">
					<button class="menubtn">
						<img alt="mypage"
						 src="https://phinf.pstatic.net/memo/20240115_226/1705286276463mRXwX_PNG/%B8%B6%C0%CC%C6%E4%C0%CC%C1%F6.png?type=w740"
						 style="width:100%;">
					</button>
					<h3>마이페이지</h3>
				</div>
			</div>
		</div>
	</div>


	<!-- 베스트 수강후기 -->
	<div class="w3-row-padding w3-padding-64 w3-theme-l1" id="work">
		<div class="w3-quarter">
			<br> <br>
			<h2 style="color: white;">수강후기 보기</h2>
			<br> <br>
			<h4>
				회원님들께서 직접 작성해 주신 <br> 강좌의 수강후기입니다. <br>
			</h4>
			<p>
				회원님들께서 수강하신 강좌의 <br> 생생한 후기를 들려주세요. 
			</p>
		</div>

		<c:forEach items="${rlist}" var="rvo" varStatus="loopStatus">
		<div class="w3-quarter"
			style="display: flex; flex-wrap: nowrap; overflow-x: auto; gap: 10px;">
				<div class="w3-card w3-white"
					style="display: inline-block; flex: 0 0 auto; width: 95%;">
						<img alt="bestReview1"
							src="https://phinf.pstatic.net/memo/20240115_92/1705286254214WFqAf_PNG/review2.PNG?type=w740"
							style="width: 100%; height: 200px;">
					<div class="w3-container">
						<h5>${rvo.rev_title}</h5>
						<p>${rvo.rev_content}</p>
                		<p class="idTD" id="idTD_${loopStatus.index}"></p>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>	
		
		
	<!-- 수강후기 작성 -->
	<a id="reviewLoginChk" href="reviewForm">
		<div class="w3-container" style="position: relative;">
			<button
				class="w3-button w3-xlarge w3-circle w3-teal"
				style="position: absolute; top: -28px; right: 24px">+</button>
		</div>
	</a>

	<!-- 문의글 남기기  -->
	<div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
		<div class="w3-row">
			<div class="w3-col m5">
				<div class="w3-padding-16">
					<span> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp </span> <span
						class="w3-xlarge w3-border-teal w3-bottombar"> Contact Us </span>
				</div>
				<br>
				<h3>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
					대표 연락처</h3>
				<p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
					&nbsp &nbsp 문의글을 남겨주세요.</p>
				<br>
				<p>
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <i
						class="fa fa-map-marker w3-text-teal w3-xlarge"></i>   경기도 수원,
					대한민국
				</p>
				<p>
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <i
						class="fa fa-phone w3-text-teal w3-xlarge"></i>   +82 031-000-0000
				</p>
				<p>
					&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <i
						class="fa fa-envelope-o w3-text-teal w3-xlarge"></i>  
					saessak@edu.com
				</p>
			</div>
			<div class="w3-col m7" style="width: 600px; margin-right: 20px;">
				<form class="w3-container w3-card-4 w3-padding-16 w3-white"
					action="/action_page.php" target="_blank">
					<div class="w3-section">
						<label>Name</label> <input class="w3-input" type="text"
							name="Name" style="width: 530px;" required>
					</div>
					<div class="w3-section">
						<label>Email</label> <input class="w3-input" type="text"
							name="Email" style="width: 530px;" required>
					</div>
					<div class="w3-section">
						<label>Message</label> <input class="w3-input" type="text"
							name="Message" style="width: 530px;" required>
					</div>
					<input class="w3-check" type="checkbox" checked name="Like">
					<label> &nbsp 중요</label>
					<button type="submit" id="send" class="w3-button w3-right w3-theme">Send</button>
				</form>
			</div>
		</div>
	</div>

	<!-- 하단 유관기관 배너 -->
	<article>
		<div id="banner">
			<button class="banner">
				<img
					src="data:image/png;base64,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"
					alt="Boss" style="width: 100%">
			</button>
			<button class="banner">
				<img src="https://www.moe.go.kr/images/template/01012/sub/moe1.png"
					alt="Boss" style="width: 50%">
			</button>
			<button class="banner">
				<img
					src="https://upload.wikimedia.org/wikipedia/commons/c/ca/%EC%97%AC%EC%84%B1%EA%B0%80%EC%A1%B1%EB%B6%80_%EB%A1%9C%EA%B3%A0_%282010-2016%29.svg"
					alt="Boss" style="width: 50%">
			</button>
			<button class="banner">
				<img
					src="data:image/jpeg;base64,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"
					alt="Boss" style="width: 50%">
			</button>
			<button class="banner">
				<img
					src="https://cdn.ngonews.kr/news/photo/202301/138349_104230_813.jpg"
					alt="Boss" style="width: 100%">
			</button>
			<button class="banner">
				<img
					src="https://ilyo.co.kr/contents/article/images/2020/0303/1583226740857023.jpg"
					alt="Boss" style="width: 100%">
			</button>
		</div>
	</article>

	<!-- Footer -->
	<footer class="w3-container w3-padding-64 w3-center w3-opacity">
		<div class="w3-xlarge w3-padding-32">
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
		<p>
			경기 수원시 팔달구 중부대로 100, 3층 (인계동, 새싹청소년교육복지센터) <br> 새싹청소년교육복지센터
			TEL.(031)0000-0000 FAX. (031)000-0000 <br> Copyright © Saessak
			Center for Youth Education Welfare. All Rights Reserved. <br> <br>
			(평일 09:00~18:00 / 평일 야간 및 휴일: 당직실 031-8012-0000)
		</p>

	
	<div style="position: fixed; bottom: 20px; right: 20px; z-index: 1;" class="w3-tooltip w3-right">
	    <span class="w3-text w3-padding w3-teal w3-hide-small"> 맨 위로 </span>
	    <a class="w3-button w3-theme" href="javascript:scrollToTop();">
	    <span class="w3-xlarge"> <i class="fa fa-chevron-circle-up"></i></span></a>
	</div>
	
	</footer>
</body>
<script>

	//슬라이드쇼
	window.onload = function() {
		"use strict";
		//autoplay true=on, false=off
		var autoplay = true;

		//slideshow autoplay timing in ms
		var autoTime = 3000;

		//vars
		var tracker = 0, slidewindow = document
				.querySelector("#slideshow #slidewindow"), slides = document
				.querySelectorAll("#slideshow #slidewindow div"), next = document
				.querySelector("#slideshow #controls #next"), prev = document
				.querySelector("#slideshow #controls #prev"), dots = document
				.querySelector("#slideshow #controls #dots"), allDots = dots
				.getElementsByTagName("LI");

		//Attach click events to next and prev
		next.onclick = direction;
		prev.onclick = direction;

		//create a dot for each slide
		for (var i = 0; i < slides.length; i++) {
			var dot = document.createElement("LI");
			dot.id = i;
			dots.appendChild(dot);
			dot.onclick = direction;
		}

		//run function on resize
		window.onresize = updateAll;

		//invoke updateAll
		updateAll();

		//update slide and container sizes
		function updateAll() {
			updateDots(tracker);

			//set width of slidewindow to 100%
			slidewindow.style.width = "100%";

			//Get current width and height
			var curWidth = slides[0].offsetWidth;
			var curHeight = slides[0].offsetHeight;

			//set current w/h of slidewindow to match slide
			slidewindow.style.width = curWidth + "px";
			slidewindow.style.height = curHeight + "px";

			//set position of each slide
			for (var i = 0; i < slides.length; i++) {
				console.log(slides[i].style.transform)
				slides[i].style.transform = "translateX("
						+ (i * curWidth + tracker * curWidth) + "px )";
			}
		}

		function isNumber(obj) {
			return !isNaN(parseFloat(obj));
		}

		//autoplay
		if (autoplay === true) {
			setInterval(function() {
				if (tracker > 1 - slides.length) {
					tracker -= 1;
				} else if (tracker === 1 - slides.length) {
					tracker = 0;
				} else if (tracker < 0) {
					tracker += 1;
				} else if (tracker === 0) {
					tracker = -slides.length + 1;
				}
				updateAll();
			}, autoTime);
		}

		function direction(eventObject) {
			//get id from target
			var idVal = eventObject.target.id;

			if (idVal === "next" && tracker > 1 - slides.length) {
				tracker -= 1;
			} else if (idVal === "next" && tracker === 1 - slides.length) {
				tracker = 0;
			} else if (idVal === "prev" && tracker < 0) {
				tracker += 1;
			} else if (idVal === "prev" && tracker === 0) {
				tracker = -slides.length + 1;
			} else if (isNumber(idVal)) {
				tracker = -idVal;
			}
			updateAll();
		}

		//updateDots
		function updateDots(n) {
			n *= -1;
			for (var i = 0; i < allDots.length; i++) {
				allDots[i].className = "";
			}
			allDots[n].className = "active";
		}

		//swipe event listeners
		slidewindow.addEventListener("touchstart", handleTouchStart, false);
		slidewindow.addEventListener("touchmove", handleTouchMove, false);

		//swipe vars
		var xDown = null;
		var yDown = null;

		//swipe handleTouchStart
		function handleTouchStart(evt) {
			xDown = evt.touches[0].clientX;
			yDown = evt.touches[0].clientY;
		}

		//swipe handleTouchMove
		function handleTouchMove(evt) {
			if (!xDown || !yDown) {
				return;
			}

			var xUp = evt.touches[0].clientX;
			var yUp = evt.touches[0].clientY;

			var xDiff = xDown - xUp;
			var yDiff = yDown - yUp;

			if (Math.abs(xDiff) > Math.abs(yDiff)) {
				/*determine most significant*/
				if (xDiff > 0) {
					//swipe left - next
					if (tracker > 1 - slides.length) {
						tracker -= 1;
					} else if (tracker === 1 - slides.length) {
						tracker = 0;
					}
					updateAll();
				} else {
					//swipe right - prev
					if (tracker < 0) {
						tracker += 1;
					} else if (tracker === 0) {
						tracker = -slides.length + 1;
					}
					updateAll();
				}
			} else {
				if (yDiff > 0) {
					//swipe up
				} else {
					//swipe down
				}
			}

			/* reset values */
			xDown = null;
			yDown = null;
		}
	};
	 // 맨 위로 버튼 클릭 시 스크롤을 맨 위로 이동시키기
	 function scrollToTop() {
	        window.scrollTo({ top: 0, behavior: 'smooth' });
	 }
	 //마스킹 처리 - 아이디
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
	    <c:forEach items="${rlist}" var="rvo" varStatus="loopStatus">
       let reviewId_${loopStatus.index} = '${rvo.m_id}';
       let reviewDate_${loopStatus.index} = '${rvo.rev_date}';

       if (reviewId_${loopStatus.index} && reviewDate_${loopStatus.index}) {
           let tdElement_${loopStatus.index} = document.getElementById('idTD_${loopStatus.index}');
           let maskedID_${loopStatus.index} = masking.id(reviewId_${loopStatus.index});
           let maskedDATE_${loopStatus.index} = formatDateTime(reviewDate_${loopStatus.index});
           tdElement_${loopStatus.index}.innerHTML = maskedID_${loopStatus.index} + ' / ' + maskedDATE_${loopStatus.index};
       }
   	</c:forEach>
	 
</script>
</html>
