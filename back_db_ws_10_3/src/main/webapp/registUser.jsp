<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="main" method="POST">
	<fieldset>
		<legend>회원가입</legend>
		<input type="hidden" name="action" value="registUser">
		<p> 아이디 <input type="text" name="id" id="id"> </p>
	    <p> 이름 <input type="text" name="name" id="name"> </p>
	    <p> 비밀번호 <input type="password" name="password" id="password"> </p>
	    <p> rec_id <input type="text" name="rec_id" id="rec_id" value="없음"> </p>
	    <input type="submit" value="회원가입">
	    <input type="reset" value="취소">
	</fieldset>
	</form>
</body>
</html>