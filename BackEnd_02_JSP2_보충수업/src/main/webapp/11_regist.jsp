<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
<h3>사람 등록</h3>
	<!-- action 속성이 /로 시작하냐 안하냐에 따라 차이를 명확하게 알고 있어야한다.! -->
	<form action="main" method="POST">
		<input type="hidden" name="act" value="regist">
		<label>이름 : </label>
		<input type="text" placeholder="이름을 입력하세요" name="name"><br>
		<label>나이 : </label>
		<input type="number" min="0" placeholder="나이를 입력하세요" name="age"><br>
		<input type="radio" id="man" name="gender" value="man">
		<label for="man">남자</label>
		<input type="radio" id="woman" name="gender" value="woman">
		<label for="woman">여자</label>
		
		<fieldset>
			<legend>취미</legend>
			<input type="checkbox" id="sleep" name="hobby" value="sleep">
			<label for="sleep">수면</label>
			<input type="checkbox" id="eat" name="hobby" value="eat">
			<label for="eat">먹기</label>
			<input type="checkbox" id="study" name="hobby" value="study">
			<label for="study">공부</label>
		</fieldset>
		<input type="submit" value="등록">
		<a href="main?act=list">사용자 목록</a> <!-- main과 맵핑된 servlet에서 name이 act이고 value가 list가 되어 넘어감 -->
	</form>
</body>
</html>