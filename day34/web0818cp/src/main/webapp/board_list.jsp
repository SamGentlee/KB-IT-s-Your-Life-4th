<%@page import="board.dto.BoardDto"%>
<%@page import="board.dao.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:forEach var="i" items="${list }">
			<tr>
				<td>${i.no }</td>
				<td><a href="board?command=detail&no=${i.no }">${i.title }</a></td>
				<td><a href="board?command=detail&no=${i.no }">${i.writer }</a></td>
				<td>${i.content }</td>
				<td>${i.regdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>