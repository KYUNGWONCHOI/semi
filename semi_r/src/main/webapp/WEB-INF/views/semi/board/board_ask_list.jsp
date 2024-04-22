<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="ask grid">
<c:choose>
	<c:when test="${empty mapBoardAsk.dtolist }">
	글 없음.
	</c:when>
	<c:otherwise>
	<div class="colname">No</div>
	<div class="colname">Subject</div>
	<div class="colname">Date</div>
	<div class="colname">ReadNo</div>
	<div class="colname">PW View</div>	
	<div class="colname">Id</div>
		<c:forEach items="${mapBoardAsk.dtolist }" var="vo" varStatus="vs">
		<div>${vo.boardAskNo }</div>
		<div>${vo.askSubject }</div>
		<div>${vo.boardAskDate }</div>
		<div>${vo.boardAskReadNo }</div>
		<div>${vo.askPwnYn }</div>
		<div>${vo.memberId }</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
</div>
<div><button type="button" class="btn write" >글쓰기</button></div>

<div >
	<ul>
	<c:if test="${mapBoardAsk.startPageNum > 1}">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardAsk.startPageNum-1 }">  &lt;&lt; </a></li>
	</c:if>
	<c:forEach begin="${mapBoardAsk.startPageNum }" end="${mapBoardAsk.endPageNum }" var="page">
		<c:if test="${mapBoardAny.currentPageNum == page }">
		<li><strong>${page }</strong></li>
		</c:if>
		<c:if test="${mapBoardAsk.currentPageNum != page }">
		<li><a href="${pageContext.request.contextPath }/board?page=${page }">${page }</a></li>
		</c:if>
	</c:forEach>
	<c:if test="${mapBoardAsk.endPageNum < mapBoardAny.totalPageCount }">
		<li><a href="${pageContext.request.contextPath }/board?page=${mapBoardAsk.endPageNum+1 }">  &gt;&gt; </a></li>
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