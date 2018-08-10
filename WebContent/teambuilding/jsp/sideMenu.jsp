<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.side_menu_row_menu {
	width: 230px;
	margin: 0 0 10px 0;
	background-color: #ffffff;
	border-radius: 7px;
}

.side_menu_box_content {

}
</style>
</head>
<body>
	<div class="col-xs-6" style="margin-left: 10px;">
		<div class="row side_menu_row_menu side_menu_box_content">
			<c:choose>
				<c:when test="${not empty sessionScope.memberBean }">
					<jsp:include page="profile.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="loginInput.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row side_menu_row_menu side_menu_box_content">
			<jsp:include page="simplePortfolio.jsp" />
		</div>
	</div>
</body>
</html>