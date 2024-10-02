<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.ssafy.ws.step3.dto.*" %>
<%@ page import="com.ssafy.ws.step3.dao.*" %>
<%!
private CampusDao campusDao = new CampusDaoImpl();
private CurriculumDao curriculumDao = new CurriculumDaoImpl();
%>
<%
try {
	// 캠퍼스와 커리큘럼 정보를 가져옵니다.
	List<Campus> campuses = campusDao.selectAll();
	List<Curriculum> curriculums = curriculumDao.selectAll();
	
	// 가져온 정보를 request 객체에 저장합니다.
	request.setAttribute("campuses", campuses);	
	request.setAttribute("curriculums", curriculums);
} catch (SQLException e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 교육생 등록 페이지</title>
</head>
<body>
	<h1>SSAFY 교육생 등록 페이지</h1>
	<form action="main" method="post">
		<input type="hidden" name="action" value="regist">
	    학번 : <input type="text" name="id"><br>
		이름 : <input type="text" name="name"><br> 
		성별 : <select name="gender">
			<option value="남" >남성</option>
			<option value="여" >여성</option>
		</select>
		캠퍼스 : <select name="campus">
			<c:forEach var="campus" items="${campuses}">
				<option value="${campus.id}" >${campus.loc} - ${campus.classNumber}반</option>
			</c:forEach>
		</select>
		트랙 : <select name="curriculum">
			<c:forEach var="curriculum" items="${curriculums}">
                <option value="${curriculum.id}" >${curriculum.name}</option>
			</c:forEach>
		</select><br>
		생년월일 : <input type="text" name="birth_date"><br>
		전공 : <input type="text" name="major"><br> 
		재학유무 : <select name="in_ssafy">
			<option value="0">미분류</option>
			<option value="1">재학</option>
			<option value="2">휴학</option>
			<option value="3">졸업</option>
			<option value="4">취업퇴소</option>
			<option value="5">중도퇴소</option>
		</select><br>	
		<input type="submit" value="등록">
	</form>
	<a href="main?action=list">뒤로가기</a>
</body>
</html>