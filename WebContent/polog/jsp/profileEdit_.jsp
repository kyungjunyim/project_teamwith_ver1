<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

</head>
<style>
.profile_edit_row{
margin:40px;
}

.profile_edit_row form div{

margin:5px;
}
.profile_edit_row form label{
width:100px;
}
.profile_edit_row form input{
width: 300px;
margin-bottom:20px;
}
.profile_edit_row form .custom-file input{
width:400px;
}

.my_form_control {
  display: block;
  width: 100%;
  height: 34px;
  padding: 6px 12px;
  font-size: 14px;
  line-height: 1.42857143;
  color: #555;
  background-color: #fff;
  background-image: none;
  border: 1px solid #ccc;
  border-radius: 4px;
  -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
          box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
  -webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow ease-in-out .15s;
       -o-transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
          transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
.my_form_control:focus {
  border-color: #ff4111;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px #fff2f6, 0 0 8px #fff2f6;
          box-shadow: inset 0 1px 1px #fff2f6, 0 0 8px #fff2f6;
}
</style>
<body>
	<div class="row profile_edit_row">
		<form>
			<h3>나의 프로필 수정하기</h3>
			<div class="form-group">
				<label>아이디 </label> <input type="text" class="form-control"
					id="member_id" value="${sessionScope.pologOwner.memberId} "  style=" background-color:white;" readonly> <label>이름
				</label> <input type="text" class="form-control" id="member_name_in_profile"
					value="황규진" readonly> <label>이메일 </label> <input
					type="text" class="form-control" id="member_email"
					value="kyukyu@gmail.com" readonly> <label>생년월일 </label> <input
					type="text" class="form-control" id="member_birth" value="920123"
					 style="color: gray;" readonly> <label for="exampleInputFile">프로필 사진</label>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="inputGroupFile01">
					<span class="custom-file-label" for="inputGroupFile01">
						파일을 선택해주세요.</span>
				</div>
				<label>자기 소개 </label>
				<textarea class="my_form_control" id="member_intro" name="member_intro"
					placeholder="자기소개를 써주세요." style="height: 200px;  background-color:#fff4ef;"></textarea>

				<div class="form-group">
					활동 상태 <input type="checkbox" class="my_tog" checked data-toggle="toggle"
						data-onstyle="info">
				</div>
				<div class="form-group">
					핸드폰 번호 <input class="form-control" type="number" style=" background-color:#e4ecf4;">
				</div>
				<div class="form-group">

					<div class="form-group col-md-4">
						<label for="inputState">역할</label> <select id="inputState"
							class="form-control">
							<option selected>역할 선택</option>
							<option>기획자</option>
							<option>디자이너</option>
							<option>개발자</option>
							<option>기타</option>
						</select>
					</div>
				</div>

				<jsp:include page="careerAdd.jsp"></jsp:include>
				<jsp:include page="license.jsp"></jsp:include>
				<div>
					<jsp:include page="skill.jsp"></jsp:include>
				</div>
				<div>
					<jsp:include page="region.jsp"></jsp:include>
				</div>
				
				<div>
					<jsp:include page="tendency.jsp"></jsp:include>
				</div>
				<button type="submit" class="btn btn-dark">저장</button>
			</div>
		</form>
	</div>
</body>
</html>