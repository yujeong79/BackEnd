<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화정보사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>SSAFY 영화 관리</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>영화 정보 입력</legend>
		<input type="hidden" name="action" value="regist">
		<label for="title">제목</label>
		<input type="text" id="title" name="title"><br>
		<label for="director">감독</label>
		<input type="text" id="director" name="director"><br>
		<label for="genre">장르</label>
		<input type="text" id="genre" name="genre"><br>
		<label for="runningTime">상영시간</label>
		<input type="text" id="runningTime" name="runningTime"><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>
</body>
</html>