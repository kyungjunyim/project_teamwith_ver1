<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>here title</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

.theme {
	background-color: white;
}

a:hover {
	color: #f2f2f2;
}
</style>
<script>
	
</script>
</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="window" style="background-color: #e4ecf4;">
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
			
				<c:choose>
					<c:when test="${polog.pologMenuPosition == 'l1' }">
						<div class="col-xs-3 polog_profile">
							<jsp:include page="menu.jsp"></jsp:include>
						</div>
						<div class="col-xs-7 polog_main">
							<jsp:include page="main.jsp"></jsp:include>
						</div>
					</c:when>
					
					<c:otherwise>
						<div class="col-xs-7 polog_main" style="width:880px; margin:0px -10px;">
							<jsp:include page="main.jsp"></jsp:include>
						</div>
						<div class="polog_padding">&nbsp;</div>
						<div class="col-xs-3 polog_profile">
							<jsp:include page="menu.jsp"></jsp:include>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="row">
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>


	</div>
</body>
<script>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	$(document).ready(function() {
		//="${color }"
		//<c:if test="${myTitle!=null}">
		document.title = "${polog.pologTitle}";

		$('#polog_edit_submit').click(function() {
			alert();
			$('#hidden_polog_edit').click(function() {
				$(".polog_profile").insertAfter(".polog_main");
			});
		});

		//$('#my_title')[0].innerText="${myTitle}";
		//</c:if>

		//console.log(document.getElementsByClassName('theme')[0].style.backgroundColor="${color }");
		//console.log(document.getElementsByClassName('theme')[0].style.backgroundColor);

		$('#profile_edit_btn').click(function() {
			$.ajax({
				url : './profileEdit.do', //이동할 주소
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
		/*
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
		 */
		$('#portfolio_add_btn').click(function() {
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