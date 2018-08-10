<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<script>
	
	function add_item(){
	    // pre_set 에 있는 내용을 읽어와서 처리..
	    
    	var div = document.createElement('div');
	    div.opacity="0.4";
	    div.innerHTML = document.getElementById('pre_set').innerHTML;
	    document.getElementById('field').appendChild(div);
	    index+=1;
	
	    
	}
	
	function remove_item(obj){
	    // obj.parentNode 를 이용하여 삭제
	   
	    /* obj.parentNode.parentNode.parentNode.remove(); */
	    obj.parentNode.parentNode.remove();

	}

	function allowDrop(ev) {
	    ev.preventDefault();
	}

	function drag(ev) {
	    ev.dataTransfer.setData("text", ev.target.innerHTML);
	}

	function drop(ev) {
	    ev.preventDefault();
	    var data = ev.dataTransfer.getData("text");
	    ev.target.innerText = data;
	    var $inputbox;
	    if(data=='Media'){
	    	//$(ev.target).parent().parent().parent().children().eq(4).remove();
	    	//$('#mediadiv').remove();
	    	var $inputbox=$("<div style='margin:0 auto' id='mediadiv'>Media URL : <input type='text' placeholder='동영상 URL을 입력해 주세요'></div>");
	    	
	    	//$(ev.target).parent().parent().parent().children().last().parent().append($mediainput);
	    	//$(ev.target).parent().parent().parent().append($mediainput);
	    }
	    else if(data=='PPT'){
	    	var $inputbox=$("<div style='margin:0 auto'>PPT 선택 : <input type='file'></div>");
	    	//$(ev.target).parent().parent().parent().append($pptinput);
	    }
	    else if(data=='Image'){
	    	var $inputbox=$("<div style='margin:0 auto'>Image 선택 : <input type='file'></div>");
	    	//$(ev.target).parent().parent().parent().append($imageinput);
	    }
	    var id=$(ev.target).attr('id');
	    
	    if(id=='l2e1'||id=='l2e2'){
	    	$(ev.target).parent().parent().parent().parent().parent().append($inputbox);
	    }
	    else{
	    	$(ev.target).parent().parent().parent().append($inputbox);
	    }
	}

</script>
<style>
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

.btn_submit {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
	color: #fff;
	background-color: #ff4111;
	opacity: 0.7;
}

.btn_submit:hover {
	color: #fff;
	background-color: #ff4111;
	border-color: #fff;
	opacity: 1;
}

.btn_cancel {
	width: 140px;
	padding: 0px 10px;
	font-size: 23px;
}

.main_row{
margin:20px;

}
.portfolio_title{
	
	width:810px;
	height:100px;
	margin: 10px 0px;

	text-align:center;
	font-size:30px;
}
.my{
width: 860px;
	text-align:center;
	margin-top:15px;
		margin-bottom:15px;
		margin-left:30px;
	
}

#btnimg{
width:100px;
height:100px;
cursor: pointer;
border-radius: 100px;
}
#btnimg:hover{
background-color:#fff4ef;
}
.layoutbtn{
	border-style:none;
}
#field{
	margin-top: 20px;
	margin-left:25px;	
}
.portfolio_layout{
width:370px;
height:320px;
margin:0 auto;
margin-bottom:10px;
}

.l1e1{
width:100px;
height:100px;
margin-left:70px;
margin-top:80px;
background-color:#ced9ea;
font-size:20px;
text-align: center;
line-height: 110px;

}

