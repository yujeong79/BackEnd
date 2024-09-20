<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%> <!-- 이 페이지는 에러페이지가 맞다 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
	<h2>오류났을 때 오는 페이지</h2>
	<%=exception.getMessage()%> <!-- exception은 기본객체, 그냥 그 어디서도 선언되지 않는 객체가 사용된다면 기본객체라고 생각해..-->
	<a href="index.html">홈으로</a>
</body>
</html>