<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
.main_contents_row_whole {
	margin: 0 0 10px 0;
}
</style>
<body>
	<div class="row main_contents_row_whole">
		<div class="col-xs-6 main_contents_container" style="width: 860px">
			<c:if test="${not empty sessionScope.memberBean}">
				<jsp:include page="myTeam.jsp" />
			</c:if>
			<jsp:include page="recentTeam.jsp" />
			<jsp:include page="bestMember.jsp" />
		</div>
		<div>
			<jsp:include page="sideMenu.jsp" />
		</div>
	</div>
</body>
</html>