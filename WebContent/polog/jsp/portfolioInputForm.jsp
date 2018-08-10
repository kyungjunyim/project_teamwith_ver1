<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"/>
<title>Insert title here</title>
<style>
	.myrow{
		width:860px;
		margin-top:15px;
		margin-bottom:15px;
		font-size:25px;
		font-color:#002b5a;
		
	}
	.portfolioInputForm_option{
		background-color:#ffffff;
		
	}
	.portfolioInputForm_necessary{
		background-color: #fff4ef;
	}
	.mycol{
	width:360px;
	text-align:center;
	}
	.portfolio_register_title{
		font-size:30px;
		width:860px;
		margin:0 auto;
		text-align:center;
	}
	/* The switch - the box around the slider */
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
   height: 34px;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
   background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
   width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
   background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
} 
</style>
</head>
<body>
<div class="row myrow">
<form id="portfolio_register_form" action="./portfolioAdd.do" method="post">
	<div class="portfolio_register_title" >포트폴리오 등록</div>
	<div class ="row myrow "><div class="mycol">포트폴리오 제목 </div><div class="mycol"><input class="form-control portfolioInputForm_necessary" type="text" name="portfolio_title"></div></div>
	<div class ="row myrow"><div class="mycol">프로젝트 소개</div><div class="mycol"> <textarea class="form-control portfolioInputForm_necessary" name="portfolio_intro" style="resize: none;"rows="15" cols="50"></textarea>	</div></div>
	<div class ="row myrow"><div class="mycol">시작 일자 </div><div class="mycol"><input class="form-control portfolioInputForm_option" type="date" name="portfolio_start_date"></div></div>
	<div class ="row myrow"><div class="mycol">종료 일자</div><div class="mycol"> <input class="form-control portfolioInputForm_option" type="date" name="portfolio_end_date"></div></div>
	<div class ="row myrow"><div class="mycol">팀 이름 </div><div class="mycol"><input class="form-control portfolioInputForm_option" type="text" name="portfolio_team_name"></div></div>
	<div class ="row myrow"><div class="mycol">참여 인원 </div><div class="mycol"><input class="form-control portfolioInputForm_option" type="number" name="portfolio_people_num"></div></div>
	<div class ="row myrow"><div class="mycol">역할 </div><div class="mycol"><input class="form-control portfolioInputForm_option" type="text" name="portfolio_role"></div></div>
	<div class ="row myrow"><div class="mycol">업무 내용</div><div class="mycol">  <textarea class="form-control portfolioInputForm_option" name="portfolio_work" style="resize: none;"rows="10" cols="50"></textarea></div></div>
	<div class ="row myrow"><div class="mycol">사용 기술 </div><div class="mycol"><input class="form-control portfolioInputForm_option" type="text" name="portfolio_skill"></div></div>
	<div class ="row myrow"><div class="mycol">대표 사진</div><div class="mycol"> <input class="form-control portfolioInputForm_option" type="file" name="portfolio_pic" /></div></div>
	<div class="row myrow">
	<div class="mycol">카테고리</div>
		<div class="mycol" style="text-align:left">
			<button id="categoryBtn" type="button"
				class="btn btn-md btn_color" data-toggle="modal"
				data-target="#categoryModal" >카테고리</button>
		</div>
			<div class="modal" id="categoryModal" style="font-size: 25px;">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"
							style="color: #ff4111; text-align: center">분야 선택</div>
						<!-- Modal body -->
						<div class="modal-body">
							<c:forEach begin="0" varStatus="count"
								end="${fn:length(applicationScope.categories)}" var="cName"
								items="${applicationScope.categories}" step="3">
								<div class="row">
									<c:forEach begin="${count.index }" end="${count.index+2 }"
										var="ccName" items="${applicationScope.categories}">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input"
												name="category" id="${ccName.key}" value="${ccName.key}">
												${ccName.value}
										</div>
									</c:forEach>
								</div>
							</c:forEach>
							<div class="row">
								<button type="button" class="btn btn-mid btn_color"
									data-dismiss="modal"
									style="margin-left: 150px; margin-bottom: 20px; margin-top: 30px;">확인</button>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
	<div class="row myrow"><div class="mycol">대표 포트폴리오</div><div class="mycol" style="text-align:left"><label class="switch" style="margin-top:7px">  <input type="checkbox">  <span class="slider round"></span></label></div></div> 
	</form>
	</div>
</body>
</html>