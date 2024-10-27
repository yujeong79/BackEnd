<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<form action="main" method="POST">
		<fieldset>
			<legend>${book.title} 도서 수정</legend>
			<input type="hidden" name="action" value="update">
			<p> ISBN <input type="text" name="isbn" id="isbn" value="${book.isbn}"> </p>
			<p> 제목 <input type="text" name="title" id="title" value="${book.title}"> </p>
			<p> 작가 <input type="text" name="author" id="author" value="${book.author}"> </p>
			<p> 가격 <input type="text" name="price" id="price" value="${book.price}"> </p>
			<p> 설명 <input type="text" name="desc" id="desc" value="${book.desc}"> </p>
			<p> 이미지 <input type="text" name="img" id="img" value="${book.img}"> </p>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</fieldset>
	</form>
</body>
</html>