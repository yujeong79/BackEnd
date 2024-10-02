DROP DATABASE IF EXISTS ssafydb; # 이미 생성된 DB가 있다면 삭제
CREATE DATABASE ssafydb;         # DB ssafydb 생성

USE ssafydb;                     # ssafydb 사용

-- SSAFY 학생 테이블 생성
CREATE TABLE ssafy_student (
    `id` int PRIMARY KEY,         -- 학번
    `name` varchar(30) NOT NULL,  -- 이름
    `phone` varchar(15),          -- 전화번호
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP,        -- 생성일시
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 수정일시
)ENGINE=InnoDB;

INSERT INTO ssafy_student (id, name, phone) VALUES (1, 'Kim', '010-1234-5678');
INSERT INTO ssafy_student (id, name, phone) VALUES (2, 'Park', '010-9876-5432');
INSERT INTO ssafy_student (id, name, phone) VALUES (3, 'Lee', '010-1111-2222');