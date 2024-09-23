<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 기본객체</title>
</head>
<body>
	<%
		// 각 영역에 데이터 심기
		pageContext.setAttribute("name", "page yang"); // secondScope로 넘어가게 되면 page는 나오지 않는다, 페이지 영역은 다른 페이지로 넘어가면 새롭게 객체가 생성되기 때문
		request.setAttribute("name", "request yang");
		session.setAttribute("name", "session yang");
		application.setAttribute("name", "application yang");
		
		System.out.println("페이지 속성 " + pageContext.getAttribute("name"));
		System.out.println("요청 속성 "+ request.getAttribute("name"));
		System.out.println("세션 속성 "+ session.getAttribute("name"));
		System.out.println("어플리케이션 속성 "+ application.getAttribute("name"));
		
		// forwarding 방법으로 자연스럽게 secondScope 영역으로 이동
		// 그러면 pageContext 객체는 그렇다치고 나머지 객체들은 어디 저장됨?
		// 아 맞다~ 기본객체잖아!!
		request.getRequestDispatcher("04_SecondScope.jsp").forward(request, response);
		
	%>
	
	
</body>
</html>