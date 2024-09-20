<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!
	int A = 10;
	int B = 20;
	
	String name = "SSAFY";
	
	public int add(int A, int B){
		return A+B;
	}
	
	public int abs(int A){
		return A > 0 ? A : -A;
	}
%>	

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부</title>
</head>
<body>
	
	<%
		int C = -10;
	
	//요기에 메서드를 정의할 수는 없을까??
	/* 		public int mul(int A, int B){
			return A * B;
		} */
	
	
		out.print(add(A, B));
		out.print("<br>");
		
		out.print(abs(C));
		out.print("<br>");
	%>







	<a href="index.html">홈으로</a>
</body>
</html>