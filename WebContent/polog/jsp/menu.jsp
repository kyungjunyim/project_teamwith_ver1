<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
#polog_menu {
	width: 230px;
	max-width: none !important;
	background-color: #e4ecf4;
	padding: 0;
	margin: 10px 0px;
}

#polog_list {
	width: 230px;
	max-width: none !important;
	background-color: #e4ecf4;
	padding: 0px;
	margin: 10px 0px;
}
</style>

</head>
<body>

	<div class="row" id="polog_menu">
		<jsp:include page="profile.jsp"></jsp:include>
	</div>
	<div class="row" class="theme" id="polog_list">
		<jsp:include page="list.jsp"></jsp:include>
	</div>


</body>
</html>