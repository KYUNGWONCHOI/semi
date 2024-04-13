<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
<h1>Join</h1>

<form action="${pageContext.request.contextPath}/join" method="post">
<div>ID : <input type="text" name="id"><button type="button" class="btn checkid">중복확인</button></div>
<div>PW : <input type="password" name="pwd"></div>
<div>email : <input type="text" name="email"></div>
<div><button type="submit">회원가입</button></div>
</form>

<div class="member-list">
	
</div>


<!-- 스크립트 위치 -->
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록, btn click
	$(".btn.checkid").on("click", btnCheckidClickHandler);
}

function btnCheckidClickHandler(){
	//id 에 있는 값 꺼내기
	var idVal = $("[name=id]").val();
	//중복확인
	//ajax 메소드, 매개인자로 1 덩어리 입력 / form tag 대체 url(action), method, input,..., submit
	$.ajax({ 
		//async:"true"; 
		//true: 비동기 / false : 동기
		url:"${pageContext.request.contextPath}/checkid"
		//ajax 에서 id, pwd, 등 값을 읽어올 수 없으므로 controller 서블릿 만들어 사용
		, method:"post"
		, data: {id:$("[name=id]").val(), k1:"v1"}
		//data의 type 은 contentType 으로 수정
		
		, dataType : "json"
		//dataType 은 아래 success 의 result 자료형을 의미
		//dataType 의 T 대문자
		
		//data 에서 값을 받는 "id" 가 controller 에 사용됨 ','사용해서 여러 값 입력 가능
		, success : function(result){
			console.log(result);
			console.log("ok");
			console.log(typeof result);
			if(result > 0){
				alert("사용불가 다른 아이디 시도");
			} else{
				alert("사용가능합니다.");
			}
			
		}
			//String > dataType으로 json으로 변경
			
			/* 
			var htmlVal = '';			
			$.each(result, function(){
				console.log(this);
				console.log(this.memEmail);
				
				htmlVal += '<div>'+this.memEmail+'</div>';
			});
			$(".memver-list").html(htmlVal);
		} 
		*/
		, error : function(request,status,error){
			alert("code:"+request.status+"\n"+"message:"
					+ request.responseText + "\n"
					+ "error:"+error);
			}
		});
}
</script>

</body>
</html>