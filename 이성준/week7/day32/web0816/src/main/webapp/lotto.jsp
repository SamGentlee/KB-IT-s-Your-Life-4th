<%@page import="java.util.TreeSet"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	TreeSet<Integer> lotto = new TreeSet<>();
	public static String prn(){
		return "헬롱";
	}
%>
<%	//스크립트릿(Scriptlet - ~let 작다라는 의미)
	for(;lotto.size()<6;){
		int r = new java.util.Random().nextInt(45)+1;
		lotto.add(r);
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로또번호 추천 JSP</title>
</head>
<body>
	<h1>오늘의 로또 번호</h1>
	<h2><%= lotto %></h2>
	<h2><%= prn() %></h2>
</body>
</html>