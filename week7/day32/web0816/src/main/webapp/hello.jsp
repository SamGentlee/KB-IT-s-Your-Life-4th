<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
	<%= new java.util.Date() %>
	<%
		response.getWriter().println("Hello");
		out.println("hello");
	%>
</body>
</html>