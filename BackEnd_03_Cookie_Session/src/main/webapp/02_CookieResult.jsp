<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생산공장</title>
</head>
<body>
	<h2>현재 내브라우저에 있는 쿠키 정보</h2>
	<!-- 내가 가지고 있는 쿠키 전부 출력! -->
	<!-- redirect로 쿠키를 다시 재요청해서 받았을 때 쿠키는 어디있을까? -->
	<!-- 클라이언트가 다시 여기로 재요청을 보낸 것이기 때문에 request 안에 있다. -->
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				out.print(c.getName()+":"+c.getValue()+"<br>");
			}
		} else {
			out.print("쿠키가 없습니다.");
		}
	
	
	%>
	<a href="index.html">홈으로</a>
</body>
</html>