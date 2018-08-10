<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>here title</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
@font-face {
	font-family: NanumSquareRoundEB;
	src: url(../../font/NanumSquareRoundEB.eot) format('embedded-opentype'),
		url(../../font/NanumSquareRoundEB.woff) format('woff'),
		url(../../font/NanumSquareRoundEB.ttf) format('truetype');
}
.container {
	width: 1100px;
	max-width: none !important;
	padding: 0;
	margin: auto;
	font-family: yanoljaBold;
}

.polog_profile {
	width: 230px;
}

.polog_padding {
	width: 10px;
}

.polog_main {
	width: 860px;
	
}

.menu_and_main {
	display: none;
}
.theme{
background-color: white;
}
a:hover{
color:#f2f2f2;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<style>

.portfolid_detail_row{
margin:20px;
width:810px;
height:auto;



}
.portfolio_title{
	
	width:810px;
	height:100px;
	margin: 10px 0px;
	text-align:center;
	font-size:30px;
}
.my{
width: 860px;
	text-align:right;
	/* background-color:white; */
}
.btn_color {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #002b5a;
	background-color: #ffffff;
	border-color: #002b5a;
}

.btn_color:hover {
	color: #ff4111;
	background-color: #f7e7e3;
	border-color: #ff4111;
}

.btn_submit {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #fff;
	background-color: #ff4111;
	opacity: 0.7;
}

.btn_submit:hover {
	color: #fff;
	background-color: #ff4111;
	border-color: #fff;
	opacity: 1;
}

.btn_cancel {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
}
.smalle{
width:250px;
height:250px;
margin-left:100px;
margin-top:10px;
background-color:white;
border:4px solid #e4ecf4;
border-radius: 10px;
}
.hbige{
	width:650px;
	height: auto;
	margin-left:95px;
	background-color:white;
	border:1px solid #e4ecf4;
	
}
.smallme{
	margin-left:140px;
}
.vbige{
	width:250px;
	height:512px;
	margin-left:275px;
	margin-top:10px;
	background-color:white;
	border:1px solid #e4ecf4;
	
}
.l4vbige{
	margin-left:25px;
}
.l4smalle{
	margin-left:260px;
}
.main_row {
width: 860px;
	max-width: none !important;
	
	padding: 0;

	margin: 10px 0px 10px 10px;
}
</style>
<script>
	$(document).ready(function(e){
		
		$('#updatebtn').click(function(e){
			$.ajax({

			    type: 'post'

			  , url: 'portfolioRegister.jsp'
				
			  , dataType : 'html'

			  , success: function(data) {

			    $('.polog_main').html(data);

			  }

			 });	

			 });
		
		$('#deletebtn').click(function(e){
			
			var d={"dd":"go"};
			$.post({

			    type: 'post'

			  , url: 'portfolioDelete.do'
				
			  , dataType : 'html'
			  , data : d

			  , success: function(data) {
					
			    $('.polog_main').html(data);

			  }

			 });	
		});

		});
</script>
</head>
<body>

<div class="window"  style="background-color: #e4ecf4;">
	<div class="container">
		<div class="row">
			<div>
				<jsp:include page="header.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="row">
			<jsp:include page="title.jsp"></jsp:include>
			</div>

		<div class="row">

			<div class="col-xs-3 polog_profile">
				<jsp:include page="menu.jsp"></jsp:include>
			</div>
			
			<div class="col-xs-7 polog_main">
				<div class="main_row">
<div class="main_row">
<div class="theme">
	<div class="row portfolid_detail_row " id="portfolio_title">
		<div class="col-xs-6 portfolio_title">
		포트폴리오 아이디 : ${requestScope.portfolio.portfolioId}<br>제목 :${requestScope.portfolio.portfolioTitle }   
		
		
		</div>
	</div>
	<c:forEach items="${requestScope.portfolioContentElementList }" var="e" varStatus="i">
	<c:set var="index" value="${e }" scope="request"/>
	<c:choose>
	<c:when test="${e[0].layoutName=='sh2'}">
	<div class="row portfolid_detail_row"  >
		<jsp:include page="portfolioLayout1.jsp"/>
	</div>
	
	</c:when>
	<c:when test="${e[0].layoutName=='sv2lv1'}">
	<div class="row portfolid_detail_row" >
		<jsp:include page="portfolioLayout2.jsp"/>
	</div>
	</c:when>
	<c:when test="${e[0].layoutName=='lh1' }">
		<div class="row portfolid_detail_row" >
		<jsp:include page="portfolioLayout3.jsp"/>
	</div>
	</c:when>
	<c:when test="${e[0].layoutName=='lv1sv2'}">
		<div class="row portfolid_detail_row" id="aa">
		<jsp:include page="portfolioLayout4.jsp"/>
	</div>
	</c:when>
	</c:choose>
	</c:forEach>
	<div class="row portfolid_detail_row ">
		<div class="col-xs-12 my"><button type="button" class=" btn btn-md btn_color" id="updatebtn">수정하기</button>
		<button type="button" class=" btn btn-md btn_color" id="deletebtn">삭제하기</button>
		</div>
		
	</div>
	</div>
	</div>
				
			
			</div>
		</div>
<div class="row" style="margin-top:10px">
<jsp:include page="footer.jsp"></jsp:include>
</div>
	</div>
	
	
	</div>
</body>
<script>
		$(document).ready(function() {
			document.title="황규진님의 폴로그";
			
			$('#profile_edit_btn').click(function() {
				$.post({
					url : './profileEdit.jsp', //이동할 주소
					method : 'POST',
					
					async : true,
					success : function(data, status, xhr) {
						
						if (status == 'success') {
							console.log($('.polog_main'));
							$('.polog_main').html(data);
						} else {
							alert();
						}
					}
				});

			});

			$('#polog_design_btn').click(function() {
				$.ajax({
					url : './pologEdit.jsp', //이동할 주소
					method : 'POST',
					
					async : true,
					success : function(data, status, xhr) {
						
						if (status == 'success') {
							console.log($('.polog_main'));
							$('.polog_main').html(data);
							
						} else {
							alert();
						}
					}
				});

			});
			
			
			$('#polog_portfolio_add').click(function() {
				$.ajax({
					url : 'portfolioRegister.do', //이동할 주소
					method : 'POST',
					
					async : true,
					success : function(data, status, xhr) {
						
						if (status == 'success') {							
							$('.polog_main').html(data);
						} else {
							alert();
						}
					}
				});

			});
			
		});
	</script>
</html>