<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
/* Customize the label (the box) */

.modal{
z-index:10;
}
.box {
width:200px;
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

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">역량 선택</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="box-fluid">
						<div class="row">
							<div class="col-xs-3">
								기획 역량 <label class="box">스토리보드 <input
								type="checkbox" checked="checked"> <span
								class="checkmark"></span>
							</label> <label class="box">데이터분석 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">브랜딩 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">마케팅 <input type="checkbox">
								<span class="checkmark"></span>
							</label>
							</div>
						</div>

						<div class="col-xs-3">
							디자인 역량 <label class="box">포토샵 <input
								type="checkbox" checked="checked"> <span
								class="checkmark"></span>
							</label> <label class="box">일러스트레이터 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">동영상편집 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">포스터 디자인 <input type="checkbox">
								<span class="checkmark"></span>
							</label>
						</div>
						<div class="col-xs-3">개발 역량 <label class="box">C <input
								type="checkbox" checked="checked"> <span
								class="checkmark"></span>
							</label> <label class="box">C++ <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">Java <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">Java Script<input type="checkbox">
								<span class="checkmark"></span>
							</label></div>
						<div class="col-xs-3">기타 역량<label class="box">발표<input
								type="checkbox" checked="checked"> <span
								class="checkmark"></span>
							</label> <label class="box">영어 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">중국어 <input type="checkbox">
								<span class="checkmark"></span>
							</label> <label class="box">일본어<input type="checkbox">
								<span class="checkmark"></span>
							</label></div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<button type="button" class="btn btn-primary">저장</button>
			</div>
		</div>
	</div>



</body>
</html>