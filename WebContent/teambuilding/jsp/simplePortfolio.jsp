<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.simple_portfolio_box_title {
	font-size: 23px;
	font-weight: bold;
	margin: 10px;
}

.simple_portfolio_text_orange {
	color: #ff4111;
}

.simple_portfolio_text_blue {
	color: #002b5a;
}

.simple_portfolio_small_simple_box_whole {
	width: 230px;
	margin: 0;
	padding: 0;
}

.simple_portfolio_small_simple_box_two {
	width: 105px;
	margin: 0 5px;
	padding: 0;
}

.simple_portfolio_small_simple_box_two:hover {
	cursor: pointer;
	border-radius: 15px;
	background-color: #fff7f4;
}

.simple_portfolio_small_simple_content_two {
	width: 105px;
	padding: 0 10px;
	margin: 0;
}

.simple_portfolio_small_simple_image {
	width: 85px;
	height: 85px;
	padding: 0;
	margin: 10px;
}

#simple_portfolio_profile_pic {
	width: 85px;
	height: 85px;
	border-radius: 7px;
}

.simple_portfolio_member_name {
	font-size: 18px;
	width: 85px;
	margin: 0;
	padding: 0;
	text-align: center;
}

.simple_portfolio_portfolio_name {
	font-size: 20px;
	color: #ff4111;
}

.simple_portfolio_text_label {
	width: 85px;
	text-align: center;
}

.simple_portfolio_more_btn {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #002b5a;
	background-color: #ffffff;
	border-color: #002b5a;
	margin: 10px auto;
}

.simple_portfolio_more_btn:hover {
	color: #ff4111;
	background-color: #f7e7e3;
	border-color: #ff4111;
}

label {
	margin: 0;
}
</style>
</head>
<body>
	<div class="row simple_portfolio_box_title">
		<div class="col">
			<span class="simple_portfolio_text_orange">최근</span><span
				class="simple_portfolio_text_blue" style="margin-left: 5px;">포트폴리오</span>
		</div>
	</div>
	<c:forEach items="${recentPortfolioList }" var="recentPortfolio" begin="0" end="4" varStatus="status">
		<c:if test="${status.index mod 2 == 0}">
			<div class="row simple_portfolio_small_simple_box_whole">
		</c:if>
		<form action="portfolioDetail.do" method="post" id="recentPortfolioForm${recentPortfolio.portfolioId }">
			<div class="col-xs-6 simple_portfolio_small_simple_box_two" onclick="$('#recentPortfolioForm${recentPortfolio.portfolioId }').submit()">
				<div class="row simple_portfolio_small_simple_image">
					<img src="${recentPortfolio.portfolioPic }" id="simple_portfolio_profile_pic">
				</div>
				<div class="row simple_portfolio_small_simple_content_two">
					<div class="row simple_portfolio_member_name text-truncate">
						<label class="simple_portfolio_text_label">${recentPortfolio.memberName }</label>
					</div>
					<div class="simple_portfolio_portfolio_name text-truncate">
						<label class="simple_portfolio_text_label">${recentPortfolio.portfolioTitle }</label>
					</div>
				</div>
			</div>
		</form>
		<c:if test="${status.index mod 2 != 0}">
			</div>
		</c:if>
	</c:forEach>
	<button type="button" class="btn btn-md simple_portfolio_more_btn">더보기</button>
</body>
</html>