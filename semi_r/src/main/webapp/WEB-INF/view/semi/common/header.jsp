<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
    <div>
        <header class="wrap-header">
            <div class="showCurrPage">
                <span class="pageLocation">Home</span>
            </div>
            <nav class="homeList">
                <ul>
                    <li><a href="${pageContext.request.contextPath }/login">로그인</a></li>
                    <li><a href="${pageContext.request.contextPath }/join">회원가입</a></li>
                    <li><a href="${pageContext.request.contextPath }/main">로그아웃</a></li>
                    <li><a href="#">마이페이지</a></li>
                </ul>
            </nav>
        </header>
      <div class="banner">
            <ul class="bannerList">
                <li class="actlist"><a href="${pageContext.request.contextPath}/announce"><button>공지사항</button></a></li>
                <li class="actlist"><a href="${pageContext.request.contextPath}/notice"><button >게시판</button></a></li>
                <li class="actlist"><a href="${pageContext.request.contextPath}/price"><button>요금안내</button></a></li>
            </ul>
      </div>
        
    </div>
    
    <script>
    $(loadedHandler);
    function loadedHandler(){
    	$(".banner > ul > li>a").on("click", btnClickHandler);    	
    }
        
    function btnClickHandler(){
			$(".banner > ul >li>a").removeClass("activetab");
			$(this).addClass("activetab");			
	}
    </script>
</body>
</html>