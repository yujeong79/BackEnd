
DROP DATABASE IF EXISTS ssafydb; # 이미 생성된 DB가 있다면 삭제
CREATE DATABASE ssafydb;         # DB ssafydb 생성

USE ssafydb;                     # ssafydb 사용

-- SSAFY 학생 테이블 생성
CREATE TABLE ssafy_student (
	`id` VARCHAR(7) PRIMARY KEY,    	#학번
	`name` varchar(10) NOT NULL,    	#이름
    `gender` varchar(2) NOT NULL,   	#성별
    `campus` int DEFAULT 0,				#캠퍼스 (지역/반)
    `curriculum` int DEFAULT 0,			#1학기 트랙
    `birth_date` varchar(20) NOT NULL,  #생년월일
    `major` varchar(20) NOT NULL,		#전공
    `in_ssafy` int DEFAULT 1			#재학유무 0: 미분류, 1: 1학기, 2: 2학기, 3: 졸업, 4: 취업퇴소, 5: 중도퇴소
)ENGINE=InnoDB;

-- SSAFY 커리큘럼 테이블 생성
CREATE TABLE ssafy_curriculum (				
	`id` int PRIMARY KEY AUTO_INCREMENT,#커리큘럼식별자
	`name` varchar(30) NOT NULL			#커리큘럼이름
)ENGINE=InnoDB;

-- SSAFY 캠퍼스 테이블 생성
CREATE TABLE ssafy_campus (				
	`id` int PRIMARY KEY AUTO_INCREMENT,#캠퍼스식별자
	`loc` varchar(30) NOT NULL,			#캠퍼스 위치
    `class` int DEFAULT 0				#분반
)ENGINE=InnoDB;


INSERT INTO `ssafy_student` (`id`, `name`, `gender`, `campus`, `curriculum`, `birth_date`, `major`, `in_ssafy`) VALUES
('2024001', '홍길동', '남', 1, 1, '1990-01-01', 'IT융합학과', 1),
('2024002', '이순신', '남', 2, 2, '1991-02-02', '경영학과', 2),
('2024003', '유관순', '여', 1, 1, '1992-03-03', '컴퓨터공학과', 3),
('2024004', '김유신', '남', 2, 2, '1993-04-04', '모바일', 4),
('2024005', '신사임당', '여', 1, 1, '1994-05-05', '임베디드', 5),
('2024006', '강감찬', '남', 2, 2, '1995-06-06', '전공자바', 1),
('2024007', '이성계', '남', 1, 1, '1996-07-07', '비전자바', 2),
('2024008', '김구', '남', 2, 2, '1997-08-08', '파이썬', 3),
('2024009', '안중근', '남', 1, 1, '1998-09-09', '모바일', 4),
('2024010', '윤봉길', '남', 2, 2, '1999-10-10', '임베디드', 5);

INSERT INTO `ssafy_curriculum` (`id`, `name`) VALUES
(1, '전공자바'),
(2, '비전자바'),
(3, '파이썬'),
(4, '모바일'),
(5, '임베디드');

INSERT INTO `ssafy_campus` (`id`, `loc`, `class`) VALUES
(1, '서울', 1),
(2, '대전', 1),
(3, '광주', 1),
(4, '구미', 1),
(5, '부울경', 1);


/*
-- 1. SSAFY 학생 테이블과 커리큘럼 테이블을 합쳐, 각 학생이 어떤 커리큘럼을 수강하는지 조회합니다.
SELECT ssafy_student.name, ssafy_curriculum.name
FROM ssafy_student
JOIN ssafy_curriculum ON ssafy_student.curriculum = ssafy_curriculum.id;

-- 2. SSAFY 학생 테이블과 캠퍼스 테이블을 합쳐, 각 학생이 어느 캠퍼스에 소속되어 있는지 조회합니다.
SELECT ssafy_student.name, ssafy_campus.loc
FROM ssafy_student
JOIN ssafy_campus ON ssafy_student.campus = ssafy_campus.id;

-- 5. SSAFY 학생 테이블, 커리큘럼 테이블, 캠퍼스 테이블을 모두 합쳐, 각 학생의 이름, 커리큘럼, 캠퍼스 소속을 한번에 조회합니다.
SELECT ssafy_student.name, ssafy_curriculum.name, ssafy_campus.loc
FROM ssafy_student
JOIN ssafy_curriculum ON ssafy_student.curriculum = ssafy_curriculum.id
JOIN ssafy_campus ON ssafy_student.campus = ssafy_campus.id;
*/

