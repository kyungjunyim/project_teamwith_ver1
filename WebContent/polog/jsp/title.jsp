<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
@font-face {
	font-family: bmjua;
	src: url(../../font/BMJUA.eot) format('embedded-opentype'),
		url(../../font/BMJUA.woff) format('woff'), url(../../font/BMJUA.ttf)
		format('truetype');
	font-weight: 400;
}

.polog_title {
	margin: 5px 0px 0px 14px;
	padding: 0;
	width: 1100px;
	height: 150px;
	font-family: bmjua;
	text-align: center;
	line-height: 150px;
	font-size: 30px;
	background-image: url();
}

.polog_title:hover {
	opacity: 0.9;
}
</style>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="row">
		<div class="col-xs-1">
			<div class="polog_title theme" id="my_title">
				<c:choose>
					<c:when test="${polog.pologTitle!=null}">
			${polog.pologTitle}
			</c:when>
					<c:otherwise>황규진님의 폴로그 </c:otherwise>

				</c:choose>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.polog_title').click(function() {
				location.href = './polog.do';

			});

		});
	</script>
</body>
</html>