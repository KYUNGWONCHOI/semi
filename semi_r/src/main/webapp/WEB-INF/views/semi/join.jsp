<link href="<%=request.getContextPath()%>/resource/css/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/join.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp" />
</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
	<div class="wrap">
	<div>
		<form action="${pageContex.request.contextPath }/join" method="post" class="joinwindow">
			<div>
				ID : <input type="text" name="id" required>
				<button type="button" class="btn checkid">중복확인</button>
			</div>
			<div>
				PW : <input type="password" name="pwd" required>
			</div>
			<div>
				<input type="file" name="memphoto" required class="btn file">
			</div>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>
	</div>
	<div>
		<%@include file="/WEB-INF/views/semi/common/footer.jsp" %>
	</div>

	<script>
		$(loadedHandler);
		function loadedHandler() {
			$(".btn.checkid").on("click", btnCheckidClickHandler);
		}

		function btnCheckidClickHandler() {
			console.log("A");
			var idVal = $("[name=id]").val();
			$.ajax({
				async : false,
				url : "${pageContext.request.contextPath }/checkid",
				method : "post",
				data : {
					cid : $("[name=id]").val()
				},
				error : ajaxErrorHandler,
				success : function(result) {
					console.log(result);
					if (result > 0) {
						alert("사용불가!! 다른아이디를 사용해주세요.");
					} else {
						alert("사용가능");
					}
				}

			});
		}
	</script>
</body>
</html>