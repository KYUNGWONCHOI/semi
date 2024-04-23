<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [[${listLessonOneday }]] --%>
<div class="lessonday grid">
<c:choose>
	<c:when test="${empty listLessonWeekend }">
	수업 없음
	</c:when>
	<c:otherwise>	
	<div class="colname">No</div>
	<div class="colname">난이도</div>
	<div class="colname">시작일</div>
	<div class="colname">기간</div>
	<div class="colname">끝나는 날</div>
	<div class="colname">강사</div>
	<div class="colname">강습시간</div>
	<div class="colname">강습요일</div>
		<c:forEach items="${listLessonWeekend }" var="vo" varStatus="vs">
			<div>${vs.count }</div>
			<div>${vo.lessonLevel }</div>	
			<div>${vo.lessonStart }</div>	
			<div>${vo.lessonDuration }</div>	
			<div>${vo.lessonEnd }</div>	
			<div>${vo.teacherName }</div>	
			<div>${vo.lessonTime }</div>	
			<div>${vo.lessonDay }</div>			
		</c:forEach>		
	</c:otherwise>
</c:choose>
</div>