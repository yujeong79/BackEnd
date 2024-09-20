<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="09_error.jsp" %> <!-- 에러가 발생하면 09_error.jsp로 가~ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러연습</title>
</head>
<body>
	<h2>정수를 0으로 나누어 보자</h2>
	<%= 2 / 0 %> <!-- 에러가 발생해서 09_error.jsp를 띄울 때 주소가 바뀌지는 않고 그냥 그 파일을 띄우는 것 -->

	<a href="index.html">홈으로</a>
</body>
</html>