<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>민규 상세 정보</title>
</head>
<body>
    <h2>민규 상세 정보</h2>
    <table border="1">
        <tr>
            <th>USER ID</th>
            <td>${minkyu.userid }</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${minkyu.name }</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${minkyu.email }</td>
        </tr>
    </table>
    
    <a href="minsseam?action=updateform">수정</a>
    <a href="minsseam?action=delete">삭제</a>
    <a href="minsseam?action=list">목록</a>
</body>
</html>