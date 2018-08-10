<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
@font-face {
	font-family: bmjua;
	src: url(/teamwith/font/BMJUA.eot) format('embedded-opentype'),
		url(/teamwith/font/BMJUA.woff) format('woff'),
		url(/teamwith/font/BMJUA.ttf) format('truetype');
}

.menu_bar {
	width: 1100px;
	height: 100px;
	padding: 0;
	margin: 0 auto;
	max-width: none !important;
	border: 1px solid #e4ecf4;
	background-color: #ffffff;
	border-radius: 7px;
}

.menu_bar_nav-item {
	margin: 0 30px;
	font-size: 20px;
	font-weight: bold;
	cursor: pointer;
	color: #002b5a;
}

.menu_bar_nav-item:hover {
	color: #ff4111;
}

.menu_bar_box_logo {
	width: 60px;
	height: 60px;
	margin-left: 5px;
}

.menu_bar_text_logo {
	height: 40px;
	margin-left: 10px;
}

.menu_bar_menu_link {
	text-decoration: none;
	color: #002b5a;
}

.menu_bar_menu_link:hover {
	text-decoration: none;
	color: #ff4111;
}

.menu_bar_justify-content-center {
	margin: auto;
}

.nav-link {
	font-weight: 400;
	font-family: bmjua;
	font-size: 25px;
}



</style>
</head>
<body>
	<nav
		class="navbar navbar-inverse fixed-top menu_bar">
		<div class="container-fluid">
			<form action="home.do" method="post" class="to_home">
				<div class="navbar-header">
					<img src="/teamwith/image/logoBox.png" class="menu_bar_box_logo" style="cursor: pointer">
					<img src="/teamwith/image/logoText.png" class="menu_bar_text_logo" style="cursor: pointer">
				</div>
			</form>
			<ul class="nav menu_bar_justify-content-center">
				<li class="menu_bar_nav-item"><a
					class="nav-link menu_bar_menu_link"
					href="teambuilding/jsp/team.jsp">팀</a></li>
				<li class="menu_bar_nav-item"><a
					class="nav-link menu_bar_menu_link" href="member.jsp">회원</a></li>
				<li class="menu_bar_nav-item"><a
					class="nav-link menu_bar_menu_link" href="portfolio.jsp">포트폴리오</a></li>
				<li class="menu_bar_nav-item"><a
					class="nav-link menu_bar_menu_link commingSoon">공모전</a></li>
			</ul>
		</div>
	</nav>
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(".navbar-header").click(function(e) {
		$(".to_home").submit();
	})
	$(".commingSoon").click(function(e) {
		alert("준비중인 서비스입니다.");
	})
</script>
</html>