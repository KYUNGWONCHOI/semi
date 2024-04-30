<link href="<%=request.getContextPath()%>/resource/css/common/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/common.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/common/page_bottom.css" rel="stylesheet">

<link href="<%=request.getContextPath()%>/resource/css/price/price.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/price/point.css" rel="stylesheet">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>price</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200..1000&family=Lugrasimo&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<jsp:include page="/WEB-INF/views/semi/common_function.jsp" />

</head>
<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp"%>
	</div>
	<div class="wrap">
		<section>
			<aside class="sidebar">
				<ul>
					<li class="actlist activetab"><button>요금</button></li>
					<li class="actlist"><button>충전</button></li>
				</ul>
			</aside>
			<article class="tbl table1">
				<h1>요금안내</h1>
				<%@include file="/WEB-INF/views/semi/price/price.jsp"%>
			</article>
			<article class="tbl table2">
				<h1>포인트 충전</h1>
				<%@include file="/WEB-INF/views/semi/price/point.jsp"%>
			</article>
			<div>
				<%@include file="/WEB-INF/views/semi/common/footer.jsp"%>
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

        $(".lesson_act").each(function (index, item) {
            $(this).on("click", function() {
                $(".tbl3").css("display", "none");
                $(".tbl3").eq(index).css("display", "block");
                console.log(index);
                $(".lesson_sort").css("background-color","brown");

            })   
        });

        /*  */

    </script>
</body>
</html>