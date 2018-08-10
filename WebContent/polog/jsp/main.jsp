<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<style>
.main_row {
	background-color: #fff;
	width: 860px;
	max-width: none !important;
	padding: 0;
	margin: 10px 0px 10px 10px;
}
</style>
<body>

	<div>
		<c:choose>
			<c:when test="${PologEdit!='true' }">
				<div class="row main_row" id="best_portfolio">
					<jsp:include page="bestPortfolio.jsp"></jsp:include>
				</div>
				<div class="row main_row" id="profile_detail">
					<jsp:include page="profileDetail.jsp"></jsp:include>
				</div>
			</c:when>
			<c:otherwise>
				<jsp:include page="pologEdit.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</div>
</body>
<script>
$(document).ready(function() {
	$('#polog_edit_submit').click(function() {

		$('#hidden_polog_edit').trigger('click');

	});
});
</script>
</html>