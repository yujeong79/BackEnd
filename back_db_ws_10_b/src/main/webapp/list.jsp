<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.ws.step2.Student"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 학생 정보</title>
</head>
<body>
	<table>
		<%-- JSTL 을 사용하여 테이블 형태로 출력을 진행합니다. --%>
		<h1>전체 학생 정보</h1>
		<!-- 
	    private int id; // 학번
	    private String name; // 이름
	    private String phone; // 전화번호
	    private Date created_at; // 생성일시
	    private Date updated_at; // 수정일시
	    -->
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>기타</th>
		</tr>

		<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.phone}</td>
				<th><a href="main?action=selectOne&id=${student.id}">상세조회</a></th>
			<tr>
		</c:forEach>

		<a href="index.jsp">메인화면으로</a>
	</table>
</body>