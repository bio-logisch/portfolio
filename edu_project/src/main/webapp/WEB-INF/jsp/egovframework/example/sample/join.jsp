<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
#logo {
	width: 500px;
	height: 80px;
	display: inline-block;
	position: absolute;
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
   #form{
        margin-left: 100px;
        width:1050px;
        height:600px;
        position:absolute;
        top:20%;
        left:18%;
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
.button {
	  /* 기본 css */
	  display: inline-block;
	  text-align: center;
	  padding: 1px 500px;
	  color: black;
	  font-size: 2rem;
	  font-weight: 600;
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
	<br><br><br><br>
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240115_238/1705312507234jfsFB_PNG/%C8%B8%BF%F8%B0%A1%C0%D4.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
	
    <div id="form">
    <form class="row g-3" action="joinDone" method="post">
        <div class="col-md-6">
	<br><br><br><br><br><br><br>
          <label for="inputEmail4" class="form-label">아이디(이메일)</label>
          <input type="text" class="form-control" name="m_id" placeholder="이메일" id="user_id">
          <span id="id_warn" style="font-size:12px; color:blue;"></span>
        </div>
        <!-- 
        <div class="col-12">
            <button type="submit" class="btn btn-primary" style="background-color: #f94327;
            border:#f94327;">이메일 인증</button>
          </div>
         -->
          <div class="col-md-8">
            <label for="inputCity" class="form-label">비밀번호</label>
            <input type="password" class="form-control" name="m_pw" id="user_pw" placeholder="비밀번호">
			<span id="pw_warn" style="font-size:12px; color:blue;"></span>         
          </div>
          <br>
          <div class="col-md-8">
            <label for="inputCity" class="form-label">비밀번호 확인</label>
            <input type="password" class="form-control" id="user_confirm" placeholder="비밀번호 확인">
            <span id="pw_confirm" style="font-size:12px; color:blue;"></span>
          </div>
          <br>
        <div class="col-md-8">
          <label for="inputZip" class="form-label">이름</label>
          <input type="text" class="form-control" name="m_name" id="user_name" placeholder="이름">
          <span id="name_warn" style="font-size:12px; color:blue;"></span>
        </div>
        <div class="col-md-8">
            <label for="inputCity" class="form-label">연락처</label>
            <input type="text" class="form-control" name="m_phone" id="user_phone" placeholder="01011112222">
            <span id="phone_warn" style="font-size:12px; color:blue;"></span>
          </div>
        <div class="col-12">
          <button type="button" id="signup_btn" class="btn btn-primary" style="background-color: #f94327;
          border:#f94327;">회원가입</button>
        </div>
      </form>
      </div>
      <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
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

		<div style="position: relative; bottom: 100px; z-index: 1;"
			class="w3-tooltip w3-right">
			<span class="w3-text w3-padding w3-teal w3-hide-small"> 맨 위로 </span>
			<a class="w3-button w3-theme" href="#myPage"><span
				class="w3-xlarge"> <i class="fa fa-chevron-circle-up"></i></span></a>
		</div>
	</footer>
	<c:if test="${chk3 == 1}">
	<script>
		alert("회원가입 실패[사유:아이디중복] 다른 아이디를 입력하세요.")
	</script>	
	</c:if>	
</body>
<script>
	let chk1=false;
	let chk2=false;
	//아이디 제약조건 정규표현식 : 영문만 입력, @과 . 반드시 포함
	const getIdCheck = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	//비밀번호 제약조건 정규표현식 : 영문, 숫자 혼합 8~20자
	const getPwCheck = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/;
	//이름 제약조건 정규표현식 : 한글만 입력, 2~10자
	const getNameCheck = /^[가-힣]{2,10}$/;
	//번호 제약조건 정규표현식 : 숫자만 입력, 10~11자
	const getPhoneCheck = /^\d{10,11}$/;
	
	//아이디/비번/이름/연락처 란에 키입력 이벤트/마우스 클릭했다 없어지는 이벤트가 감지되면 체크 함수 실행
	$('#user_id').on('keyup blur',function(event){
	    chk($(this),'#id_warn',getIdCheck,'아이디는','아이디는 이메일 형식으로 7~50');
	});
	$('#user_pw').on('keyup blur',function(event){
	    chk($(this),'#pw_warn',getPwCheck,'비밀번호는','비밀번호는 영문,숫자 혼합으로 8~20');
	});
	$('#user_name').on('keyup blur',function(event){
	    chk($(this),'#name_warn',getNameCheck,'이름은','이름은 한글로 2~10');
	});
	$('#user_phone').on('keyup blur',function(event){
	    chk($(this),'#phone_warn',getPhoneCheck,'연락처는','연락처는 숫자로만 10~11');
	});
	
	function chk(target, id, regex, info1, info2){//매개변수 : input태그, span태그 아이디, 정규표현식 변수명, span태그 내용1, span태그 내용2
		if(target.val()==''){ //입력 란이 공백이면
			target.css('background','pink');
			$(id).html('<b>'+info1+' 필수 정보입니다.</b>');
			chk1=false;
		}else if(!regex.test(target.val())){ //입력값이 제약조건에 맞지 않으면
			target.css('background','pink');
			$(id).html('<b>'+info2+'자여야 합니다.</b>');
			chk1=false;
		}else{ //입력값이 공백이 아니면서 제약조건에 맞으면
			target.css('background','white');
			$(id).html('');
			chk1=true;
		}
	}
	
	//비밀번호 확인 체크 함수
	function pwConfirm(target){
		if(target.val()==''){
			target.css('background','pink');
			$('#pw_confirm').html('<b>비밀번호 확인은 필수입니다.</b>');
			chk2=false;
		}else if(target.val()==$('#user_pw').val()){ //비밀번호 확인란 입력값이 비밀번호란 입력값과 같으면
			target.css('background','white');
			$('#pw_confirm').html('<b>비밀번호가 일치합니다</b>');
			chk2=true;
		}else{
			target.css('background','pink');
			$('#pw_confirm').html('<b>비밀번호가 일치하지 않습니다.</b>');
			chk2=false;
		}
	}
	$('#user_confirm').blur(function(event){
		pwConfirm($(this));
	});
	
	
	
	$('#signup_btn').click(function(){
		if(chk3 == 0){
			const idchk=$('#user_id').val();
		}
		if(chk1 && chk2){
			const id=$('#user_id').val();
			const pw=$('#user_pw').val();
			const name=$('#user_name').val();
			const phone=$('#user_phone').val();
			const user = {m_id : id,m_pw : pw,m_name : name,m_phone : phone}
			$.ajax({
				url:'user',
				method:'POST',
				data : JSON.stringify(user), //js 데이터 객체 user를 json 문자열로 변환
				contentType : "application/json; charset=UTF-8", //서버로 보내는 데이터 타입(json)
				//dataType : 'text', //서버로부터 받을 데이터 타입
				success: function(result){
					console.log('통신 성공:'+result);
					alert("회원가입이 완료되었습니다.");
					location.href='/edu_project/home';
				},
				error : function(){
					alert("회원가입 실패");
				}
			});
		}else if(!chk1 && chk2){
			alert("조건에 맞게 입력되지 않은 정보가 있습니다.");
		}else if(chk1 && !chk2){
			alert("비밀번호 확인이 일치해야 합니다.");
		}else{
			alert("조건에 맞게 입력되지 않은 정보가 있습니다.\n비밀번호 확인이 일치해야 합니다.");
		}
	});
</script>
</html>