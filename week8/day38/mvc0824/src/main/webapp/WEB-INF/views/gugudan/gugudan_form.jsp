<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>

	<form action="gugudan_view" id="gugudanForm">
		<fieldset>
		<select name="gugudanNum" form="gugudanForm">
			<option value="2">2단</option>
			<option value="3">3단</option>
			<option value="4">4단</option>
			<option value="5">5단</option>
			<option value="6">6단</option>
			<option value="7">7단</option>
			<option value="8">8단</option>
			<option value="9">9단</option>
		</select>
			출력할 구구단을 입력하세요 : <input type = "number" name="gugudanNum2" min="2" max="9"> 
			<input type = "submit" value="구구단 출력">
		</fieldset>
	</form>
	
	<div id="result" >
	<c:if test="${gugudanNum ne 0}">
		<c:forEach begin="1" end="9" var="i">
		${gugudanNum} x ${i } = ${gugudanNum*i} <br>
		</c:forEach>
	</c:if>
	</div>
	<div id="result2">
		${result }
	</div>
	
</body>
</html>