<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<style>
.row {
	width: 860px;
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

.btn {
	height: 30px;
	line-height: 15px;
	background-color: #f2f2f2;
}

.btn_submit {
	width: 140px;
	padding: 0px 10px;
	font-size: 17px;
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

.row_title {
	color: #ff4111;
}

.row_text {
	padding-left: 30px;
}

.my_hr {
	width: 780px;
	margin: 20px 0;
}

.text_color_red {
	color: #ff4111;
}

.team_detail_text_font {
	font-family: '나눔스퀘어라운드 ExtraBold';
	font-size: 18px;
	color: #002b5a;
}

.teamDetail {
	font-weight: bold;
}

.team_detail_hover_opacity:hover {
	opacity: 0.8;
	background-color: #c3dcf7;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#leader').click(function(e) {
			$('#leaderForm').submit();
		});
		$('#applyBtn').click(function(e) {
			$('#applyTry').text("지원 취소");
			$('#applyTry2').text("지원 취소");
		});
		$('#closeBtn').click(function(e) {
			$('#closeForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="col-xs-6 col_content team_detail_text_font">
		<div class="row row_content box_content"
			style="margin: auto; padding: 20px; text-align: center;">
			<div class="row" style="margin-top: 30px; margin-bottom: 30px;">
				<div class="col">
					<img src="${requestScope.teamDetailVO.teamPic }" width="150"
						height="150">
				</div>
				<div class="col" style="line-height: 50px; font-size: 25px;">
					<div>
						<label class="teamDetal_bold">${requestScope.teamDetailVO.teamProjectName }</label>
					</div>
					<div>
						<label>${requestScope.teamDetailVO.teamName } 팀</label>
					</div>
				</div>
				<c:if
					test="${requestScope.teamDetailVO.memberId eq sessionScope.memberBean.memberId }">
					<div class="col" style="line-height: 50px;">
						<div>
							<button type="button" class="btn btn-md btn_color">정보 수정</button>
							<button type="button" class="btn btn-md btn_color"
								data-toggle="modal" data-target="#myModal0" style="color: red;">팀
								삭제</button>
							<div class="modal" id="myModal0" style="font-size: 25px;">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header"
											style="color: #ff4111; text-align: center">주의</div>
										<!-- Modal body -->
										<div class="modal-body">
											<div class="row row_text">팀 삭제시 되돌릴 수 없습니다.</div>
											<div class="row row_text text_color_red">정말 삭제하시겠습니까?</div>
											<div class="row">
												<button type="button" class="btn btn-mid btn_submit"
													data-dismiss="modal"
													style="margin-left: 70px; margin-bottom: 20px; margin-top: 30px;">취소</button>
												<button type="button" class="btn btn-mid btn_submit"
													data-dismiss="modal"
													style="margin-left: 70px; margin-bottom: 20px; margin-top: 30px;">확인</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div>
							<form action="myApplicant.do" method="post">
								<input type="hidden" name="team_id"
									value="${requestScope.teamDetailVO.teamId }"> <input
									type="hidden" name="job" value="myApplicant">
								<button type="submit"
									class="btn btn-md btn_color btn_apply_member" id="myApplicants">지원자보기</button>
							</form>
						</div>
					</div>
				</c:if>
			</div>
			<div class="row" style="margin-top: 30px; background-color: #e6f2ff;">
				<form action="/teamwith/polog/jsp/polog.do" method="post" id="leaderForm">
					<input type="hidden" name="memberId" value="${teamDetailVO.memberId }">
					<div class="col team_detail_hover_opacity"
						style="border: none; cursor: pointer;">
						<div class="row" style="width: 300px;" id="leader">
							<div class="col">
								<img src="${requestScope.teamDetailVO.memberPic }"
									class="rounded-circle" width="100px" height="100px">
							</div>
							<div class="col" style="line-height: 50px">
								<div>팀장 ${requestScope.teamDetailVO.memberName } 님</div>
								<div>개발자</div>
							</div>
						</div>
					</div>
				</form>

				<div class="col"
					style="line-height: 50px; background-color: #ffebcc;">
					<div>${applicationScope.categories[requestScope.teamDetailVO.projectCategoryId] }</div>
					<div>${applicationScope.regions[requestScope.teamDetailVO.regionId] }&nbsp;&nbsp;&nbsp;모집중&nbsp;&nbsp;&nbsp;D-24</div>
				</div>
			</div>
			<div class="row" style="margin-top: 30px;">
				<c:choose>
					<c:when
						test="${sessionScope.memberBean.memberId != requestScope.teamDetailVO.memberId }">
						<button type="button" class="btn btn-md btn_submit"
							data-toggle="modal" data-target="#myModal1" style="margin: auto;"
							id="applyTry">지원하기</button>
					</c:when>
					<c:when
						test="${sessionScope.memberBean.memberId eq requestScope.teamDetailVO.memberId}">
						<button id="closeBtn" type="button" class="btn btn-md btn_submit"
							style="margin: auto;">모집 완료</button>
						<form action="./closeTeam.do" method="post" id="closeForm">
							<input type="hidden" value="${requestScope.teamDetailVO.teamId }">
						</form>
					</c:when>
				</c:choose>
			</div>

			<div class="row" style="margin-top: 20px;">
				<div class="row row_title">팀 개요</div>
				<div class="row row_text">${requestScope.teamDetailVO.teamSummary }</div>
			</div>
			<div class="row" style="margin-top: 20px;">
				<div class="row row_title">팀 소개</div>
				<div class="row row_text">${requestScope.teamDetailVO.teamContent }</div>
			</div>
			<c:forEach items="${requestScope.recruitRoleList }" var="recruitRole">
				<hr class="my_hr">
				<div class="row" style="margin-top: 20px;">
					<div class="row row_title">모집 팀원</div>
					<div class="row row_text">모집 역할 :
						${applicationScope.roles[recruitRole[1]] }</div>
					<div class="row row_text">모집 인원 : ${recruitRole[2] }</div>
					<div class="row row_text">우대 조건 : ${recruitRole[3] }</div>
					<div class="row row_text">역할 설명 : ${recruitRole[4] }</div>
					<div class="row row_text">
						요구 기술 :
						<c:forEach items="${requestScope.recruitRequireSkillList}"
							var="recruitRequireSkill">
							<c:forEach items="${recruitRequireSkill}"
								var="recruitRequireSkillVo">
								<c:if
									test="${recruitRole[0] eq recruitRequireSkillVo.recruitId }">
									<c:forEach items="${applicationScope.skills }" var="skill">
										<c:if test="${skill.skillId eq recruitRequireSkillVo.skillId}">
											${skill.skillName }&nbsp;
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
						</c:forEach>
					</div>
				</div>
			</c:forEach>


			<hr class="my_hr">
			<div class="row" style="margin-top: 20px;">
				<div class="row row_title">공모전 정보</div>
				<div class="row row_text">공모전 명:
					${requestScope.teamDetailVO.teamContestName }</div>
				<div class="row row_text">
					공모전 url:&nbsp;&nbsp;<a
						href="${requestScope.teamDetailVO.teamContestLink }">${requestScope.teamDetailVO.teamContestLink }</a>
				</div>
			</div>

			<hr class="my_hr">
			<jsp:include page="coworker.jsp" />
			<hr class="my_hr">
			<jsp:include page="faq.jsp" />
			<hr class="my_hr">
			<jsp:include page="recommandedMember.jsp" />
			<hr class="my_hr">
			<jsp:include page="inquiry.jsp" />
			<div class="row" style="margin-top: 30px;">
				<c:choose>
					<c:when
						test="${sessionScope.memberBean.memberId != requestScope.teamDetailVO.memberId }">
						<!-- loginID가 팀장 ID와 일치하지 않는 경우 -->
						<button type="button" class="btn btn-md btn_submit"
							data-toggle="modal" data-target="#myModal1" style="margin: auto;"
							id="applyTry2">지원하기</button>
					</c:when>
					<c:otherwise>
						<!-- loginID가 팀장 ID와 일치하는 경우 -->
						<button type="button" class="btn btn-md btn_submit"
							style="margin: auto;">모집 완료</button>
					</c:otherwise>
				</c:choose>
			</div>


			<div class="row" style="margin: auto; margin-top: 50px;">

				<div class="modal" id="myModal1" style="font-size: 25px;">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header" style="color: #ff4111;">지원하기</div>
							<!-- Modal body -->
							<div class="modal-body">
								<form action="./apply.do" method="post" id="applyForm">
									<div class="row row_text">
										지원 분야 <select id="role" name="role_id"
											style="margin-left: 20px;">
											<c:forEach items="${requestScope.recruitRoleList }"
												var="recruitRoleValue">
												<option>${applicationScope.roles[recruitRoleValue[1]] }</option>
											</c:forEach>
										</select>
									</div>

									<div class="row row_text" style="margin-top: 30px;">간단면접</div>
									<c:forEach items="${requestScope.interviewQuestionList }"
										var="interview">
										<div class="row row_text" style="margin-left: 35px;">Q:${interview }</div>
										<div class="row row_text">
											<textarea id="interview_answer" name="interview_answer"
												style="margin-left: 35px; width: 300px;"></textarea>
										</div>
									</c:forEach>

									<div class="row row_text" style="margin-top: 30px">하고싶은 말
									</div>
									<div class="row row_text">
										<textarea id="freewriting" name="application_freewriting"
											style="margin-left: 35px; width: 300px;"></textarea>
									</div>
									<div class="row">
										<button type="button" class="btn btn-mid btn_submit"
											data-dismiss="modal"
											style="margin-left: 60px; margin-bottom: 20px; margin-top: 30px;">취소</button>
										<button type="button" id="applyBtn"
											class="btn btn-mid btn_submit"
											style="margin-left: 60px; margin-bottom: 20px; margin-top: 30px;"
											data-dismiss="modal">확인</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 내용끝 -->
</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(".btn_apply_member").click(function(e) {
		location.href = "test.jsp";
	})
</script>

</html>