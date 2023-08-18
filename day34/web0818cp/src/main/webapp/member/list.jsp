<%@page import="member.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	
    String contextPath = request.getContextPath(); 
%>
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
		<% 
		List<MemberDto> list = (List)request.getAttribute("list");
		for(MemberDto dto : list) {
		%>
			<tr>
				<td><a href="detail?id=<%=dto.getId()%>"><%=dto.getId() %></a></td>
				<td><a href="detail?id=<%=dto.getId()%>"><%=dto.getName()%></a></td>
				<td><%=dto.getPwd() %></td>
				<td><%=dto.getStatus() %></td>
			</tr>
		<%
		} 
		%>
		</tbody>
	</table>
	<button><a href="insert_form">회원 등록</a></button>
	<button><a href="<%=contextPath %>/index.jsp">이전으로 돌아가기</a></button>
	
</body>
</html>