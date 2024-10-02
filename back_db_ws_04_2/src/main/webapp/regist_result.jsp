<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	width: 130px;
}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<c:if test="${sessionScope.movieCount != null}">
		<h2>지금까지 등록한 영화 수 : ${sessionScope.movieCount}</h2>	
	</c:if>
<<<<<<< HEAD
=======
	<h2>등록 영화 정보</h2>
	<c:if test="${requestScope.movie != null}">
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
					<td>${requestScope.movie.title}</td>
				</tr>
				<tr>
					<td>감독</td>
					<td>${requestScope.movie.director}</td>
				</tr>
				<tr>
					<td>장르</td>
					<td>${requestScope.movie.genre}</td>
				</tr>
				<tr>
					<td>상영 시간</td>
					<td>${requestScope.movie.runningTime}</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<c:if test="${requestScope.movie == null}">
		<p>등록된 영화 정보가 없습니다.</p>
	</c:if>
	<a href="regist.jsp">추가등록</a>
	<a href="./main?action=list">영화목록</a>
>>>>>>> refs/remotes/origin/main
</body>
</html>
