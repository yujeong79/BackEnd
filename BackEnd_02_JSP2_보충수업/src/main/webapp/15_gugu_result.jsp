<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>구구단 결과</h1>
	<% 
	int dan = Integer.parseInt(request.getParameter("dan")); /* request를 받아오기 위해서는 해당 메소드 안에 있어야 하므로 <% 안에 써야한다. */
	
	for(int i =1; i <= 9; i++) {
	%>
		<%=dan + " * " + i + " = " + (dan*i) %> <br>
	<%
	}
	%>
</body>
</html>