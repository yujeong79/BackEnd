<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<%@ include file="/include/header.jsp" %>
	<h1>전체 도서 목록</h1>
	<table>
	<thead>
		<tr>
			<th>ISBN</th>
			<th>제목</th>
			<th>작가</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td><a href="main?action=detail&id=${book.isbn}">${book.isbn}</a></td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="regist.jsp">도서 등록</a>
</body>
</html>
