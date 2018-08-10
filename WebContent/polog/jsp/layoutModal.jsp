<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
<style>
	.layoutpic{
		width:50px;
		height:50px;
		
	}
	.layoutbtn{
		border-style: none;
		background-color: white;
		
	}
	.layoutbtn{
		width:70px;
		text-align:center;
		cursor:pointer;
	}
		
	.layoutbtn:hover {
		color: #ff4111;
		background-color: #f7e7e3;
		border-color: #ff4111;
	}
	

</style>

</head>
<body>
<!-- 모달 팝업 --> 
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" > 
<div class="modal-dialog"> <div class="modal-content"> 
<div class="modal-header"> 
<h4 class="modal-title" id="myModalLabel" style="margin-left:120px">레이아웃을 선택해 주세요</h4>
<button type="button" class="close" data-dismiss="modal">
<span aria-hidden="true">×</span><span class="sr-only">Close</span>
</button> 

 </div>
 <!-- 내용 --> 
 <div class="modal-body">
	<button type="button" class="layoutbtn"><img src="../../image/layout1.png" border="1" class="layoutpic" id="layout1" ></button>
	<button type="button" class="layoutbtn"><img src="../../image/layout3.png" border="1" class="layoutpic" id="layout2"></button>
	<button type="button" class="layoutbtn"><img src="../../image/layout2.png" border="1" class="layoutpic" id="layout3"></button>
	<button type="button" class="layoutbtn"><img src="../../image/layout4.png" border="1" class="layoutpic" id="layout4"></button>
</div> 
 <div class="modal-footer"> 
 <button type="button" class="btn btn-md btn_cancel btn_color" data-dismiss="modal" id="closebtn">Cancel</button> 
 <button type="button" class="btn btn-md btn_submit btn_color" data-dismiss="modal" id="okbtn">OK</button> 
 </div> 
 </div>
</div> 
</div>
</body>
</html>