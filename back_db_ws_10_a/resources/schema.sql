
DROP DATABASE IF EXISTS ssafydb; # 이미 생성된 DB가 있다면 삭제
CREATE DATABASE ssafydb;         # DB ssafydb 생성
USE ssafydb;                     # ssafydb 사용

-- 싸피 학생 테이블
CREATE TABLE ssafy_student (
    id INT PRIMARY KEY AUTO_INCREMENT, # 번호
    name VARCHAR(100) NOT NULL,               # 이름
    phone VARCHAR(100) NOT NULL,              # 전화번호
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP, # 생성일
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP # 수정일
);

-- 싸피 학생 데이터
INSERT INTO ssafy_student (name, phone) VALUES ('홍길동', '010-1234-5678');
INSERT INTO ssafy_student (name, phone) VALUES ('김철수', '010-1234-5679');
INSERT INTO ssafy_student (name, phone) VALUES ('이영희', '010-1234-5680');



-- SQL 파일 실행
-- mysql -u ssafy -p ssafy < SSAFY_DB.sql   # ssafy 계정으로 SSAFY_DB.sql 파일 실행

-- 데이터베이스 접속
-- mysql -u ssafy -p                        # ssafy 계정으로 접속

-- 데이터베이스 조회
-- use ssafydb;                 # 데이터베이스 선택
-- show tables;                 # 테이블 조회
-- desc ssafy_student;          # 테이블 구조 조회

-- 싸피 학생 조회
-- SELECT * FROM ssafy_student; # 학생 테이블 전체 조회