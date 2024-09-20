<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet, Expression</title>
</head>
<body>
	<h1>랜덤 환영 메시지</h1>
	<!--
	
		JSP(Jakarta Server Pages, Java Server Pages)
		- JSP는 HTML 내부에 Java 코드를 삽입하여 동적 웹 페이지를 생성할 수 있습니다.
		- JSP 파일은 서버에서 Java Servlet으로 변환되어 실행됩니다.

		스크립트릿(Scriptlet):
		- 스크립트릿은 JSP 페이지 내에서 Java 코드를 사용하는 영역입니다.
		- < %와 % > 사이에 Java 코드를 작성하여 변수 선언, 조건문, 반복문, 메서드 호출 등을 수행할 수 있습니다.
		- 스크립트릿은 서버 측에서 실행되며, 클라이언트에게는 결과만 전달됩니다.

		표현식(Expression):
		- 표현식은 JSP 페이지 내에서 Java 코드의 결과를 출력하는 영역입니다.
		- < %= % > 태그를 사용하여 표현식을 작성하며, 그 안에 변수, 메서드 호출 등을 사용하여 값을 출력할 수 있습니다.
		- 표현식은 스크립트릿과 달리 단순히 값을 출력하는 용도로만 사용됩니다.
		
	  -->
<%
	// 랜덤 환영 메시지를 message 담는 코드
    String[] welcomeMessageList = { "환영합니다!", "반가워요!", "안녕하세요!" };
    int randomNumber = (new Random()).nextInt(welcomeMessageList.length); // 0, 1, 2 중에 랜덤 숫자
    
    // Q. welcomeMessages 배열에서 randomNumber값을 인덱스로 사용하였을 때 해당되는 요소를 message 변수에 담는 코드를 작성해주세요.
    String message = ____[____];
%>
	<%-- 
		Q. welcomeMessages 배열을 출력하도록 아래 코드를 작성해주세요.
	 --%>
    <h1>랜덤 환영 메시지들 : <%= Arrays.____(____) %></h1>
	
	
	<%--
		Q. message 변수를 출력하도록 아래 코드를 작성해주세요.
	--%>
	<h1>____</h1>

	<%--
		Q. message가 "환영합니다!"라면 "반갑습니다!!"를 출력하도록 아래 코드를 작성해주세요. 
	--%>
	<%
		if(message.equals("환영합니다!")) {
			____.____("<h1>반갑습니다!!.</h1>");
		}
	%>

	<%--
		Q. welcomeMeesageList의 값을 하나 씩 출력하면서, message 변수와 동일한 경우에는 굵게 표시해 봅시다.
	--%>
	<%
		for(int messageIdx = 0; messageIdx < welcomeMessageList.length; messageIdx++) {
			
			if(welcomeMessageList[messageIdx].equals(message)) {
				
				____.____("<p><b>" + ____[____] + "</b></p>");
				
			} else {
				
				____.____("<p>" + ____[____] + "</p>");
			
			}
		} 
	%>
	
	<h3>새로고침하면 결과가 다르게 나타납니다.</h3>
</body>
</html>