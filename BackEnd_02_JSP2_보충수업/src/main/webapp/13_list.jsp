<%@page import="com.ssafy.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 목록</h1>
	<%
		List<Person> list = (List<Person>) request.getAttribute("list");
		if(list == null || list.size() == 0) { // 등록된 사용자가 없으면
			out.print("등록된 사용자가 없습니다. <br/>");
		} else {
			for(Person p : list) {
				out.print(p.toString() + "<br/>");
			}
		}
		
	%>
</body>
</html>