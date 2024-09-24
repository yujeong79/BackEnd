<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<%
	//pageContext.setAttribute("name", "page yang");
	request.setAttribute("name", "request yang");
	session.setAttribute("name", "session yang");
	application.setAttribute("name", "application yang");
	%>
	
	JSP Page 영역 접근 : <%=pageContext.getAttribute("name") %><br>
	EL (Page) : ${pageScope.name} <br>
	EL (Request) : ${requestScope.name} <br>
	EL (Session) : ${sessionScope.name} <br>
	EL (Application) : ${applicationScope.name} <br>
	
	
	그냥 속성 작성 : ${name } <br>
	
	
	쿠키(대괄호 접근) : ${cookie["JSESSIONID"].value} <br>
	쿠키(. dot 접근) : ${cookie.JSESSIONID.value} <br>
	
	
	
	
</body>
</html>