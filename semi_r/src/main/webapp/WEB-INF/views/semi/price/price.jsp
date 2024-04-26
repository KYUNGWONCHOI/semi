<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="pricetab">
	<ul>
		<li class="pricelist activetab"><button>회원권</button></li>
		<li class="pricelist"><button>일일이용</button></li>
	</ul>
</div>

<div class="pricechart">
	<div class="chart1">
		<div class="pricedetails">
			<h1>정기권</h1>
			<table>
				<tr>
					<th>기간</th>
					<th>금액</th>
				</tr>
				<tr>
					<td>3개월 (최대 15일 2회 정지가능)</td>
					<td>330,000</td>
				</tr>
				<tr>
					<td>1개월 (최대 15일 1회 정지가능)</td>
					<td>130,000</td>
				</tr>
			</table>
			<h1>횟수권</h1>
			<table>
				<tr>
					<th>구성</th>
					<th>금액</th>
				</tr>
				<tr>
					<td>10회 (기간 : 1년)</td>
					<td>170,000</td>
				</tr>
				<tr>
					<td>5회 (기간 : 1년)</td>
					<td>90,000</td>
				</tr>
			</table>
			<div class="modal membership">
				<div class="modal_body membership">
					<h2>모달창 제목</h2>
					<p>모달창 내용</p>
					<button type="button" class="btn close-modal">Modal 닫기</button>
				</div>
			</div>
			<button class="btn membership">신청</button>
		</div>
	</div>
	<div class="chart2">
		<div class="pricedetails">
			<div><h1>일일 이용권</h1>
				<ul>
					<li>22,000원</li>
				</ul>
			</div>
			<div><h1>장비 대여</h1>
				<ul>
					<li>암벽화 3,000원</li>
					<li>초크 1,000원</li>
				</ul>
			</div>
		</div>
	<button class="btn oneday">예약하기</button>
	</div>
</div>


<script>
	$(loadedHandler);
	function loadedHandler() {
		$(".btn.membership").on("click", btnMembershipClickHandler);
		$(".btn.oneday").on("click", btnOnedayClickHandler);
		$(".btn.close-modal").on("click", btnCloseModalClickHandler);
	}
	
	function btnMembershipClickHandler() {
		$(".modal.membership").css("display","flex");
	}
	function btnCloseModalClickHandler() {
		$(".modal").css("display","none");		
	}
	function btnOnedayClickHandler() {
		location.href="${pageContext.request.contextPath}/main";
	}

	$(".pricechart > div").hide();
	$(".pricechart > div").eq(0).show();

	$(".pricetab > ul > li").click(function() {
		var target = $(this);
		var indexNum = target.index();
		var none = $(this)
		$(".pricechart > div").css("display", "none");
		$(".pricechart > div").eq(indexNum).css("display", "block");
	});

	$(".pricetab > ul > li").click(function() {
		$(".pricetab > ul >li").removeClass("activetab");
		$(this).addClass("activetab");
	});
</script>