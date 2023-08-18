<%@ page language="java" errorPage="error_gugudan.jsp"%>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<%
	String sdan = request.getParameter("dan");
	int dan = Integer.parseInt(sdan);
	for(int i = 1;i<10;i++){
%>
	<%= dan %> * <%= i %> = <%=dan*i %><br>
<% 		
	}
%>
</body>
</html>