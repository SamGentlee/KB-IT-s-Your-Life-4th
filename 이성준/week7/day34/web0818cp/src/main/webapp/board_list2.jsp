<%@page import="board.dto.BoardDto"%>
<%@page import="board.dao.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDto> list = (List)request.getAttribute("list");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
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
</style>
</head>
<body>
	<h1>게시판 목록</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<% 
		for(BoardDto dto : list) {
		%>
			<tr>
				<td><%=dto.getNo() %></td>
				<td><a href="board?command=detail&no=<%=dto.getNo()%>"><%=dto.getTitle() %></a></td>
				<td><a href="board?command=detail&no=<%=dto.getNo()%>"><%=dto.getWriter() %></a></td>
				<td><%=dto.getContent() %></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
		<%
		} 
		%>
		</tbody>
	</table>
</body>
</html>