<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%! /* 변수나 메소드를 정의할 수 있다*/
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
		// 여기에 메소드를 정의할 수는 없을까?
		/* public int mul(int A, int B){
			return A *B;
		} */
	
		int C = -10;
	
		out.print(add(A, B));
		out.print("<br>");
		
		out.print(abs(C));
		out.print("<br>");
	%>
	
	<a href="index.html">홈으로</a>
</body>
</html>