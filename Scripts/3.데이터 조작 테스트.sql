
INSERT INTO student VALUES(1001, '서승아', 80, 90, 70);
INSERT INTO student VALUES(1002, '신민휘', 75, 80, 85);
INSERT INTO student VALUES(1003, '최영지', 75, 75, 95);

SELECT stdno, stdname, kor, eng, math FROM student;
SELECT stdno, stdname, kor, eng, math FROM student WHERE stdno=1001;

UPDATE student SET stdname='', kor=90, eng=90, math=63 WHERE stdno=1002;

DELETE FROM student WHERE stdno=1003;