.l3e1{
	width:280px;
	height:150px;
	margin-left:60px;
	margin-top:50px;
	background-color:#ced9ea;
	border:1px solid #ced9ea;
}
.l2e1{
width:100px;
height:100px;
margin-left:80px;
margin-top:15px;
background-color:#ced9ea;
border:1px solid #ced9ea;
}
.l2e3{
	width:100px;
	height:215px;
	margin-left:80px;
	margin-top:15px;
	background-color:#ced9ea;
	border:1px solid #ced9ea;
}
.choosebox{
	margin-left:40px;
}
.main_row {
width: 860px;
	max-width: none !important;
	
	padding: 0;

	margin: 10px 0px 10px 10px;
}
body{
	font-size: 25px;
}
</style>
<script>
	var layoutIndex=0;
	$(document).ready(function(e){
		var index=0;
		
		$('#okbtn').click(function(e){
			//var div = document.createElement('div');
			 var $div=$("<div></div>");
			if(index==1){
			    //div.innerHTML = document.getElementById('layout_set1').innerHTML;
				$div.html($('#layout_set1').html());
			}else if(index==2){
			    //div.innerHTML = document.getElementById('layout_set2').innerHTML;
				$div.html($('#layout_set2').html());
			}else if(index==3){
			    //div.innerHTML = document.getElementById('layout_set3').innerHTML;
				$div.html($('#layout_set3').html());
			}else if(index==4){
				//div.innerHTML=document.getElementById('layout_set4').innerHTML;
				$div.html($('#layout_set4').html());
			}
			// document.getElementById('field').appendChild(div);
			
			 $('#field').append($div);
			 $('#myModal').hide();
			 
		});
		$('#layout1').click(function(e){
			index=1;
			layoutIndex=1;
			
		});
		$('#layout2').click(function(e){
			index=2;
			layoutIndex=2;
		});
		$('#layout3').click(function(e){
			index=3;
			layoutIndex=3;
		});
		$('#layout4').click(function(e){
			index=4;
			layoutIndex=4;
		});
		
		
		$('#portfolio_registerbtn').click(function(){
			
			
			 $('#portfolio_register_form').submit();
			 
			/*
			 var formData=$('#portfolio_register_form').serialize();
			$.post({
				url : 'portfolioAdd.do', //이동할 주소
				method : 'POST',
				async : true,
				data : formData,
				success :  function(data) {
					
					$('.polog_main').html(data);
				} 
			}); */
		}); 
		$('#portfolio_cancelbtn').click(function(){
			$.ajax({
				url : './main.jsp', //이동할 주소
				method : 'GET',
				async : true,
				success : function(data) {
					alert('등록이 취소되었습니다');
					$('.polog_main').html(data);
				}
			});
		});
		
	});
	function up(obj){
		$(obj).parent().parent().parent().prev().before($(obj).parent().parent().parent());
	}
	function down(obj){
		$(obj).parent().parent().parent().next().after($(obj).parent().parent().parent());
	}
</script>

</head>

<body style="background-color: #e4ecf4; color:#002b5a;font-family: yanoljaBold">
<div class="main_row">
<div class="theme">

<div id="layout_set1" class="row main_row" style="display:none">
	<jsp:include page="layoutView1.jsp"/>
</div>
<div id="layout_set2" class="row main_row" style="display:none">

    <jsp:include page="layoutView2.jsp"/>

</div>
<div id="layout_set3" class="row main_row" style="display:none">
	<jsp:include page="layoutView3.jsp"/>
</div>
<div id="layout_set4" class="row main_row" style="display:none">
	<jsp:include page="layoutView4.jsp"/>
</div>
 <div class="row">
 	<%@include file="portfolioInputForm.jsp" %>
 </div>

<div id="field" class="row">
	
</div>
<div class="my">
<label class="layoutinfo" style="font-size:25px">하나이상의 레이아웃을 선택해 주세요</label>
</div>
<div class="my">
<img  data-toggle="modal" data-target="#myModal"id="btnimg" src="../../image/plus.png"/><br>

<jsp:include page="layoutModal.jsp"/> 
<div class="row" style="margin-top:50px;margin-bottom:100px">
	<button type="button" class="btn btn-md btn_color btn_submit" id="portfolio_registerbtn">등록</button>
	<button type="button"  class="btn btn-md btn_color btn_cancel" id="portfolio_cancelbtn">취소</button>
</div>
</div>
</div>
</div>
</body>

</html>
