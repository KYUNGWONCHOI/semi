--MEMBER
SELECT * FROM MEMBER;
DESC MEMBER;
--ID        NOT NULL VARCHAR2(20)  PK
--PWD       NOT NULL VARCHAR2(20)  
--PHOTO_NAME      NOT NULL VARCHAR2(100) 
--PHOTO_SAVE_PATH NOT NULL VARCHAR2(200) 
--MEM_ADMIN NOT NULL NUMBER   DEFAULT 1 / 관리자0, 일반1
--POINT     NOT NULL NUMBER  DEFAULT 0
--EMAIL     NOT NULL VARCHAR2(30)
INSERT INTO MEMBER VALUES ('choi', '123', 1, DEFAULT, 'A@A.COM');
INSERT INTO MEMBER VALUES ('kyung', '123', 0, DEFAULT, 'A@A.COM');

commit;

--NOTICE
SELECT * FROM NOTICE;
desc notice;
--NOTICE_NO        NOT NULL NUMBER         PK
--NOTICE_SUBJECT   NOT NULL VARCHAR2(100)  
--NOTICE_CONTENT            VARCHAR2(2000) 
--BOARD_DATE       NOT NULL TIMESTAMP(6)   DEFAULT SYSTIMESTAMP
--BOARD_READ_NO    NOT NULL NUMBER         DEFAULT 0
--NOTICE_TYPE      NOT NULL NUMBER         DEFAULT 2 / 1 고정 2 기본
INSERT INTO NOTICE VALUES (SEQ_NOTICE_NO.NEXTVAL, 'SUBJECT', NULL, SYSTIMESTAMP, DEFAULT, 2);
INSERT INTO NOTICE VALUES (SEQ_NOTICE_NO.NEXTVAL, 'SUBJECT', NULL, SYSTIMESTAMP, DEFAULT, 2);
INSERT INTO NOTICE VALUES (SEQ_NOTICE_NO.NEXTVAL, 'SUBJECT', NULL, SYSTIMESTAMP, DEFAULT, 2);
INSERT INTO NOTICE VALUES (SEQ_NOTICE_NO.NEXTVAL, 'SUBJECT', NULL, SYSTIMESTAMP, DEFAULT, 2);
COMMIT;

