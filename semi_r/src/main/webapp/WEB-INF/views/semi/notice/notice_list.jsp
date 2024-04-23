<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Semim Notice List</h1>
<div>${sssLogin.memId }</div>
<div>${sssLogin.memAdmin }</div>
	
<div class="notice grid">
<c:choose>
	<c:when test="${empty mapNotice.dtolist }">
	글 없어요.
	</c:when>
	<c:otherwise>
		<div class="colname">No</div>
		<div class="colname">Subject</div>
		<div class="colname">Date</div>
		<div class="colname">ReadNo</div>
		<c:forEach items="${mapNotice.dtolist }" var="vo" varStatus="vs">
			<c:if test="${vo.noticeType eq 1 }"> 
				<div>공지</div>
				<div><a href="${pageContext.request.contextPath }/notice/read?id=${vo.noticeNo }">${vo.noticeSubject }</a></div>
				<div>${vo.boardDate }</div>
				<div>${vo.baordReadNo }</div>
			</c:if>
		</c:forEach>
		<c:forEach items="${mapNotice.dtolist }" var="vo" varStatus="vs">
			<c:if test="${vo.noticeType eq 2 }">
				<div>${vo.noticeNo }</div>
				<div><a href="${pageContext.request.contextPath }/notice/read?id=${vo.noticeNo }">${vo.noticeSubject }</a></div>
				<div>${vo.boardDate }</div>
				<div>${vo.baordReadNo }</div>
			</c:if>
		</c:forEach>
	</c:otherwise>
</c:choose>
</div>
<c:if test="${sssLogin.memAdmin eq 0 }">
	<div><button type="button" class="btn write" >글쓰기</button></div>
</c:if>


<div >
	<ul>
	<c:if test="${mapNotice.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/notice?page=${mapNotice.startPageNum-1 }"> &lt;&lt; </a></li>
	</c:if>
	<c:forEach begin="${mapNotice.startPageNum }" end="${mapNotice.endPageNum }" var="page">
		<c:if test="${mapNotice.currentPageNum == page }">
		<li><strong>${page }</strong></li>
		</c:if>
		<c:if test="${mapNotice.currentPageNum != page }">
		<li><a href="${pageContext.request.contextPath }/notice?page=${page }">${page }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${mapNotice.endPageNum < mapNotice.totalPageCount }">
		<li><a href="${pageContext.request.contextPath }/notice?page=${mapNotice.endPageNum+1 }"> &gt;&gt; </a></li>
	</c:if>
	</ul>
</div>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.write").on("click", btnWriteClickHandler);
}

function btnWriteClickHandler(){
	
	//Login 페이지로 이동
	if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","write")){
		return;
	}
	
	location.href="${pageContext.request.contextPath}/notice/write";
}
</script>
