<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<h3>로그인페이지</h3>
	<form action="07_LoginCheck.jsp" method="POST"> <!-- 07_LoginCheck.jsp로 보낸다. -->
	<!-- 원래 여태까진 action 해서 다 servlet으로 보냈는데 이 LoginForm에서는 jsp로 보낸다. 가능할까? -->
	<!-- jsp도 결국 servlet으로 변환되기 때문에 가능하다. -->
		<input type="hidden" name="action" value="login">
		<input type="text" placeholder="아이디입력" name="id">
		<input type="password" placeholder="비밀번호입력" name="password">
		<button>로그인</button>
	</form>
</body>
</html>