<link href="<%=request.getContextPath()%>/resource/css/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_notice.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/board/board_prob_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/board/board_any_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/board/board_ask_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/board/board_lost_list.css" rel="stylesheet">
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>
    <title>게시판</title>

</head>

<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
    <div class="wrap">
        <section>
            <aside class="sidebar">
                <ul>
                    <li class="actlist activetab"><button>함께풀기</button></li>
                    <li class="actlist"><button>자유게시판</button></li>
                    <li class="actlist"><button>문의</button></li>
                    <li class="actlist"><button>분실물</button></li>
                </ul>
            </aside>
            <article class="tbl table1">
            	<h1>문제 게시판</h1>
                <%@include file="/WEB-INF/views/semi/board/board_prob_list.jsp" %>
            </article>
            <article class="tbl table2">
                <h1>자유게시판</h1>
                <%@include file="/WEB-INF/views/semi/board/board_any_list.jsp" %>
            </article>
            <article class="tbl table3">
                <h1>문의</h1>
                <%@include file="/WEB-INF/views/semi/board/board_ask_list.jsp" %>
            </article>
            <article class="tbl table4">
                <h1>분실물</h1>
                <%@include file="/WEB-INF/views/semi/board/board_lost_list.jsp" %>
            </article>
        </section>
    </div>

	<div>
		<%@include file="/WEB-INF/views/semi/common/footer.jsp" %>
	</div>
    <script>
        var tab = $(".sidebar > ul > li");
        var chart = $("section > article");

        $(".tbl").hide();
        $(".tbl.table1").show();

        tab.click(function () {
            var target = $(this);
            var indexNum = target.index();
            var none = $(this)
            chart.css("display", "none");
            chart.eq(indexNum).css("display", "block");

            $(".sidebar > ul >li").removeClass("activetab");
			$(this).addClass("activetab");			
		});
    </script>
</body>

</html>