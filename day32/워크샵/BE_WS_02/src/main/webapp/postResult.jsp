<%@page import="dto.ParameterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post result</title>
<style>
	table, tr, td{
		border: 1px solid black;
	}
</style>
</head>
<% ParameterDto dto=(ParameterDto)request.getAttribute("dto"); %>
<body>
	<h1>Post Result</h1>
	<table>
		<tr>
			<td >name</td>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>email</td>
			<td><%=dto.getEmail() %></td>
		</tr>
		<tr>
			<td>gender</td>
			<td><%=dto.getGender() %></td>
		</tr>
		<tr>
			<td>hobby</td>
			<td><%
				for(int i=0;i<dto.getHobby().length;i++){
				%>
				<%=dto.getHobby()[i] %>
				<%
				}
				%>
			</td>
		</tr>
		<tr>
			<td>favorite</td>
			<td><%=dto.getFavorite() %></td>
		</tr>
		<tr>
			<td>desc</td>
			<td><%=dto.getDesc() %></td>
		</tr>
	</table>
</body>
</html>