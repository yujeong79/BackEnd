<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
=======
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록</title>
<style>
	#movie-list {
	border-collapse: collapse;
	width: 100%;
	}
	
	#movie-list td, #movie-list th {
		border: 1px solid black;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>영화 목록</h1>
	<h2>지금까지 등록한 영화 수 : ${movieCount}</h2>
	<table id="movie-list">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>상영시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${movies}" var="movie" varStatus="vs">
			<tr>				
				<td>${vs.count}</td>
				<td>${movie.title}</td>
				<td>${movie.director}</td>
				<td>${movie.genre}</td>
				<td>${movie.runningTime}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>
>>>>>>> branch 'main' of https://github.com/yujeong79/BackEnd.git
