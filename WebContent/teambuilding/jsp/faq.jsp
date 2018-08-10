<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<style>
.row {
	width: 860px;
	margin: 0;
}

.row_title {
	color: #ff4111;
}

.row_text {
	padding-left: 30px;
}

.my_hr {
	width: 780px;
	margin: 20px 0;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#img').click(function(e) {
			$('#leaderForm').submit();
		});
	});
</script>
<body>
	<div class="row" style="margin-top: 20px;">
		<div class="row row_title">FAQ</div>
		<c:forEach items="${requestScope.faqList }" var="faq">
			<div class="row row_text" style="margin-top:20px;">Q: ${faq.faqQuestion }</div>
			<div class="row row_text" style="margin-left: 40px; margin-top: 10px;">
				<lable style="margin-left:15px;">팀장 답변 : ${faq.faqAnswer }</lable>
			</div>
			<form id="leaderForm" action="./polog.do" method="post">
				<input type="hidden" value="${requestScope.teamDetailVO.memberId }">
			</form>
		</c:forEach>
	</div>
</body>
</html>