--LESSON
select * from lesson;
desc lesson;
--LESSON_CODE  NOT NULL NUMBER  //PK
--LESSON_TYPE  NOT NULL CHAR(1)      //강습종류 1일클래스/레벨업 - 0/1
--LESSON_LEVEL NOT NULL NUMBER       //수업난이도 1~5
--LESSON_START NOT NULL DATE    //default sysdate
--LESSON_END   NOT NULL DATE         //강습신청 개월, ADD_MONTHS
--TEACHER_NAME   NOT NULL VARCHAR2(40)       //강사이름 김,이,박,최, 신, 조, 주
--LESSON_TIME  NOT NULL NUMBER       //0-10:00, 1-12:00, 2-15:00, 3-18:00, 4-19:00, 5-20:00
--LESSON_DAY   NOT NULL VARCHAR2(20) //월,수,금 / 화,목 / 토,일
--LESSON_DURATION          NUMBER   
--LESSON_CAPACITY          VARCHAR2(10) ?/5
INSERT INTO LESSON VALUES (1, 1, 1, DEFAULT, ADD_MONTHS(SYSDATE, 1), '김', 0, '월,수,금', 1, '0/5');
INSERT INTO LESSON VALUES (2, 1, 2, DEFAULT, ADD_MONTHS(SYSDATE, 3), '김', 2, '월,수,금', 3, '0/5');
INSERT INTO LESSON VALUES (3, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '김', 3, '월,수,금', 1, '0/5');
INSERT INTO LESSON VALUES (4, 1, 5, DEFAULT, ADD_MONTHS(SYSDATE, 1), '김', 5, '월,수,금', 1, '0/5');
INSERT INTO LESSON VALUES (5, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '이', 1, '월,수,금', 1, '0/5');
INSERT INTO LESSON VALUES (6, 1, 4, DEFAULT, ADD_MONTHS(SYSDATE, 1), '이', 2, '월,수,금', 1, '0/5');
INSERT INTO LESSON VALUES (7, 1, 2, DEFAULT, ADD_MONTHS(SYSDATE, 3), '이', 3, '월,수,금', 3, '0/5');
INSERT INTO LESSON VALUES (8, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 3), '이', 4, '월,수,금', 3, '0/5');
INSERT INTO LESSON VALUES (9, 1, 1, DEFAULT, ADD_MONTHS(SYSDATE, 1), '박', 0, '화,목', 1, '0/5');
INSERT INTO LESSON VALUES (10, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '박', 2, '화,목', 1, '0/5');
INSERT INTO LESSON VALUES (11, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 3), '박', 5, '화,목', 3, '0/5');
INSERT INTO LESSON VALUES (12, 1, 5, DEFAULT, ADD_MONTHS(SYSDATE, 3), '박', 4, '화,목', 3, '0/5');
INSERT INTO LESSON VALUES (13, 1, 2, DEFAULT, ADD_MONTHS(SYSDATE, 1), '최', 1, '화,목', 1, '0/5');
INSERT INTO LESSON VALUES (14, 1, 4, DEFAULT, ADD_MONTHS(SYSDATE, 1), '최', 3, '화,목', 1, '0/5');
INSERT INTO LESSON VALUES (15, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '최', 4, '화,목', 1, '0/5');
INSERT INTO LESSON VALUES (16, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '주', 0, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (17, 1, 1, DEFAULT, ADD_MONTHS(SYSDATE, 1), '주', 1, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (18, 1, 4, DEFAULT, ADD_MONTHS(SYSDATE, 1), '신', 1, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (19, 1, 2, DEFAULT, ADD_MONTHS(SYSDATE, 1), '신', 2, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (20, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '신', 3, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (21, 1, 5, DEFAULT, ADD_MONTHS(SYSDATE, 1), '신', 4, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (22, 1, 4, DEFAULT, ADD_MONTHS(SYSDATE, 1), '조', 3, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (23, 1, 3, DEFAULT, ADD_MONTHS(SYSDATE, 1), '조', 4, '토,일', 1, '0/5');
INSERT INTO LESSON VALUES (100, 0, 1, NULL, NULL, NULL, 0, '매일', NULL, '0/5');
INSERT INTO LESSON VALUES (101, 0, 1, NULL, NULL, NULL, 1, '매일', NULL, '0/5');
INSERT INTO LESSON VALUES (102, 0, 1, NULL, NULL, NULL, 2, '매일', NULL, '0/5');
INSERT INTO LESSON VALUES (103, 0, 1, NULL, NULL, NULL, 3, '매일', NULL, '0/5');
INSERT INTO LESSON VALUES (104, 0, 1, NULL, NULL, NULL, 4, '매일', NULL, '0/5');
COMMIT;

--BOARD_PROBLEM
DESC BOARD_PROBLEM;
--BOARD_PROB_NO      NOT NULL NUMBER        PK
--PROB_SECTOR                 NUMBER        
--PROB_LEVEL                  NUMBER        
--VIDEO_ORIGIN_NAME           VARCHAR2(200) 
--VIDEO_SAVE_PATH             VARCHAR2(200) 
--PROB_CONTENT                VARCHAR2(200) 
--BOARD_PROB_DATE    NOT NULL TIMESTAMP        DEFAULT SYSTIMESTAMP  
--BOARD_PROB_READ_NO NOT NULL NUMBER        
--PROB_SUBJECT NOT NULL VARCHAR2(100)
--MEMBER_ID                 NOT NULL VARCHAR2(20) 
INSERT INTO BOARD_PROBLEM VALUES (SEQ_BOARD_PROBLEM.NEXTVAL, NULL, NULL, NULL, NULL, NULL, SYSDATE, DEFAULT,'SUBJECT', 'kyung');
SELECT * FROM BOARD_PROBLEM;
COMMIT;

--BOARD_ANY
CREATE SEQUENCE SEQ_BOARD_ANY;
SELECT * FROM USER_TABLES;
DESC BOARD_ANY;
--BOARD_ANY_NO      NOT NULL NUMBER         PK
--BOARD_ANY_SUBJECT NOT NULL VARCHAR2(100)  
--ANY_CONTENT                VARCHAR2(1000) 
--BOARD_ANY_DATE    NOT NULL DATE           DEFAULT SYSTIMESTAMP
--BOARD_ANY_READ_NO          NUMBER         
--MEMBER_ID         NOT NULL VARCHAR2(20)  
INSERT INTO BOARD_ANY VALUES(SEQ_BOARD_ANY.NEXTVAL, 'SUBJECT', 'CONTENT', SYSDATE, DEFAULT, 'kyung');
DROP TABLE BOARD_ANY CASCADE CONSTRAINTS;
ALTER TABLE BOARD_ANY RENAME COLUMN ID TO MEMBER_ID;
SELECT * FROM BOARD_ANY;
commit;

--BOARD_ASK
DESC BOARD_ASK;
CREATE SEQUENCE SEQ_BOARD_ASK;
--BOARD_ASK_NO      NOT NULL NUMBER         PK
--ASK_SUBJECT       NOT NULL VARCHAR2(100)  
--ASK_CONTENT       NOT NULL VARCHAR2(1000) 
--BOARD_ASK_DATE    NOT NULL DATE           DEFAULT SYSTIMESTAMP
--ASK_ANSWER                 VARCHAR2(100)  
--BOARD_ASK_READ_NO NOT NULL NUMBER         
--ASK_PWN_YN        NOT NULL CHAR(1)        DEFAULT 0 / 1 - 비밀글, 0 - 공개글
--ASK_PWD                    VARCHAR2(20)   /비밀글 설정 시 비밀번호 지정 4
--MEMBER_ID         NOT NULL VARCHAR2(20)  
INSERT INTO BOARD_ASK VALUES (SEQ_BOARD_ANY.NEXTVAL, 'SUBJECT', 'CONTENT', SYSDATE, 'ANSWER', DEFAULT, DEFAULT, NULL, 'kyung');
SELECT * FROM BOARD_ASK;
commit;


--LOST
select * from user_tables;
desc lost;
CREATE SEQUENCE SEQ_LOST;
--BOARD_NO     NOT NULL NUMBER         PK
--LOST_TYPE    NOT NULL VARCHAR2(20)   
--LOST_PLACE            VARCHAR2(20)   
--LOST_TIME             TIMESTAMP(6)   
--BOARD_DATE   NOT NULL DATE           DEFAULT SYSDATE
--LOST_SUBJECT NOT NULL VARCHAR2(100)  
--LOST_CONTENT NOT NULL VARCHAR2(1000) 
--FILE_ORIGIN_NAME          VARCHAR2(100)  
--FILE_SAVE_PATH            VARCHAR2(100)  
INSERT INTO LOST VALUES (SEQ_LOST.NEXTVAL, 'TYPE', 'SECTOR', SYSDATE, SYSDATE, 'SUBJECT', 'CONTENT', 'FILE_NAME', 'FILE_PATH');
INSERT INTO LOST VALUES (SEQ_LOST.NEXTVAL, 'TYPE', 'SECTOR', SYSDATE, SYSDATE, 'SUBJECT', 'CONTENT', 'FILE_NAME', 'FILE_PATH');
INSERT INTO LOST VALUES (SEQ_LOST.NEXTVAL, 'TYPE', 'SECTOR', SYSDATE, SYSDATE, 'SUBJECT', 'CONTENT', 'FILE_NAME', 'FILE_PATH');
COMMIT;

--PRICE
DESC PRICE;
--PRICE_TYPE NOT NULL NUMBER  PK / 0 - 1일권, 1 - 5회권, 2 - 10회권, 3 - 1개월, 4 - 3개월     
--PRICE      NOT NULL NUMBER        / 20,000, 90,000, 170,000, 130,000, 330,000
--PRICE_DESC          VARCHAR2(100)  / 5회권 이용기간 3개월, 10 회권 이용기간 6개월, 1개월 및 3개월 권 15일 정지 가능
--SERVICE_ON NOT NULL CHAR(1) DEFAULT 1 / 0 - 서비스 종료, 1 - 서비스 중
INSERT INTO PRICE VALUES (0, 20000, '일일 자유이용권', 1);
INSERT INTO PRICE VALUES (1, 90000, '5회권', 1);
INSERT INTO PRICE VALUES (2, 170000, '10회권', 1);
INSERT INTO PRICE VALUES (3, 130000, '1개월 이용권', 1);
INSERT INTO PRICE VALUES (4, 330000, '3개월 이용권', 1);
SELECT * FROM PRICE;
COMMIT;




--DML