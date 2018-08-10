<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
body {
	padding: 0;
}
</style>
</head>
<body style="background-color: #e4ecf4; padding: -10;  font-family: yanoljaBold">
	<div class="menu">
		<jsp:include page="menuBar.jsp" />
	</div>
	<div class="home_container">
		<jsp:include page="teamInfoContents.jsp"/>
	</div>
	<div class="home_container" style="margin-top: 10px;">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>