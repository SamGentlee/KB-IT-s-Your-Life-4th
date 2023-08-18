<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작업 결과</title>
</head>
<body>
	
	<h1>게시판 작업 결과</h1>
	<p>메시지 : <%=request.getAttribute("msg") %><br>
	<p>메시지 : ${msg}<br>
	<p>메시지 : <%=request.getAttribute("msg1") %><br>
	<p>메시지 : ${msg1}<br>
	<p>제목 : ${dto.title}<br>
	<p>작성자 : ${dto.writer}<br>
	<p>내용 : ${dto.content}<br>
	<p>작성일 : ${dto["regdate"]}<br>
	<hr>
	<a href="list">게시물 목록</a>
</body>
</html>