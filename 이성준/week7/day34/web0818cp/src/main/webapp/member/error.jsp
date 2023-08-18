<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작업 실패</title>
</head>
<body>
	<h1>메시지 : ${err_msg }</h1>
	<a href="<%=contextPath %>/index.jsp">돌아가기</a>
</body>
</html>