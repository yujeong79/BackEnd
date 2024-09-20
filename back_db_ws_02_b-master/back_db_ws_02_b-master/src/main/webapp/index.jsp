<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
<%-- 
	JSP 지시자 : <%@ 지시자 속성="값" %>
		- page : JSP 페이지에 대한 속성을 지정
		- include : 다른 파일을 현재 JSP 페이지에 포함
		- taglib : 사용자 정의 태그 라이브러리를 사용할 때 사용
	
	JSP 선언문 : <%! 선언부분 %>
		- 변수, 메서드 선언
		- 전역변수 선언
		- 메서드 선언
--%>




	
<%!
	// Q. double형 변수 value1, value2를 선언하고 각각 10.0, 20.0을 저장해 봅시다.
	double value1 = 10.0;
	double value2 = 20.0;


	// Q. 이름은 add, 파라미터는 double형 num1, num2이면서 num1과 num2의 '합'을 반환하는 메소드를 작성해 봅시다.
	double add(double num1, double num2){
	    return num1 + num2;
	}
	
	// Q. 이름은 subtract, 파라미터는 double형 num1, num2이면서 num1과 num2의 '차'을 반환하는 메소드를 작성해 봅시다.
	double subtract(double num1, double num2){
	    return num1 - num2;
	}
	
	// Q. 이름은 multiply, 파라미터는 double형 num1, num2이면서 num1과 num2의 '곱'을 반환하는 메소드를 작성해 봅시다.
	double multiply(double num1, double num2){
	    return num1 * num2;
	}
	
	// Q. 이름은 divide, 파라미터는 double형 num1, num2이면서 num1과 num2의 '몫'을 반환하는 메소드를 작성해 봅시다.
	//    0으로 나눌 수 없으므로, num2의 값이 0인 경우는 -1을 반환합니다.
	double divide(double num1, double num2){
	    if(num2 == 0){ 
	    	return -1;
	    }
	    return num1 / num2;
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>JSP 계산기</title>
</head>
<body>

<%--
	Q. JSP Directive 중 include를 이용하여 header.jsp를 화면에 출력되도록 해봅시다.
--%>
<%@ include file="/header.jsp" %>


<h2>계산결과</h2>
<p>  
	<%-- Q. 변수 value1과 value2의 값을 출력 --%>
	변수 value1: <% out.print(value1); %> <br>
	변수 value2: <% out.print(value2); %> <br>
	
	
	
	------------------------- <br>
	
	
	
	<%-- Q. 위에 선언한 덧셈/뺄셈/곱셈/나눗셈 메서드를 호출하여 value1과 value2 연산 결과 출력 --%>
	덧셈: <% out.print(add(value1, value2) ); %> <br>
	뺄셈: <% out.print(subtract(value1, value2) ); %> <br>
	곱셈: <% out.print(multiply(value1, value2) ); %> <br>
	나눗셈: <% out.print(divide(value1, value2)) ; %> <br>
</p>
</body>
</html>