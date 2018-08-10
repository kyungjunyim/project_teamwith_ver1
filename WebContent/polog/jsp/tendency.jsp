<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
.tendency_row {
	margin-left: 100px;
	width: 600px;
}

.tendency_figure {
	margin-left: 230px;
	margin-bottom: 20px;
	text-align: center;
}

.slider {
	-webkit-appearance: none;
	width: 300px;
	height: 15px;
	border-radius: 5px;
	background: #d3d3d3;
	outline: none;
	-webkit-transition: .2s;
	transition: opacity .2s;
}

.slider::-webkit-slider-thumb {
	-webkit-appearance: none;
	appearance: none;
	width: 25px;
	height: 25px;
	border-radius: 50%;
	background: #002b5a;
	cursor: pointer;
}

.slider::-moz-range-thumb {
	width: 25px;
	height: 25px;
	border-radius: 50%;
	background: #4CAF50;
	cursor: pointer;
}

.tendency_name {
	float: left;
	width: 100px;
	color: #002b5a;
	text-align: center;
}

.tendency_vlaue {
	float: left;
	width: 300px;
}
</style>
</head>
<body>

	<h3>나의 성향</h3>

	<div class="row profile_detail_row tendency_row" id="7">

		<div class="tendency_name" id="tendency_name">독립적</div>

		<input type="range" min="1" max="10" value="${tendency[0]}" class="slider slider1"
			id="tendency1" name="tendency1" oninput="oninput1()">

		<div class="tendency_name" id="tendency_name">상호의존적</div>

		<span class="tendency_figure" id="tendency_figure1">${tendency[0]}</span>
	</div>

	<div class="row profile_detail_row tendency_row" id="7">
		<div class="tendency_name" id="tendency_name">수직적</div>
		<input type="range" min="1" max="10" value="${tendency[1]}" class="slider"
			id="tendency2" name="tendency2" oninput="oninput2()">
		<div class="tendency_name" id="tendency_name">수평적</div>
		<span class="tendency_figure" id="tendency_figure2">${tendency[1]}</span>
	</div>

	<div class="row profile_detail_row tendency_row" id="7">
		<div class="tendency_name" id="tendency_name">확실성</div>
		<input type="range" min="1" max="10" value="${tendency[2]}" class="slider"
			id="tendency3" name="tendency3" oninput="oninput3()">
		<div class="tendency_name" id="tendency_name">모험추구</div>
		<span class="tendency_figure" id="tendency_figure3">${tendency[2]}</span>
	</div>

	<div class="row profile_detail_row tendency_row" id="7">
		<div class="tendency_name" id="tendency_name">업무중심</div>
		<input type="range" min="1" max="10" value="${tendency[3]}" class="slider"
			id="tendency4" name="tendency4" oninput="oninput4()">
		<div class="tendency_name" id="tendency_name">관계중심</div>
		<span class="tendency_figure" id="tendency_figure4">${tendency[3]}</span>
	</div>

	<div class="row profile_detail_row tendency_row" id="7">
		<div class="tendency_name" id="tendency_name">주도적</div>
		<input type="range" min="1" max="10" value="${tendency[4]}" class="slider"
			id="tendency5" name="tendency5" oninput="oninput5()">
		<div class="tendency_name" id="tendency_name">수동적</div>
		<span class="tendency_figure" id="tendency_figure5">${tendency[4]}</span>
	</div>

	<script>

		var oninput1 = function() {
			document.getElementById('tendency_figure1').innerHTML = document.getElementById("tendency1").value;
		}
		var oninput2 = function() {
			document.getElementById('tendency_figure2').innerHTML = document.getElementById("tendency2").value;
		}
		var oninput3 = function() {
			document.getElementById('tendency_figure3').innerHTML = document.getElementById("tendency3").value;
		}
		var oninput4 = function() {
			document.getElementById('tendency_figure4').innerHTML = document.getElementById("tendency4").value;
		}
		var oninput5 = function() {
			document.getElementById('tendency_figure5').innerHTML = document.getElementById("tendency5").value;
		}

	</script>

</body>
</html>
