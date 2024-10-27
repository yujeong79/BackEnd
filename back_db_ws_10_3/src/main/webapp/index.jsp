<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리 시스템</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<c:if test="${msg != null}">
		<alert>${msg}</alert>
	</c:if>
	<a href="regist.jsp">도서 등록</a>
	<a href="main?action=list">도서 목록</a>
</body>
</html>