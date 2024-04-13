<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax JavaScript 방식</title>
</head>
<body>
<h1>Join</h1>
<h1>Ajax JS 방식</h1>
<form action="${pageContext.request.contextPath}/join" method="post">
<div>ID : <input type="text" name="id"><button type="button" class="btn checkid">중복확인</button></div>
<div>PW : <input type="password" name="pwd"></div>
<div>email : <input type="text" name="email"></div>
<div><button type="submit">회원가입</button></div>
</form>

<div class="member-list">
</div>


<!-- 
1. 객체 생성 : script문에 요청을 위한 XMLHttpRequest객체 생성
2. 서버 응답 처리 함수 생성 및 지정(onreadystatechange에 함수 지정) 지정되는 함수에 포함될 내용
	1) 응답 상태 확인 readyState(서버 응답 상태 확인) / status(Http응답 상태 코드 확인)
	2) 응답 완료(서버 응답 데이터 접근) responseText / responseXML
3. open()메소드 호출하여 요청 방식, 대상(서버), 동기/비동기 지정
4. send()메소드 호출하여 대상(서버)에 전송 
-->
<script>
var req = new XMLHttpRequest();
//객체 생성 : script문에 요청을 위한 XMLHttpRequest객체 생성

req.onreadystatechange = function(){
	console.log("@@ 서버에서 응답이 들어오면 호출됨 - 여러번");
	console.log(req.readyState);
	//@@ readystate 의 변화만큼 들옴
	
	if(req.readyState == 4 && req.status == 200){
		//success
		//console.log("aa");
		console.log(req.responseText);
	}else{
		//error
		console.log("error");
	}
	
};

req.open("post", "${pageContext.request.contextPath}//ajax/test", true);
//req객체에 전송할 준비. open()메소드 호출하여 요청 방식, 대상(서버), 동기/비동기 지정

req.send();
//send()메소드 호출하여 대상(서버)에 전송

</script>
</body>
</html>