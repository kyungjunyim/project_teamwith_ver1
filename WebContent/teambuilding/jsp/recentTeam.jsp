<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.recent_team_row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.recent_team_box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.recent_team_box_title {
	width: 860px;
	font-size: 25px;
	font-weight: bold;
	margin: 10px;
}

.recent_team_text_orange {
	color: #ff4111;
}

.recent_team_text_blue {
	color: #002b5a;
}

.recent_team_menu_link {
	text-decoration: none;
	color: #002b5a;
}

.recent_team_menu_link:hover {
	text-decoration: none;
	color: #ff4111;
}

.recent_team_simple_box_whole {
	width: 840px;
	margin: 10px 60px;
	padding: 0;
}

.recent_team_simple_box_two {
	width: 360px;
	margin: 0 5px;
	padding: 0;
}

.recent_team_simple_box_two:hover {
	cursor: pointer;
	border-radius: 15px;
	background-color: #fff7f4;
}

.recent_team_simple_content_two {
	width: 360px;
	padding: 0;
	margin: 0;
}

.recent_team_simple_image {
	width: 120px;
	height: 120px;
	padding: 0;
	margin: 10px;
}

#recent_team_profile_pic {
	width: 120px;
	height: 120px;
	border-radius: 7px;
}

.recent_team_simple_content {
	color: #002b5a;
	font-size: 25px;
	width: 220px;
	padding: 10px 0;
	margin: 0;
}

.recent_team_text {
	text-align: center;
	width: 220px;
	height: 40px;
	line-height: 40px;
	margin: 0;
}

.recent_team_name {
	font-size: 20px;
	color: #ff4111;
}
</style>
</head>
<body>
	<div class="row recent_team_row_content recent_team_box_content">
		<div class="row recent_team_box_title">
			<div class="col">
				<span class="recent_team_text_orange">최근 등록</span><span
					class="recent_team_text_blue" style="margin-left: 5px;">팀</span>
			</div>
		</div>
		<c:forEach items="${recentTeamList }" var="recentTeam" begin="0" end="3" varStatus="status">
			<c:if test="${status.index mod 2 == 0}">
				<div class="row recent_team_simple_box_whole">
			</c:if>
			<form action="teamDetail.do" method="post" id="recentTeamForm${recentTeam.teamId }">
				<div class="col-xs-6 recent_team_simple_box_two" onclick="$('#recentTeamForm${recentTeam.teamId }').submit();">
					<input type="hidden" name="teamId" value="${recentTeam.teamId }">
					<div class="row recent_team_simple_content_two">
						<div class="col-xs-6 recent_team_simple_image">
							<img src="${recentTeam.teamPic }" id="recent_team_profile_pic">
						</div>
						<div class="col-xs-6 recent_team_simple_content">
							<div class="row recent_team_text">
								<label class="recent_team_text text-truncate">${recentTeam.teamProjectName }</label>
							</div>
							<div class="row recent_team_text">
								<label class="recent_team_text">${applicationScope.categories[recentTeam.projectCategoryId] }</label>
							</div>
							<div class="row recent_team_text">
								<label class="recent_team_text recent_team_name">${recentTeam.teamName }</label>
							</div>
						</div>
					</div>
				</div>
			</form>
			<c:if test="${status.index mod 2 != 0}">
				</div>
			</c:if>
		</c:forEach>
	</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	
</script>
</html>