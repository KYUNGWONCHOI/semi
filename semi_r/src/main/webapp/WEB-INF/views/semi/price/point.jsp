<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="frm-charging">
	<div class="point grid">
		<div><label>10,000<input type="radio" class="amount" name="charge" value="10000"></label></div>
		<div><label>20,000<input type="radio" class="amount" name="charge" value="20000"></label></div>
		<div><label>50,000<input type="radio" class="amount" name="charge" value="50000" checked></label></div>
		<div><label>90,000<input type="radio" class="amount" name="charge" value="90000"></label></div>
		<div><label>130,000<input type="radio" class="amount" name="charge" value="130000"></label></div>
		<div><label>170,000<input type="radio" class="amount" name="charge" value="170000"></label></div>
		<div><label>200,000<input type="radio" class="amount" name="charge" value="200000"></label></div>
		<div><label>330,000<input type="radio" class="amount" name="charge" value="330000"></label></div>
	</div>
	<div class="confirmbtn">
		<button type="button" class="confirm">충전하기</button>
	</div>
</form>

<script>
	$(loadedHandler);
	function loadedHandler() {
		$(".confirm").on("click", checkAmountClickHandler);
	}
	function checkAmountClickHandler() {
		if (checkLogin("로그인되어야 글쓰기가 가능합니다.\n로그인페이지로 이동하시겠습니까?",
				"bookOnedayClass")) {
			return false;
		}
		
		$.ajax({
			async : false,
			url : "${pageContext.request.contextPath }/charge",
			method : "post",
			data : $("#frm-charging").serialize(),
			error : ajaxErrorHandler,
			success : function(result) {
				
			}
		});
		var temp ="${cResult }";
		console.log(temp);
		console.log("${cResult }");
		console.log(${cResult });
		location.href = "${pageContext.request.contextPath}/price";
	}
</script>