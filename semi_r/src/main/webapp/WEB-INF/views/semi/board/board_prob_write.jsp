<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_announce.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semim Board Write</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>
</head>


<body>
[["${sssLogin }"]]

<div>
	<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
</div>
<h1>Semim Board Write</h1>
${sssLogin.memId }
<form id="frm-write">	
	<div>
		<label>문제<input type="radio" name="pos" value=0 checked></label>
		<label>자유<input type="radio" name="pos" value=1></label>
		<label>문의<input type="radio" name="pos" value=2></label>
	</div>
	<div><label>제목</label><input type="text" name="subject" required></div>
	<div><label>내용</label><textarea name="content" required></textarea></div>
	<div><label>섹터</label><input type="text" name="sector" required></div>
	<div><label>난이도</label><input type="text" name="level" required></div>
	<input type="hidden" name="memId" value="${sssLogin.memId }">
	<div><button type="button" class="btn file">파일추가</button></div>	
	<!-- event click 시 추가됨 -->
	<div><button type="button" class="btn write" >글쓰기</button></div>
</form>
<div>
	<%@include file="/WEB-INF/views/semi/common/footer.jsp" %>
</div>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click", btnWriteClickHandler);
	$(".btn.file").on("click", btnFileClickHandler);
}
function btnFileClickHandler(){
	var htmlVal =`<div><input type="file" name="uploadfiles" required><button type="button" class="btn file-cancle">취소</button></div> `;
	$(this).parent().after(htmlVal);
	
	// JS 중요! Event 등록시 중복 등록됨을 방지함.
	$(".btn.file-cancle").off("click");
	$(".btn.file-cancle").on("click", btnFileCancleClickHandler);
}
function btnFileCancleClickHandler(){
	console.log("btnFileCancleClickHandler");
	// 중요!
	$(this).parent().remove();
	
}
function btnWriteClickHandler(){
	
	//Login 페이지로 이동

	console.log($("[name=content]").val().length);  // 사용자 입력값은 value가 진짜임.
	console.log($("[name=content]").val().trim().length);
	
	if($("[name=subject]").val().trim().length == 0){
	   alert("빈문자열만 입력할 수 없습니다. 제목을 작성해주세요.");
	   return;
    }
	if($("[name=content]").val().trim().length == 0){
	   alert("빈문자열만 입력할 수 없습니다. 내용을 작성해주세요.");
	   return;
	}
	// 중요!
	var frm = document.getElementById("frm-write");
	frm.method="post";  // content 길이 길거라..
	frm.action = "${pageContext.request.contextPath}/board/write";
	frm.enctype="multipart/form-data";  // form 태그 내부에 input type="file"이 있다면
	frm.submit();	
}
</script>
</body>
</html>
