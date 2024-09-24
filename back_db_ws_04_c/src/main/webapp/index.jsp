<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
	<title>로그인 예제</title>
</head>
<body>
	
	<!--
		Q. header.jsp 파일을 포함시켜 봅시다.
	-->
	<%@ include file="header.jsp"%>
	
	
	<h1>로그인 예제</h1>
	
	<c:choose>
		<%-- 
			Q. 로그인 정보가 없는 경우 로그인 폼을 출력해 봅시다.
		--%>
		<c:when test="${session.loginUser != null}">
		
			<form action="login" method="post">
				
				<%--
					Q. 사용자 아이디는  userId로, 비밀번호는 password로 전송해 봅시다.
				--%>
				아이디: <input type="text" name="userId"><br/>
				비밀번호: <input type="password" name="password"><br/>
				<input type="submit" value="로그인">
				
				
				<%--
					Q. 로그인에 실패한 경우 errorMessage의 값이 존재한다면 출력해 봅시다.
				--%>
				<c:catch var="errorMessage">
					<b>${errorMessage}</b>
				</c:catch>
			</form>
		</c:when>
		
		<c:otherwise>
			
			<%--
				Q. 로그인 사용자가 있는 경우 로그인 사용자 이름 출력
			--%>
			<p>환영합니다, ${sessionScope.loginUser}님!</p>
			<a href="logout">로그아웃</a>
			
		</c:otherwise>
	</c:choose>
</body>
</html>