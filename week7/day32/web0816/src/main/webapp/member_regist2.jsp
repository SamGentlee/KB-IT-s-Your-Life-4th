<%@page import="web0816.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto dto = (MemberDto)request.getAttribute("dto");
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_regist2.jsp</title>
</head>
<body>
	dto = <%=dto %> <br>
	dto.name = <%=dto.getName() %> <br>
	dto.age = <%=dto.getAge() %> <br>
	<%=msg %>
	
</body>
</html>