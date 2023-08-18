<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
	<h1>회원 정보 수정</h1>
	<form action="update_action" method="post" }><br>
		아이디 : <input type="text" name="id" value="${dto.id }" readonly><br>
		이름 : <input type="text" name="name" value="${dto.name }"><br>
		비밀번호 : <input type="password" name="pwd" value="${dto.pwd }"><br>
		회원상태 :	<input id="Y" type="radio" name="status" value="Y" checked><label for="Y">Y</label>
      		    <input id="N" type="radio" name="status" value="N"><label for="N">N</label><br>
		<input type="submit" value="수정">
		<input type="button" id="btn" value="이전 화면">
	</form>
	<script>
		window.onload=function(){
			
			document.querySelector("#btn").onclick = function(){
				history.back();
			}
		}
	</script>
</html>