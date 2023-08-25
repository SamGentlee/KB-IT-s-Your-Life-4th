<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
<body>
	<h1>게시물 목록</h1>
	<table>
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${board_list}" var="i">
			<tr>
				<td>${i.no}</td>
				<td><a href="board_detail?no=${i.no}">${i.title }</a></td>
				<td>${i.writer }</td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${i.regdate }" var="d"/>
				<td>${d }</td>
			</tr>
			</c:forEach>			
		</tbody>
	</table>
</body>
</html>