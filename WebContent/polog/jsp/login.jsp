<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

/* The Modal (background) */
.login_modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.login_modal_content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 400px; /* Could be more or less, depending on screen size */
}

/* Add Zoom Animation */
.login_animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

.login_title {
	margin: 10px 0;
	text-align: center;
	font-size: 23px;
}

/* Full-width input fields */
.login_input {
	width: 80%;
	font-size: 20px;
	padding: 8px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

span.psw {
	float: right;
	padding-top: 16px;
}
/* Set a style for all buttons */
.login_btn {
	background-color: #ff4111;
	font-size: 25px;
	color: white;
	padding: 8px 20px;
	margin: 8px auto;
	border: none;
	cursor: pointer;
	width: 80%;
	opacity: 0.8;
}

.login_btn:hover {
	opacity: 1;
}

.login_cancel_btn {
	width: 80px;
	margin: 10px 35px;
	font-size:20px;
}

#find_idpw, #register {
	font-size: 20px;
}

#find_idpw:hover, #register:hover {
	color: #ff4111;
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>


	<a href="#"
		onclick="document.getElementById('login_modal').style.display='block'"
		style="width: auto;">로그인</a>

	<div id="login_modal" class="login_modal">

		<form class="login_modal_content login_animate"
			action="/action_page.php">
			<div class="login_title">로그인</div>


			<div class="login_title">
				<input type="text" placeholder="아이디" class="login_input"
					name="member_id" required> <input type="password"
					placeholder="비밀번호" class="login_input" name="member_password"
					required>

				<button type="submit" class="login_btn">로그인</button>

			</div>
			<div class="login_find_idpw" style="background-color: #f1f1f1">
			
	
				<a href="#" id="register">
		회원가입
				</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<a href="#" id="find_account">아이디/비밀번호 찾기</a>

				<button type="button"
					onclick="document.getElementById('login_modal').style.display='none'"
					class="btn btn-secondary login_cancel_btn">취소</button>

			</div>
		</form>
	</div>

	<script>
		// Get the modal
		var login_modal = document.getElementById('login_modal');


		$(document).ready(function(){
			$('#register').click(function(){
				login_modal.style.display = "none";
				$('#trigger_register_btn').trigger('click');
			});
			
			$('#find_account').click(function(){
				login_modal.style.display = "none";
				$('#trigger_find_account_btn').trigger('click');
			});
			
		});
	</script>

</body>
</html>
