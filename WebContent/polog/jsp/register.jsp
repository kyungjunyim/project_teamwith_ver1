<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

/* The Modal (background) */
.register_modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1040; /* Sit on top */
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
.register_modal_content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 600px; /* Could be more or less, depending on screen size */
}

/* Add Zoom Animation */
.register_animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

.register_title {
	margin: 10px 0;
	text-align: center;
	font-size: 23px;
}
.register_label{
width:100px;
margin-left:30px;
margin-right:20px;
text-align:left;
}
/* Full-width input fields */
.register_input {
	width: 60%;
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
.register_btn {
	background-color: #ff4111;
	font-size: 25px;
	color: white;
	padding: 8px 20px;
	margin: 17px auto;
	border: none;
	cursor: pointer;
	width: 80%;
	opacity: 0.8;
}

.register_btn:hover {
	opacity: 1;
}

.register_cancel_btn {
	width: 80px;
	margin: 10px 35px;
	font-size:20px;
}

#register {
	font-size: 20px;
}

#register:hover {
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
		onclick="document.getElementById('register_modal').style.display='block'"
		style="width: auto;" id="trigger_register_btn"></a>

	<div id="register_modal" class="register_modal">

		<form class="register_modal_content register_animate"
			action="/action_page.php">
			<div class="register_title">회원가입</div>


			<div class="register_title">
			<label class="register_label">아이디</label>
				<input type="text" placeholder="아이디" class="register_input"
					name="member_id" required> 
		<label class="register_label">비밀번호</label>
				<input type="password"	placeholder="비밀번호" class="register_input" name="member_password"
					required>
					<label class="register_label">비밀번호 확인</label>
				<input type="password"
					placeholder="비밀번호 확인" class="register_input" name="member_password"
					required>
					<label class="register_label">이메일</label>
				<input type="email"
					placeholder="이메일" class="register_input" name="member_password"
					required>
					<label class="register_label">생년월일</label>
				<input type="date"
					placeholder="생년월일" class="register_input" name="member_password"
					required>
					<label class="register_label">핸드폰번호</label>
					<input type="number"
					placeholder="핸드폰번호" class="register_input" name="member_password"
					required>

				<button type="submit" class="register_btn">회원가입</button>

			</div>
			<div class="register_find_idpw" style="background-color: #f1f1f1">

				<button type="button"
					onclick="document.getElementById('register_modal').style.display='none'"
					class="btn btn-secondary register_cancel_btn">취소</button>

			</div>
		</form>
</div>


</body>
</html>
