
-- 테이블 DROP & CREATE
DROP TABLE BOARD;
DROP TABLE BOARD CASCADE CONSTRAINTS; -- 강제 삭제

CREATE TABLE BOARD(
    NUM     NUMBER(5,0) PRIMARY KEY, -- 글번호
    WRITER  VARCHAR2(50) NOT NULL,   -- 글쓴이 REQUIRED=REQUIRED
    SUBJECT VARCHAR2(100) NOT NULL,  -- 글제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 본문
    EMAIL VARCHAR2(30),              -- 글 작성자 이메일
    READCOUNT NUMBER(5, 0) DEFAULT 0,  -- 글 HIT 수(= 히트 수) / 아무것도 입력하지 않아도
    PW VARCHAR2(20) NOT NULL,       -- 비밀번호 글 삭제 시 비밀번호 입력하도록
    REF NUMBER(5,0) DEFAULT 0,      -- 글그룹(원글일 경우. 글번호로/답변글일 경우 원글의 글번호로)
    RE_INDENT NUMBER(5) NOT NULL,   -- 그룹 내 출력순서(원글은 무조건 )
    RE_STEP NUMBER(5) DEFAULT 0,    -- 글 LIST 출력시 제목 들여쓰기 정도(원글없이)
    IP       VARCHAR2(20) NOT NULL, -- 글 작성 시 , 컴퓨터 IP주소
    RDATE    DATE DEFAULT SYSDATE );-- 글쓴 시점 (날짜+시간)    
    -- 글1
    --  글 1-2
    --     글1-2-1
    --  글 1-1

-- 8개의 함수
-- 1. 글 갯수
-- TITLE에 특수문자가 가려질 수 있도록 해주어야 한다.
SELECT COUNT(*) FROM BOARD;

-- 2. 글 목록 (최신글이 위로)
-- 원글만 있을 경우
SELECT * FROM BOARD ORDER BY NUM DESC;

-- 3. 글 쓰기 (원글 쓰기)
-- MYSQL 에서도 사용할 수 있도록 시퀀스 사용 X
-- DEFAULT 값을 준 것, SYSDATE를 준 RDATE를 제외하고 넣어준다. (기본값이 설정되어 있기 때문)
    -- 3-1. 글번호 받아오는 것
    -- 글번호에 NULL 들어오면 안된다 (PRIMARY KEY) - NULL이면 0을 넣는 NVL!
    -- 서브쿼리는 괄호로 묶자!
    SELECT NVL(MAX(NUM),0) + 1 FROM BOARD;
--(1)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), '홍길동', '글제목1', '본문입니다.\n금요일이다!', NULL, 
                '1', (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, '192.168.10.30' );

--(2)
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), '홍길동', '글제목2', '금요일이네요.\n수업 빨리 끝나라!', NULL, 
                '1', (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, '192.168.10.30' );
-- (3)
SELECT NVL(MAX(NUM),0) + 1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), '홍길동', '글제목3', '본문입니다.\n신나는 금요일', NULL, 
                '1', (SELECT NVL(MAX(NUM),0) + 1 FROM BOARD), 0, 0, '192.168.10.30' );

-- 4. 글 번호(REF로 정렬)로 글(Dto) 가져오기 
-- 상세보기 페이지
SELECT * FROM BOARD WHERE NUM = 1; 

-- 5. 조회수 올리기
-- 기존의 조회수에 + 1
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = 1;

-- 6. 글 수정
-- REF 수정 불가. IP는 내가 수정한 곳의 IP로 저장될 수 있도록
UPDATE BOARD SET SUBJECT = '수정된 제목',
                 CONTENT = '수정된 본문입니다.\n와우!',
                 EMAIL   = 'hong@hong.com',
                 PW      = '1',
                 IP      = '127.0.0.1'
        WHERE NUM = 1;

-- 7. 글 삭제 (비밀번호 필수)
COMMIT;
DELETE FROM BOARD WHERE NUM = 1 AND PW='1';
ROLLBACK;

-- 조회수 조작 (3번글이 제일 핫한글)
UPDATE BOARD SET READCOUNT = 70 WHERE NUM = 13;


-- 8. 페이징을 위한 TOP-N 구문 (* startRow ~ endRow까지 출력할 top-N)
-- 111등 ~120등 출력
    -- 1단계. 등수 출력을 위한 order by 정렬, 댓글은 오름차순 정렬
    SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP;
    -- 2단계. FROM 절에 서브쿼리를 넣는 인라인 뷰
    -- WHERE 절은 사용 불가
    SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A;
    -- 최종 3단계. TOP-N 구문
    SELECT * 
     FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP) A)
    WHERE RN BETWEEN 11 AND 20;










