<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<<<<<<< HEAD
<!DOCTYPE html>
=======
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
<style>
#movie-list {
	border-collapse: collapse;
	width: 100%;
}

#movie-list td, #movie-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>영화 목록</h1>
	<c:if test="${sessionScope.movieCount != null}">
		<h2>지금까지 등록한 영화 수 : ${sessionScope.movieCount}</h2>	
	</c:if>
	<table id="movie-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>감독</th>
				<th>장르</th>
				<th>상영 시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.movies}" var="movie" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${movie.title}</td>
					<td>${movie.director}</td>
					<td>${movie.genre}</td>
					<td>${movie.runningTime}분</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>
>>>>>>> refs/remotes/origin/main
