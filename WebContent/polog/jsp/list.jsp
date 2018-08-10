<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
.category_name {
	font-weight: bold;
}

.nav-item {
	font-size: 15pt;
}

.list_nav{
list-style:none;
width:230px;
padding:20px;
font-size: 25px;
}

a:hover{
color:#929292;
}
.bb:hover{
	cursor:pointer;
	color:#929292;
}
</style>

</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="theme">
	<c:choose>
<c:when test="${sessionScope.pologOwner.memberId=='hwangkyujin' }">
		<ul class="list_nav">
			<li>
				<div class="category_name project_category1">빅데이터</div>
			</li>
			
			<li class="nav-item">
			<div class="text-truncate" style="width:190px; word-wrap:normal;">
			<label style="width:190px;">
			<label class="nav-link bb text-truncate"  id="portfolio-1">경기 빅데이터 공모전 수상작</label>
			</label></div></li>
			
			<li class="nav-item"><div class="text-truncate" style="width:190px; word-wrap:normal;"><label class="nav-link bb text-truncate" 
				 width="190px" id="portfolio-2">2017 공공 빅데이터 공모전 수상작</label></div></li>
			

			<li>
				<div class="category_name project_category2">보안</div>
			</li>
			<li class="nav-item"><label class="nav-link bb text-truncate"  id="portfolio-3">보안 취약점
					자동분석 아이디어 공모전</label></li>
					
		</ul>
		</c:when>
		<c:otherwise >
		<ul class="list_nav">
			<li>
				<div class="category_name project_category1">로봇/자동차</div>
			</li>
			
			<li class="nav-item">
			<div class="text-truncate" style="width:190px; word-wrap:normal;">
		
			<label class="nav-link bb text-truncate" id="portfolio-1">가사도우미 뽀미</label>
			</div></li>
			
			<li class="nav-item"><div class="text-truncate" style="width:190px; word-wrap:normal;"><label class="nav-link bb text-truncate" 
				 width="190px" id="portfolio-2">스마트카</label></div></li>
					
		</ul>
		</c:otherwise>
		</c:choose>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.bb').click(function(e){
				
				var id=$(this).attr('id');
				var $f=$("<form action='portfolioDetail.do'></form>");
				var $h=$("<input type='hidden' name='portfolio_id'/>");
				$h.attr('value',id);
				$f.append($h);
				$('body').append($f);
				$f.submit();
			/* $('.nav-link').click(function() {
				$.ajax({
					url : './portfolioDetail.jsp', //이동할 주소
					method : 'post',
					async : true,
					success : function(data, status, xhr) {
						console.log(status);
						if (status == 'success') {
							//xhr.responseText
							console.log(data);
							$('.polog_main').html(data);

						} else {
							alert();
						}
					}
				})*/
			}); 
		});
	</script>
</body>
</html>