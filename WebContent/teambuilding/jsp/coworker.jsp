<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<style>
.row {
	width: 860px;
	margin: 0;
}
.row_detail {
	width: 840px;
}
.row_title{
	color:#ff4111;
}
.row_text{
	padding-left:30px;
}
.my_hr {
	width: 780px;
	margin: 20px 0;
}
.team_detail_hover_opacity:hover{
	opacity:0.8;
}
</style>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e){
		$('#teamMember').click(function(e){
			$('#teamMember1').submit();
		});
	});
</script>
</head>

<body>
	<div class="row row_detail" style="margin-top: 20px; width: 820px">
		<div class="row row_title">합류한 팀원</div>
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="teamMember1">
			<input type="hidden" name="memberId" value="hwangkyujin">				
		<div id="teamMember" class="row row_detail row_text team_detail_hover_opacity" style="width: 820px; margin-top:20px; cursor: pointer" onclick="$('#teamMember1').submit()">
			<img src="./image/member/hwangkyujin.jpg" class="rounded-circle" width="40" height="40"><label style="margin-left: 10px; line-height: 40px">황규진 개발자</label>
		</div>
		</form>
		<form action="/teamwith/polog/jsp/polog.do" method="post" id="teamMember2">
			<input type="hidden" name="memberId" value="kimjongseung">
		<div class="row row_detail row_text team_detail_hover_opacity" style="width: 820px; margin-top:20px; cursor: pointer" onclick="$('#teamMember2').submit()">
			<img src="./image/member/kimjongseung.jpg" class="rounded-circle" width="40" height="40"><label style="margin-left: 10px; line-height: 40px">김종승 기타</label>
		</div>
		</form>
	</div>
</body>
</html>