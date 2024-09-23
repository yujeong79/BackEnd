<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체</title>
</head>
<body>
	<p>페이지 속성 : <%= pageContext.getAttribute("name") %></p>
	<p>요청 속성 : <%= request.getAttribute("name") %></p>
	<p>세션 속성 : <%= session.getAttribute("name") %></p>
	<p>애플리케이션속성 속성 : <%= application.getAttribute("name") %></p>
	
	<!-- 해당 링크를 누르면 p r s a 중에 무엇이 남을까? -->
	<!-- 새로운 요청이 들어오기 때문에 해당 링크를 누르면 s와 a만 남는다. --> 
	<a href="05_ThirdScope.jsp">세번째 페이지</a>
</body>
</html>