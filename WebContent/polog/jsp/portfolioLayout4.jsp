<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row portfolio_layout">
		<div class="col-xs-9 vbige l4vbige" id="l4e1">
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
		<div class="col-xs-3">
			<div class="row ">
				<div class="col-xs-3 smalle l4smalle" id="l4e2">
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
			<div class="row">
				<div class="col-xs-3 smalle l4smalle" id="l4e3">
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
		
	</div> 
</body>
</html>