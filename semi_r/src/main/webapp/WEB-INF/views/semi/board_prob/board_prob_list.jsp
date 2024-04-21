<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="prob grid">
<c:choose>
	<c:when test="${empty mapBoardProb.dtolist }">
	글 없음.
	</c:when>
	<c:otherwise>
	<div class="colname">Subject</div>
	<div class="colname">Sector</div>
	<div class="colname">Level</div>
	<div class="colname">Date</div>
	<div class="colname">ReadNo</div>
	<div class="colname">Id</div>
		<c:forEach items="${mapBoardProb.dtolist }" var="vo" varStatus="vs">
		<div>${vo.probSubject }</div>
		<div>${vo.probSector }</div>
		<div>${vo.probLevel }</div>
		<div>${vo.boardProbDate }</div>
		<div>${vo.boardProbReadNo }</div>
		<div>${vo.memberId }</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
</div>
<div><button type="button" class="btn write" >글쓰기</button></div>

<div >
	<ul>
	<c:if test="${mapBoardProb.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardProb.startPageNum-1 }">  &lt;&lt; </a></li>
	</c:if>
	<c:forEach begin="${mapBoardProb.startPageNum }" end="${mapBoardProb.endPageNum }" var="page">
		<c:if test="${mapBoardProb.currentPageNum == page }">
		<li><strong>${page }</strong></li>
		</c:if>
		<c:if test="${mapBoardProb.currentPageNum != page }">
		<li><a href="${pageContext.request.contextPath }/board?page=${page }">${page }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${mapBoardProb.endPageNum < mapBoardProb.totalPageCount }">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardProb.endPageNum+1 }">  &gt;&gt; </a></li>
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