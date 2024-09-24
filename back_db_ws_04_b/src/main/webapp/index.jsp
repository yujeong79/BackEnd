<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<%
    request.setAttribute("name", "홍길동");
    request.setAttribute("age", 20);
    request.setAttribute("address", "서울");
    request.setAttribute("fruits", new String[]{"사과", "바나나", "딸기"});
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 태그 연습</title>
</head>
<body>
	<h1>JSTL 태그 연습</h1>

	<%-- 
		JSTL(JavaServer Pages Standard Tag Library) : JSP에서 자주 사용하는 기능을 태그 형태로 제공하는 표준 태그 라이브러리.
		
		JSTL 주요 태그
		1. `<c:out>` : 값을 출력합니다. 변수나 표현식의 결과를 HTML 출력 스트림에 쓸 때 사용됩니다.
		2. `<c:set>` : 변수의 값을 설정합니다. 실질적으로 지정된 범위(페이지, 요청, 세션, 애플리케이션)의 속성을 설정합니다.
		3. `<c:if>` : 조건이 참이면 본문을 처리합니다. Java의 if 문과 비슷합니다.
		4. `<c:choose>`, `<c:when>`, `<c:otherwise>` : 여러 조건 중 하나를 선택하여 처리합니다. Java의 switch 문과 비슷합니다.
		5. `<c:forEach>` : 컬렉션의 각 항목에 대해 반복 처리를 수행합니다. 배열이나 컬렉션의 각 항목에 대해 지정된 액션을 수행합니다.
	
	--%>

	<p>
		
		
		<%--
			Q. JSTL 태그를 사용하여 message 변수에 "안녕하세요"를 저장해 봅시다.
			   <c:set> 태그를 사용하여 범위를 지정치 않고 저장한 변수는 pageContext에 속성으로 저장됩니다
		--%>
		<c:set var="message" value="안녕하세요" />
		
		
		
		<%--
			Q. JSTL 태그를 사용하여 message 변수에 저장된 값을 출력해 봅시다.   
		--%>
		메시지 : <c:out value="${message}" />
		<br>
		
		
		
		<%--
			Q. JSTL 태그를 사용하여 age 변수에 저장된 값을 2배한 값으로 저장하고 출력해 봅시다.
		--%>
		<c:set var="age" value="${age*2}" />
		나이 : <c:out value="${age}" />
		<br>
		
		
		
		<%--
			Q. JSTL 태그를 사용하여서 member에 빈 Member 객체를 생성하고 hello() 메소드를 호출해 봅시다.
			   Member 객체는 Scriptlet 방식으로 생성합니다.
		--%>
		<c:set var="member" value="<%= new com.ssafy.ws.step2.Member() %>" />
		소개 : <c:out value="${member.hello()}" />
		<br>
		
		
		
		<%--
			Q. JSTL 태그를 사용하여 address가 "서울"이라면 "주거 지역 : 서울"을 출력하고 아니면 "주거 지역 : 기타"를 출력해 봅시다.
		--%>
		<c:if test="${address == '서울'}">
			주거 지역 : 서울
		</c:if>
		
		<c:if test="${address != '서울'}">
			주거 지역 : 기타
		</c:if>
		<br>
		
		
		
		<%--
			Q. JSTL 태그의 조건문을 사용하여 age 변수에 저장된 값이 5살 미만이면 "유아", 20이상이면 "성인", 그 외라면 "미성년자"를 출력해 봅시다.
			   <c:choose>, <c:when>, <c:otherwise>를 사용하여 출력해 봅시다.
		--%>
		연령대: 
		<c:choose>
			<c:when test="${age<5}">
				유아
			</c:when>
			<c:when test="${age>=20}">
				성인
			</c:when>
			<c:otherwise>
				미성년자
			</c:otherwise>
		</c:choose>
		<br>



		<%--
			Q. JSTL 태그를 사용하여 fruits 변수에 저장된 배열의 모든 요소를 출력해 봅시다.
			   <c:forEach>를 이용하여 출력해 봅시다.
		--%>
		과일 :
		<c:forEach var="fruit" items="${fruits}">
			<c:out value="${fruit}" />, 
		</c:forEach>
		
		<br>
			
	</p>
</body>
</html>