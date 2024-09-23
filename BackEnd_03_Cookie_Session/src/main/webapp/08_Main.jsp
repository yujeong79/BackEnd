<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(session.getAttribute("userid") == null) { // 로그인되지 않았다면 다시 원래 페이지로 돌아간다.
			response.sendRedirect("07_LoginFrom.jsp");
		} else { %>
			<%= session.getAttribute("userid") %>
			
			<a href="07_Logout.jsp">로그아웃</a>
			<%
		}
	%>

</body>
</html>