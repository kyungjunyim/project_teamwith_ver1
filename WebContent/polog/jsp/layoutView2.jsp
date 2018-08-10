<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
<div class="row">
	<div class="col-xs-1 choosebox" style="width:300px;height:250px;border:1px solid #ced9ea"  >
		<div class="row inforow" style="margin:0 auto; color:#002b5a"><div class="row" style="margin:0 auto">드래그하여 오른쪽 박스에 드롭 해 주세요</div><div class="row" style="margin:0 auto">(이미지:jpg,png 동영상:youtubeURL)</div></div>
		<div class="row elementrow" style="margin-top:20px; text-align:center"id="textlement" draggable="true" ondragstart="drag(event)">
			<div class="col textCol" id="textlement " draggable="true" ondragstart="drag(event)">Text</div>
			<div class="col textCol" id="imageelement" draggable="true" ondragstart="drag(event)">Image</div>
		</div>
		<div class="row elementrow">
			<div class="col textCol" id="mediaelement" draggable="true" ondragstart="drag(event)">Media</div>
			<div class="col textCol" id="pptelement" draggable="true" ondragstart="drag(event)">PPT</div>
		</div>
		
		</div>
	<div class="col-xs-1" style="width:50px; height:250px; "></div> 
	<div class="col-xs-1 col-xs-offset-2" style="width:370px; height:250px; border:1px solid #ced9ea;"> 
		<!-- 레이아웃 -->
		<div class="row" id="l1">
		<div class="col-xs-1">
			<div class="row">
				<div class="col-xs-1 l2e1" ondrop="drop(event)" ondragover="allowDrop(event)"  id="l2e1">
					
				</div>
			</div>
			<div class="row">
				<div class="col-xs-1 l2e1" ondrop="drop(event)" ondragover="allowDrop(event)"  id="l2e2">
					
				</div>
			</div>
		</div>
		<div class="col-xs-1 l2e3" ondrop="drop(event)" ondragover="allowDrop(event)"  id="l2e3">
			
		</div>
		
	</div> 
	</div>
	
	<div class="col-xs-1" style="width:100px; height:250px;"> 
	
	<button type="button" class = "btn btn-md btn_color layoutremovebtn" onclick="remove_item(this)">삭제</button>
	<button type="button" class = "btn btn-md btn_color layoutremovebtn" id="upbtn" onclick="up(this)">위로</button>
	<button type="button" class = "btn btn-md btn_color layoutremovebtn" id="downbtn" onclick="down(this)">아래로</button>
	</div>
	
    </div>

</body>
</html>