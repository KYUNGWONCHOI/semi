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
  	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200..1000&family=Lugrasimo&display=swap" rel="stylesheet">
</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
	<div class="wrap">
	<div>
		<form class="joinwindow" id="frm-write">
			<table>
				<tr>
					<td class="inputdesc">아이디 :</td>
					<td>
						<div class="iputdiv"><input type="text" name="id" required autofocus id="id" class="inputline" placeholder="ID"></div>
						<div class="notice id">필수 입력 항목입니다.</div>
					</td>
					<td><button type="button" class="btn checkid">중복확인</button></td>
				</tr>							
				<tr>
					<td class="inputdesc">비밀번호 : </td>
					<td>
						<div class="iputdiv"><input type="password" name="pwd" required id="pw" class="inputline" placeholder="PASSWORD"></div>
						<div class="notice pw">필수 입력 항목입니다.</div>
						<div class="notice onfocus">영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자</div>
						<div class="notice blur">알맞은 비밀번호를 입력해 주세요.</div>
					</td>
					<td></td>
				</tr>				
				<tr>
					<td class="inputdesc">비밀번호 확인 : </td>
					<td>
						<div class="iputdiv"><input type="password" required id="pwcheck" class="inputline" placeholder="CONFIRM PASSWORD"></div>
						<div class="notice pwcheck">필수 입력 항목입니다.</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="inputdesc">E-Mail : </td>
					<td>
						<div class="iputdiv"><input type="text" name="memmail" required id="mail" class="inputline" placeholder="E-Mail"></div>
						<div class="notice mail">필수 입력 항목입니다.</div>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="inputdesc">사진 : </td>
					<td>
						<div class="iputdiv"><input type="file" name="memphoto" required class="btn file"></div>
						<div class="notice file">필수 입력 항목입니다.</div>
					</td>
					<td></td>
				</tr>				
			</table>
			<div class="joinbtn">
				<input type="button" class="btn join" value="회원가입">
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
			$(".btn.join").on("click", btnJoinSubmitClickHandler);
		}
		
		function btnCheckidClickHandler() {
			var idVal = $("[name=id]").val();
			var idLength = $("#id").val().length;
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
					} else{
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
		$("#pw").on("blur", function(){
			pwlength = $("#pw").val().length;
			if(pwlength < 8){
				$(".notice.blur").css("display","block");
			}else {
				$(".notice.blur").css("display","none");
			}
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
				$("#pwcheck").val("");
				$("#pw").focus();
			}
		});
		function btnJoinSubmitClickHandler(){
			console.log("@@");
			var frm = document.getElementById("frm-write");
			frm.method="post";
			frm.action ="${pageContext.request.contextPath }/join";
			frm.enctype="multipart/form-data";  // form 태그 내부에 input type="file"이 있다면
			frm.submit();	
		}
	</script>
</body>
</html>