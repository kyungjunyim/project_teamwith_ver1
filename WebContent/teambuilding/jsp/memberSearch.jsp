<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.team_search_layout {
	width: 860px;
	margin: 0 10px 10px 0;
	background-color: #ffffff;
	border-radius: 7px;
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

.col_kyu {
	width: 150px;
	padding: 0;
	margin-top: 10px;
	text-align: center;
}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(e) {	
		$('#teamSearch').change(function(e){
			var regionCnt=$('input:checkbox[name="region"]:checked').length;
			var roleCnt=$('input:checkbox[name="role"]:checked').length;
			var skillCnt=$('input:checkbox[name="skill"]:checked').length;
			var categoryCnt=$('input:checkbox[name="category"]:checked').length;
			$('#regionBtn').text('활동 지역'+regionCnt);
			$('#roleBtn').text('역할'+roleCnt);
			$('#skillBtn').text('요구 기술'+skillCnt);
			$('#categoryBtn').text('카테고리'+categoryCnt);
		});
		$('#search_btn').click(function(e){
			//검색 버튼을 클릭하면 form 데이터를 post방식으로 서버에 전송한다.
		});
	});
</script>
</head>
<body>
	<form action="#" method="post" id="teamSearch">
		<div class="row team_search_layout">
			<div class="row">

				<div class="col-2">
					<!-- Button trigger modal -->
					<button id=regionBtn type="button" class="btn btn-md btn_color"
						data-toggle="modal" data-target="#regionModal" style="color: red;">활동
						지역0</button>
					<div class="modal" id="regionModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">활동 지역 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region" id="region1"
												value="서울">서울
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region" id="region2"
												value="경기">경기
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region" id="region3"
												value="광주">광주
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="region" id="region4"
												value="부산">부산
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

				<div class="col-2">
					<button id="roleBtn" type="button" class="btn btn-md btn_color"
						data-toggle="modal" data-target="#roleModal" style="color: red;">역할0</button>
					<div class="modal" id="roleModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">역할 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role" id="role1" value="개발자">개발자
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role" id="role2" value="디자이너">디자이너
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role" id="role3" value="기획자">기획자
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="role" id="role4" value="기타">기타
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
				<div class="col-2">
					<button id="skillBtn" type="button" class="btn btn-md btn_color"
						data-toggle="modal" data-target="#skillModal" style="color: red;">요구
						기술0</button>
					<div class="modal" id="skillModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">기술 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill" id="skill1" value="C">C
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill" id="skill2" value="C++">C++
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill" id="skill3" value="JAVA">JAVA
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="skill" id="skill4" value="JAVASCRIPT">JAVASCRIPT
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
				<div class="col-2">
					<button id="categoryBtn" type="button" class="btn btn-md btn_color"
						data-toggle="modal" data-target="#categoryModal"
						style="color: red;">카테고리0</button>
					<div class="modal" id="categoryModal" style="font-size: 25px;">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header"
									style="color: #ff4111; text-align: center">카테고리 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="category" id="category1" value="빅데이터">빅데이터
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="category" id="category2" value="보안">보안
										</div>
									</div>
									<div class="row">
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="category" id="category3" value="인공지능">인공지능
										</div>
										<div class="col" style="margin-left: 20px;">
											<input type="checkbox" class="form-check-input" name="category" id="category4" value="IOT">IOT
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


				<div class="col-4">
					<select>
						<option>이름</option>
						<option>id</option>
					</select>
					<input type="text">
					<button type="button" id="search_btn">검색</button>
				</div>

			</div>


		</div>
	</form>
</body>
</html>