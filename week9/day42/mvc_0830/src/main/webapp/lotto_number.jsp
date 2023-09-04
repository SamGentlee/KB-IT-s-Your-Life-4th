<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또번호 추천 for REST</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				sendNumber()
			})
		})
		function sendNumber(){
			$.ajax({
				url : "today_lotto",
				success : function(data){
				$.each(data,function(){
					$("#msg").append(this+" ")
				})
				},error : function(){
					
				}
			})
		}
	</script>
</head>
<body>
	<h1>로또 번호 추천</h1>
		<h3>버튼을 누르세요</h3>
		<button id="btn">오늘의 로또번호</button>
		<div id="msg"></div>
	
	
	
</body>
</html>