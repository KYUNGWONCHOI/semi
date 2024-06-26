﻿DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"ID"	VARCHAR2(20)		NOT NULL,
	"PWD"	VARCHAR2(20)		NOT NULL,
	"MEM_ADMIN"	NUMBER	DEFAULT 1	NOT NULL,
	"POINT"	NUMBER	DEFAULT 0	NOT NULL,
	"EMAIL"	VARCHAR2(30)		NOT NULL
);

COMMENT ON COLUMN "MEMBER"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "MEMBER"."PWD" IS '대소문자, 숫자,특수문자';

COMMENT ON COLUMN "MEMBER"."MEM_ADMIN" IS '관리자0, 일반1';

COMMENT ON COLUMN "MEMBER"."POINT" IS '보유 포인트';

COMMENT ON COLUMN "MEMBER"."EMAIL" IS '메일';

DROP TABLE "LESSON";

CREATE TABLE "LESSON" (
	"LESSON_CODE"	NUMBER		NOT NULL,
	"LESSON_TYPE"	CHAR(1)		NOT NULL,
	"LESSON_LEVEL"	NUMBER		NULL,
	"LESSON_START"	DATE	DEFAULT SYSDATE	NULL,
	"LESSON_END"	DATE		NULL,
	"TEACHER_NAME"	VARCHAR2(20)		NULL,
	"LESSON_TIME"	VARCHAR2(20)		NULL,
	"LESSON_DAY"	VARCHAR2(40)		NULL,
	"LESSON_DURATION"	NUMBER		NULL,
	"LESSON_CAPACITY"	NUMBER	DEFAULT 0	NULL
);

COMMENT ON COLUMN "LESSON"."LESSON_CODE" IS '강습코드';

COMMENT ON COLUMN "LESSON"."LESSON_TYPE" IS '강습종류 1일클래스/레벨업 - 0/1';

COMMENT ON COLUMN "LESSON"."LESSON_LEVEL" IS '수업난이도 1~5';

COMMENT ON COLUMN "LESSON"."LESSON_START" IS '시작날 - 강습기간에 따라 끝나는 날 도출';

COMMENT ON COLUMN "LESSON"."LESSON_END" IS '강습신청 개월, ADD_MONTHS';

COMMENT ON COLUMN "LESSON"."TEACHER_NAME" IS '강사이름';

COMMENT ON COLUMN "LESSON"."LESSON_TIME" IS '시간';

COMMENT ON COLUMN "LESSON"."LESSON_DAY" IS '월수금, 화목';

COMMENT ON COLUMN "LESSON"."LESSON_DURATION" IS '강습기간';

COMMENT ON COLUMN "LESSON"."LESSON_CAPACITY" IS '강습인원';

DROP TABLE "OPENTIME";

