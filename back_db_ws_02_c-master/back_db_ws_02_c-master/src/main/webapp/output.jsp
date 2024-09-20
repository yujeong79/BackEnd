<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward, Redirect</title>
</head>
<body>
	<p>당신의 메시지 : <%= request.getParameter("message") %></p>
	<a href="regist.jsp">돌아가기</a>
</body>
</html>