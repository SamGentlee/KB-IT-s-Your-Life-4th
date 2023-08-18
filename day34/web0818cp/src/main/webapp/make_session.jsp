<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션생성하기</title>
</head>
<body>
<%
	session.setAttribute("myname", "Hong");
%>
	<h1> myname에 Hong을 저장</h1>
</body>
</html>