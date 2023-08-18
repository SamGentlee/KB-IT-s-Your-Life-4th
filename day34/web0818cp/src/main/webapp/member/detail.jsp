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
		<a href="list">목록</a>
		<a href="update_form?id=${dto.id}">수정</a>
		<!-- 수정폼은 검색한 dto 각 변수를 등록폼에 출력 -->
		<!-- 수정폼은 상세보기 + 등록폼 -->
		<a href="delete_form?id=${dto.id}">삭제</a>
	</div>
</body>
</html>