select user(),database();
-- 내 스키마
DROP SCHEMA IF EXISTS student_mgn;

-- 내 스키마
CREATE SCHEMA student_mgn;

-- 학생
CREATE TABLE student_mgn.student (
	stdno   INTEGER     NOT NULL COMMENT '학생번호', -- 학생번호
	stdname VARCHAR(50) NOT NULL COMMENT '학생이름', -- 학생이름
	kor     INTEGER     NULL     COMMENT '국어', -- 국어
	eng     INTEGER     NULL     COMMENT '영어', -- 영어
	math    INTEGER     NULL     COMMENT '수학' -- 수학
)
COMMENT '학생';

-- 학생
ALTER TABLE student_mgn.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			stdno -- 학생번호
		);

-- 사용자 계정
drop user 'user_student_mgn'@'localhost';

GRANT all privileges 
		on student_mgn.*
	    to 'user_student_mgn'@'localhost' IDENTIFIED BY 'rootroot';	
	
/*CREATE USER 'user_student_mgn'@'localhost';
ALTER USER 'user_student_mgn'@'localhost' IDENTIFIED BY 'rootroot';
GRANT Alter ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Create ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Create view ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Delete ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Drop ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Grant option ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Index ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Insert ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT References ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Select ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Show view ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Trigger ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Update ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Alter routine ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Create routine ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Create temporary tables ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Execute ON student_mgn.* TO 'user_student_mgn'@'localhost';
GRANT Lock tables ON student_mgn.* TO 'user_student_mgn'@'localhost';*/
