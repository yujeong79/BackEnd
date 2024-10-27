<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<h1>${book.title} 상세 정보</h1>
	<table>
		<thead>
			<tr>
				<th>ISBN</th>
				<th>제목</th>
				<th>작가</th>
				<th>가격</th>
				<th>설명</th>
				<th>이미지</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}원</td>
				<td>${book.desc}</td>
				<td>${book.img}</td>
			</tr>
		</tbody>
	</table>
	<a href="main?action=updateForm&id=${book.isbn}">수정</a>
	<a href="main?action=remove&id=${book.isbn}">삭제</a>
</body>
</html>