<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="frm-lessonend">
	<div class="lessonend grid">
	<c:choose>
		<c:when test="${empty listLessonWeekend }">
		수업 없음
		</c:when>
		<c:otherwise>
			<div></div>
			<div class="colname">No</div>
			<div class="colname">난이도</div>
			<div class="colname">시작일</div>
			<div class="colname">기간</div>
			<div class="colname">끝나는 날</div>
			<div class="colname">강사</div>
			<div class="colname">강습시간</div>
			<div class="colname">강습요일</div>	
			<div class="colname">인원</div>	
			<c:forEach items="${listLessonWeekend }" var="vo" varStatus="vs">
				<c:choose>
					<c:when test="${vo.lessonCapacity eq 5}">
						<div><label><input type="radio" name="lessonNo" value="${vo.lessonCode}" disabled></label></div>
					</c:when>
					<c:otherwise>
						<div><label><input type="radio" name="lessonNo" value="${vo.lessonCode}"></label></div>
				</c:otherwise>
				</c:choose>
				<div>${vs.count }</div>
				<div>${vo.lessonLevel }</div>	
				<div>${vo.lessonStart }</div>	
				<div>${vo.lessonDuration }</div>	
				<div>${vo.lessonEnd }</div>	
				<div>${vo.teacherName }</div>	
				<div>${vo.lessonTime }</div>	
				<div>${vo.lessonDay }</div>
				<c:choose>
					<c:when test="${vo.lessonCapacity eq 5}">
						<div class="ended lesson">마감</div>
					</c:when>
					<c:otherwise>
						<div>${vo.lessonCapacity } / 5</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>		
		</c:otherwise>
	</c:choose>
	</div>
	<div>
		<button type="button" class="btn bookend">예약하기</button>
	</div>
</form>
<script>

	$(loadedHandler);
		function loadedHandler(){
			//event 등록
			$(".btn.bookend").on("click", btnEndBookClickHandler);
	}
	function btnEndBookClickHandler(){
		if(checkLogin("로그인되어야 예약이 가능합니다.\n로그인페이지로 이동하시겠습니까?","bookWeekendClass")){
			return false;
		}	
		$.ajax({
			async : false,
			url : "${pageContext.request.contextPath }/lesson",
			method : "post",
			data : $("#frm-lessonend").serialize(),
			error : ajaxErrorHandler,
			success : function(result) {
				console.log("Ajax result : " + result);
				console.log("${sssLogin.memId}");
				var tabmenu = "${param.tabmenu}";
				
			}
		});		
		location.href="${pageContext.request.contextPath}/notice?tabmenu=2";
	}


</script>
