DROP TABLE "LOST";
DROP TABLE "NOTICE" CASCADE CONSTRAINTS;
DROP TABLE "OPENTIME";
DROP TABLE "REPLY";
DROP TABLE "MEMBERSHIP";
DROP TABLE "MEM_LESSON";
DROP TABLE "LESSON";
DROP TABLE "RENT";
DROP TABLE "BOARD_PROBLEM";
DROP TABLE "BOARD_ANY" CASCADE CONSTRAINTS;
DROP TABLE "ASK" CASCADE CONSTRAINTS;
DROP TABLE "PAY_HISTORY";
DROP TABLE "PRICE";
DROP TABLE "MEMBER" ;

CREATE TABLE "MEMBER" (
	"ID"	VARCHAR2(20)		NOT NULL,
	"PWD"	VARCHAR2(20)		NOT NULL,
	"PHOTO"	VARCHAR2(200)		NOT NULL,
	"MEM_ADMIN"	NUMBER	DEFAULT 1	NOT NULL,
	"POINT"	NUMBER	DEFAULT 0	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "MEMBER"."PWD" IS '대소문자, 숫자,특수문자';

COMMENT ON COLUMN "MEMBER"."PHOTO" IS '사진, 본인 확인용, PATH';

COMMENT ON COLUMN "MEMBER"."MEM_ADMIN" IS '관리자0, 일반1';

COMMENT ON COLUMN "MEMBER"."POINT" IS '보유 포인트';


CREATE TABLE "LESSON" (
	"LESSON_CODE"	NUMBER		NOT NULL,
	"LESSON_TYPE"	CHAR(1)		NOT NULL,
	"LESSON_LEVEL"	NUMBER		NOT NULL,
	"LESSON_START"	DATE	DEFAULT SYSDATE	NOT NULL,
	"LESSON_END"	DATE		NOT NULL,
	"TEACHER_NO"	NUMBER		NOT NULL,
	"LESSON_TIME"	NUMBER		NOT NULL,
	"LESSON_DAY"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "LESSON"."LESSON_CODE" IS '강습코드';

COMMENT ON COLUMN "LESSON"."LESSON_TYPE" IS '강습종류 1일클래스/레벨업 - 0/1';

COMMENT ON COLUMN "LESSON"."LESSON_LEVEL" IS '수업난이도 1~5';

COMMENT ON COLUMN "LESSON"."LESSON_START" IS '시작날 - 강습기간에 따라 끝나는 날 도출';

COMMENT ON COLUMN "LESSON"."LESSON_END" IS '강습신청 개월, ADD_MONTHS';

COMMENT ON COLUMN "LESSON"."TEACHER_NAME" IS '강사이름';

COMMENT ON COLUMN "LESSON"."LESSON_TIME" IS '시간';

COMMENT ON COLUMN "LESSON"."LESSON_DAY" IS '요일';


CREATE TABLE "OPENTIME" (
	"OPEN_TIME"	VARCHAR2(20)		NULL,
	"CLOSE_DATE"	DATE		NULL,
	"CLOSE_REASON"	VARCHAR2(40)		NULL
);

COMMENT ON COLUMN "OPENTIME"."OPEN_TIME" IS '매일 07~24';

COMMENT ON COLUMN "OPENTIME"."CLOSE_DATE" IS '공휴일 및 이벤트';

COMMENT ON COLUMN "OPENTIME"."CLOSE_REASON" IS '특별한 경우로 문 닫는 경우 알림';


CREATE TABLE "BOARD_PROBLEM" (
	"BOARD_PROB_NO"	NUMBER		NOT NULL,
	"PROB_SECTOR"	NUMBER		NULL,
	"PROB_LEVEL"	NUMBER		NULL,
	"PROB_VIDEO"	VARCHAR2(200)		NULL,
	"PROB_CONTENT"	VARCHAR2(200)		NULL,
	"BOARD_PROB_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_PROB_READ_NO"	NUMBER	DEFAULT 0	NOT NULL,
	"ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_SECTOR" IS '문제 있는 위치';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_LEVEL" IS '문제 난이도';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_VIDEO" IS '문제 풀이 영상, PATH';

COMMENT ON COLUMN "BOARD_PROBLEM"."PROB_CONTENT" IS '문제 풀이 방법';

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_DATE" IS '게시 날짜';

COMMENT ON COLUMN "BOARD_PROBLEM"."BOARD_PROB_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "BOARD_PROBLEM"."ID" IS '아이디';


CREATE TABLE "BOARD_ANY" (
	"BOARD_ANY_NO"	NUMBER		NOT NULL,
	"ANY_CONTENT"	VARCHAR2(1000)		NULL,
	"BOARD_ANY_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_ANY_READ_NO"	NUMBER	DEFAULT 0	NULL,
	"ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_NO" IS '게시물 번호';

COMMENT ON COLUMN "BOARD_ANY"."ANY_CONTENT" IS '내용';

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_DATE" IS '게시 날짜';

COMMENT ON COLUMN "BOARD_ANY"."BOARD_ANY_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "BOARD_ANY"."ID" IS '아이디';

CREATE TABLE "ASK" (
	"BOARD_ASK_NO"	NUMBER		NOT NULL,
	"ASK_CONTENT"	VARCHAR2(1000)		NOT NULL,
	"BOARD_ASK_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ASK_ANSWER"	VARCHAR2(100)		NULL,
	"BOARD_ASK_READ_NO"	NUMBER	DEFAULT 0	NOT NULL,
	"ASK_PWN_YN"	CHAR(1)	DEFAULT 0	NOT NULL,
	"ASK_PWD"	VARCHAR2(20)		NULL,
	"ID"	VARCHAR2(20)		NOT NULL
);

COMMENT ON COLUMN "ASK"."BOARD_ASK_NO" IS '게시물 번호';

COMMENT ON COLUMN "ASK"."ASK_CONTENT" IS '문의 내용';

COMMENT ON COLUMN "ASK"."BOARD_ASK_DATE" IS '게시 날짜';

COMMENT ON COLUMN "ASK"."ASK_ANSWER" IS '답변';

COMMENT ON COLUMN "ASK"."BOARD_ASK_READ_NO" IS '1씩 증가';

COMMENT ON COLUMN "ASK"."ASK_PWN_YN" IS '비밀글 YN';

COMMENT ON COLUMN "ASK"."ASK_PWD" IS '비밀번호';

COMMENT ON COLUMN "ASK"."ID" IS '아이디';



CREATE TABLE "NOTICE" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"NOTICE_TYPE"	VARCHAR2(20)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(1000)		NULL,
	"BOARD_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_READ_NO"	NUMBER	DEFAULT 0	NOT NULL
);

COMMENT ON COLUMN "NOTICE"."BOARD_NO" IS '게시물 번호';

COMMENT ON COLUMN "NOTICE"."NOTICE_TYPE" IS '1고정/2기본';

COMMENT ON COLUMN "NOTICE"."NOTICE_CONTENT" IS '공지내용';

COMMENT ON COLUMN "NOTICE"."BOARD_DATE" IS '게시 날짜';

COMMENT ON COLUMN "NOTICE"."BOARD_READ_NO" IS '조회수 DEFUALT 0';

CREATE TABLE "LOST" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"LOST_TYPE"	VARCHAR2(20)		NOT NULL,
	"LOST_PLACE"	VARCHAR2(20)		NULL,
	"LOST_TIME"	TIMESTAMP		NULL,
	"BOARD_DATE"	DATE	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "LOST"."BOARD_NO" IS '게시물 번호';

COMMENT ON COLUMN "LOST"."LOST_TYPE" IS '습득물건';

COMMENT ON COLUMN "LOST"."LOST_PLACE" IS '습득위치';

COMMENT ON COLUMN "LOST"."LOST_TIME" IS '습득시간';

COMMENT ON COLUMN "LOST"."BOARD_DATE" IS '게시 날짜';

CREATE TABLE "RENT" (
	"RENT_ITEM"	NUMBER		NOT NULL,
	"SHOE_SIZE"	NUMBER		NULL,
	"SHOE_COUNT"	NUMBER		NULL,
	"CHALK_COUNT"	NUMBER		NULL,
	"PAY_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "RENT"."RENT_ITEM" IS '1신발/2초크백';

COMMENT ON COLUMN "RENT"."SHOE_SIZE" IS '신발 사이즈';

COMMENT ON COLUMN "RENT"."SHOE_COUNT" IS '신발 보유현황';

COMMENT ON COLUMN "RENT"."CHALK_COUNT" IS '초크백 보유현황';

COMMENT ON COLUMN "RENT"."PAY_DATE" IS '구매일';

CREATE TABLE "MEMBERSHIP" (
	"MEM_HISTORY"	TIMESTAMP		NULL,
	"MEM_LOCKER_NO"	NUMBER		NULL,
	"MEM_LOCKER"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"PAY_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "MEMBERSHIP"."MEM_HISTORY" IS '사용기록';

COMMENT ON COLUMN "MEMBERSHIP"."MEM_LOCKER_NO" IS '라커번호';

COMMENT ON COLUMN "MEMBERSHIP"."MEM_LOCKER" IS '라커사용유무 Y/N';

COMMENT ON COLUMN "MEMBERSHIP"."PAY_DATE" IS '구매일';


CREATE TABLE "PRICE" (
	"PRICE_TYPE"	NUMBER		NOT NULL,
	"PRICE"	NUMBER		NOT NULL,
	"PRICE_DESC"	VARCHAR2(100)		NULL,
	"SERVICE_ON"	CHAR(1)	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "PRICE"."PRICE_TYPE" IS '요금종류 횟수(5,10),개월(1,3), 대여,1~6까지 대입)';

COMMENT ON COLUMN "PRICE"."PRICE" IS '금액';

COMMENT ON COLUMN "PRICE"."PRICE_DESC" IS '설명';

COMMENT ON COLUMN "PRICE"."SERVICE_ON" IS '0, 1';

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


CREATE TABLE "MEM_LESSON" (
	"ID"	VARCHAR2(20)		NOT NULL,
	"LESSON_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "MEM_LESSON"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "MEM_LESSON"."LESSON_CODE" IS '강습코드';

CREATE TABLE "REPLY" (
	"BOARD_REPLY_ID"	NUMBER		NOT NULL,
	"BOARD_REPLY_LEVEL"	NUMBER(2)	DEFAULT 1	NOT NULL,
	"BOARD_REPLY_REF"	NUMBER		NOT NULL,
	"BOARD_REPLY_STEP"	NUMBER(3)	DEFAULT 1	NOT NULL,
	"ID"	VARCHAR2(20)		NOT NULL,
	"BOARD_ANY_NO"	NUMBER		NOT NULL,
	"BOARD_ASK_NO"	NUMBER		NOT NULL,
	"BOARD_PROB_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_ID" IS '댓글아이디';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_LEVEL" IS '댓글계층';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_REF" IS '참조댓글';

COMMENT ON COLUMN "REPLY"."BOARD_REPLY_STEP" IS '댓글순서';

COMMENT ON COLUMN "REPLY"."ID" IS '대소문자, 숫자';

COMMENT ON COLUMN "REPLY"."BOARD_ANY_NO" IS '게시물 번호';

COMMENT ON COLUMN "REPLY"."BOARD_ASK_NO" IS '게시물 번호';

COMMENT ON COLUMN "REPLY"."BOARD_PROB_NO" IS '게시물 번호';

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

ALTER TABLE "ASK" ADD CONSTRAINT "PK_ASK" PRIMARY KEY (
	"BOARD_ASK_NO"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
	"BOARD_NO"
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

ALTER TABLE "BOARD_PROBLEM" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_PROBLEM_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "BOARD_ANY" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_ANY_1" FOREIGN KEY (
	"ID"
)
REFERENCES "MEMBER" (
	"ID"
);

ALTER TABLE "ASK" ADD CONSTRAINT "FK_MEMBER_TO_ASK_1" FOREIGN KEY (
	"ID"
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

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_ASK_TO_REPLY_1" FOREIGN KEY (
	"BOARD_ASK_NO"
)
REFERENCES "ASK" (
	"BOARD_ASK_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_BOARD_PROBLEM_TO_REPLY_1" FOREIGN KEY (
	"BOARD_PROB_NO"
)
REFERENCES "BOARD_PROBLEM" (
	"BOARD_PROB_NO"
);



