<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
.beset_portfolio_best_portfolio{
width:260px;
height:300px;
margin:0 10px;
padding:0;
background-color:white;
border-radius:15px;
}
.beset_portfolio_myrow{
	margin: 0;
	width:260px;
	height:300px;
	
}
.beset_portfolio_myrow .beset_portfolio_smallrow{
	height:auto;
}
.beset_portfolio_overview{
text-overflow:ellipsis;
white-space:nowrap;
word-wrap:normal;
width:200px;
overflow:hidden;

}
.aa{
	cursor: pointer;
	
}
.aa:hover{
	background-color:#f7e7e3;
}
.bpimg{
	border-radius:15px;
}

.row_portfolio {
	width: 860px;
	margin: 0;
	padding: 15px 5px;
}
.best_portfolio_row_2 {
margin: 0;
}

.text_label {
font-size: 20px;
 width: 260px; 
 text-align:center; 
 line-height: 30px; 
 margin: 0;
}
</style>
<script>
	$(document).ready(function(e){	
		$('.b').click(function(e){
			
			var id=$(this).attr('id');
			
			var title=$(this).children().children().children().last().html();
			var $f=$("<form action='portfolioDetail.do'></form>");
			var $h=$("<input type='hidden' name='portfolio_id'/>");
			var $t=$("<input type='hidden' name='portfolio_title'/>");
			$h.attr('value',id);
			$t.attr('value',title);
			$f.append($h);
			$f.append($t);
			$('body').append($f);
			$f.submit();
			/* $.post({

			    type: 'post'

			  , url: 'portfolioDetail.do'
				
			  , dataType : 'html'
			  ,	data : id
			  , success: function(data) {

			    $('.polog_main').html(data);

			  }

			 });
 */		});
		
	});
</script>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
<c:when test="${sessionScope.pologOwner.memberId!='hwangkyujin'}">
	<div class="row row_portfolio">
		<div class="col-xs-4 best_portfolio best_portfolio1 beset_portfolio_best_portfolio b" id="portfolio-1">
			<!-- 포폴 -->
			<div class="row beset_portfolio_myrow" >
				<div class="row best_portfolio_row_2">
					<div class="col-xs-1" >
						<img src="http://www.irobotnews.com/news/photo/201709/11794_27156_1618.png" width="260px" height="250px" class="bpimg">
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow ">
					<div class="col-xs-1" style="width: 260px" ><label class="text_label">조란님 포트폴리오</label></div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow ">
					<div class="col-xs-1 beset_portfolio_overview" style="width: 260px" ><label class="text_label">로봇 가사 도우미 뽀미</label>
					</div>
				</div>
			</div>
			
			<!-- 포폴 -->
		</div>

			<!-- 포폴 -->
		</div>

	</c:when>
	<c:otherwise>
	<div class="row row_portfolio">
		<div class="col-xs-4 best_portfolio best_portfolio1 beset_portfolio_best_portfolio b" id="portfolio-1">
			<!-- 포폴 -->
			<div class="row beset_portfolio_myrow" >
				<div class="row best_portfolio_row_2">
					<div class="col-xs-1" >
						<img src="../../image/po.jpg" width="260px" height="250px" class="bpimg">
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow ">
					<div class="col-xs-1" style="width: 260px" ><label class="text_label">황규진님 포트폴리오</label></div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow ">
					<div class="col-xs-1 beset_portfolio_overview" style="width: 260px" ><label class="text_label">경기 빅데이터 공모전 수상작</label>
					</div>
				</div>
			</div>
			
			<!-- 포폴 -->
		</div>
		<div class="col-xs-4 beset_portfolio_best_portfolio beset_portfolio_best_portfolio2 b" id="portfolio-2">
		<!-- 포폴 -->
		<form action="portfolioDetail.jsp">
			<div class="row beset_portfolio_myrow ">
				<div class="row best_portfolio_row_2">
					<div class="col-xs-1">
						<img src="../../image/why.jpg" width="260px" height="250px" class="bpimg">
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow">
					<div class="col-xs-1">
						<label class="text_label">황규진님 포트폴리오</label>
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow ">
					<div class="col-xs-1 beset_portfolio_overview"  >
						<label class="text_label">2017 공공 빅데이터 공모전 수상작</label>
					</div>
				</div>
			</div>
			</form>
			<!-- 포폴 -->
			</div>
		<div class="col-xs-4 beset_portfolio_best_portfolio beset_portfolio_best_portfolio3 b" id="portfolio-3">
			<!-- 포폴 -->
			<form action="portfolioDetail.jsp">
			<div class="row beset_portfolio_myrow ">
				<div class="row best_portfolio_row_2">
					<div class="col-xs-1">
						<img src="../../image/book.png" width="260px" height="250px" class="bpimg">
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow">
					<div class="col-xs-1">
						<label class="text_label">황규진님 포트폴리오</label>
					</div>
				</div>
				<div class="row beset_portfolio_myrow beset_portfolio_smallrow" >
					<div class="col-xs-1 beset_portfolio_overview ">
						<label class="text_label">보안 취약점 자동분석 아이디어 공모전</label>
					</div>
				</div>
			</div>
			</form>
			<!-- 포폴 -->
		</div>

	</div>
	</c:otherwise>
	</c:choose>
</body>
</html>