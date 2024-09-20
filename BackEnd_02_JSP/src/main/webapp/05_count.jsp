<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%! int count1 = 0; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호출</title>
</head>
<body>
	<%
	int count2 = 0;
	
	out.print("count1: " + (count1++) + "<br>"); /* 새로고침하면 count1만 올라간다. 왜?*/
	out.print("count2: " + (count2++) + "<br>");
	%>
	<a href="index.html">홈으로</a>
</body>
</html>