<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
</head>
<body>
<h1>게시물 삭제하기</h1>
<table style="text-align:center;">
	<tr>
		<th>게시물 번호</th><td>${dto.no }</td>
	</tr>
	<tr>
		<th>게시물 제목</th><td>${dto.title }</td>
	</tr>
	<tr>
		<th>게시물 작성자</th><td>${dto.writer}</td>
	</tr>
	<tr>
	<fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${dto.regdate }" var="d"/>
		<th>게시물 작성일</th><td>${d}</td>
	</tr>
	<tr>
		<th>게시물 내용</th>
	</tr>
	<tr>
		<td colspan="2"><textarea rows="3" cols="60" readonly>${dto.content }</textarea></td>
	</tr>
</table>
	<a href="board_delete_action?no=${dto.no }">게시물 삭제 완료</a><br>
	<a href="board_detail?no=${dto.no }">게시물 삭제 취소</a><br>
	<a href="board_list">게시물 목록</a><br>
</body>
</html>