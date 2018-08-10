<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team wITh</title>
<link rel="stylesheet" href="/teamwith/css/bootstrap.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/teamwith/js/bootstrap.js"></script>
<style>
@font-face {
	font-family: yanoljaBold;
	src: url(/teamwith/font/yanoljaBold.eot) format('embedded-opentype'),
		url(/teamwith/font/yanoljaBold.woff) format('woff'),
		url(/teamwith/font/yanoljaBold.ttf) format('truetype');
	font-weight: bold;
}

@font-face {
	font-family: yanoljaRegular;
	src: url(/teamwith/font/yanoljaRegular.eot) format('embedded-opentype'),
		url(/teamwith/font/yanoljaRegular.woff) format('woff'),
		url(/teamwith/font/yanoljaRegular.ttf) format('truetype');
}

.home_container {
	width: 1100px;
	padding: 0;
	margin: 110px auto 0 auto;
	max-width: none !important;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body style="background-color: #e4ecf4; font-family: yanoljaBold">
	<div class="menu">
		<nav class="navbar navbar-inverse fixed-top menu_bar">
			<div class="container-fluid">
				<form action="home.do" method="post" class="to_home">
					<div class="navbar-header">
						<img src="/teamwith/image/logoBox.png" class="menu_bar_box_logo"
							style="cursor: pointer"> <img
							src="/teamwith/image/logoText.png" class="menu_bar_text_logo"
							style="cursor: pointer">
					</div>
				</form>
				<ul class="nav menu_bar_justify-content-center">
					<li class="menu_bar_nav-item"><a
						class="nav-link menu_bar_menu_link"
						href="teambuilding/jsp/team.jsp">팀</a></li>
					<li class="menu_bar_nav-item"><a
						class="nav-link menu_bar_menu_link" href="member.jsp">회원</a></li>
					<li class="menu_bar_nav-item"><a
						class="nav-link menu_bar_menu_link" href="portfolio.jsp">포트폴리오</a></li>
					<li class="menu_bar_nav-item"><a
						class="nav-link menu_bar_menu_link commingSoon">공모전</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="home_container">
		<div class="row main_contents_row_whole">
			<div class="col-xs-6 main_contents_container" style="width: 860px">
				<div class="row my_team_row_content my_team_box_content"
					style="height: 300px">
					<div class="row my_team_box_title">
						<div class="col">
							<span class="my_team_text_orange">나의</span><span
								class="my_team_text_blue" style="margin-left: 5px;">팀</span>
						</div>
					</div>
					<c:choose>
						<c:when test="${fn:length(myTeamList) == 0}">
							<div class="row my_team_simple_box_whole">
								<label
									style="width: 740px; text-align: center; font-size: 20px; color: #002b5a">아직
									등록된 팀이 없습니다. 팀을 등록해주세요!</label>
							</div>
						</c:when>
						<c:otherwise>
							<div class="row my_team_simple_box_whole">
								<c:set var="doneLoop" value="false" />
								<c:forEach items="${myTeamList }" var="myTeam"
									varStatus="status">
									<c:if test="${not doneLoop}">
										<form action="teamDetail.do" method="post"
											id="myTeamForm${myTeam.teamId }">
											<input type="hidden" name="teamId" value="${myTeam.teamId }">
											<div class="col-xs-6 my_team_simple_box_two"
												onclick="$('#myTeamForm${myTeam.teamId }').submit()">
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
									</c:if>
									<c:if test="${status.count == 2}">
										<c:set var="doneLoop" value="true" />
									</c:if>
								</c:forEach>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="row" style="margin: 20px auto">
						<form action="teamRegister.do" method="post">
							<input type="hidden" name="job" value="teamRegister">
							<button type="submit" class="btn btn-md btn_submit">팀
								만들기</button>
						</form>
					</div>
				</div>
				<jsp:include page="recentTeam.jsp" />
				<jsp:include page="bestMember.jsp" />
			</div>
			<div>
				<jsp:include page="sideMenu.jsp" />
			</div>
		</div>
	</div>
	<div class="home_container" style="margin-top: -10px">
		<div class="row footer_row_whole">
			<div class="col footer_col_whole footer_footer footer_box_content">
				<div class="row" style="width: 1100px; height: 100px; margin: 0;">
					<div class="col footer_footer_logo">
						<img src="/teamwith/image/teamLogoText.png"
							class="footer_text_team_logo">
					</div>
					<div class="col"></div>
					<div class="col footer_footer_text">
						<span class="footer_text_orange">렉토피아 전문가 과정 16기</span><br> <span
							class="footer_text_blue">팀장: 황규진<br>팀원: 김종승, 임경준, 조란
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>