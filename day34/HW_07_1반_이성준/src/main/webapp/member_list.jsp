<%@page import="HW_07_1반_이성준.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<style>
	table{
		width:100%;
	}
	table, tr, th, td{
		border: 1px solid black;
	}
	a {
		text-decoration:none;
		color:black;
	}
	a:hover{
		text-decoration:underline;
		color:blue;
	}
	button{
		text-align:center;
		margin: 10px auto;
	}
</style>
</head>
<body>
	<h1>게시판 목록</h1>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>회원 상태</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="i" items="${list}">
			<tr>
				<td><a href="detail?id=${i.id }">${i.id }</a></td>
				<td><a href="detail?id=${i.id }">${i.name }</a></td>
				<td>${i.pwd }</td>
				<td>${i.status }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<button><a href="insert_form">회원 등록</a></button>
	<button><a href="<%=contextPath %>/index.jsp">이전으로 돌아가기</a></button>
	
</body>
</html>