<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세 보기</title>
<style>
	h1 {
		text-align: center;
	}
	table{
		width: 80%;
		margin:10px auto;
		text-align: center;
	}
	table, tr, th, td{
		border: 1px solid black;
	}
	div{
		text-align:center;
	}
</style>
</head>
<body>
	<h1>회원 정보 상세 보기</h1>
	<table>
		<tr>
			<th>아이디</th><td>${dto.id }</td>
		</tr>
		<tr>
			<th>이름</th><td>${dto.name}</td>
		</tr>
		<tr>
			<th>비밀번호</th><td>${dto.pwd}</td>
		</tr>
		<tr>
			<th>회원 상태</th><td>${dto.status}</td>
		</tr>
	</table>
	<div>
		<p>삭제하시겠습니까?</p>
		<a href="delete_action?id=${dto.id}">삭제하기</a>
		<a href="list">목록으로 돌아가기</a>
	</div>
</body>
</html>