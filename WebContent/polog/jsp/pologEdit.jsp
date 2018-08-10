<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="styleSheet" href="../css/pologDesign.css">
<style>
h2, h3, h4, h5{
font-family: BMJUA;
}
.form-control{
font-size:21px;
}
label{
font-size:25px;
}

</style>
</head>
<body>

	<div class="row polog_edit_row">
		<form action="./pologUpdate.do" id="polog_design_form" method="post">
			<h2>폴로그 꾸미기</h2>
			<h3>폴로그 정보</h3>
			<div class="form-group">
				<label for="exampleInputEmail1">폴로그 제목</label> <input type="text"
					class="form-control" id="polog_title" name="polog_title" 
					placeholder="폴로그 제목을 입력해주세요." value="${polog.pologTitle }">
			</div>

			<div class="form-group">
				<label for="exampleInputFile">폴로그 제목 사진</label>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="inputGroupFile01">
					<label class="custom-file-label" for="inputGroupFile01">Choose
						file</label>
				</div>
				<p class="help-block" style="color: red;">! 1100*200px의 jpg 파일로
					올려주세요. 이미지가 작거나 클 시 원하는 대로 안 나올 수 있습니다.</p>
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">폴로그 소개</label> <input type="text"
					class="form-control" id="polog_intro" name="polog_intro"
					placeholder="폴로그 소개를 입력해주세요." value="안녕하세요~~ 아니 요즘 왜 이렇게 할 일이 많은지 모르겠네요.. 연락 잘 못 받아도 양해 좀 해주세요~~">
			</div>

			<br>
			<div class="form-group">
				<h3>배경</h3>
				<label for="exampleInputFile">폴로그 배경 사진</label>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="inputGroupFile01">
					<label class="custom-file-label" for="inputGroupFile01">Choose
						file</label>
				</div>
				<p class="help-block" style="color: red;">! 1100*600px의 jpg 파일로
					올려주세요. 이미지가 작거나 클 시 원하는 대로 안 나올 수 있습니다.</p>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">테마 색상</label> <input type="color"
					name="theme_color" value="white">

			</div>

			<br>
			<h3>레이아웃</h3>
			<div class="row polog_layout_row">

				<div class="col-xs-1 polog_layout_col1">
					<h5>폴로그 구성</h5>
					<div class="checkbox">
						<label> <input type="checkbox" value="제목" checked> <label
							draggable="true" ondragstart="drag(event)" id="polog_title">제목</label>
						</label>
					</div>
					<div class="checkbox disabled">
						<label> <input type="checkbox" value="프로필 & 포트폴리오 목록" checked disabled>
							<label draggable="true" ondragstart="drag(event)"
							id="polog_profile">프로필, 포트폴리오 목록
						</label>

						</label>
					</div>

					<div class="checkbox">
						<label> <input type="checkbox" value="폴로그 소개말" checked> <label
							draggable="true" ondragstart="drag(event)" id="polog_intro">폴로그
								소개말</label>
						</label>
					</div>
				</div>
				<div class="col-xs-1 polog_layout_col2">
						<h5>폴로그 구성 위치</h5>

					<div class="row layout_temp2" ondrop="drop(event)" ondragover="allowDrop(event)">제목</div>
					<div class="row layout_temp2" ondrop="drop(event)" ondragover="allowDrop(event)">top2</div>
					<div class="row layout_temp2" style="height:120px;">
						<div class="col-xs-1 previous layout_temp" ondrop="drop(event)"
							ondragover="allowDrop(event)">
							프로필, 포트폴리오 목록
						</div>
						<div class="col-xs-1 layout_temp" style="width: 220px; color: gray;">메인페이지
						</div>
						<div class="col-xs-1 layout_temp" ondrop="drop(event)"
							ondragover="allowDrop(event)">right</div>
					</div>
					<div class="row layout_temp" ondrop="drop(event)" ondragover="allowDrop(event)">bottom</div>
				
			</div>
			</div>
			<button type="button" class="btn btn-default " id="polog_edit_submit">수정</button>
			<button type="submit" style="display:none;" id="hidden_polog_edit"></button>
		</form>


	</div>
	<script>
	
		
		function allowDrop(ev) {
			ev.preventDefault();
		}

		function drag(ev) {
			console.log(ev.target);
			ev.dataTransfer.setData("text", $(ev)[0].target.innerHTML);
			console.log($(ev)[0].target.innerHTML);
		}

		function drop(ev) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			ev.target.innerText = data;
			console.log($('.previous')[0]);
			$('.previous')[0].innerHTML="left";
		}
		
	</script>
</body>
</html>