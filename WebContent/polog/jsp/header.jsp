<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>

<style>
.polog_header {
	width: 1100px;
	max-width: none !important;
	height: 35px;
	margin: auto;
}

.container {
	width: 1100px;
}

.polog_header .logo:hover {
	opacity: 0.8;
}

.polog_header img {
	height: 23px;
	margin: 5px 25px;
}

.polog_header_gap {
	width: 0px;
}

.polog_header_menu {
	width: 970px;
	text-align: right;
	margin-top: 5px;
}

.polog_header_menu a {
	font-size: 17px;
}

.polog_header_menu a:hover {
	text-decoration: none;
}
</style>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="polog_header theme">
		<div class="row">

			<!-- 로고 -->
			<div class="col-xs-1">
				<img src="../../image/logoText.png" id="logo">
				<form action="/teamwith/home.do" method="post">
					<button type="submit" style="display: none;" id="teamwith_btn"></button>
				</form>
			</div>


			<!-- 오른쪽 상단 -->
			<div class="col-xs-1 polog_header_menu">
				<c:if test="${sessionScope.memberBean.memberId==sessionScope.pologOwner.memberId }">
					<a href="#" id="profile_edit_btn">프로필 수정</a> &nbsp; &nbsp; &nbsp; <a
						href="pologEdit.do" id="polog_design_btn">폴로그 꾸미기</a> &nbsp; &nbsp;
				&nbsp;
				</c:if>

				<a href="#" id="search_polog">다른 폴로그 구경하기</a> &nbsp;&nbsp;&nbsp;
				<c:if test="${sessionScope.memberBean.memberId!=null }">
				 <a href="polog.do" id="my_polog">내 폴로그</a> &nbsp;
				&nbsp;&nbsp;
				</c:if>
				<c:if test="${sessionScope.memberBean.memberId==null }">
						<span id="login"> <jsp:include page="login.jsp"></jsp:include></span>
					<jsp:include page="register.jsp"></jsp:include>
					<jsp:include page="findAccount.jsp"></jsp:include>
				</c:if>
			</div>

		</div>

	</div>
	<script>
		$(document).ready(function() {
			$('#logo').click(function() {
				$('#teamwith_btn').trigger('click');
			});

		});
	</script>
</body>
</html>