<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생산공장</title>
</head>
<body>
	<h2>쿠키 설정</h2>
	<form action="make" method="GET"> <!-- make에 요청을 보내겠다, GET 방식이기 때문에 주소창에 데이터가 뜬다. -->
		이름 : <input type="text" name="key"> <br>
		내용 : <input type="text" name="value"> <br>
		<button>생성</button> <!-- input의 submit가 똑같이 동작 -->
	</form>
</body>
</html>