<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/join.css" rel="stylesheet">

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
				<label>아이디 : <input type="text" name="id" required autofocus id="id" class="inputline"></label>
				<button type="button" class="btn checkid">중복확인</button>
				<div class="notice id">필수 입력 항목입니다.</div>
			</div>
			<div>
				<label>비밀번호 : <input type="password" name="pwd" required id="pw" class="inputline"></label>
			</div>
			<div class="notice pw">필수 입력 항목입니다.</div>
			<div class="notice onfocus">영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자</div>
			<div>
				<label>비밀번호 확인 : <input type="password" name="pwd" required id="pwcheck" class="inputline"></label>
			</div>
			<div class="notice pwcheck">필수 입력 항목입니다.</div>
			<div>
				<label>E-Mail : <input type="text" name="memmail" required id="mail" class="inputline"></label>
			</div>
			<div class="notice mail">필수 입력 항목입니다.</div>
			<div>
				<label>사진 : <input type="file" name="memphoto" required class="btn file"></label>
			</div>
			<div class="notice file">필수 입력 항목입니다.</div>
			<div>
				<button type="submit" class="btn join">회원가입</button>
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
		$("#pw").on("focus", function() {
			id = $("#id").val();
			$(".notice.onfocus").css("display", "block");
			if ($("#pw").on("blur", function() {
				$(".notice.onfocus").css("display", "none");
			}))
				;
			if (id == '') {
				$(".notice.id").css("display", "block");
			} else {
				$(".notice.id").css("display", "none");
			}
		});
		//TODO
		$("#pw").on("blur", function(){
			pwlength = $("#pw").length;
			console.log(pwlength);
		});
		$("#pwcheck").on("focus", function() {
			pw = $("#pw").val();
			if (pw == '') {
				$(".notice.pw").css("display", "block");
			} else {
				$(".notice.pw").css("display", "none");
			}
		});
		$("#mail").on("focus", function() {
			pwcheck = $("#pwcheck").val();
			if (pwcheck == '') {
				$(".notice.pwcheck").css("display", "block");
			} else {
				$(".notice.pwcheck").css("display", "none");
			}
		});

		$("#pwcheck").on("blur", function() {
			pwcheck = $("#pwcheck").val();
			if (!(pw == pwcheck)) {
				alert("비밀번호가 일치하지 않습니다.");
				//TO CHECK
				pw = '';
				pwcheck = '';
				$("#pw").focus();
			}
		});
	</script>
</body>
</html>