<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<style>
header {
	background-color: #f2f2f2;
	text-align: center;
	font-size: 20px;
}
</style>


<header>
    <%--
    	Q. 홈으로 가는 경로를 EL 표현식으로 작성해 봅시다.
    	   pageContext.request.contextPath는 프로젝트의 시작점을 나타냅니다.
    --%>
	<a href="${pageContext.request.contextPath}/">홈</a>
	
	
	<%--
		Q. header.jsp에 로그인한 사용자의 이름을 표시하고, 로그인한 사용자에게만 보이도록 코드를 작성해 봅시다.
	--%>
	
	<c:if test="${sessionScope.loginUser != null}">
		  | <a href="${pageContext.request.contextPath}/logout">로그아웃</a> | 
		안녕하세요 ${sessionScope.loginUser} 님!
	</c:if>
</header>