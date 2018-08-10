<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
/* Customize the label (the box) */
.box {
	width: 200px;
	display: block;
	position: relative;
	padding-left: 35px;
	margin-bottom: 12px;
	cursor: pointer;
	font-size: 15px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

/* Hide the browser's default checkbox */
.box input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
}

/* Create a custom checkbox */
.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 25px;
	width: 25px;
	background-color: #eee;
}

/* On mouse-over, add a grey background color */
.box:hover input ~ .checkmark {
	background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.box input:checked ~ .checkmark {
	background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

/* Show the checkmark when checked */
.box input:checked ~ .checkmark:after {
	display: block;
}

/* Style the checkmark/indicator */
.box .checkmark:after {
	left: 9px;
	top: 5px;
	width: 5px;
	height: 10px;
	border: solid white;
	border-width: 0 3px 3px 0;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}
</style>

</head>
<body>
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-md btn_color" data-toggle="modal"
		data-target="#exampleModalCenter2" style="height: 40px;">활동
		지역 선택</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter2" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">활동 지역 선택</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="box-fluid">
						지역 <label class="box">서울 <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label> <label class="box">인천 <input type="checkbox"
							id="region-1" name="regoin-1"> <span class="checkmark"></span>
						</label> <label class="box">부산 <input type="checkbox"
							id="region-1" name="regoin-1"> <span class="checkmark"></span>
						</label> <label class="box">대전 <input type="checkbox"
							id="region-1" name="regoin-1"> <span class="checkmark"></span></label>
						<label class="box">대구 <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label> <label class="box">광주<input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label> <label class="box">울산</label> <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span> <label class="box">제주 <input
							type="checkbox" checked="checked" id="region-1" name="regoin-1">
							<span class="checkmark"></span>
						</label> <label class="box">세종 <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label> <label class="box">경기도 <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label>
						<label class="box">경기도 <input type="checkbox"
							checked="checked" id="region-1" name="regoin-1"> <span
							class="checkmark"></span>
						</label>


					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary">저장</button>
				</div>
			</div>

		</div>
	</div>


</body>
</html>