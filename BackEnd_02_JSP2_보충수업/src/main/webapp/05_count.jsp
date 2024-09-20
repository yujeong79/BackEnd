<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>호출1</title>
</head>
<body>
	<%!int count1 = 0;%>
	<%
	int count2 = 0;
	
	
	out.print("count1: "+(count1++)+"<br>");
	out.print("count2: "+(count2++)+"<br>");
	%>
	<a href="index.html">홈으로</a>
</body>
</html>