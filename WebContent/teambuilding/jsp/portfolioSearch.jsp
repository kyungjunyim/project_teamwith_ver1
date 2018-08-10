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
			var categoryCnt=$('input:checkbox[name="category"]:checked').length;
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
				<div class="col">
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


				
					<input type="text">
					<button type="button" id="search_btn">검색</button>
	

			</div>
		</div>
	</form>
</body>
</html>