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
private StudentDao studentDao = StudentDaoImpl.getInstance();
%>
<%
String id = request.getParameter("id");
try {
	// 교육생과 캠퍼스, 커리큘럼 정보를 가져옵니다.
	Student student = studentDao.selectOne(id);
    List<Campus> campuses = campusDao.selectAll();
    List<Curriculum> curriculums = curriculumDao.selectAll();
    
 	// 가져온 정보를 request 객체에 저장합니다.
    request.setAttribute("campuses", campuses);
    request.setAttribute("curriculums", curriculums);
    request.setAttribute("student", student);
} catch (SQLException e) {
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 교육생 수정 페이지</title>
</head>
<body>
	<h1>SSAFY 교육생 수정 페이지</h1>
	<form action="main" method="post">
		<input type="hidden" name="action" value="update">
	    <input type="hidden" name="id" value="${student.id}"><br>
		이름 : <input type="text" name="name" value="${student.name}"><br> 
		성별 : <select name="gender">
			<option value="남" ${'남' == student.gender ? 'selected':''}>남성</option>
			<option value="여" ${'여' == student.gender ? 'selected':''}>여성</option>
		</select>
		캠퍼스 : <select name="campus">
			<c:forEach var="camp" items="${campuses}">
				<option value="${camp.id}" ${camp.id == student.campus.id ? 'selected':''}>${camp.loc} - ${camp.classNumber}반</option>
			</c:forEach>
		</select>
		트랙 : <select name="curriculum" >
            <c:forEach var="curri" items="${curriculums}">
                <option value="${curri.id}" ${curri.id == student.curriculum.id ? 'selected':''}>${curri.name}</option>
            </c:forEach>
		</select><br>
		생년월일 : <input type="text" name="birth_date" value="${student.birthDate}"><br>
		전공 : <input type="text" name="major" value="${student.major}"><br> 
		재학유무 : <select name="in_ssafy">
			<option value="0" ${0 == student.inSsafy ? 'selected':''}>미분류</option>
			<option value="1" ${1 == student.inSsafy ? 'selected':''}>재학</option>
			<option value="2" ${2 == student.inSsafy ? 'selected':''}>휴학</option>
			<option value="3" ${3 == student.inSsafy ? 'selected':''}>졸업</option>
			<option value="4" ${4 == student.inSsafy ? 'selected':''}>취업퇴소</option>
			<option value="5" ${5 == student.inSsafy ? 'selected':''}>중도퇴소</option>
		</select><br>	
		<input type="submit" value="수정"><br>
		<a href="main?action=list">목록으로 돌아가기</a>
	</form>
</body>
</html>