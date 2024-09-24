<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드라마 반복</title>
</head>
<body>
	<%
		String[] dramaList = {"파스타", "왔다 장보리", "눈물의 여왕", "태조왕건"};
		pageContext.setAttribute("dramaList1", dramaList);
	%>
	
	<h3>C:forEach</h3>
	<ul>
		<c:forEach items="${dramaList1}" var="drama">
			<li>${drama}</li>
		</c:forEach>
	</ul>
	<hr>
	<c:forEach items="${dramaList1}" var="drama" varStatus="status" begin="1" end="3" step="2">
		<div>${status.index } : ${drama }</div>
	</c:forEach>
	<hr>
	<c:forEach items="${dramaList1}" var="drama" varStatus="status" begin="1" end="3" step="2">
		<div>${status.count } : ${drama }</div>
	</c:forEach>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>