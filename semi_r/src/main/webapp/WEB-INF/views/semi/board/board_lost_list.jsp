<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="lost grid">
<c:choose>
	<c:when test="${empty mapBoardLost.dtolist }">
	글 없음.
	</c:when>
	<c:otherwise>

		<c:forEach items="${mapBoardLost.dtolist }" var="vo" varStatus="vs">
		<div>${vo.baordNo }</div>
		<div>${vo.lostSubject }</div>
		<div>${vo.boardDate }</div>
		<div>${vo.fileSavePath }</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
</div>
<div><button type="button" class="btn write" >글쓰기</button></div>

<div >
	<ul>
	<c:if test="${mapBoardLost.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardLost.startPageNum-1 }">  &lt;&lt; </a></li>
	</c:if>
	<c:forEach begin="${mapBoardLost.startPageNum }" end="${mapBoardLost.endPageNum }" var="page">
		<c:if test="${mapBoardLost.currentPageNum == page }">
		<li><strong>${page }</strong></li>
		</c:if>
		<c:if test="${mapBoardLost.currentPageNum != page }">
		<li><a href="${pageContext.request.contextPath }/board?page=${page }">${page }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${mapBoardLost.endPageNum < mapBoardLost.totalPageCount }">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardLost.endPageNum+1 }">  &gt;&gt; </a></li>
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