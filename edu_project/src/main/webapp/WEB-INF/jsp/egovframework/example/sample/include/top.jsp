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
	top: 0;
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
	margin-top: 750px;
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
</style>

<!-- 최상단 기관 로고  -->
<body id="myPage">
	<div id="logo">
		<img alt="logotest"
			src="https://phinf.pstatic.net/memo/20240115_80/1705286116047rbs54_PNG/%BB%F5%BD%CF%C3%BB%BC%D2%B3%E2%B1%B3%C0%B0%BA%B9%C1%F6%BC%BE%C5%CD.png?type=w740"
			style="width:380px; height:90px;">
	</div>
<!-- 상단 메뉴  -->
	<div id="body">
		<div class="w3-top">
			<div class="w3-bar w3-red w3-card w3-left-align w3-large">
				<a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red"
					href="javascript:void(0);" onclick="myFunction()"
					title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a> 
				<!-- 홈 -->
				<a href="home" class="w3-bar-item w3-button w3-padding-large w3-white">홈</a> 
				
				<!-- 강좌보기 -->
				<a href="courseList" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">강좌보기</a>
				
				<!-- 수강후기 -->
				<a href="reviewList" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">수강후기</a>
				
				<!-- 기관안내 -->
				<a href="centerInfo" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">기관안내</a>
				
				<!-- 마이페이지 -->
				<a href="myPage2" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">마이페이지</a>
			</div>
		</div>
	</div>	
	<div>
		<h1> &nbsp </h1>
		<h1> &nbsp </h1>
	</div>
	<!-- 내용추가 -->
</body>
</html>
