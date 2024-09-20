<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<h2>스크립트릿 연습</h2>
	<% 
		int A = 10;
		int B = 20;
		
		int sum = A + B; 
		
		/* 
		sum을 브라우저 화면에 보여주고 싶어!!
		그러면 System.out.println을 하는 것이 아니고
		out.print(sum) 하면됨
		여기서 out은 미리 만들어진 jakarta.servlet.jsp.JspWriter out 기본객체임
		*/
	
		out.print(A + "+" + B + "=" + sum);
	%>
	<br>
	<a href="index.html">홈으로</a>
</body>
</html>
