<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 교육생 관리</title>
</head>
<body>
	<h1>교육생 상세 정보</h1>
		<p>아이디 : ${student.id}</p>
		<p>이름 : ${student.name}</p>
		<p>성별 : ${student.gender }</p>
		<p>생년월일 : ${student.birthDate }</p>
	    <hr>
		<p>전공 : ${student.major }</p>		
		<p>캠퍼스 : ${student.campus.loc } - ${student.campus.classNumber }반</p>
		<p>과정 : ${student.curriculum.name }</p>
	<form action="update.jsp" method="get">
		<input type="hidden" name="id" value="${student.id }"> 
		<input type="submit" value="수정">
	</form>
	<form action="main" method="post">
	    <input type="hidden" name="action" value="delete">
		<input type="hidden" name="id" value="${student.id }"> 
		<input type="submit" value="삭제">
	</form>
	<a href="main?action=list">목록으로 돌아가기</a>
</body>
</html>