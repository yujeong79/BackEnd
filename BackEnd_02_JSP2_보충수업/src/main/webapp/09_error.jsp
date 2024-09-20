<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
	<h2>오류났을 때 오는 페이지</h2>
	<%=exception.getMessage()%>
	<a href="index.html">홈으로</a>
</body>
</html>