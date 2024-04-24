<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="colname">인원</div>
	<div class="colname">예약하기</div>			
		<c:forEach items="${listLessonOneday }" var="vo" varStatus="vs">
			<div>${vs.count }</div>
			<div>입문</div>	
			<div>${vo.lessonTime }</div>	
			<div>${vo.lessonDay }</div>				
			<div>${vo.lessonCapacity }</div>
			<div><button>예약하기</button></div>
		</c:forEach>		
	</c:otherwise>
</c:choose>
</div>