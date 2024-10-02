<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 교육생 관리</title>
<style>
#student-list {
	border-collapse: collapse;
	width: 100%;
}

#student-list td, #student-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>교육생 목록</h1>
	<c:if test="${!empty studentCount }">
		<h2>지금까지 등록한 student 수 : ${studentCount}</h2>
	</c:if>
	<table id="student-list">
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>1학기 트랙</th>
				<th>생년월일</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 students로 등록된 자료를 반복문을 이용해 출력한다. --%>
			<c:forEach items="${students }" var="student" varStatus="vs">
				<tr>
					<td>${student.id }</td>
					<td><a href="main?action=detail&id=${student.id }">
					${student.name }</a></td>
					<td>${student.curriculum.name }</td>
					<td>${student.birthDate }</td>
					<td><a href="main?action=delete&id=${student.id }">삭제</a>
						<a href="update.jsp?id=${student.id }">수정</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">교육생 등록하기</a>
	<a href="index.jsp">메인으로</a>
</body>
</html>