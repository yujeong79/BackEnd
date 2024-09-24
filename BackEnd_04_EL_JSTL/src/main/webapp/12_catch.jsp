<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외처리</title>
</head>
<body>
	<h3>C:catch</h3>
	<c:catch var="errmsg">
		<div>예외 발생전</div>
		<div><%=1/0 %></div>
		<div>예외 발생후</div>
	</c:catch>
	${errmsg }
	
</body>
</html>