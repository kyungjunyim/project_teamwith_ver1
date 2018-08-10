<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.loginInput_row_input {
	width: 230px;
	margin: 0;
	padding: 15px;
	padding-bottom: 0;
}

.loginInput_col_input {
	width: 140px;
	margin: 0;
}

.loginInput_col_btn {
	width: 60px;
	height: 60px;
	padding: 0;
	margin: 0;
}

.loginInput_row_link {
	line-height: 38px;
	width: 230px;
	margin: 0;
	padding: 5px 15px 0px 15px;
	text-align: center;
}

.loginInput_link_text {
	font-size: 15px;
	text-decoration: none;
	color: #002b5a;
}

.loginInput_link_text:hover {
	text-decoration: none;
	color: #ff4111;
}

.loginInput_btn {
	width: 60px;
	height: 60px;
	padding: 0;
	color: #fff;
	background-color: #ff4111;
	opacity: 0.7;
}

.loginInput_btn:hover {
	color: #fff;
	background-color: #ff4111;
	border-color: #fff;
	opacity: 1;
}

.loginInput_input {
	width: 140px;
	height: 30px;
	margin: 0;
}

input {
	border-radius: 5px;
	padding: 3px 5px;
}
</style>
<body>
	<div class="loginAjax" style="width: 230px;">
		<form action="login.do" method="post">
			<input type="hidden" name="job" value="login">
			<div class="row loginInput_row_input">
				<div class="col-xs-6 loginInput_col_input">
					<div class="row loginInput_input">
						<input type="text" name="memberId" placeholder="아이디"	style="width: 140px;">
					</div>
					<div class="row loginInput_input">
						<input type="password" name="memberPassword" placeholder="비밀번호"	style="width: 140px;">
					</div>
				</div>
				<div class="col-xs-6 loginInput_col_btn">
					<button type="submit" id="loginInput_login_btn"	class="btn btn-md loginInput_btn">로그인</button>
				</div>
			</div>
		</form>
		<div class="row loginInput_row_link">
			<div class="col-xs-4"
				style="padding: 0; width: 109px; text-align: center">
				<a href="#" id="register" class="loginInput_link_text"><label
					style="font-size: 20px; cursor: pointer">회원가입</label></a>

			</div>

			<div class="col-xs-8"
				style="padding: 0; width: 91px; text-align: right">
				<a href="#" id="find_account" class="loginInput_link_text"><label
					style="cursor: pointer">아이디/비밀번호찾기</label></a>

			</div>

		</div>
		<jsp:include page="../../polog/jsp/register.jsp" />
		<jsp:include page="../../polog/jsp/findAccount.jsp" />
	</div>
	<script>
		$(document).ready(function() {
			$('#register').click(function() {
				$('#trigger_register_btn').trigger('click');
			});

			$('#find_account').click(function() {
				$('#trigger_find_account_btn').trigger('click');
			});

		});
	</script>
</body>
</html>