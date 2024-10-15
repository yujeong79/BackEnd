<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
	table {
	border-collapse: collapse;
	width: 100%;
	}
	
	th, td {
		border: 1px solid black;
	}
	
	th:nth-child(1) {
		width: 120px;
	}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<h2>지금까지 등록한 영화 수 : </h2>
	<table>
		<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>영화 제목</td>
			<td>${movie.title}</td>
		</tr>
		</tbody>
	</table>
</body>
</html>
