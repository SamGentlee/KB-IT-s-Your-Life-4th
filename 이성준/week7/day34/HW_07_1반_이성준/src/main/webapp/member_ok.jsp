<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작업 성공</title>
</head>
<body>
	<h1>메시지 : ${msg }</h1>
	<h3>아이디 : ${dto.id }</h3>
	<h3>이름 : ${dto.name }</h3>
	<h3>비밀번호 : ${dto.pwd }</h3>
	<h3>회원상태 : ${dto.status }</h3>
	<a href="list">회원목록</a>
	<a href="<%=contextPath %>/index.jsp">돌아가기</a>
</body>
</html>