<link href="<%=request.getContextPath()%>/resource/css/reset.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_announce.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/notice/notice_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_header.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/page_bottom.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/lesson/lesson_oneday_list.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resource/css/lesson/lesson_weekend_list.css" rel="stylesheet">

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>

    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <jsp:include page="/WEB-INF/views/semi/common_function.jsp"/>


</head>

<body>
	<div>
		<%@include file="/WEB-INF/views/semi/common/header.jsp" %>
	</div>
    <div class="wrap">
        <section>
            <aside class="sidebar">
                <ul>
                    <li class="actlist activetab"><button>공지</button></li>
                    <li class="actlist"><button>운영시간</button></li>
                    <li class="actlist">
                        <div class="lesson_detail">
                            <button class="lesson_sort">강습안내</button>
                            <div class="lesson_show">
                                <a href="#" class="lessonbtn lesson_act">일일강습(원데이체험)</a>
                                <a href="#" class="lesson_act">평일</a>
                                <a href="#" class="lesson_act">주말</a>
                            </div>
                        </div>
                    </li>
                </ul>
            </aside>
            <article class="tbl table1" id="ann_notice">
            	<%@include file="/WEB-INF/views/semi/notice/notice_list.jsp" %>
            </article>
            <article class="tbl table2" id="ann_openhour">
                <img class="img_gym" src="/semi/resource/img/img2_gangnam.jpg" alt="gym">
                <div class="openhour_con">
                    <h1>오시는 길</h1>
                    <ul>
                        <li>서울특별시 강남구 테헤란로8길 21 강남화인빌딩 지하 1층</li>
                        <li>강남역 1번 출구 도보 4분 거리</li>
                    </ul>
                    <h1 id="openhour_gap">운영안내</h1>
                    <ul>
                        <li>평일</li>
                        <li>토요일</li>
                        <li>주말 & 공휴일</li>
                    </ul>
                </div>
                <div class="loc_map">
                    <img src="/semi/resource/img/img1.jpg" alt="map">
                </div>

            </article>
            <article class="tbl table3" id="ann_price">
                <div class="tbl3">
                    <div class="class_day">
                        <h1>일일클래스</h1>
                        <div>
                            <div class="hd">일일 체험 강습 프로그램 진행과정</div>
                            <img class="lesson_onedayiimg" src="/semi/resource/img/lessson_img.jpg" alt="onedayclass">
                        </div>
                        <div class="divline"><hr></div>
                        <div>
                            <div class="hd">일일 체험 강습 안내</div>
                            <table class="class_day_tbl" border="1">
                            <tr>
                                <th>준비물</th>
                                <th>금액</th>
                                <th>구성</th>
                            </tr>
                            <tr>
                                <td>움직임 편안한 운동복</td>
                                <td rowspan="3">30,000</td>
                                <td>체험강습</td>
                            </tr>
                            <tr>
                                <td>개인양말</td>
                                <td>전용 암벽화 대여</td>
                            </tr>
                            <tr>
                                <td>샤워시 개인 수건</td>
                                <td>일일 자유이용권 포함</td>
                            </tr>
                            </table>                            
                        </div>
                        <%@include file="/WEB-INF/views/semi/lesson/lesson_oneday.jsp" %>
                        <button>예약하기</button>
                    </div>
                </div>
                <div class="tbl3">
                    <div class="class_weekday">
                        <h1>평일</h1>
                        <div>
                            <span>클라이밍 레벨을 한 단계 업그레이드 하고 싶으시다면,
                                강습을 선택하세요!!</span>
                        </div>
                        <div>
                            <%@include file="/WEB-INF/views/semi/lesson/lesson_list_weekday.jsp" %>
                        </div>
                        <button>예약하기</button>
                    </div>
                </div>
                <div class="tbl3">
                    <div class="class_weekend">
                        <h1>주말</h1>
                        <div>
                            <span>클라이밍 레벨을 한 단계 업그레이드 하고 싶으시다면,
                                강습을 선택하세요!!</span>
                        </div>
                        <div>
                            <%@include file="/WEB-INF/views/semi/lesson/lesson_list_weekend.jsp" %>
                        </div>
                        <button>예약하기</button>
                    </div>
                </div>
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
       
        $(".lesson_act").each(function (index, item) {
            $(this).on("click", function() {
                $(".tbl3").css("display", "none");
                $(".tbl3").eq(index).css("display", "block");
                console.log(index);
                $(".lesson_sort").css("background-color","brown");
               })   
        });
    </script>

</body>
</html>