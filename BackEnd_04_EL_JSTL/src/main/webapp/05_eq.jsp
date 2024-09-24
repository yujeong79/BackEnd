<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EQ</title>
</head>
<body>
	<!-- URL 쿼리스트링을 작성해서 보았다. -->
	<%=request.getParameter("id") %> <br>
	${param.id} <br>
	
	== : <%=request.getParameter("id") == "ssafy"%> <br>
	equals() : <%=request.getParameter("id").equals("ssafy") %> <br> 
	
	== (EL) : ${param.id == "ssafy"} <br>
	eq (EL) : ${param.id eq "ssafy"} <br>
	
	
</body>
</html>