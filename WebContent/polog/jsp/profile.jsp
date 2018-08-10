<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
div {
	border-radius: 7px;
}

#polog_profile_pic {
	width: 180px;
	height: 180px;
	background-color: #f0f0f5;
	margin: 25px;
}

#profile_pic {
	width: 180px;
	height: 180px;
	border-radius: 7px;
}

#polog_profile_intro {
	margin: 25px;
	margin-top: 0px;
	font-family: NanumSquareRoundEB;
	font-size: 13px;
}

.profile_member_name {
	margin: auto;
	text-align: center;
	line-height: 40px;
	text-align: center;
	font-size: 18px;
}

#polog_portfolio_add button {
	border-radius: 10px;
	margin: 0px 60px 20px;
}

.btn_submit {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #fff;
	background-color: #ff4111;
	opacity: 0.7;
}

.btn_submit:hover {
	color: #fff;
	background-color: #ff4111;
	border-color: #fff;
	opacity: 1;
}
</style>

</head>
<body>
	<div class="theme">
		<div class="row" id="polog_profile_pic">
			<c:choose>
				<c:when test="${sessionScope.pologOwner.memberId=='joran' }">
					<img src="/teamwith/image/member/joran.jpg" id="profile_pic">
				</c:when>
				<c:otherwise>
					<img src="/teamwith/image/member/hwangkyujin.jpg" id="profile_pic">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row" id="polog_profile_intro">
			<div class="profile_member_name" id="member_name">${sessionScope.pologOwner.memberName}</div>
		</div>
		<div class="row" id="polog_profile_intro">
			<div id="polog_intro" style="font-size: 15px;">${sessionScope.pologOwner.memberIntro}</div>
		</div>

		<c:if test="true">

			<div class="row" id="polog_portfolio_add">

				<button class="btn btn_submit" type="submit" id="portfolio_add_btn">포트폴리오
					추가</button>

			</div>
		</c:if>

	</div>
</body>
<script>
	
</script>
</html>