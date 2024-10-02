<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
<style>
#car-list {
	border-collapse: collapse;
	width: 100%;
}

#car-list td, #car-list th {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h1>자동차 목록</h1>
	<c:if test="${!empty carCount }">
		<h2>지금까지 등록한 자동차 수 : ${carCount}</h2>
	</c:if>
	<table id="car-list">
		<thead>
			<tr>
				<th>번호</th>
				<th>자동차등록번호</th>
				<th>모델명</th>
				<th>색상</th>
				<th>주행 거리</th>
			</tr>
		</thead>
		<tbody>
			<%-- request 영역에 cars로 등록된 자료를 반복문을 이용해 출력한다. --%>
			<c:forEach items="${cars }" var="car" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${car.vin }</td>
					<td>${car.modelName }</td>
					<td>${car.color }</td>
					<td>${car.mileage } km</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="regist.jsp">추가등록</a>
</body>
</html>