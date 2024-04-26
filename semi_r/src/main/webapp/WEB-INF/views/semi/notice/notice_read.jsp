<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css"	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/notice/notice_read.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/notice/notice_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_notice.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semi Notice Read</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp" />
<%-- [[${sssLogin.memAdmin }]] --%>
</head>
<body>
console.log("notice_read.jsp");
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp"%>
	</div>
	<div class="wrap">
		<section class="flag">
			<div><button class="btn back"><img src="#" alt="back"></button></div>
			<article class="tbl table1" id="ann_notice">
				<h1>Semi Notice Read</h1>
				<div class="board grid">
					<div class="flex">
						<div>${dto.noticeNo }</div>
						<div>${dto.noticeSubject }</div>
						<%-- 
						<div>${dto.noticeContent }</div>
						 --%>
						<div>${dto.boardDate }</div>
						<div>${dto.boardReadNo }</div>
					</div>
				</div>
				<div>${dto.noticeContent }</div>
				<c:if test="${not empty dto.fileDtoList }">
					<div>
						<c:forEach items="${dto.fileDtoList }" var="filedto">
							<div>
								<a
									href="${pageContext.request.contextPath }/notice_list/${filedto.fileSavePath}" download="">${filedto.fileOriginName }</a>
							</div>
						</c:forEach>
					</div>
				</c:if>
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
 		location.href="${pageContext.request.contextPath}/notice";
 	}
 	function btnBackClickHandler(){
 		
 		const referrerUrl = document.referrer;
 		var result = referrerUrl.includes("tabmenu");
 		console.log(result);
 		if(result){
	 		const idx = referrerUrl.indexOf("?");
	 		var pageUrlWoQueryString = referrerUrl.substring(0, idx);
	 		location.href = pageUrlWoQueryString; 			
 		}else{
 			location.href = referrerUrl;
 		}
 	}
     
     
	</script>
</body>
</html>
