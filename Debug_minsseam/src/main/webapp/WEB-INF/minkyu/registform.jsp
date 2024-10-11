<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>민규 등록</title>
</head>
<body>
    <h2>민규 등록</h2>
    <form action="minsseam" method="POST">
    	<input type="hidden" name="action" value="regist">
        이름: <input type="text" name="name"><br>
        이메일: <input type="email" name="email"><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>