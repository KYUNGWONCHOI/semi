<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css"	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/notice/notice_read.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/notice/notice_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_notice.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/board/board_prob_read.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp" />
</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp"%>
	</div>
	<div class="wrap">
		<section class="flag">
			<div><button class="btn back"><img src="#" alt="back"></button></div>
			<article class="tbl table1" id="ann_board">
				<h1>Semi Notice Read</h1>
				<div class="board grid">
					<div class="flex">
						<div>${dto.boardProbNo }</div>
						<div>${dto.probSubject }</div>
						<div>${dto.probSector }</div>
						<div>${dto.probLevel }</div>
						<div>${dto.boardProbDate }</div>
						<div>${dto.boardProbReadNo }</div>
						<div>${dto.memberId }</div>
					</div>
				</div>
				<c:if test="${not empty dto.videoDtoList }">
					<div>
						<c:forEach items="${dto.videoDtoList }" var="filedto">
							<div>
								<video class="vid" src="${pageContext.request.contextPath }/problem_video/${filedto.videoSaveName}" autoplay></video>							
							</div>
						</c:forEach>
					</div>
				</c:if>
				<div>${dto.probContent }</div>
			</article>
		</section>
	</div>
	<div>
		<%@include file="/WEB-INF/views/semi/common/footer.jsp"%>
	</div>
	<script>
	 var tab = $(".sidebar > ul > li button");
     var chart = $("section > article");
     
     $(loadedHandler);
 	function loadedHandler() {
 		tab.on("click", btnClickHandler);
 		$(".btn.back").on("click", btnBackClickHandler);
 	}
 	
 	function btnClickHandler(){
 		location.href="${pageContext.request.contextPath}/board";
 	}
 	function btnBackClickHandler(){
 		location.href = document.referrer;
 	}
     
     
	</script>
</body>
</html>