<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ssafy.ws.step1.Member" %>

<%
	   Member member = new Member("홍길동", 20);

	   List<String> fruits = new ArrayList<>();
       fruits.add("사과");
       fruits.add("바나나");
       fruits.add("딸기");
       
	   request.setAttribute("member", member);
	   request.setAttribute("fruits", fruits);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 표현식 연습하기</title>
</head>
<body>
	<h1>EL 표현식 연습하기</h1>
	
	<%--  
		EL 표현식(Expression Language)
		JSP에서 자바 코드를 사용하지 않고도 데이터를 출력하거나 연산을 수행할 수 있도록 도와주는 표현식입니다.
		
		EL 문법
		기본적으로 ${표현식} 형태로 작성하며, 중괄호 안에 들어가는 부분이 실제로 평가되는 표현식입니다.
		
		EL 표현식의 종류
			- .과 [] 연산자
			이들은 객체의 속성에 접근하는 데 사용됩니다. 예를 들어, ${person.name} 또는 ${person["name"]}은 person 객체의 name 속성에 접근합니다.
			
			- 산술 연산자
			+, -, *, /, % 등의 산술 연산자를 사용할 수 있습니다.
			
			- 관계 연산자
			==, !=, <, >, <=, >= 등의 관계 연산자를 사용할 수 있습니다.
			
			- 논리 연산자
			&&, ||, ! 등의 논리 연산자를 사용할 수 있습니다.
			
			- 삼항 연산자
			조건 ? 값1 : 값2 형식의 삼항 연산자를 사용할 수 있습니다.
			
			- empty 연산자
			변수가 설정되어 있지 않거나 변수의 값이 false인 경우 true를 반환합니다.
	 --%>
	
	
	
	
	<!-- 
		Q. EL 표현식을 사용하여 member 객체의 이름과 나이를 출력해 봅시다.
	-->
	<p>이름 : ${member.name}</p>
	<p>나이 : ${member.age}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여 member 객체의 hello() 메소드를 호출하여 출력한다.
	-->
	<p>소개 : ${member.hello()}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여 fruits 리스트의 길이를 출력해 봅시다.
	-->
	<p>배열의 길이 : ${fruits.size()}</p>
    	
    	
    	
    	
	<!--
		Q. EL 표현식을 사용하여 fruits 배열의 첫번째 요소를 출력해 봅시다.
	-->
	<p>배열의 첫번째 요소 : ${fruits[0]}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 1과 2를 더한 결과를 출력해 봅시다.
	-->
	<p>1 + 2 = ${1+1}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 1을 2로 나눈 결과를 출력해 봅시다.
	-->
	<p>1 / 2 = ${1 / 2}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 1과 2가 같은지 비교하여 출력해 봅시다.
	-->
	<p>1 == 2 = ${1 == 2}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 1과 2가 같지 않은지 비교하여 출력해 봅시다.
	-->
	<p>1 != 2 = ${1 != 2}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 논리연산 결과를 출력해 봅시다.
	-->
	<p>true && false = ${true && false}</p>
	<p>true || false = ${true || false}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 삼항 연산 결과를 출력해 봅시다.
	-->
	<p>1==1 ? "참" : "거짓" = ${1 == 1 ? "참" : "거짓"}</p>
	<p>1==2 ? "참" : "거짓" = ${1 == 2 ? "참" : "거짓"}</p>
	
	
	
	
	<!--
		Q. EL 표현식을 사용하여서 fruits 배열이 비어있는지, 비어있지 않은지를 출력해 봅시다.
	-->
	<p>fruits 배열이 비어있는지 : ${empty fruits}</p>
	<p>fruits 배열이 비어있지 않은지 : ${not empty fruits}</p>
	
</body>
</html>