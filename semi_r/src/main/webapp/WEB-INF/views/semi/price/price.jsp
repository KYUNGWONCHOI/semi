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
					<h1>신청하기</h1>
					<div class="memsort grid">
						<div>
							<button type="button" class="btn btnmonth">회원권</button>
						</div>
						<div>
							<button type="button" class="btn btnnumber">횟수권</button>
						</div>
					</div>
					<form class="membership frm" id="frm-membership">
						<div>
							<div class="memMonth">
								<h1>회원권</h1>
								<div class="membership grid ">
									<div>
										<label>1개월<input type="radio" name="priceType" value=1></label>
									</div>
									<div>
										<label>3개월<input type="radio" name="priceType" value=3></label>
									</div>
								</div>
							</div>
							<div class="memNumber">
								<h1>횟수권</h1>
								<div class="membership grid">
									<div>
										<label>5회<input type="radio" name="priceType" value=2></label>
									</div>
									<div>
										<label>10회<input type="radio" name="priceType" value=4></label>
									</div>
								</div>
							</div>
							<div class="memLocker">
								<h1>라커</h1>
								<div class="membership grid">
									<div>
										<label>Y<input type="radio" name="locker" value="Y"></label>
									</div>
									<div>
										<label>N<input type="radio" name="locker" value="N"></label>
									</div>
								</div>
							</div>
						</div>
						<div class="memsub membership grid">
							<div>
								<button type="button" class="btn submit">신청하기</button>
							</div>
							<div>
								<button type="button" class="btn close-modal">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<button class="btn membership">신청</button>
		</div>
	</div>
	<div class="chart2">
		<div class="pricedetails">
			<div>
				<h1>일일 이용권</h1>
				<ul>
					<li>22,000원</li>
				</ul>
			</div>
			<div>
				<h1>장비 대여</h1>
				<ul>
					<li>암벽화 3,000원</li>
					<li>초크 1,000원</li>
				</ul>
			</div>
			<button class="btn oneday">예약하기</button>
		</div>
		<div class="modal bookonday">
			<div class="modal_body bookonday">
				<form class="bookonday frm" id="frm-bookonday">
					<div>
						<div class="wrap-rent">
							<h1>렌탈</h1>
							<div><label>일일이용권<input type="checkbox" name="priceType" value=5 checked disabled></label></div>
							<div class="rentlist grid">
								<div>
									<label>신발<input type="radio" name="rent" value=1></label>
								</div>
								<div>
									<label>초크백<input type="radio" name="rent" value=2></label>
								</div>
								<div>
									<label>안함<input type="radio" name="rent" value=3></label>
								</div>
							</div>
								<div class="size"><label>신발 사이즈 : <input class="sizeS" type="number" min="210" max="300" step="5" name="shoesize" value=""></label></div>
						</div>
						<div class="memsub bookonday grid">
							<div>
								<button type="button" class="btn submit">예약</button>
							</div>
							<div>
								<button type="button" class="btn close-modal">취소</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<script>
	$(loadedHandler);
	var radiobox = $(".pricechart input[type='radio']");
	var rentCheck = $(".rentlist input[type='radio']");
	function loadedHandler() {
		$(".size").hide();
		$(".btn.membership").on("click", btnMembershipClickHandler);
		$(".btn.oneday").on("click", btnOnedayClickHandler);
		$(".btn.close-modal").on("click", btnCloseModalClickHandler);
		$(".btn.submit").on("click", btnsubmitClickHandler);
		$(".btn.btnmonth").on("click", btnbtnmonthClickHandler);
		$(".btn.btnnumber").on("click", btnbtnnumberClickHandler);
		rentCheck.on("click", checkedrentHandler);
		$(".memNumber").hide();
		$(".memMonth").hide();
		$(".memLocker").hide();
	}	
	function btnbtnmonthClickHandler() {
		$(".memNumber").hide();
		$(".memMonth").show();
		$(".memLocker").show();
	}
	function btnbtnnumberClickHandler() {
		$(".memMonth").hide();
		$(".memNumber").show();
		$(".memLocker").show();
	}
	function btnsubmitClickHandler() {
		$(".modal.membership").css("display", "none");
		$(".modal.bookonday").css("display", "none");
		$.ajax({
			async : false,
			url : "${pageContext.request.contextPath }/price",
			method : "post",
			data : $("#frm-membership").serialize(),
			error : ajaxErrorHandler,
			success : function(result) {

			}
		});
		radiobox.prop("checked",false);
		$(".memNumber").hide();
		$(".memMonth").hide();
		$(".memLocker").hide();
	}

	function btnMembershipClickHandler() {
		$(".modal.membership").css("display", "flex");
	}
	function btnCloseModalClickHandler() {
		radiobox.prop("checked",false);
		$(".modal").css("display", "none");
	}
	function btnOnedayClickHandler() {
		$(".modal.bookonday").css("display", "flex");
	}
	function checkedrentHandler(){
		var indexNum = $(this).val();
		console.log(indexNum);
		if(indexNum == 1){
			$(".size").show();			
		}else {
			$(".size").hide();
		}
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