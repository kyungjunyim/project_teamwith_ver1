<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="styleSheet" href="../css/profileDetail.css">
<link href="../css/topBtn.css" rel="stylesheet">
<script src="../js/topBtn.js"></script>

</head>
<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<div class="prof_detail_div">

		<p>프로필</p>
		<div class="row profile_detail_row" id="1">
			<label>이름</label> <br> <label class="member_info"
				id="member_name">${sessionScope.pologOwner.memberName} </label>
		</div>
		<div class="row profile_detail_row" id="2">
			<label>이메일</label> <label class="member_info" id="member_email">${sessionScope.pologOwner.memberEmail}</label>
		</div>
		<div class="row profile_detail_row" id="2">
			<label>전화번호</label> <label class="member_info" id="member_phone">${sessionScope.pologOwner.memberPhone}</label>
		</div>

		<div class="row profile_detail_row" id="3">
			<label>나이</label> <label class="member_info" id="member_age">27세</label>
		</div>
		<hr class="my_hr">

		<div class="row profile_detail_row" id="4">
			<label>활동 상태</label> <label class="member_info" id="member_active">활동
				가능 </label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label>활동 지역 </label>
			<c:forEach var="rName" items="${region}">
				<label class="member_info" id="member_region">
					${applicationScope.regions[rName]} &nbsp;&nbsp;&nbsp; </label>
			</c:forEach>


		</div>
		<div class="row profile_detail_row" id="5">
			<label>자기소개 </label><label class="member_info" id="member_intro">${sessionScope.pologOwner.memberIntro}</label>
		</div>
		<hr class="my_hr">
		<div class="row profile_detail_row" id="6">


			<label>관심 분야</label>
			<c:forEach var="cName" items="${category}">

				<label class="member_info" id="project_category">${applicationScope.categories[cName]}
					&nbsp;&nbsp;&nbsp; </label>
			</c:forEach>
		</div>

		<div class="row profile_detail_row" id="6">
			<label>역할 </label><label class="member_info" id="member_role">기획자

			</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label>기술 </label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info" id="role_name">기획역량</label>
		</div>

		<div class="row profile_detail_row" id="7">
			<label></label>
			<c:forEach var="sVo" items="${applicationScope.skills }">
				<c:forEach var="memSkill" items="${skill}">
					<c:if test="${sVo.skillId == memSkill && sVo.roleId=='role-1' }">
						<label class="member_info" id="skill_name">${sVo.skillName }&nbsp;&nbsp;&nbsp;</label>
					</c:if>
				</c:forEach>
			</c:forEach>

		</div>

		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info" id="role_name">디자인역량</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label>
			<c:forEach var="sVo" items="${applicationScope.skills }">
				<c:forEach var="memSkill" items="${skill }">
					<c:if test="${sVo.skillId == memSkill && sVo.roleId=='role-2' }">
						<label class="member_info" id="skill_name">${sVo.skillName }&nbsp;&nbsp;&nbsp;</label>

					</c:if>
				</c:forEach>
			</c:forEach>

		</div>

		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info" id="role_name">개발역량</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label>
			<c:forEach var="sVo" items="${applicationScope.skills }">
				<c:forEach var="memSkill" items="${skill }">
					<c:if test="${sVo.skillId == memSkill && sVo.roleId=='role-3' }">
						<label class="member_info" id="skill_name">${sVo.skillName }&nbsp;&nbsp;&nbsp;</label>

					</c:if>
				</c:forEach>
			</c:forEach>

		</div>

		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info" id="role_name">기타역량</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label>
			<c:forEach var="sVo" items="${applicationScope.skills }">
				<c:forEach var="memSkill" items="${skill }">
					<c:if test="${sVo.skillId == memSkill && sVo.roleId=='role-4' }">
						<label class="member_info" id="skill_name">${sVo.skillName }&nbsp;&nbsp;&nbsp;</label>

					</c:if>
				</c:forEach>
			</c:forEach>

		</div>

		<hr class="my_hr">

		<div class="row profile_detail_row" id="7">
			<label>자격증 </label>
		</div>
		<div class="row profile_detail_row" id="7">
			<c:choose>
				<c:when test="${sessionScope.pologOwner.memberId=='joran' }">
					<label>&nbsp;</label>
					<label class="member_info" id="license_name">토익 </label>&nbsp;&nbsp;&nbsp; <label
						class="member_info" id="license_level">890점</label>&nbsp;&nbsp;&nbsp;
			<label class="member_info" id="license_date">2018년 2월</label>&nbsp;&nbsp;&nbsp;
			</c:when>
				<c:otherwise>
					<label>&nbsp;</label>
					<label class="member_info" id="license_name">정보처리기사 </label>&nbsp;&nbsp;&nbsp; 
			<label class="member_info" id="license_date">2017년 9월</label>&nbsp;&nbsp;&nbsp;
			</c:otherwise>
			</c:choose>
		</div>

		<hr class="my_hr">
		<div class="row profile_detail_row" id="7">
			<label>경력 </label>
		</div>

		<hr class="my_hr">
		<div class="row profile_detail_row" id="7">
			<label class="member_praise">칭찬 내역 </label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_praise member_info"
				id="member_praise1">전문성 3회</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info member_praise"
				id="member_praise2">적극성 3회</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info member_praise"
				id="member_praise3">일정 준수 3회</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info member_praise"
				id="member_praise3">의사 소통 3회</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <label class="member_info member_praise"
				id="member_praise3">친화력 3회</label>
		</div>
		<div class="row profile_detail_row" id="7">
			<label></label> <button class="btn btn-md btn_color" disabled style="margin-left:500px;">칭찬하기</button>
		</div>

		<hr class="my_hr">
		<div class="row profile_detail_row" id="7">
			<label>나의 성향 </label>
		</div>
		<div class="row profile_detail_row tendency_row" id="7">

			<div class="tendency_name" id="tendency_name">독립적</div>

			<input type="range" min="1" max="10"
				value="${tendency[0]}" class="slider" id="tendency1"
				disabled>

			<div class="tendency_name" id="tendency_name">상호의존적</div>

			<span class="tendency_figure" id="tendency_figure1">${tendency[0]}</span>
		</div>



		<div class="row profile_detail_row tendency_row" id="7">
			<div class="tendency_name" id="tendency_name">수직적</div>
			<input type="range" min="1" max="10"
				value="${tendency[1]}" class="slider" id="tendency2"
				disabled>
			<div class="tendency_name" id="tendency_name">수평적</div>
			<span class="tendency_figure" id="tendency_figure2">${tendency[1]}</span>
		</div>
		<div class="row profile_detail_row tendency_row" id="7">
			<div class="tendency_name" id="tendency_name">확실성</div>
			<input type="range" min="1" max="10"
				value="${tendency[2]}" class="slider" id="tendency3"
				disabled>
			<div class="tendency_name" id="tendency_name">모험추구</div>
			<span class="tendency_figure" id="tendency_figure3">${tendency[2]}</span>
		</div>
		<div class="row profile_detail_row tendency_row" id="7">
			<div class="tendency_name" id="tendency_name">업무중심</div>
			<input type="range" min="1" max="10"
				value="${tendency[3]}" class="slider" id="tendency4"
				disabled>
			<div class="tendency_name" id="tendency_name">관계중심</div>
			<span class="tendency_figure" id="tendency_figure4">${tendency[3]}</span>
		</div>
		<div class="row profile_detail_row tendency_row" id="7">
			<div class="tendency_name" id="tendency_name">주도적</div>
			<input type="range" min="1" max="10"
				value="${tendency[4]}" class="slider" id="tendency5"
				disabled>
			<div class="tendency_name" id="tendency_name">수동적</div>
			<span class="tendency_figure" id="tendency_figure5">${tendency[4]}</span>
		</div>
		<button onclick="topFunction()" id="top_btn" title="맨 위로 가기">Top</button>
	</div>

</body>
</html>