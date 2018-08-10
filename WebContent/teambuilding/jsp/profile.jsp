<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
#profile_polog_profile_pic {
	width: 230px;
	margin: 0;
	padding: 10px 55px;
}

#profile_pic {
	width: 120px;
	height: 120px;
	border-radius: 7px;
}

#profile_polog_profile_intro {
	width: 230px;
	margin: 0;
}

#profile_member_name {
	font-size: 25px;
	margin: auto;
	line-height: 40px;
	text-align: center;
}

.profile_row {
	width: 230px;
	padding: 0;
	margin: 0;
	margin-left: 5px;
}

.profile_col {
	width: 75px;
	padding: 0;
}

.profile_notify_label {
	width: 75px;
	text-align: center;
	color: #002b5a;
	font-size: 18px;
	font-weight: bold;
}

.profile_notify_button {
	width: 20px;
	margin: 0 27.5px;
	padding: 0;
	font-size: 18px;
	color: #002b5a;
	background-color: #ffffff;
	border-color: #002b5a;
}

.profile_notify_button:hover {
	color: #ff4111;
	background-color: #f7e7e3;
	border-color: #ff4111;
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
	<div class="row" id="profile_polog_profile_pic">
		<img src="${sessionScope.memberBean.memberPic }" id="profile_pic">
	</div>
	<div class="row" id="profile_polog_profile_intro">
		<div id="profile_member_name">${sessionScope.memberBean.memberName }</div>
		<form action="login.do" method="post">
			<input type="hidden" name="job" value="logout">
			<button type="submit" style="margin-right: 15px; border: none; margin-left: -68px; background-color: white; color: #002b5a; cursor: pointer; margin-top: 7px;">로그아웃</button>
		</form>
		
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<label class="profile_notify_label">알림</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_notify_label">나의 지원</label>
		</div>

		<div class="col-xs-4 profile_col">
			<label class="profile_notify_label">나의 팀</label>
		</div>
	</div>
	<div class="row profile_row">
		<div class="col-xs-4 profile_col">
			<button type="button" class="btn btn-md profile_notify_button">0</button>
		</div>
		<div class="col-xs-4 profile_col">
			<form action="myApplication.do" method="post">
				<input type="hidden" name="memberId" value="${sessionScope.memberBean.memberId }">
				<input type="hidden" name="job" value="myApplication">
				<c:if test="${myApplicationCount == 0 }">
					<button type="submit" class="btn btn-md profile_notify_button my_application">0</button>
				</c:if>
				<c:if test="${myApplicationCount != 0 }">
					<button type="submit" class="btn btn-md profile_notify_button my_application">${myApplicationCount }</button>
				</c:if>

			</form>
		</div>
		<div class="col-xs-4 profile_col">
			<form action="myTeam.do" method="post">
				<input type="hidden" name="memberId" value="kyujin1">
				<button type="submit" class="btn btn-md profile_notify_button">${fn:length(myTeamList) }</button>
			</form>
		</div>
	</div>
	<div class="row profile_row" style="margin: 15px 0; padding: 0 45px;">
		<form action="/teamwith/polog/jsp/polog.do" method="post">
			<input type="hidden" name="memberId" value="${sessionScope.memberBean.memberId }">
			<button type="submit" class="btn btn-md btn_submit">나의 폴로그</button>
		</form>
	</div>
</body>
</html>