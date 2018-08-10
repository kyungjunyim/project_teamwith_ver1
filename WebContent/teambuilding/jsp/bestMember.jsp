<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.best_member_row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.best_member_box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.best_member_box_title {
	width: 860px;
	font-size: 25px;
	font-weight: bold;
	margin: 10px;
}

.best_member_text_orange {
	color: #ff4111;
}

.best_member_text_blue {
	color: #002b5a;
}

.best_member_menu_link {
	text-decoration: none;
	color: #002b5a;
}

.best_member_menu_link:hover {
	cursor: pointer;
	text-decoration: none;
	color: #ff4111;
}

.best_member_simple_box_whole {
	width: 840px;
	margin: 10px 60px 20px 60px;
	padding: 0;
}

.best_member_simple_box_two {
	width: 140px;
	margin: 0 22.5px;
	padding: 0;
}

.best_member_simple_box_two:hover {
	cursor: pointer;
	border-radius: 15px;
	background-color: #fff7f4;
}

.best_member_simple_content_two {
	width: 140px;
	padding: 0;
	margin: 0;
}

.best_member_simple_image {
	width: 120px;
	height: 120px;
	padding: 0;
	margin: 10px;
}

#best_member_profile_pic {
	width: 120px;
	height: 120px;
	margin: 10px;
	border-radius: 7px;
}

.best_member_simple_content {
	color: #002b5a;
	font-size: 25px;
	width: 220px;
	padding: 10px 0;
	margin: 0;
}

.best_member_text {
	font-size: 25px;
	color: #002b5a;
	text-align: center;
	width: 140px;
	margin: 0;
	text-align: center;
	width: 140px;
	margin: 0;
	height: 30px;
	line-height: 30px;
	width: 140px;
	margin: 0;
	text-align: center;
	width: 140px;
	margin: 0;
	margin: 0;
	text-align: center;
	width: 140px;
	margin: 0;
}

.best_member_praise_cnt {
	font-size: 20px;
	color: #ff4111;
}

.best_member_text_row {
	margin: 0;
	width: 140px;
}
</style>
</head>
<body>
	<div class="row best_member_row_content best_member_box_content">
		<div class="row best_member_box_title">
			<div class="col">
				<span class="best_member_text_orange">우수</span><span
					class="best_member_text_blue" style="margin-left: 5px;">회원</span>
			</div>
		</div>
		<div class="row best_member_simple_box_whole">
			<c:forEach items="${bestMemberList }" var="bestMember" begin="0" end="4" varStatus="status">
				<form action="/teamwith/polog/jsp/polog.do" method="post" id="bestMemberForm${bestMember.memberId }">
					<input type="hidden" name="memberId" value="${bestMember.memberId }">
					<div class="col-xs-6 best_member_simple_box_two" onclick="$('#bestMemberForm${bestMember.memberId }').submit()">
						<div class="row best_member_simple_content_two">
							<img src="${bestMember.memberPic }" id="best_member_profile_pic">
						</div>
						<div class="row best_member_text_row">
							<div class="row best_member_text">
								<label class="best_member_text">${bestMember.memberName }</label>
							</div>
							<div class="row best_member_text">
								<label class="best_member_text best_member_praise_cnt">${bestMember.praiseTotalCount }회 칭찬</label>
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>