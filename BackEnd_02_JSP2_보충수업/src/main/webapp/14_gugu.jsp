<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<h3>몇단 을 구할까나?</h3>
	<form action="15_gugu_result.jsp" method="get">
		<input type="hidden" name="action" value="gugu">
		<div>단 입력</div>
		<input type="number" min="1" value="1" name="dan">
		<button>계산</button>
	</form>
</body>
</html>