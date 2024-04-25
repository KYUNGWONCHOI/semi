<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

function checkLogin(msg,prePage){
	//Login 페이지로 이동
	var sslogin = "${sssLogin }";  // EL 은 ""안에 작성되어 blank 상황에 문법적 오류 발생을 방지함.
	if ( !sslogin ) {
		var result = confirm(msg);
		if( result ){
			console.log(prePage);
			location.href="${pageContext.request.contextPath}/login?aaa="+prePage;
		}
		return true;
	}
	return false;
}


</script>