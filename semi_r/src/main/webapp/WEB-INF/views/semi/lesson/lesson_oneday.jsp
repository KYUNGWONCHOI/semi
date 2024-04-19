<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [[${listLessonOneday }]] --%>
<div class="lesson grid">
<c:choose>
	<c:when test="${empty listLessonOneday }">
	수업 없음
	</c:when>
	<c:otherwise>
	<div class="colname">No</div>
	<div class="colname">강습 난이도</div>	
	<div class="colname">강습 시간</div>	
	<div class="colname">강습 요일</div>			
		<c:forEach items="${listLessonOneday }" var="vo" varStatus="vs">
			<div>${vs.count }</div>
			<div>${vo.lessonLevel }</div>	
			<div>${vo.lessonTime }</div>	
			<div>${vo.lessonDay }</div>				
		</c:forEach>		
	</c:otherwise>
</c:choose>
</div>