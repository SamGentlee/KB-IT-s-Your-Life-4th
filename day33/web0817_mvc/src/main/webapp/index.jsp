<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 예제</title>
</head>
<body>
	
	<h1>Welcome MVC</h1>
	<!-- 상대경로는 앞에 /가 없으며 현재 url의 파일경로가 앞에 있다는 뜻
		href="board/insert_form"
	http://localhost:8080/web0817_mvc/board/insert_form
		앞에 /가 붙으면 contextPath가 사라지면서
		href="/board/insert_form"
	 http://localhost:8080/board/insert_form -->
	<a href="board/insert_form">게시물 등록</a> 
	<a href="board/list">게시물 목록</a> 
	
</body>
</html>