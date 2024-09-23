<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<!-- 로그아웃하기 -->
	<!-- 방법1. 속성 지우기 -->
	<% session.removeAttribute("userid"); %>
	
	<!-- 방법2. 세션 자체를 아예 없애버리기 -->
	<%-- <% session.invalidate(); %> --%>
	
	<!-- 그냥 해봄ㅎㅎ 자바스크립트임 -->
	<script>
		alert("로그아웃!!")
		location.href = "index.html"; 
	</script>
</body>
</html>