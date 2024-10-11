<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>민규 수정</title>
</head>
<body>
    <h2>민규 수정</h2>
    <form action="minsseam" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="${minkyu.userid }">
        이름: <input type="text" name="name" value="${minkyu.name }" required><br>
        이메일: <input type="text" name="email" value="${minkyu.email }" required><br>
        <input type="submit" value="수정">
    </form>
</body>
</html>