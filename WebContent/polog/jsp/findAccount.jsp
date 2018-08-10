<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

/* The Modal (background) */
.find_account_modal {
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
.find_account_modal_content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 400px; /* Could be more or less, depending on screen size */
}

/* Add Zoom Animation */
.find_account_animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

.find_account_title {
	margin: 10px 0;
	text-align: center;
	font-size: 23px;
}
.find_account_label{
width:67px;
margin-left:2px;
margin-right:11px;
text-align:left;
}

/* Full-width input fields */
.find_account_input {
	width: 60%;
	font-size: 20px;
	padding: 8px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
.find_account_btn {
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

.find_account_btn:hover {
	opacity: 1;
}

.find_account_cancel_btn {
	width: 80px;
	margin: 10px 35px;
	font-size: 20px;
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
		onclick="document.getElementById('find_account_modal').style.display='block'"
		style="width: auto;" id="trigger_find_account_btn"></a>

	<div id="find_account_modal" class="find_account_modal">

		<form class="find_account_modal_content find_account_animate"
			action="/action_page.php">
			<div class="find_account_title">아이디 비밀번호 찾기</div>


			<div class="find_account_title">
			<label class="find_account_label">아이디</label>
				<input type="text" placeholder="아이디" class="find_account_input"
					name="member_id"> <label class="find_account_label">이메일</label>
				<input type="email" placeholder="이메일" class="register_input"
					name="member_password" required> <label
					class="find_account_label">생년월일</label> <input type="date"
					placeholder="생년월일" class="register_input" name="member_password"
					required>

				<button type="submit" class="find_account_btn">아이디 비밀번호 찾기</button>
<p style="line-height:50px; margin-bottom:0;">아이디가 기억나지 않는다면?</p>
아이디만 빈칸으로 남겨주세요. 아이디를 알려드립니다.
			</div>
			<div class="find_account_find_idpw" style="background-color: #f1f1f1">

				<button type="button"
					onclick="document.getElementById('find_account_modal').style.display='none'"
					class="btn btn-secondary find_account_cancel_btn">취소</button>

			</div>
		</form>
	</div>


</body>
</html>
