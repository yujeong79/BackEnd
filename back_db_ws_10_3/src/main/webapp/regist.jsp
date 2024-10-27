<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
    <%@ include file="/include/header.jsp" %> <!-- header.jsp 파일 포함 -->
    
    <form action="main" method="POST">
        <fieldset>
            <legend>SSAFY 도서 등록</legend>
            <input type="hidden" name="action" value="regist">
            <p> ISBN <input type="text" name="isbn" id="isbn"> </p>
            <p> 제목 <input type="text" name="title" id="title"> </p>
            <p> 작가 <input type="text" name="author" id="author"> </p>
            <p> 가격 <input type="text" name="price" id="price"> </p>
            <p> 설명 <input type="text" name="desc" id="desc"> </p>
            <p> 이미지 <input type="text" name="img" id="img"> </p>
            <input type="submit" value="등록">
            <input type="reset" value="취소">
        </fieldset>
    </form>
</body>
</html>
