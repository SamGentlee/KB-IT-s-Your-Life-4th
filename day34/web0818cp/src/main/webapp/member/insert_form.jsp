<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<h1>회원등록</h1>
	<form action="insert_action" method="post"><br>
		아이디 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		<input type="submit" value="등록">
		<input type="button" id="btn" value="이전 화면">
	</form>
	<script>
		window.onload=function(){
			
			document.querySelector("#btn").onclick = function(){
				history.back();
			}
		}
	</script>
</body>
</html>