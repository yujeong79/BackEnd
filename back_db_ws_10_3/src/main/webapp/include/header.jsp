<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
</head>
    <h1>SSAFY 도서 관리</h1>
    <form action="main" method="POST">
        <input type="text" name="id" placeholder="아이디를 입력하세요.">
        <input type="password" name="password" placeholder="비밀번호를 입력하세요.">
        <input type="submit" value="로그인">
    </form>
    <a href="registUser.jsp">회원가입</a> <br>
    <a href="index.jsp">홈</a> <br>
</html>