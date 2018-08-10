<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE>
<html lang="en">
<head>
<meta charset="UTF-8">
<style>
.row {
	width: 1100px;
	margin: 0;
}

.row_content {
	width: 860px;
	margin: 0 10px 10px 0;
}

.box_content {
	background-color: #ffffff;
	border-radius: 7px;
}

.text_orange {
	color: #ff4111;
}

.text_blue {
	color: #002b5a;
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

.btn_kyu {
	width: 60px;
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
</style>
</head>
<body>
	<div class="col-xs-6 col_content">
		<div class="row row_content box_content">
			<div class="row" style="margin: auto;">
				<div class="text_orange"
					style="margin: auto; margin-top: 30px; margin-bottom: 30px;">
					<h1>나의지원</h1>
				</div>
			</div>
			<div class="row" style="margin: auto; width: 650px;">
				<table class="table table-hover table_size_kyu text-truncate" style="font-size: 18px;">
					<tr style="text-align: center;">
						<th>사진</th>
						<th>팀명</th>
						<th>모집분야</th>
						<th>지원날짜</th>
						<th>부가정보</th>
						<th>지원상태</th>
						<th>비고</th>
					</tr>
					<c:if test="${empty myApplicationList }">
						<tr><td>지원 내역이 없습니다.</td></tr>
					</c:if>
					<c:forEach items="${myApplicationList }" var="myApplication" varStatus="status">
						<tr>
							<td><img src="${myApplication.teamPic }" class="rounded-circle" width="40" height="40"></td>
							<td>${myApplication.teamName }</td>
							<td>${myApplication.roleId }</td>
							<td>${fn:substring(myApplication.applicationDate, 0, 10) }</td>
							<td>
								<button type="button" class="btn btn_color btn_kyu"	data-toggle="modal" data-target="#myModal${status.index }">보기</button>
								<div class="modal" id="myModal${status.index }">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header text_orange">간단면접</div>
											<!-- Modal body -->
											<div class="modal-body">
												<div class="row">매일 아침 7시부터 프로젝트 진행하는데 괜찮으세요?</div>
												<div class="row">
													<div class="col"></div>
													<div class="col-12">A:당연하죠</div>
												</div>
											</div>
											<div class="modal-header text_orange">하고싶은 말</div>
											<!-- Modal body -->
											<div class="modal-body">제발 저 좀 써주세요..</div>

											<!-- Modal footer -->
											<div class="modal-footer">
												<button type="button" class="btn" data-dismiss="modal">확인</button>
											</div>
										</div>
									</div>
								</div>
							</td>
							<td>${myApplication.applicationStatus }</td>
							<td>
								<button type="button" data-toggle="modal"
									data-target="#myModalCancel" class="btn btn_color btn_kyu">취소</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>