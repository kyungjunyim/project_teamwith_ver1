<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">

<style>
.row {
	width: 860px;
	margin: 0;
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

.inquiry_line_height {
	line-height: 40px;
}

.inquiry_btn_height {
	height: 40px;
	margin-left: 5px;
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

</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$('document').ready(function(e) {
		$('#inquiryAddBtn').click(function(e) {
			$('#addInquiryForm').submit();
		});
	});
</script>
</head>
<body>
	<div class="row" style="margin-top: 20px;">
		<div class="row row_title">문의하기</div>
		<!--  댓글 입력 창 -->
		<div class="row row_text" style="margin-top: 20px;">
			<img src="${sessionScope.memberBean.memberPic }" class="rounded-circle" width="40" height="40">
			<label style="line-height: 40px; margin-left: 10px">${sessionScope.memberBean.memberName }</label>
			<form id="addInquiryForm" action="./addInquiry.do" method="post">
				<input type="text" name="inquiry_content" style="margin-left: 20px; border-radius: 7px; width: 300px">
			</form>
			<button id="inquiryAddBtn" type="button" class="btn btn-md btn_color" style="width: 100px; margin-left: 20px;">등록</button>
		</div>

		<!-- 댓글 보기 화면 -->
		<div class="row" style="margin-top: 30px;">
			<hr class="my_hr">
			<c:forEach items="${requestScope.inquiryMemberList }" var="inquiryMember">
				<!-- 단일 댓글 -->
				<div class="row row_text" style="margin-top: 20px;">
					<!-- 작성자 사진 -->
					<img src="${inquiryMember.memberPic }" class="rounded-circle"
						width="40" height="40">&nbsp;&nbsp;
					<!-- 작성자 이름 -->
					<label class="inquiry_line_height">${inquiryMember.memberName }</label>&nbsp;&nbsp;
					<!-- 댓글 내용 -->
					<label class="inquiry_line_height">${inquiryMember.inquiryContent }</label>&nbsp;&nbsp;
					<!-- 작성 시간 -->
					<label class="inquiry_line_height">${fn:substring(inquiryMember.inquiryUpdateDate, 0, 16) }</label>&nbsp;&nbsp;
					<!-- 대댓글 작성 입력칸 보이게 하는 버튼 -->
					<button class="btn btn-link btn-sm inquiry_btn_height"
						type="button">답글달기</button>
					<c:if
						test="${inquiryMember.memberId eq sessionScope.memberBean.memberId }">
						<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 수정버튼을 보이게 만든다. -->
						<button class="btn btn-link btn-sm inquiry_btn_height"
							type="button">수정</button>
						<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 삭제버튼을 보이게 만든다. -->
						<button class="btn btn-link btn-sm inquiry_btn_height"
							type="button">삭제</button>
					</c:if>
				</div>

				<!-- 대댓글 -->
				<c:forEach items="${requestScope.replyList }" var="replyAry">
					<c:if test="${not empty replyAry }">
						<c:forEach items="${replyAry }" var="reply">
							<c:if test="${reply.inquiryId == inquiryMember.inquiryId}">
							<div class="row row_text" style="margin-top: 20px;">
								<!-- 작성자 사진 -->
								&nbsp;&nbsp;<label style="font-weight: bold; font-size: 30px;">ㄴ</label>&nbsp;<img
									src="${reply.memberPic }" class="rounded-circle"
									width="40" height="40"> &nbsp;&nbsp;
								<!-- 작성자 이름 -->
								<label class="inquiry_line_height">${reply.memberName }(팀장)</label>&nbsp;&nbsp;
								<!-- 대댓글 내용 -->
								<label class="inquiry_line_height">${reply.replyContent }</label>&nbsp;&nbsp;
								<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 수정버튼을 보이게 만든다. -->
								<c:if
									test="${reply.memberId eq sessionScope.memberBean.memberId }">
									<button class="btn btn-link btn-sm inquiry_btn_height"
										type="button">수정</button>
									<!-- 글쓴이가 로그인 세션 아이디와 일치한다면 삭제버튼을 보이게 만든다. -->
									<button class="btn btn-link btn-sm inquiry_btn_height"
										type="button">삭제</button>
								</c:if>
							</div>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
			</c:forEach>
		</div>

	</div>
</body>
</html>