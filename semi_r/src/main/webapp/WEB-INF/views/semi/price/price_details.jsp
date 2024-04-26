
<link href="<%=request.getContextPath()%>/resource/css/price/price_details.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div class="modal">
		<div class="modal_body">
			<h2>모달창 제목</h2>
			<p>모달창 내용</p>
			<button type="button" class="btn close-modal">Modal 닫기</button>
		</div>
	</div>
	<button type="button" class="btn open-modal">Modal열기</button>
	
	
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.open-modal").on("click", btnOpenModalClickHandler);
	$(".btn.close-modal").on("click", btnCloseModalClickHandler);
}

function btnOpenModalClickHandler() {
	$(".modal").css("display","flex");		
}
function btnCloseModalClickHandler() {
	$(".modal").css("display","none");		
}

   </script>
</body>
</html>