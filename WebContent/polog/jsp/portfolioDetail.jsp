<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	background-color:white;
	text-align:center;
	font-size:30px;
}
.my{
width: 860px;
	text-align:right;
	background-color:white;
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
border:1px solid black;
}
.hbige{
	width:750px;
	height: auto;
	margin-left:50px;
	background-color:white;
	border:1px solid black;
	
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
	border:1px solid black;
	
}
.l4vbige{
	margin-left:50px;
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
	<script>
	
	/* $('#l1e1').html(str);
	$('#l1e2').html(img);
	$('#aa').attr('id','asd'); */
	/* $('#asd #l3e1').html('안녕하세요ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ<br><br><br><br><br><br>'); */
	/* var l21img="<img width='250px' height='250px' src='../../image/why.jpg'/>";
	var l22img="<img width='250px' height='250px' src='../../image/po.jpg'/>";
	var l23pdf="<iframe width='250px' height='512px' src='../../image/aaa.pdf'></iframe>";
	$('#l2e1').html(l21img);
	$('#l2e2').html(l22img);
	$('#l2e3').html(l23pdf);
	$('#l4e1').html('안녕하세요 ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ만나서 반갑습니다');
	$('#l4e2').html("<img width='250px' height='250px' src='../../image/dog.jpg'/>")
	$('#l4e3').html("<img width='250px' height='250px' src='../../image/cat.jpg'/>") */
	
	</script>
</div>
</body>

</html>