<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>



</style>
</head>
<body>

	<div class="row portfolio_layout">
		<div class="col-xs-3">
			<div class="row " >
				<div class="col-xs-3 smalle" id="l2e1">
					<c:forEach  items="${requestScope.index }" var="portfolioContentElement">
		<c:if test="${portfolioContentElement.layoutId=='layout-1' }">
		
			<c:choose>
				<c:when test="${portfolioContentElement.elementName=='이미지' }">
					<img src="../../image/${portfolioContentElement.elementContent}" style="width:250px;height:250px"/>
				</c:when>
				<c:when test="${portfolioContentElement.elementName=='동영상' }">
					<iframe width='248' height='248' src='${portfolioContentElement.elementContent}' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>
				</c:when>
				<c:otherwise>
					${portfolioContentElement.elementContent }
				</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
				</div>
			</div>
			<div class="row" >
				<div class="col-xs-3 smalle" id="l2e2">
					<c:forEach  items="${requestScope.index }" var="portfolioContentElement">
		<c:if test="${portfolioContentElement.layoutId=='layout-1' }">
		
			<c:choose>
				<c:when test="${portfolioContentElement.elementName=='이미지' }">
					<img src="../../image/${portfolioContentElement.elementContent}" style="width:250px;height:250px"/>
				</c:when>
				<c:when test="${portfolioContentElement.elementName=='동영상' }">
					<iframe width='248' height='248' src='${portfolioContentElement.elementContent}' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>
				</c:when>
				<c:otherwise>
					${portfolioContentElement.elementContent }
				</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-xs-9 vbige" id="l2e3">
			<c:forEach  items="${requestScope.index }" var="portfolioContentElement">
		<c:if test="${portfolioContentElement.layoutId=='layout-1' }">
		
			<c:choose>
				<c:when test="${portfolioContentElement.elementName=='이미지' }">
					<img src="../../image/${portfolioContentElement.elementContent}" style="width:250px;height:250px"/>
				</c:when>
				<c:when test="${portfolioContentElement.elementName=='동영상' }">
					<iframe width='248' height='248' src='${portfolioContentElement.elementContent}' frameborder='0' allow='autoplay; encrypted-media' allowfullscreen></iframe>
				</c:when>
				<c:otherwise>
					${portfolioContentElement.elementContent }
				</c:otherwise>
			</c:choose>
			</c:if>
			</c:forEach>
		</div>
	</div> 
</body>
</html>
