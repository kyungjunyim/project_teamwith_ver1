<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="../css/topBtn.css" rel="stylesheet">
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.my_hr {
	width: 780px;
	margin: 20px auto;
}

.profile_regist_form_layout {
	width: 860px;
	margin: 10px;
	margin-bottom: 20px;
	background-color: #ffffff;
	border-radius: 7px;
	font-size: 20px;
}

.profile_regist_whole {
	width: 860px;
	padding: 0;
	margin: 0;
}

.profile_regist_row {
	width: 840px;
	padding: 0;
	margin: 0;
}

.profile_regist_form_title {
	width: 860px;
	margin: 15px 15px 0 15px;
	padding: 0;
}

.text_title {
	width: 830px;
	text-align: center;
	font-size: 25px;
	text-align: center;
}

.text_blue {
	color: #002b5a;
}

.profile_regist_form_col {
	font-size: 25px;
	padding: 0;
	margin: 0;
}

.profile_regist_form_text {
	width: 400px;
	text-align: center;
	margin: 0px -60px 20px -85px;
}

.profile_regist_form_input {
	width: 400px;
}

.profile_regist_row_btns {
	padding: 0 260px;
}

.btn_submit {
	margin: 0 10px;
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
	margin: 0 10px;
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
}

.team_regist_form_inputbox_mendatory {
	background-color: #fff4ef;
}

