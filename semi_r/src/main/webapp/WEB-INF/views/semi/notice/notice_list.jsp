<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<h1>Semim Board List</h1>
	
<div><button type="button" class="btn write" >글쓰기</button></div>
<div class="notice grid">
<c:choose>
	<c:when test="${empty mapNotice.dtolist }">
	글 없어요.
	</c:when>
	<c:otherwise>
		<div>no</div>
		<div>b</div>
		<div>c</div>
		<div>c</div>
		<div>c</div>
		<c:forEach items="${mapNotice.dtolist }" var="vo" varStatus="vs">
			<div>${vo.noticeNo }</div>
			<div><a href="${pageContext.request.contextPath }/notice/read?id=${vo.noticeNo }">${vo.noticeSubject }</a></div>
			<div>${vo.boardDate }</div>
			<div>${vo.baordReadNo }</div>
			<div>${vo.noticeType }</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
</div>

<div >
	<ul>
	<c:if test="${mapNotice.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/notice?page=${mapNotice.startPageNum-1 }">  &lt;&lt; </a></li>
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
		<li><a href="${pageContext.request.contextPath }/notice?page=${mapNotice.endPageNum+1 }">  &gt;&gt; </a></li>
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
