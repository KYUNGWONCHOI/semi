<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[["${sssLogin }"]]
<form id="frm-lesson">
	<div class="lesson grid">
		<c:choose>
			<c:when test="${empty listLessonOneday }">
		수업 없음
		</c:when>
			<c:otherwise>
				<div></div>
				<div class="colname">No</div>
				<div class="colname">강습 난이도</div>
				<div class="colname">강습 시간</div>
				<div class="colname">강습 요일</div>
				<div class="colname">인원</div>
				<c:forEach items="${listLessonOneday }" var="vo" varStatus="vs">
					<div><label><input type="radio" name="classNo" value="${vs.count}"></label></div>
					<div>${vs.count }</div>
					<div>체험강습</div>
					<div>${vo.lessonTime }</div>
					<div>${vo.lessonDay }</div>
					<div>${vo.lessonCapacity } / 5</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<button type="button" class="btn book">예약하기</button>
	</div>
</form>
<script>

	$(loadedHandler);
		function loadedHandler(){
			
			//event 등록
			$(".btn.book").on("click", btnBookClickHandler);
	}
	function btnBookClickHandler(){
		if(checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?","bookOnedayClass")){
			return false;
		}	
		$.ajax({
			async : false,
			url : "${pageContext.request.contextPath }/lesson",
			method : "post",
			data : $("#frm-lesson").serialize(),
			error : ajaxErrorHandler,
			success : function(result) {
				console.log("Ajax result : " + result);
				console.log("${sssLogin.memId}");
				var tabmenu = "${param.tabmenu}";
				
			}

		});
		
	}


</script>