.team_regist_form_inputbox_mendatory:focus {
	color: #495057;
	background-color: #fff4ef;
	border-color: #ff7f44;
	outline: 0;
	box-shadow: 0 0 0 0.2rem rgba(255, 127, 68, 0.25);
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

h3 {
	margin-left: 40px;
}
</style>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

</head>
<body style="background-color: #e4ecf4">
	<div class="col-xs-6 profile_regist_form_layout theme">
		<div class="row profile_regist_whole">
			<div class="row profile_regist_form_title">
				<label class="text_title text_blue" style="font-size:32px;">나의 프로필 수정</label>
			</div>
			<hr class="my_hr">
			<form action="./profileUpdate.do" method="post"
				class="profile_regist_whole" id="profile_info">
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">
						아이디</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<input type="text" class="form-control" id="member_id" name="member_id"
							value="${sessionScope.pologOwner.memberId}" readonly>

					</div>
				</div>
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">이름</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<input type="text" class="form-control"
							id="member_name_in_profile" value="${sessionScope.pologOwner.memberName}" readonly>
					</div>
				</div>
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">이메일</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<input type="text" class="form-control" id="member_email"
							value="${sessionScope.pologOwner.memberEmail}" readonly>
					</div>
				</div>
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">전화번호</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<input type="text" class="form-control" id="member_phone"
							value="${sessionScope.pologOwner.memberPhone}">
					</div>
				</div>

				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">프로필
						사진</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<div class="custom-file">
							<input type="file" id="member_pic" name="member_pic"
								value="${sessionScope.pologOwner.memberPic }">
						</div>
					</div>
				</div>
				<hr class="my_hr">
<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">프로필 공개</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<c:choose>
							<c:when test="${sessionScope.pologOwner.memberActive==0}">
								<input type="checkbox" class="my_tog" data-toggle="toggle"
									data-onstyle="info" name="member_active" checked>
							</c:when>
							<c:otherwise>
								<input type="checkbox" class="my_tog" data-toggle="toggle"
									data-onstyle="info" name="member_active">
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">활동
						상태</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<c:choose>
							<c:when test="${sessionScope.pologOwner.memberActive==0}">
								<input type="checkbox" class="my_tog" data-toggle="toggle"
									data-onstyle="info" name="member_active" checked>
							</c:when>
							<c:otherwise>
								<input type="checkbox" class="my_tog" data-toggle="toggle"
									data-onstyle="info" name="member_active">
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">활동
						지역</div>
					<!-- Button trigger modal -->
					<button id=regionBtn type="button" class="btn btn-md btn_color"
						data-toggle="modal" data-target="#regionModal"
						style="height: 40px;">활동 지역 선택</button>
					<div class="modal" id="regionModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">활동 지역 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-1" value="region-1">서울
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-2" value="region-2">인천
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-3" value="region-3">부산
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-4" value="region-4">대전
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-5" value="region-5">대구
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-6" value="region-6">광주
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-7" value="region-7">울산
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-8" value="region-8">제주
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-9" value="region-9">세종
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-10" value="region-10">경기도
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-11" value="region-11">강원도
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-12" value="region-12">충청북도
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-13" value="region-13">충청남도
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-14" value="region-14">경상북도
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-15" value="region-15">경상남도
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-16" value="region-16">전라북도
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region"
												id="region-17" value="region-17">전라남도
										</div>

									</div>

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
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">자기소개</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<textarea class="my_form_control" id="member_intro"
							name="member_intro" placeholder="자기소개를 써주세요."
							style="width: 400px; height: 200px; background-color: #fff4ef; resize: none;">${sessionScope.pologOwner.memberIntro}</textarea>
						<div></div>
					</div>
				</div>

				<hr class="my_hr">
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">관심
						분야</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">
						<button id="categoryBtn" type="button"
							class="btn btn-md btn_color" data-toggle="modal"
							data-target="#categoryModal">관심 분야</button>
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

				</div>

				<div class="row profile_regist_row">



					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">역할</div>
					<div class="col-xs-6 profile_regist_form_col">
						<select name="member_role" id="member_role">
							<option>역할 선택</option>
							<option class="form-check-input" id="role-1" value="role-1">기획자</option>
							<option class="form-check-input" id="role-2" value="role-2">디자이너</option>
							<option class="form-check-input" id="role-3" value="role-3">개발자</option>
							<option class="form-check-input" id="role-4" value="role-4">기타</option>
						</select>

					</div>
				</div>

				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text">기술</div>
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_input">


						<button id="skillBtn" type="button" class="btn btn-md btn_color"
							data-toggle="modal" data-target="#skillModal">기술 선택</button>
						<div class="modal" id="skillModal" style="font-size: 25px;">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header"
										style="color: #ff4111; text-align: center">기술 선택</div>
									<!-- Modal body -->
									<div class="modal-body">
										<h4>기획자 역량</h4>	<hr>
										<c:forEach begin="0" varStatus="count"
											end="${fn:length(applicationScope.skills)}" var="sName"
											items="${applicationScope.skills}" step="3">

											<div class="row">
												<c:forEach begin="${count.index }" end="${count.index+2 }"
													var="ssName" items="${applicationScope.skills}">
													<c:if test="${ ssName.roleId=='role-1'}">
														<div class="col" style="margin-left: 20px;">
															<input type="checkbox" class="form-check-input"
																name="skill" id="${ssName.skillId}"
																value="${ssName.skillId}">${ssName.skillName}
														</div>
													</c:if>

												</c:forEach>
											</div>
										</c:forEach>
											<hr>
										<h4>디자이너 역량</h4>	<hr>
										<c:forEach begin="0" varStatus="count"
											end="${fn:length(applicationScope.skills)}" var="sName"
											items="${applicationScope.skills}" step="3">

											<div class="row">
												<c:forEach begin="${count.index }" end="${count.index+2 }"
													var="ssName" items="${applicationScope.skills}">
													<c:if test="${ ssName.roleId=='role-2'}">
														<div class="col" style="margin-left: 20px;">
															<input type="checkbox" class="form-check-input"
																name="skill" id="${ssName.skillId}"
																value="${ssName.skillId}">${ssName.skillName}
														</div>
													</c:if>

												</c:forEach>
											</div>
										</c:forEach>
											<hr>
										<h4>개발자 역량</h4>	<hr>
										<c:forEach begin="0" varStatus="count"
											end="${fn:length(applicationScope.skills)}" var="sName"
											items="${applicationScope.skills}" step="3">

											<div class="row">
												<c:forEach begin="${count.index }" end="${count.index+2 }"
													var="ssName" items="${applicationScope.skills}">
													<c:if test="${ ssName.roleId=='role-3'}">
														<div class="col" style="margin-left: 20px;">
															<input type="checkbox" class="form-check-input"
																name="skill" id="${ssName.skillId}"
																value="${ssName.skillId}">${ssName.skillName}
														</div>
													</c:if>

												</c:forEach>
											</div>
										</c:forEach>
											<hr>
										<h4>기타 역량</h4>	<hr>
										<c:forEach begin="0" varStatus="count"
											end="${fn:length(applicationScope.skills)}" var="sName"
											items="${applicationScope.skills}" step="3">

											<div class="row">
												<c:forEach begin="${count.index }" end="${count.index+2 }"
													var="ssName" items="${applicationScope.skills}">
													<c:if test="${ ssName.roleId=='role-4'}">
														<div class="col" style="margin-left: 20px;">
															<input type="checkbox" class="form-check-input"
																name="skill" id="${ssName.skillId}"
																value="${ssName.skillId}">${ssName.skillName}
														</div>
													</c:if>

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
				</div>

				<hr class="my_hr">
				<h3>자격증</h3>
				<div id="faq" class="faq">
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">자격증
							이름</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="text"
								class="form-control profile_regist_form_inputbox" value="정보처리기사">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">자격증
							수준</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="text"
								class="form-control profile_regist_form_inputbox" value="">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">자격증
							취득일자</div>
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_input">
							<input type="text"
								class="form-control profile_regist_form_inputbox" value="2017년 9월">
							<button type="button" class="btn btn-md btn_color"
								id="btn_remove_faq" onclick="remove_faq(this)">삭제하기</button>
						</div>
					</div>
				</div>
				<div id="addFaq"></div>
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text"></div>
					<div class="col-xs-6 profile_regist_form_col">
						<button type="button" class="btn"
							style="background-color: white; color: blue;" onclick="add_faq()">추가하기</button>
					</div>
				</div>
				<hr class="my_hr">
				<h3>경력</h3>
				<div id="interview" class="interview">
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">경력명</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="text"
								class="form-control profile_regist_form_inputbox"
								placeholder="수상 경력, 인턴 경력, 프로젝트 진행 경험 등을 적어주세요.">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">역할</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="text"
								class="form-control profile_regist_form_inputbox">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">시작일</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="date"
								class="form-control profile_regist_form_inputbox">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">종료일</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<input type="date"
								class="form-control profile_regist_form_inputbox">
						</div>
					</div>
					<div class="row profile_regist_row">
						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text">상세
							설명</div>
						<div
							class="col-xs-6 profile_regist_form_col  profile_regist_form_input">
							<textarea class="form-control profile_regist_form_inputbox"
								placeholder="수상 내역, 인턴 내용, 프로젝트 설명 등 자유롭게 설명을 써주세요."></textarea>
						</div>
					</div>
					<div class="row profile_regist_row">


						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_text"></div>

						<div
							class="col-xs-6 profile_regist_form_col profile_regist_form_input">

							<button type="button" class="btn btn-md btn_color"
								id="btn_remove_interview" onclick="remove_interview(this)">삭제하기</button>
						</div>
					</div>
				</div>
				<div id="addInterview"></div>
				<div class="row profile_regist_row">
					<div
						class="col-xs-6 profile_regist_form_col profile_regist_form_text"></div>
					<div class="col-xs-6 profile_regist_form_col">
						<button type="button" class="btn"
							style="background-color: white; color: blue;"
							onclick="add_interview()">추가하기</button>
					</div>
				</div>
				<hr class="my_hr">

				<div>
					<jsp:include page="tendency.jsp"></jsp:include>
				</div>

				<div class="row profile_regist_row profile_regist_row_btns"
					style="margin-bottom: 20px;">
					<button type="button" class="btn btn-md btn_cancel" onclick="location.href='./polog.do'">취소하기</button>
					<button type="submit" class="btn btn-md btn_submit"
						id="profile_submit">등록하기</button>
				</div>
			</form>
			<button onclick="topFunction()" id="top_btn" title="맨 위로 가기">Top</button>
		</div>
	</div>


</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="../js/profileEdit.js"></script>
<script src="../js/topBtn.js"></script>
<script>

	$(document)
			.ready(
					function(e) {
						
						<c:forEach var="r" items="${region}">
						$('input:checkbox[id=${r}]')[0].checked = true;
						</c:forEach>

						<c:forEach var="c" items="${category}">
						$('input:checkbox[id=${c}]')[0].checked = true;
						</c:forEach>
						<c:forEach var="r" items="${skill}">
						$('input:checkbox[id=${r}]')[0].checked = true;
						</c:forEach>
						$('#member_role').val("${member.roleId}");
						
						var regionCnt = $('input:checkbox[name="region"]:checked').length;
						var skillCnt = $('input:checkbox[name="skill"]:checked').length;
						var categoryCnt = $('input:checkbox[name="category"]:checked').length;
						$('#regionBtn').text(
								'활동 지역 ' + regionCnt);
						$('#skillBtn').text(
								'기술 선택 ' +skillCnt );
						$('#categoryBtn').text(
								'관심 분야 '+categoryCnt);
						$('#profile_info')
								.change(function(){	var regionCnt = $('input:checkbox[name="region"]:checked').length;

								var skillCnt = $('input:checkbox[name="skill"]:checked').length;
								var categoryCnt = $('input:checkbox[name="category"]:checked').length;
								$('#regionBtn').text(
										'활동 지역 ' + regionCnt);
								$('#skillBtn').text(
										'기술 선택 ' +skillCnt );
								$('#categoryBtn').text(
										'관심 분야 '+categoryCnt);
								});
								
						$('#search_btn').click(function(e) {
							//검색 버튼을 클릭하면 form 데이터를 post방식으로 서버에 전송한다.
						});

					});


	
	var uploadFile = function() {
		alert($('#member_pic').val());
	}
</script>

</html>