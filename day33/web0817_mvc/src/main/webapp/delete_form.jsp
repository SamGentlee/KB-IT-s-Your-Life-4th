<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물을 삭제할까요?</title>
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
	<h1>상세보기</h1>
	<table>
		<tr>
			<th>번호</th><td>${dto.no }</td>
		</tr>
		<tr>
			<th>제목</th><td>${dto.title}</td>
		</tr>
		<tr>
			<th>작성자</th><td>${dto.writer}</td>
		</tr>
		<tr>
			<th>작성일</th><td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td ><textarea rows="8" cols="80" readonly>${dto.content}</textarea></td>
		</tr>
	</table>
	<div>
		<a href="delete_action?no=${dto.no}">삭제하기</a>
		<a href="list">목록</a>
	</div>
</html>