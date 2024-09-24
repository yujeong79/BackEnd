<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	\${5+2} : ${5+2} <br>
	\${5/2} : ${5/2} <br> <!-- 실수 연산을 해준다. -->
<%-- 	\${5 div 2} : ${5 div 2} <br> 빨간색 어쩔 수 없어 ㅠ --%> 
	\${5 gt 2} : ${5 gt 2} <br>
	\${5 < 2} : ${5 < 2} <br>
	
	<!-- 나머지 연산은 직접 작성해 볼것 삼항이든 블라블라 -->


</body>
</html>