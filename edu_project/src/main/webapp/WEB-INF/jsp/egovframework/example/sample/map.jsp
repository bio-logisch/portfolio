<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>기관 위치보기</title>
<!-- 라이브러리 추가 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7d2e6414fd2f7670fa131b7f5e5b3e8c"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<!-- services 라이브러리 불러오기 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services"></script>
<!-- services(장소검색, 주소-좌표변환)와 cluster(마커 클러스터링), drawing(마커,그래픽스 객체 그리기) 라이브러리 불러오기 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
<style>
	*{ font-family: 'Malgun Gothic', dotum, '돋움', sans-serif; }
	#map { margin-left: 10%; }
	.map_wrap, .map_wrap * {
		margin: 0; padding: 0;
		font-size: 12px;
	}	
	.map_wrap { position: relative; width: 100%; height: 350px; }	
	#category {
		position: absolute; top: 10px; left: 10px;
		border-radius: 5px; border: 2px solid #2786EB ;
		box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
		background: #fff;
		overflow: hidden;
		z-index: 2;
	}
	#category li {
		float: left; list-style: none;
		width: 50px; px; border-right: 1px solid #acacac;
		padding: 6px 0; text-align: center;
		cursor: pointer; font-weight:bold;
	}
	#category li.on { background: #eee; }
	#category li:hover { background: #ffe6e6; border-left: 1px solid #acacac;
						 margin-left: -1px; }
	#category li:last-child { margin-right: 0; border-right: 0; }
	#category li span { display: block; width: 40px; height: 5px; }
	#category li .suwon { background-position: -10px 0; }	
	#category li .hwaseong { background-position: -10px -36px; }
	#category li .anseong { background-position: -10px -72px; }
	#category li .paju { background-position: -10px -108px; }
	#category li .namjangju { background-position: -10px -144px; }
	#category li.on .category_bg { background-position-x: -46px; }
	
	#placeinfo { list-style:none; color:#f94327; font-weight:bold;}
	
	.button {
	  /* 기본 css */
	  display: inline-block;
	  padding:40px;
	  margin-left:440px;
	}
	#info1, .info2{
		width: 200px; float: left; text-align: center; 
		color:white; font-size:27px;
		border-radius:17px;"	
	}
	#info1{ margin-left:7%; background:#4C6887; }
	.info2{ margin-left:5%; background:#2786EB; }
	#transport{ style="margin-top: 3%; margin-left: 25%; width: 800px; }
	
	
</style>
</head>
<body>
	<%@ include file="./include/top.jsp"%>
	<div id= "top">
 		 <p class="button">
        <span class="main_item">
		<img alt="courseLogo"
			src="https://phinf.pstatic.net/memo/20240116_169/1705369161528ildqE_PNG/%C1%F6%B5%B5%BA%B8%B1%E2.png?type=w740"
			style="width:100%;">
        </span>
  		</p>
		</div>
	<!-- 지도 세팅 -->
	<div id="map" style="width: 1000px; height: 400px; margin-bottom: 2%;">

		<!-- 마커별 카테고리 -->
		<div class="map_wrap">
			<div id="maCategory"
				style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
			<ul id="category">
				<li id="suwon" data-order="0">
				<span class="category_bg suwon"></span>
					수원점(센터)</li>
				<li id="hwaseong" data-order="1">
				<span class="category_bg hwaseong"></span> 
					화성점(남부)</li>
				<li id="anseong" data-order="2">
				<span class="category_bg anseong"></span> 
					안성점(남부)</li>
				<li id="paju" data-order="3">
				<span class="category_bg paju"></span>
					파주점(북부)</li>
				<li id="namjangju" data-order="4">
				<span class="category_bg namjangju"></span> 
					남양주점(북부)</li>
			</ul>
		</div>
	</div>

	<script>		
		var markerImageUrl = 'https://t1.daumcdn.net/localimg/localimages/07/2012/img/marker_p.png';//마커이미지 주소
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center : new kakao.maps.LatLng(37.277225, 127.027980), //지도의 중심좌표(경도,위도). 수원점(센터)좌표
			level : 5 //지도의 레벨(확대, 축소 정도 - 클수록 좌표에서 멀어짐)
		};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		var markers = [];
		var locations = initializeLocations(); //위치 초기화함수 호출
		
        // 각 카테고리 클릭 이벤트 등록
           document.addEventListener('DOMContentLoaded', function () {
            var categoryItems = document.querySelectorAll('#category li');
            categoryItems.forEach(function (item) {
                item.addEventListener('click', onClickCategory);
            });
        });
		//위치 초기화 함수
        function initializeLocations() {
            return [
                { id: 'suwon', name: '수원점(새싹센터)', latitude: 37.277225, longitude: 127.027980 },
                { id: 'hwaseong', name: '화성점(남부)', latitude: 37.205758, longitude: 126.812688 },
                { id: 'anseong', name: '안성점(남부)', latitude: 37.007868, longitude: 127.279859 },
                { id: 'paju', name: '파주점(북부)', latitude: 37.759436, longitude: 126.780326 },
                { id: 'namjangju', name: '남양주점(북부)', latitude: 37.610477, longitude: 127.171199 }
            ];
        }		
		// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시
		// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

		// 지도에 로드뷰 정보가 있는 도로를 표시하도록 지도타입을 추가
		//map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);    

		// 아래 코드는 위에서 추가한 로드뷰 도로 정보 지도타입을 제거
		map.removeOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

		markerImageSize = new kakao.maps.Size(40, 42), // 마커 이미지의 크기
		markerImageOptions = {
			offset : new kakao.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		};
		
		//초기 세팅(수원점)
		var markerImage = new kakao.maps.MarkerImage(markerImageUrl,
				markerImageSize, markerImageOptions);
		
		var a1 = 37.277225; //경도 - 초기값 수원점으로 세팅
		var a2 = 127.027980; //위도 - 초기값 수원점으로 세팅
		var a3 = "수원점(새싹센터)"; //장소명
		
		//각 지점에 맞는 큰지도보기, 길찾기 적용		
		iwContent = '<div style="padding:5px;">'+a3+'<br><a href="https://map.kakao.com/link/map/'+a3+','+a1+','+a2+'" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/' + a3 + ',' + a1 + ',' + a2 + '" style="color:blue" target="_blank">길찾기</a></div>'; 
	    iwPosition = new kakao.maps.LatLng(a1, a2); //인포윈도우 표시 위치			
		
		// 지도에 마커를 생성하고 표시
		var marker = new kakao.maps.Marker({
			position : new kakao.maps.LatLng(a1, a2), //마커의 좌표
			image : markerImage, // 마커의 이미지
			map : map // 마커를 표시할 지도 객체
		});

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			position : iwPosition,
			content : iwContent
		});		
		// 마커 위에 인포윈도우를 표시. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됨
		infowindow.open(map, marker);	
 
		// 위치 정보 객체 배열
	    var locations = [
	        { id: 'suwon', name: '수원점(새싹센터)', latitude: 37.277225, longitude: 127.027980 },
	        { id: 'hwaseong', name: '화성점(남부)', latitude: 37.205758, longitude: 126.812688 },
	        { id: 'anseong', name: '안성점(남부)', latitude: 37.007868, longitude: 127.279859 },
	        { id: 'paju', name: '파주점(북부)', latitude: 37.759436, longitude: 126.780326 },
	        { id: 'namjangju', name: '남양주점(북부)', latitude: 37.610477, longitude: 127.171199 }
	    ];

	    function updateMap(categoryId, location) {
	        // 클릭된 카테고리에 대한 위치로 맵 이동
	        map.panTo(new kakao.maps.LatLng(location.latitude, location.longitude));

	        // 해당 위치에 마커 생성 및 표시
	        addMarkerAndInfoWindow(new kakao.maps.LatLng(location.latitude, location.longitude), categoryId, location);
	    }

	    function onClickCategory() {
	        var id = this.id; // 클릭된 카테고리의 id 가져오기
	        removeMarker(); // 기존의 마커들을 제거
	        var location = locations.find(loc => loc.id === id) || locations[0]; // 선택된 카테고리에 따라 위치 정보 설정
	        updateMap(id, location); // 공통 기능을 수행하는 함수 호출
	        changeCategoryClass(this); // 클릭된 카테고리에만 스타일을 적용
	        displayPlaceInfo(); // 지도정보 표시 함수호출
	    }

	    function displayPlaceInfo(place) {
	        // 마커 이미지를 생성
	        var markerImage = new kakao.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

	        // 초기값 수원점으로 세팅
	        var defaultLocation = { id: 'suwon', name: '수원점(새싹센터)', latitude: 37.277225, longitude: 127.027980 };
	        
	        // 각 카테고리 선택에 따라 위치/지점명 업데이트
	        var order = document.getElementById(currCategory).getAttribute('data-order');
	        var defaultLocation = { id: 'suwon', name: '수원점(새싹센터)', latitude: 37.277225, longitude: 127.027980 };
	        var location = locations.find(loc => loc.id === currCategory) || defaultLocation;

	        // 공통 기능을 수행하는 함수 호출
	        updateMap(currCategory, location);
	    }


		// 마커를 생성하고 지도 위에 마커를 표시하는 함수
		function addMarker(position, order) {
			var imageSize = new kakao.maps.Size(40, 42), 
			    imgOptions = {
				offset : new kakao.maps.Point(20, 42)
			}, markerImage = new kakao.maps.MarkerImage(markerImageUrl, imageSize, imgOptions), 
				marker = new kakao.maps.Marker({
				position : position,
				image : markerImage
			});

			marker.setMap(map);
			markers.push(marker);

			return marker;
		}
		//마커와 인포윈도우 추가하는 함수
		function addMarkerAndInfoWindow(position, order, location) {
		    var marker = addMarker(position, order);
		    var infowindow = createInfoWindow(position, location);
		    infowindow.open(map, marker);
		}
		//인포윈도우 생성하는 함수
		function createInfoWindow(position, location) {
		    return new kakao.maps.InfoWindow({
		        position: position,
		        content: '<div style="padding:5px;">' +
		            location.name +
		            '<br><a href="https://map.kakao.com/link/map/' + location.name + ',' +
		            location.latitude + ',' + location.longitude + '" style="color:blue" target="_blank">큰지도보기</a>' +
		            '<a href="https://map.kakao.com/link/to/' + location.name + ',' +
		            location.latitude + ',' + location.longitude + '" style="color:blue" target="_blank">&nbsp길찾기</a></div>'
		    });
		}

		// 지도에 마커를 표출하는 함수
		function displayPlaces(places) { // 몇번째 카테고리가 선택되어 있는지 얻어옴
			// 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용
			var order = document.getElementById(currCategory).getAttribute(
					'data-order');

			for (var i = 0; i < places.length; i++) { // 마커를 생성하고 지도에 표시
				var marker = addMarker(new kakao.maps.LatLng(places[i].y,places[i].x), order); // 마커와 검색결과 항목을 클릭 했을 때 장소정보를 표출하도록 클릭 이벤트를 등록
				(function(marker, place) {
					kakao.maps.event.addListener(marker, 'click', function() {
						displayPlaceInfo(place); //클릭한 마커에 대한 장소 상세정보 제공하는 함수
					});
				})(marker, places[i]);
			}
		}

		// 각 카테고리에 클릭 이벤트를 등록
		function addCategoryClickEvent() {
			var category = document.getElementById('category'), children = category.children;

			for (var i = 0; i < children.length; i++) {
				children[i].onclick = onClickCategory;
			}
		}

		// 지도 위에 표시되고 있는 마커를 모두 제거
		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		// 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수
		function changeCategoryClass(el) {
			var category = document.getElementById('category'), children = category.children, i;

			for (i = 0; i < children.length; i++) {
				children[i].className = '';
			}

			if (el) {
				el.className = 'on';
				displayPlaceInfo();
			}
		}

	</script>

	<!-- 내용 추가 -->
	<section style="margin-bottom:50%;">
		<div id="info1"> <span>교통이용안내</span> </div>
		<div id="transport">
			<div class="info2"> <span>버스 이용</span> </div>
			<div class="info2" style="margin-left:215px;"> <span>지하철이용</span> </div>	
			<div id="info3" style="width:410px; margin-left:330px; display:inline-block;">
				<ul>
					<br>
					<li id="placeinfo">수원점(새싹센터)</li>
					<li>일반버스 &nbsp &nbsp 10, 10-2, 10-5, 11-1, 13-4, 15-1, 20, 22</li>
					<li>마을버스 &nbsp &nbsp 1</li>
					<br>
					<li id="placeinfo">화성점</li>
					<li>일반버스 &nbsp &nbsp 999, H404, 50, 1001, H65</li>
					<li>광역버스 &nbsp &nbsp 1002, 1008</li>
					<br>
					<li id="placeinfo">안성점</li>
					<li>일반버스 &nbsp &nbsp 1150, 70, 370, 380, 1</li>
					<br>
					<li id="placeinfo">파주점</li>
					<li>일반버스 &nbsp &nbsp 9709, 9709A, 3, 11-2, 77-1, 92, 92-1</li>
					<li>마을버스 &nbsp &nbsp 021, 030, 032, 062, 064, 065, 066</li>
					<br>
					<li id="placeinfo">남양주점</li>
					<li>일반버스 &nbsp &nbsp 97, 93, 1-4, 1000, 1200, 1100</li>
				</ul> 

			</div>
			<div id="info4" style="width:450px; display:inline-block;">
				<ul>
					<br>
					<li id="placeinfo">수원점(새싹센터)</li>
					<li>분당선 &nbsp &nbsp 수인분당선 매교역 7번출구이용 도보 26분</li>
					<br>
					<li id="placeinfo">파주점</li>
					<li>경의중앙선 &nbsp &nbsp 문산역→파주역→월롱역→금촌역</li>
					<br>
					<li id="placeinfo">남양주점</li>
					<li>경춘선 &nbsp &nbsp 금곡역 하차 후 55번 버스 이용 남양주시청 하차</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>
					<li id="placeinfo">&nbsp</li>		
					<li id="placeinfo">&nbsp</li>	
				</ul>
			</div>
		</div>	
	</section>
	<%@ include file="./include/bottom.jsp"%>
</body>
</html>