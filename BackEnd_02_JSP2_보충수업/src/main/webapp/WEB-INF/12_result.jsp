<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.dto.Person" %>   
<%@ page import="java.util.Arrays" %>   
 
<!-- WEB-INF 파일 안으로 들어가게 되면 아예 주소창을 통해서 못 들어오게끔 원천차단됨 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
	<% 
	Person p = (Person)request.getAttribute("person"); 
 	if(p == null) { // 사용자 정보가 없는 경우에 p.getName()과 같이 접근하려면 에러 발생
		%>
		Person 정보가 전달되지 않았습니다. <br>
		<%
	} else { 
	%>
	<table>
		<tr>
			<td>이름</td>
			<td><%=p.getName() %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=p.getAge() %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=p.getGender() %></td>
		</tr>
		<tr>
			<td>취미</td>
			<td><%=Arrays.toString(p.getHobbies()) %></td>
		</tr>
	</table>
	<% 
	}
	%>
	<a href="/BackEnd_02_JSP">홈으로</a>
</body>
</html>