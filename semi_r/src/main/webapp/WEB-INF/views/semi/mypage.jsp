<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_home.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
		[["${sssLogin }"]]
	<form>
	
	</form>
	<div>
		<%@include file="/WEB-INF/views/semi/common/footer.jsp" %>
	</div>
</body>
</html>