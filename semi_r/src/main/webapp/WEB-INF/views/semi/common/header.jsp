<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div>
        <header class="wrap-header">
            <div class="showCurrPage">
                <div class="pageLocation"><a href="${pageContext.request.contextPath }/main"> Climbing</a></div>
            </div>
            <c:choose>
            	<c:when test="${empty sssLogin }">
		            <div class="homeList">
		               	<button class="mem login">로그인</button>
		            	<button class="mem join">회원가입</button>
		            </div>
		        </c:when>
		        <c:otherwise>
		            <div class="homeList">
				            <span>아이디 : ${sssLogin.memId }</span>
				            <span>보유 포인트 : ${sssLogin.memPoint }</span>
				            <button class="mem charge">충전</button>
			            <form id="frm-logout">
			            	<button class="mem logout">로그아웃</button>
			            </form>
			            <button class="mem mypage">마이페이지</button>              
		            </div>
		        </c:otherwise>
            </c:choose>
        </header>
      <div class="banner">
            <ul class="bannerList">
                <li class="actlist"><a href="${pageContext.request.contextPath}/notice"><button>공지사항</button></a></li>
                <li class="actlist"><a href="${pageContext.request.contextPath}/board"><button >게시판</button></a></li>
                <li class="actlist"><a href="${pageContext.request.contextPath}/price"><button>요금안내</button></a></li>
            </ul>
      </div>
        
    </div>
    
    <script>
    $(loadedHandler);
    function loadedHandler(){
    	$(".banner > ul > li>a").on("click", btnClickHandler);
    	$(".mem.logout").on("click", btnLogoutClickHandler);
    	$(".mem.login").on("click", btnLoginClickHandler);
    	$(".mem.join").on("click", btnJoinClickHandler);
    	$(".mem.mypage").on("click", btnMypageClickHandler);
    	$(".mem.charge").on("click", btnChargeClickHandler);
    }
        
    function btnClickHandler(){
			$(".banner > ul >li>a").removeClass("activetab");
			$(this).addClass("activetab");			
	}
    function btnLoginClickHandler(){
    	location.href="${pageContext.request.contextPath}/login";
    }
    function btnJoinClickHandler(){
    	location.href="${pageContext.request.contextPath}/join";
    }
    function btnMypageClickHandler(){
    	location.href="${pageContext.request.contextPath}/mypage";
    }
    function btnChargeClickHandler(){
    	//TODO
    	//location.href="${pageContext.request.contextPath}/?";
    }
    function btnLogoutClickHandler(){
    	alert("로그아웃되었습니다.");
    	
    	var frmlogout = document.getElementById("frm-logout");
    	frmlogout.action = "${pageContext.request.contextPath}/logout";
    	frmlogout.method = "post";
    	frmlogout.submit();
    }
    
    </script>