CREATE TABLE "OPENTIME" (
	"OPEN_TIME"	VARCHAR2(20)		NULL,
	"OPEN_DAY"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "OPENTIME"."OPEN_TIME" IS '매일 07~24';

COMMENT ON COLUMN "OPENTIME"."OPEN_DAY" IS '요일';

DROP TABLE "BOARD_PROBLEM";

CREATE TABLE "BOARD_PROBLEM" (
	"BOARD_PROB_NO"	NUMBER		NOT NULL,
	"BOARD_TYPE"	NUMBER		NOT NULL,
	"PROB_SECTOR"	VARCHAR2(20)		NULL,
	"PROB_LEVEL"	NUMBER		NULL,
	"PROB_CONTENT"	VARCHAR2(400)		NULL,
	"BOARD_PROB_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_PROB_READ_NO"	NUMBER	DEFAULT 0	NOT NULL,
	"PROB_SUBJECT"	VARCHAR2(100)		NOT NULL,
	"MEMBER_ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_TYPE" IS '게시물타입';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_SECTOR" IS '문제 있는 위치';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_LEVEL" IS '문제 난이도';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_CONTENT" IS '문제 풀이 방법';

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_DATE" IS '게시 날짜';

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_SUBJECT" IS '게시물제목';

COMMENT ON COLUMN "BOARD_PROBLEM"."MEMBER_ID" IS '아이디';

DROP TABLE "BOARD_ANY";

CREATE TABLE "BOARD_ANY" (
	"BOARD_ANY_NO"	NUMBER		NOT NULL,
	"BOARD_ANY_SUBJECT"	VARCHAR2(100)		NOT NULL,
	"ANY_CONTENT"	VARCHAR2(1000)		NULL,
	"BOARD_ANY_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_ANY_READ_NO"	NUMBER	DEFAULT 0	NULL,
	"MEMBER_ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_SUBJECT" IS '제목';

COMMENT ON COLUMN "BOARD_ANY"."ANY_CONTENT" IS '내용';

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_DATE" IS '게시 날짜';

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "BOARD_ANY"."MEMBER_ID" IS '아이디';

DROP TABLE "BOARD_ASK";

CREATE TABLE "BOARD_ASK" (
	"BOARD_ASK_NO"	NUMBER		NOT NULL,
	"ASK_SUBJECT"	VARCHAR2(50)		NOT NULL,
	"ASK_CONTENT"	VARCHAR2(1000)		NOT NULL,
	"BOARD_ASK_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ASK_ANSWER"	VARCHAR2(100)		NULL,
	"BOARD_ASK_READ_NO"	NUMBER	DEFAULT 0	NOT NULL,
	"ASK_PWN_YN"	CHAR(1)	DEFAULT 0	NOT NULL,
	"ASK_PWD"	VARCHAR2(20)		NULL,
	"MEMBER_ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "BOARD_ASK"."BOARD_ASK_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_ASK"."ASK_SUBJECT" IS '게시물제목';

COMMENT ON COLUMN "BOARD_ASK"."ASK_CONTENT" IS '문의 내용';

COMMENT ON COLUMN "BOARD_ASK"."BOARD_ASK_DATE" IS '게시 날짜';

COMMENT ON COLUMN "BOARD_ASK"."ASK_ANSWER" IS '답변';

COMMENT ON COLUMN "BOARD_ASK"."BOARD_ASK_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "BOARD_ASK"."ASK_PWN_YN" IS '비밀글 YN 1/0';

COMMENT ON COLUMN "BOARD_ASK"."ASK_PWD" IS '비밀번호';

COMMENT ON COLUMN "BOARD_ASK"."MEMBER_ID" IS '아이디';

DROP TABLE "LOST";

CREATE TABLE "LOST" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"LOST_TYPE"	VARCHAR2(20)		NOT NULL,
	"LOST_PLACE"	VARCHAR2(20)		NULL,
	"LOST_TIME"	TIMESTAMP		NULL,
	"BOARD_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"LOST_SUBJECT"	VARCHAR2(100)		NOT NULL,
	"LOST_CONTENT"	VARCHAR2(1000)		NOT NULL,
	"FILE_ORIGIN_NAME"	VARCHAR2(100)		NULL,
	"FILE_SAVE_PATH"	VARCHAR2(100)		NULL
);

COMMENT ON COLUMN "LOST"."BOARD_NO" IS '게시물 번호';

COMMENT ON COLUMN "LOST"."LOST_TYPE" IS '습득물건';

COMMENT ON COLUMN "LOST"."LOST_PLACE" IS '습득위치';

COMMENT ON COLUMN "LOST"."LOST_TIME" IS '습득시간';

COMMENT ON COLUMN "LOST"."BOARD_DATE" IS '게시 날짜';

COMMENT ON COLUMN "LOST"."LOST_SUBJECT" IS '제목';

COMMENT ON COLUMN "LOST"."LOST_CONTENT" IS '내용';

COMMENT ON COLUMN "LOST"."FILE_ORIGIN_NAME" IS '파일실제이름';

COMMENT ON COLUMN "LOST"."FILE_SAVE_PATH" IS '파일저장이름';

DROP TABLE "RENT";

CREATE TABLE "RENT" (
	"RENT_ITEM"	NUMBER		NOT NULL,
	"SHOE_SIZE"	NUMBER		NULL,
	"SHOE_COUNT"	NUMBER		NULL,
	"CHALK_COUNT"	NUMBER		NULL,
	"PAY_DATE"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "RENT"."RENT_ITEM" IS '1신발/2초크백';

COMMENT ON COLUMN "RENT"."SHOE_SIZE" IS '신발 사이즈';

COMMENT ON COLUMN "RENT"."SHOE_COUNT" IS '신발 보유현황';

COMMENT ON COLUMN "RENT"."CHALK_COUNT" IS '초크백 보유현황';

COMMENT ON COLUMN "RENT"."PAY_DATE" IS '구매일';

DROP TABLE "MEMBERSHIP";

CREATE TABLE "MEMBERSHIP" (
	"MEM_HISTORY"	DATE	DEFAULT SYSDATE	NULL,
	"MEM_LOCKER_NO"	NUMBER		NULL,
	"MEM_LOCKER"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"PAY_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "MEMBERSHIP"."MEM_HISTORY" IS '사용기록';

COMMENT ON COLUMN "MEMBERSHIP"."MEM_LOCKER_NO" IS '라커번호';

COMMENT ON COLUMN "MEMBERSHIP"."MEM_LOCKER" IS '라커사용유무 Y/N';

COMMENT ON COLUMN "MEMBERSHIP"."PAY_DATE" IS '구매일';

DROP TABLE "PRICE";

CREATE TABLE "PRICE" (
	"PRICE_TYPE"	NUMBER		NOT NULL,
	"PRICE"	NUMBER		NOT NULL,
	"PRICE_DESC"	VARCHAR2(200)		NULL,
	"DURATION"	NUMBER		NULL
);

COMMENT ON COLUMN "PRICE"."PRICE_TYPE" IS '1-1개월,2-3개월,3-5회,4-10회,5일일';

COMMENT ON COLUMN "PRICE"."PRICE" IS '금액';

COMMENT ON COLUMN "PRICE"."PRICE_DESC" IS '설명';

DROP TABLE "PAY_HISTORY";

CREATE TABLE "PAY_HISTORY" (
	"PAY_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"USE_HISTORY"	NUMBER	DEFAULT 1	NULL,
	"END_DATE"	DATE	DEFAULT SYSDATE	NULL,
	"ID"	VARCHAR2(20)		NOT NULL,
	"PRICE_TYPE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "PAY_HISTORY"."PAY_DATE" IS '구매일';

COMMENT ON COLUMN "PAY_HISTORY"."USE_HISTORY" IS '대여 -1, 횟수 번호-5,10, 개월(99999999), 횟수차감';

COMMENT ON COLUMN "PAY_HISTORY"."END_DATE" IS '만료일';

COMMENT ON COLUMN "PAY_HISTORY"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "PAY_HISTORY"."PRICE_TYPE" IS '요금종류 횟수(5,10),개월(1,3), 대여,1~6까지 대입)';

DROP TABLE "MEM_LESSON";

CREATE TABLE "MEM_LESSON" (
	"ID"	VARCHAR2(20)		NOT NULL,
	"LESSON_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "MEM_LESSON"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "MEM_LESSON"."LESSON_CODE" IS '강습코드';

DROP TABLE "REPLY";

CREATE TABLE "REPLY" (
	"BOARD_REPLY_ID"	NUMBER		NOT NULL,
	"BOARD_REPLY_LEVEL"	NUMBER(2)	DEFAULT 1	NOT NULL,
	"BOARD_REPLY_REF"	NUMBER		NOT NULL,
	"BOARD_REPLY_STEP"	NUMBER(3)	DEFAULT 1	NOT NULL,
	"ID"	VARCHAR2(20)		NOT NULL,
	"BOARD_ANY_NO"	NUMBER		NULL,
	"BOARD_ASK_NO"	NUMBER		NULL,
	"BOARD_PROB_NO"	NUMBER		NULL
);

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_ID" IS '댓글아이디';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_LEVEL" IS '댓글계층';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_REF" IS '참조댓글';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_STEP" IS '댓글순서';

COMMENT ON COLUMN "REPLY"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "REPLY"."BOARD_ANY_NO" IS '게시물 번호';

COMMENT ON COLUMN "REPLY"."BOARD_ASK_NO" IS '게시물 번호';

COMMENT ON COLUMN "REPLY"."BOARD_PROB_NO" IS '게시물 번호';

DROP TABLE "CLOSE_DAY";

CREATE TABLE "CLOSE_DAY" (
	"CLOSE_DATE"	VARCHAR2(20)		NULL,
	"CLOSE_REASON"	VARCHAR2(20)		NULL
);

COMMENT ON COLUMN "CLOSE_DAY"."CLOSE_DATE" IS '휴무일';

COMMENT ON COLUMN "CLOSE_DAY"."CLOSE_REASON" IS '휴무사유';

DROP TABLE "SEQ_NOTICE_NO";

CREATE TABLE "SEQ_NOTICE_NO" (

);

DROP TABLE "SEQ_LESSON_WEEKDAY";

CREATE TABLE "SEQ_LESSON_WEEKDAY" (

);

DROP TABLE "SEQ_LESSON_WEEKEND";

CREATE TABLE "SEQ_LESSON_WEEKEND" (

);

DROP TABLE "SEQ_LESSON_ONEDAY";

CREATE TABLE "SEQ_LESSON_ONEDAY" (

);

DROP TABLE "SEQ_BOARD_PROBLEM";

CREATE TABLE "SEQ_BOARD_PROBLEM" (

);

DROP TABLE "SEQ_BOARD_ASK";

CREATE TABLE "SEQ_BOARD_ASK" (

);

DROP TABLE "SEQ_BOARD_ANY";

CREATE TABLE "SEQ_BOARD_ANY" (

);

DROP TABLE "NOTICE";

CREATE TABLE "NOTICE" (
	"NOTICE_NO"	NUMBER		NOT NULL,
	"NOTICE_SUBJECT"	VARCHAR2(100)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(2000)		NULL,
	"BOARD_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_READ_NO"	NUMBER	DEFAULT 0	NOT NULL,
	"NOTICE_TYPE"	NUMBER	DEFAULT 2	NOT NULL
);

COMMENT ON COLUMN "NOTICE"."NOTICE_NO" IS '게시물 번호';

COMMENT ON COLUMN "NOTICE"."NOTICE_SUBJECT" IS '공지제목';

COMMENT ON COLUMN "NOTICE"."NOTICE_CONTENT" IS '공지내용';

COMMENT ON COLUMN "NOTICE"."BOARD_DATE" IS '게시 날짜';

COMMENT ON COLUMN "NOTICE"."BOARD_READ_NO" IS '조회수 DEFUALT 0';

COMMENT ON COLUMN "NOTICE"."NOTICE_TYPE" IS '1고정/2기본';

DROP TABLE "SEQ_LOST";

CREATE TABLE "SEQ_LOST" (

);

DROP TABLE "PHOTO";

CREATE TABLE "PHOTO" (
	"ID"	VARCHAR2(20)		NOT NULL,
	"PHOTO_NAME"	VARCHAR2(100)		NULL,
	"PHOTO_SAVE_PATH"	VARCHAR2(200)		NULL
);

COMMENT ON COLUMN "PHOTO"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "PHOTO"."PHOTO_NAME" IS '사진이름';

COMMENT ON COLUMN "PHOTO"."PHOTO_SAVE_PATH" IS '사진PATH';

DROP TABLE "NOTICE_FILE";

CREATE TABLE "NOTICE_FILE" (
	"NOTICE_NO"	NUMBER		NOT NULL,
	"FILE_NAME"	VARCHAR2(100)		NULL,
	"FILE_SAVE_PATH"	VARCHAR2(200)		NULL
);

COMMENT ON COLUMN "NOTICE_FILE"."NOTICE_NO" IS '게시물 번호';

COMMENT ON COLUMN "NOTICE_FILE"."FILE_NAME" IS '파일이름';

COMMENT ON COLUMN "NOTICE_FILE"."FILE_SAVE_PATH" IS '파일PATH';

DROP TABLE "BOARD_PROB_VIDEO";

CREATE TABLE "BOARD_PROB_VIDEO" (
	"BOARD_PROB_NO"	NUMBER		NOT NULL,
	"VIDEO_NAME"	VARCHAR2(100)		NULL,
	"VIDEO_SAVE_PATH"	VARCHAR2(200)		NULL
);

COMMENT ON COLUMN "BOARD_PROB_VIDEO"."BOARD_PROB_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_PROB_VIDEO"."VIDEO_NAME" IS '영상이름';

COMMENT ON COLUMN "BOARD_PROB_VIDEO"."VIDEO_SAVE_PATH" IS '영상PATH';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"ID"
);

ALTER TABLE "LESSON" ADD CONSTRAINT "PK_LESSON" PRIMARY KEY (
	"LESSON_CODE"
);

ALTER TABLE "BOARD_PROBLEM" ADD CONSTRAINT "PK_BOARD_PROBLEM" PRIMARY KEY (
	"BOARD_PROB_NO"
);

ALTER TABLE "BOARD_ANY" ADD CONSTRAINT "PK_BOARD_ANY" PRIMARY KEY (
	"BOARD_ANY_NO"
);

ALTER TABLE "BOARD_ASK" ADD CONSTRAINT "PK_BOARD_ASK" PRIMARY KEY (
	"BOARD_ASK_NO"
);

ALTER TABLE "LOST" ADD CONSTRAINT "PK_LOST" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "PRICE" ADD CONSTRAINT "PK_PRICE" PRIMARY KEY (
	"PRICE_TYPE"
);

ALTER TABLE "PAY_HISTORY" ADD CONSTRAINT "PK_PAY_HISTORY" PRIMARY KEY (
	"PAY_DATE"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY (
	"BOARD_REPLY_ID"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"NOTICE_NO"
);

ALTER TABLE "PHOTO" ADD CONSTRAINT "PK_PHOTO" PRIMARY KEY (
	"ID"
);

ALTER TABLE "NOTICE_FILE" ADD CONSTRAINT "PK_NOTICE_FILE" PRIMARY KEY (
	"NOTICE_NO"
);

ALTER TABLE "BOARD_PROB_VIDEO" ADD CONSTRAINT "PK_BOARD_PROB_VIDEO" PRIMARY KEY (
	"BOARD_PROB_NO"
);

ALTER TABLE "BOARD_PROBLEM" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_PROBLEM_1" FOREIGN KEY (
	"MEMBER_ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "BOARD_ANY" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_ANY_1" FOREIGN KEY (
	"MEMBER_ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "BOARD_ASK" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_ASK_1" FOREIGN KEY (
	"MEMBER_ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "RENT" ADD CONSTRAINT "FK_PAY_HISTORY_TO_RENT_1" FOREIGN KEY (
	"PAY_DATE"
)
REFERENCES "PAY_HISTORY" (
	"PAY_DATE"
);

ALTER TABLE "MEMBERSHIP" ADD CONSTRAINT "FK_PAY_HISTORY_TO_MEMBERSHIP_1" FOREIGN KEY (
	"PAY_DATE"
)
REFERENCES "PAY_HISTORY" (
	"PAY_DATE"
);

ALTER TABLE "PAY_HISTORY" ADD CONSTRAINT "FK_MEMBER_TO_PAY_HISTORY_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "PAY_HISTORY" ADD CONSTRAINT "FK_PRICE_TO_PAY_HISTORY_1" FOREIGN KEY (
	"PRICE_TYPE"
)
REFERENCES "PRICE" (
	"PRICE_TYPE"
);

ALTER TABLE "MEM_LESSON" ADD CONSTRAINT "FK_MEMBER_TO_MEM_LESSON_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "MEM_LESSON" ADD CONSTRAINT "FK_LESSON_TO_MEM_LESSON_1" FOREIGN KEY (
	"LESSON_CODE"
)
REFERENCES "LESSON" (
	"LESSON_CODE"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_MEMBER_TO_REPLY_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_BOARD_ANY_TO_REPLY_1" FOREIGN KEY (
	"BOARD_ANY_NO"
)
REFERENCES "BOARD_ANY" (
	"BOARD_ANY_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_BOARD_ASK_TO_REPLY_1" FOREIGN KEY (
	"BOARD_ASK_NO"
)
REFERENCES "BOARD_ASK" (
	"BOARD_ASK_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_BOARD_PROBLEM_TO_REPLY_1" FOREIGN KEY (
	"BOARD_PROB_NO"
)
REFERENCES "BOARD_PROBLEM" (
	"BOARD_PROB_NO"
);

ALTER TABLE "PHOTO" ADD CONSTRAINT "FK_MEMBER_TO_PHOTO_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "NOTICE_FILE" ADD CONSTRAINT "FK_NOTICE_TO_NOTICE_FILE_1" FOREIGN KEY (
	"NOTICE_NO"
)
REFERENCES "NOTICE" (
	"NOTICE_NO"
);

ALTER TABLE "BOARD_PROB_VIDEO" ADD CONSTRAINT "FK_BOARD_PROBLEM_TO_BOARD_PROB_VIDEO_1" FOREIGN KEY (
	"BOARD_PROB_NO"
)
REFERENCES "BOARD_PROBLEM" (
	"BOARD_PROB_NO"
);

