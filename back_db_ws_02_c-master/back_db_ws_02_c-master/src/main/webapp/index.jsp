<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward, Redirect</title>
</head>
<body>

<h1>메시지를 전달하여 Redirect 와 Forward의 차이를 비교해보기 </h1>

<form action="echo" method="POST">
  포워드 방식으로 전송합니다. <br>
  <input type="hidden" name="type" value="forward" />
  메시지: <input type="text" name="message" />
  <input type="submit" value="보내기" />
</form>


<form action="echo" method="POST">
  리다이렉트 방식으로 전송합니다. <br>
  <input type="hidden" name="type" value="redirect" />
  메시지: <input type="text" name="message" />
  <input type="submit" value="보내기" />
</form>


</body>
</html>