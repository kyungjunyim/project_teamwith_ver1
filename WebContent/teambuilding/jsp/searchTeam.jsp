<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team wITh</title>
<link rel="stylesheet" href="../../css/bootstrap.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="../../js/bootstrap.js"></script>
<style>
@font-face {
	font-family: yanoljaBold;
	src: url(../../font/yanoljaBold.eot) format('embedded-opentype'),
		url(../../font/yanoljaBold.woff) format('woff'),
		url(../../font/yanoljaBold.ttf) format('truetype');
	font-weight: bold;
}
@font-face {
	font-family: yanoljaRegular;
	src: url(../../font/yanoljaRegular.eot) format('embedded-opentype'),
		url(../../font/yanoljaRegular.woff) format('woff'),
		url(../../font/yanoljaRegular.ttf) format('truetype');
}
.home_container {
	width: 1100px;
	padding: 0;
	margin: 110px auto 0 auto;
	max-width: none !important;
}
</style>
</head>
<body style="background-color: #e4ecf4; font-family: yanoljaBold">
	<div class="menu">
		<jsp:include page="menuBar.jsp" />
	</div>
	<div class="home_container">
		<jsp:include page="teamSearchContents.jsp" />
	</div>
	<div class="home_container" style="margin-top: 10px">
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>