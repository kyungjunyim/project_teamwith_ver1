<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html lang="en">
<head>
<meta charset="UTF-8">
<style>
.row {
	width: 860px;
	margin: 0;
}

.row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.modal-header {
	color: red;
	font-size: 10px;
	font-weight: bold;
	border-bottom: 1px solid #ececf9;
}

.modal-footer {
	height: 40px;
	justify-content: center;
	border-top: none;
}

.btn {
	height: 30px;
	line-height: 15px;
	background-color: #f2f2f2;
}

.page_top {
	width: 860px;
	margin-top: 30px;
	margin-bottom: 30px;
	padding: auto;
	text-align: center;
}

.text_color_red {
	color: #ff4111;
}

.page_top_text {
	width: 335px;
	line_height: 20px;
}
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
	margin: 0 auto;
	padding: 0;
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
	padding: 0;
	margin: 25px 0;
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

table {
	font-size: 23px;
}
</style>
</head>
<body>

	<div class="col-xs-6 col_content">
		<div class="row row_content box_content">
			<div class="page_top justify-content-center">
				<div class="col-xs-6 my_team_simple_box_two">
					<div class="row my_team_my_team_simple_content_two">
						<div class="col-xs-6 my_team_simple_image">
							<img src="/teamwith/image/team/team-12.jpg" id="my_team_profile_pic">
						</div>
						<div class="col-xs-6 my_team_simple_content">
							<div class="row my_team_text">
								<label class="my_team_text text-truncate">플레이파크 공모전!</label>
							</div>
							<div class="row my_team_text">
								<label class="my_team_text my_team_name">FAST BOOSTER팀</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row" style="margin: auto; width: 600px;">
				<table class="table table-hover">
					<tr>
						<th>사진</th>
						<th>이름</th>
						<th>모집분야</th>
						<th>지원날짜</th>
						<th>부가정보</th>
						<th>지원상태</th>
					</tr>
					<tr>
						<td><img src="/teamwith/image/member/hwangkyujin.jpg"
							class="rounded-circle" width="40" height="40"></td>
						<td>황규진</td>
						<td>개발자</td>
						<td>2018-07-19</td>
						<td>
							<button type="button" class="btn btn-link" data-toggle="modal" data-target="#myModal1">보기</button>
							<div class="modal" id="myModal1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header" style="font-size: 25px">간단면접</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="row">매일 아침 7시부터 프로젝트 진행하는데 괜찮으세요?</div>
											<div class="row">
												<div class="col"></div>
												<div class="col-12">A:당연하죠</div>
											</div>
										</div>
										<div class="modal-header" style="font-size: 25px">하고싶은 말</div>
										<!-- Modal body -->
										<div class="modal-body">제발 저 좀 써주세요..</div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn" data-dismiss="modal">확인</button>
										</div>
									</div>
								</div>
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-link btn_hide" data-toggle="modal" data-target="#myModal2">합류</button>
							<button type="button" class="btn btn-link btn_hide" style="color: red;">탈락</button>
							<div class="text_show" style="color: #002b5a;"></div>
													<div class="modal" id="myModal2">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-body" style="text-align:center;">"황규진"님을 팀에 합류시키시겠습니까?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn_decide" data-dismiss="modal">확인</button>
											<button type="button" class="btn" data-dismiss="modal">취소</button>
										</div>
									</div>
								</div>
							</div>
						</td>

					</tr>
				</table>
			</div>
		</div>
	</div>
	<!-- 내용끝 -->
</body>
<script src="http://code.jqeury.com/jquery-3.3.1.min.js"></script>
<script>
	$(".btn_decide").click(function(e) {
		$(".btn_hide").hide();
		$(".text_show").text("합류");
	});
</script>
</html>