<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화등록결과</title>
<style>
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<h2>등록된 영화 정보</h2>
	<table>
		<thead> <!-- 표의 열 제목 --> 
			<tr>
				<th>항목</th>
				<th>내용</th>			
			</tr>
		</thead>
		<tbody> <!-- 표의 내용 -->
			<tr>
				<td>제목</td>
				<td><%=request.getParameter("title")%></td>
			</tr>
			<tr>
				<td>감독</td>
				<td><%=request.getParameter("director")%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=request.getParameter("title")%></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><%=request.getParameter("title")%></td>
			</tr>
		</tbody>
	</table>
</body>
</html>
