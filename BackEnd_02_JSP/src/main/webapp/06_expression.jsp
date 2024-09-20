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
<title>표현식</title>
</head>
<body>
	<%=name %> <br>
	<%=A+B %> <br>
	<%=abs(B) %> <br>
	<a href="index.html">홈으로</a>
</body>
</html>