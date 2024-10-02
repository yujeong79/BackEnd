<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단일 학생 조회</title>
</head>
<body>
<!--  
    private int id; // 학번
    private String name; // 이름
    private String phone; // 전화번호
    private Date created_at; // 생성일시
    private Date updated_at; // 수정일시
 -->
		<hr>
		<h2>단일 학생 정보 상세 조회하기</h2>
        <hr>
        <p>학생번호 : ${student.id}</p>
        <p>학생이름 : ${student.name}</p>
        <p>학생전화번호 : ${student.phone}</p>
        <p>생성일시 : ${student.created_at}</p>
        <p>수정일시 : ${student.updated_at}</p>
        <hr>
        <a href="main?action=selectAll">학생목록으로 이동</a>
</body>
</html>