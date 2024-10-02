<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>영화 등록 결과</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 130px;
}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<c:if test="${sessionScope.movieCount != null}">
		<h2>지금까지 등록한 영화 수 : ${sessionScope.movieCount}</h2>	
	</c:if>
</body>
</html>
