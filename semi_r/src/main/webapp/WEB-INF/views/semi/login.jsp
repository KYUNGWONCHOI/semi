<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Semim Login</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>
</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
<fieldset>
	<legend>로그인</legend>
	<form id="frm-login">
		<div><label>아이디</label><input type="text" name="id"></div>
		<div><label>패스워드</label><input type="password" name="pwd"></div>
		<div><input type="button" value="로그인" class="btn submit"></div>
	</form>
</fieldset>
	<div>
		<%@include file="/WEB-INF/views/semi/common/footer.jsp" %>
	</div>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$("#frm-login .btn.submit").on("click", frmClickHandler);
}

function frmClickHandler(){
	//console.log(document.getElementById("frm-login").serialize());
	console.log($("#frm-login").serialize()); // query string 형태로 만들어줌.// id=sss&pwd=vvv
	//{id : $("[name=id]").val() , pwd : $("[name=pwd]").val()  }	
	//$("#frm-login").serialize()
	$.ajax({
		url:"${pageContext.request.contextPath }/login"
		, method : "post"
		, data : $("#frm-login").serialize()
		, error : ajaxErrorHandler
		, success : function(result){
			console.log(result);
			if(result == 1 ){
				alert("반갑습니다.");
				var prePage = "${prePage}";
				if(prePage == "write"){
					location.href="${pageContext.request.contextPath}/board/write";
				}
				location.href="${pageContext.request.contextPath}/main";
			}else {
				alert("아이디 또는 패스워드가 일치하지 않습니다.\n다시 확인하고 로그인해주세요.");
				$("[name=pwd]").val("");
			}
		}
	});
	
}

</script>

</body>
</html>
