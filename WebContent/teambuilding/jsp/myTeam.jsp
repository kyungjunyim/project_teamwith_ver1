<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.my_team_row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.my_team_box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.my_team_box_title {
	width: 860px;
	font-size: 25px;
	font-weight: bold;
	margin: 10px;
}

.my_team_text_orange {
	color: #ff4111;
}

.my_team_text_blue {
	color: #002b5a;
}

.my_team_menu_link {
	text-decoration: none;
	color: #002b5a;
}

.my_team_menu_link:hover {
	text-decoration: none;
	color: #ff4111;
}

.my_team_simple_box_whole {
	width: 840px;
	margin: 10px 60px;
	padding: 0;
}

.my_team_simple_box_two {
	width: 360px;
	margin: 0 5px;
	padding: 0;
}

.my_team_simple_box_two:hover {
	cursor: pointer;
	border-radius: 15px;
	background-color: #fff7f4;
}

.my_team_my_team_simple_content_two {
	width: 360px;
	padding: 0;
	margin: 0;
}

.my_team_simple_image {
	width: 120px;
	height: 120px;
	padding: 0;
	margin: 10px;
}

#my_team_profile_pic {
	width: 120px;
	height: 120px;
	border-radius: 7px;
}

.my_team_simple_content {
	color: #002b5a;
	font-size: 25px;
	width: 220px;
	padding: 10px 0;
	margin: 0;
}

.my_team_text {
	text-align: center;
	width: 220px;
	height: 40px;
	margin: 0;
	line-height: 40px;
}

.my_team_name {
	font-size: 20px;
	color: #ff4111;
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
	<div class="row my_team_row_content my_team_box_content"
		style="height: 300px">
		<div class="row my_team_box_title">
			<div class="col">
				<span class="my_team_text_orange">나의</span><span
					class="my_team_text_blue" style="margin-left: 5px;">팀</span>
			</div>
		</div>
			<div class="row my_team_simple_box_whole">
				<label
					style="width: 740px; text-align: center; font-size: 20px; color: #002b5a">아직
					등록된 팀이 없습니다. 팀을 등록해주세요!</label>
			</div>
				<div class="row my_team_simple_box_whole">
							<form action="teamDetail.do" method="post" id="myTeamForm${myTeam.teamId }">
								<input type="hidden" name="teamId" value="${myTeam.teamId }">
								<div class="col-xs-6 my_team_simple_box_two" onclick="$('#myTeamForm${myTeam.teamId }').submit()">
									<div class="row my_team_my_team_simple_content_two">
										<div class="col-xs-6 my_team_simple_image">
											<img src="${myTeam.teamPic }" id="my_team_profile_pic">
										</div>
										<div class="col-xs-6 my_team_simple_content">
											<div class="row my_team_text">
												<label class="my_team_text text-truncate">${myTeam.teamProjectName }</label>
											</div>
											<div class="row my_team_text">
												<label class="my_team_text">${applicationScope.categories[myTeam.projectCategoryId] }</label>
											</div>
											<div class="row my_team_text">
												<label class="my_team_text my_team_name">${myTeam.teamName }</label>
											</div>
										</div>
									</div>
								</div>
							</form>
				</div>
		<div class="row" style="margin: 20px auto">
			<form action="teamRegister.do" method="post">
				<input type="hidden" name="job" value="teamRegister">
				<button type="submit" class="btn btn-md btn_submit">팀 만들기</button>
			</form>
		</div>
	</div>
</body>
</html>