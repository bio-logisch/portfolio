<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>회원정보 수정</title>
<style>
    /*버튼 공통*/
    .btn{
        display: inline-block;
        width: 100px; height: 30px;
        font-weight: 600;
        text-align: center;
        border-radius: 5px;
        transition: all 0.2s ;
        color:white;
        background: #5DC8CD;
        box-shadow: 0px 5px 0px 0px #007144;
        margin:50px;
    } 
    .button {
	  /* 기본 css */
	  display: inline-block;
	  margin-left:450px;
	}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<body>
    <%@ include file="./include/top.jsp" %>
    <br>
    <!-- 게시판 내용 -->
    <div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_274/1705399552905quLWO_PNG/%C8%B8%BF%F8%C1%A4%BA%B8_%BC%F6%C1%A4_%281%29.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div><br>
        <div id="memberInfo" style="margin-left:50px;">
        <br>
        <div id= "top">
 		 <p class="button" style="margin-left:50px;">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_50/1705399558721RqdG6_PNG/%C8%B8%BF%F8_%C1%A4%BA%B8.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
        <label> 성 &nbsp&nbsp명  &nbsp&nbsp&nbsp</label> 
         <input type="text" id="name" name="m_name" value="${member.m_name}" readonly>
         <span id="name_warn" style="font-size:12px; color:blue;"></span>  
          <br>
        <label> 연락처 &nbsp&nbsp&nbsp</label>
        <input type="text" id="phone" name="m_phone" value="${member.m_phone}" readonly>
        <span id="phone_warn" style="font-size:12px; color:blue;"></span>  
         <br>
        </div> <br> 
        <div id="loginInfo" style="margin-left:50px;">
        <div id= "top">
 		 <p class="button" style="margin-left:50px;">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_70/1705399562208orn6p_PNG/%B7%CE%B1%D7%C0%CE_%C1%A4%BA%B8.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
        <label style="font-weight:bold;"> 아이디 &nbsp&nbsp&nbsp </label>
        <span id="idSpan">${member.m_id}</span>
        
            <label style="font-weight:bold;"> <br> 비밀번호 </label>
            <c:choose>
	            <c:when test="${not member.m_id.matches('.*[a-zA-Z].*')}">
		            <input type="text" style="width:400px;" name="m_pw" value="카카오 계정은 비밀번호 변경이 불가합니다." readonly>
    	        </c:when>
    	        <c:otherwise>
    	        	<input type="password" id="writePass" name="m_pw" value="${member.m_pw}" readonly>
            <span id="pw_warn" style="font-size:12px; color:blue;"></span>      
    	        </c:otherwise>
            </c:choose>
            <p>"변경"버튼을 누르면 회원정보를 수정할 수 있습니다. 
            <br> 새로운 회원정보를 입력한 후 "저장"버튼을 눌러야 수정이 완료됩니다. <br> </p>
	            <button class="btn" type="button" onclick="modifyPass()">변경</button>
            <span>&nbsp &nbsp &nbsp</span>
            <button class="btn" type="button" onclick="submitCheck()">저장</button>
        </div>
    </div>
    <script>
    //비밀번호 유효정 체크 flag
    let flag = false;
  //비밀번호 제약조건 정규표현식 : 영문, 숫자 혼합 8~20자
    const getPwCheck = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,20}$/;
  //이름 제약조건 정규표현식 : 한글만 입력, 2~10자
	const getNameCheck = /^[가-힣]{2,10}$/;
	//번호 제약조건 정규표현식 : 숫자만 입력, 10~11자
	const getPhoneCheck = /^\d{10,11}$/;
    
    function infochk(target, id, regex, info1, info2){//매개변수 : input태그, span태그 아이디, 정규표현식 변수명, span태그 내용1, span태그 내용2
		if(target.val()==''){ //입력 란이 공백이면
			target.css('background','pink');
			$(id).html('<b>'+info1+' 필수 정보입니다.</b>');
			flag=false;
		}else if(!regex.test(target.val())){ //입력값이 제약조건에 맞지 않으면
			target.css('background','pink');
			$(id).html('<b>'+info2+'자여야 합니다.</b>');
			flag=false;
		}else{ //입력값이 공백이 아니면서 제약조건에 맞으면
			target.css('background','lightgray');
			$(id).html('');
			flag=true;
		}
	}
    
        function modifyPass(){ //변경버튼 클릭 시 input 속성 수정가능한 상태로 변경
        	let originalName = '${member.m_name}';
            let originalPhone = '${member.m_phone}';
            let originalId = '${member.m_id}';
            alert("이제 회원정보를 수정할 수 있습니다.");
            document.getElementById('name').value = originalName;
            document.getElementById('phone').value = originalPhone;
            document.getElementById('name').removeAttribute('readonly');
            document.getElementById('phone').removeAttribute('readonly');
            $('#name').on('keyup blur',function(event){
        	    infochk($(this),'#name_warn',getNameCheck,'이름은','이름은 한글로 2~10');
        	});
            $('#phone').on('keyup blur',function(event){
        	    infochk($(this),'#phone_warn',getPhoneCheck,'연락처는','연락처는 숫자로만 10~11');
        	});
            if(/[a-zA-Z]/.test('${member.m_id}')){
            document.getElementById('writePass').removeAttribute('readonly');
            $('#writePass').on('keyup blur',function(event){
        	    infochk($(this),'#pw_warn',getPwCheck,'비밀번호는','비밀번호는 영문,숫자 혼합으로 8~20');
        	});
            }
        }
        //수정성공 시 알림
        function submitCheck(){
        	if(flag){
        		const id='${member.m_id}';
    			const pw=$('#writePass').val();
    			const name=$('#name').val();
    			const phone=$('#phone').val();
    			let user = null;
    			if(/[a-zA-Z]/.test('${member.m_id}')){
    				user = {m_id:id, m_pw : pw, m_name : name, m_phone : phone};
    			}else{
    				user = {m_id:id, m_name : name, m_phone : phone};
    			}
    			console.log(user);
    			$.ajax({
    				url:'user',
    				method:'PUT',
    				data : JSON.stringify(user), //js 데이터 객체 user를 json 문자열로 변환
    				contentType : "application/json; charset=UTF-8", //서버로 보내는 데이터 타입(json)
    				//dataType : 'text', //서버로부터 받을 데이터 타입
    				success: function(result){
    					console.log('통신 성공:'+result);
			            alert("회원정보가 수정되었습니다.\n다시 로그인하세요.")
    					location.href='/edu_project/logout';
    				},
    				error : function(){
    					alert("오류");
    				}
    			});
        	}else{
        		alert("조건에 맞지 않는 정보가 있습니다.");
        	}
        }

        //이름, 전화번호, 아이디 마스킹 처리
        //이름 : 첫글자와 마지막글자 제외 후 *표시(고**치), 2글자인 경우 뒷글자 *표시(이*)
        //전화번호 : 중간 4자리 *표시, 만약 db에서 불러온 입력값에 -이 있다면 -제외하고 처리
        //만약 -이 없다면 마스킹 처리 후 중간에 -삽입 후 화면에 표시(000-****-0000)
        //아이디 : 첫 2자리 제외 모두 *표시 >> 예: dd**
        let masking = {
            //null 혹은 빈칸 여부 체크
            checkNull : function (str){
                if(typeof str == "undefined" || str == null || str == "") {
                    return true;
                } else {
                    return false;
                }
            },
            name : function(str){
                let originStr = str; //원래 이름
                let maskingStr; //마스킹 처리한 이름
                let strLength; //이름 길이
                
                if(this.checkNull(originStr) == true){ //null이면 다시 null로 출력
                    return originStr;
                }
                strLength = originStr.length; //문자길이 저장
                if(strLength < 3){//이름이 3글자보다 적으면
                    maskingStr = originStr.charAt(0) + '*'.repeat(strLength - 1); //인덱스 0번째 글자는 그대로, 나머지는 *로
                } else { //3글자부터는 첫글자와 마지막 글자 제외후 모두*표시
                    maskingStr = originStr.charAt(0) + '*'.repeat(strLength - 2) + originStr.charAt(strLength - 1);
                }
                return maskingStr;
            },
            phone : function(str){
                let originStr = str; //원래 전화번호
                let maskingStr; //마스킹 처리한 전화번호
                
                if(this.checkNull(originStr) == true){
                    return originStr;
                }
                //회원가입 시 -를 입력하지 못하게 막아두어서 db에는 숫자데이터만 있음(10~11자리숫자만 입력가능)
                //phonsStr은 배열로 ["01011112222", "1111"]에 해당함
                //match함수는 해당하는 정규표현식과 일치하는 부분을 찾아내어 배열로 반환한다. |d{3}은 3자리 숫자그룹을 의미한다.
                // :은 삼항 연산자로 condition ? a1 : a2;일때 condition이 참이면 a1이 실행되고 거짓이면 a2가 실행된다.
                //따라서 originStr.length < 11이 참이면 :를 기준으로 앞에 있는 정규표현식의 결과가 반환되고, 
               	//거짓이면 뒤에 있는 정규표현식의 결과가 반환된다. ()안에 있는 수만 반환되어서 중간에 있는 3자리 혹은 4자리 숫자만 반환된다.
                let phoneStr = 
                	originStr.length < 11 ? originStr.match(/\d{3}(\d{3})\d{4}/) : originStr.match(/\d{3}(\d{4})\d{4}/);
                if(this.checkNull(phoneStr) == true) {
                    return originStr;
                }
                if(originStr.length < 11) { //전화번호가 10자리면
                    maskingStr = originStr.replace(phoneStr[1], '-***-');
                } else { //전화번호가 11자리면
                    maskingStr = originStr.replace(phoneStr[1], '-****-');
                }
                return maskingStr;
            },
            id : function(str){
                let originStr = str; //원래 아이디(아이디는 이메일주소라서 나중에 수정필요@이전문자에 대한 마스킹)
                let maskingStr; //마스킹 처리한 아이디
                let strLength; //아이디 길이
                
                if(this.checkNull(originStr) == true){ //null이면 다시 null로 출력
                    return originStr;
                }
                strLength = originStr.length; //문자길이 저장
       			maskingStr = originStr.charAt(0) + '*'.repeat(strLength - 1);//2번째부터 마스킹표시
  
       			return maskingStr;
            }
        };

        // 각 Span에 대해 마스킹 함수 적용
        document.getElementById('name').value = masking.name('${member.m_name}');
        document.getElementById('phone').value = masking.phone('${member.m_phone}');
        document.getElementById('idSpan').innerText = masking.id('${member.m_id}');
    </script>
    <%@ include file="./include/bottom.jsp" %>
</body>
</html>
