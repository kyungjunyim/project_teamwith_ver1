<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.recommend_team_row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.recommend_team_box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.recommend_team_box_title {
	width: 860px;
	font-size: 25px;
	font-weight: bold;
	margin: 10px;
}

.recommend_team_text_orange {
	color: #ff4111;
}

.recommend_team_text_blue {
	color: #002b5a;
}

.recommend_team_menu_link {
	text-decoration: none;
	color: #002b5a;
}

.recommend_team_menu_link:hover {
	text-decoration: none;
	color: #ff4111;
}

.recommend_team_simple_box_whole {
	width: 840px;
	margin: 10px 60px;
	padding: 0;
}

.recommend_team_simple_box_two {
	width: 360px;
	margin: 0 5px;
	padding: 0;
}

.recommend_team_simple_box_two:hover {
	cursor: pointer;
	border-radius: 15px;
	background-color: #fff7f4;
}

.recommend_team_simple_content_two {
	width: 360px;
	padding: 0;
	margin: 0;
}

.recommend_team_simple_image {
	width: 120px;
	height: 120px;
	padding: 0;
	margin: 10px;
}

#recommend_team_profile_pic {
	width: 120px;
	height: 120px;
	border-radius: 7px;
}

.recommend_team_simple_content {
	color: #002b5a;
	font-size: 25px;
	width: 220px;
	padding: 10px 0;
	margin: 0;
}

.recommend_team_text {
	text-align: center;
	width: 220px;
	height: 40px;
	lien-height: 40px;
	margin: 0;
}

.recommend_team_name {
	font-size: 20px;
	color: #ff4111;
}
</style>
</head>
<body>
	<div class="row recommend_team_row_content recommend_team_box_content">
		<div class="row recommend_team_box_title">
			<div class="col">
				<span class="recommend_team_text_orange">추천</span><span
					class="recommend_team_text_blue" style="margin-left: 5px;">팀</span>
			</div>
		</div>
		<div class="row recommend_team_simple_box_whole">
			<div class="col-xs-6 recommend_team_simple_box_two">
				<div class="row recommend_team_simple_content_two">
					<div class="col-xs-6 recommend_team_simple_image">
						<img src="/teamwith/image/team/book.png"
							id="recommend_team_profile_pic">
					</div>
					<div class="col-xs-6 recommend_team_simple_content">
						<div class="row recommend_team_text">
							<label class="recommend_team_text">게시판 서비스 만들기</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text">커뮤니티/소셜/미디어</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text recommend_team_name">HOPE
								ZIP 팀&nbsp;&nbsp;86%</label>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 recommend_team_simple_box_two">
				<div class="row recommend_team_simple_content_two">
					<div class="col-xs-6 recommend_team_simple_image">
						<img src="/teamwith/image/team/cat.jpg"
							id="recommend_team_profile_pic">
					</div>
					<div class="col-xs-6 recommend_team_simple_content">
						<div class="row recommend_team_text">
							<label class="recommend_team_text">게시판 서비스 만들기</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text">커뮤니티/소셜/미디어</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text recommend_team_name">HOPE
								ZIP 팀&nbsp;&nbsp;79%</label>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row recommend_team_simple_box_whole">
			<div class="col-xs-6 recommend_team_simple_box_two">
				<div class="row recommend_team_simple_content_two">
					<div class="col-xs-6 recommend_team_simple_image">
						<img src="/teamwith/image/team/dog.jpg"
							id="recommend_team_profile_pic">
					</div>
					<div class="col-xs-6 recommend_team_simple_content">
						<div class="row recommend_team_text">
							<label class="recommend_team_text">게시판 서비스 만들기</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text">커뮤니티/소셜/미디어</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text recommend_team_name">HOPE
								ZIP 팀&nbsp;&nbsp;64%</label>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 recommend_team_simple_box_two">
				<div class="row recommend_team_simple_content_two">
					<div class="col-xs-6 recommend_team_simple_image">
						<img src="/teamwith/image/team/rabbit.jpg"
							id="recommend_team_profile_pic">
					</div>
					<div class="col-xs-6 recommend_team_simple_content">
						<div class="row recommend_team_text">
							<label class="recommend_team_text">게시판 서비스 만들기</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text">커뮤니티/소셜/미디어</label>
						</div>
						<div class="row recommend_team_text">
							<label class="recommend_team_text recommend_team_name">HOPE
								ZIP 팀&nbsp;&nbsp;52%</label>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(".recommend_team_simple_box_two").click(function(e) {
		location.href="teamInfo.jsp";
	})
</script>
</html>