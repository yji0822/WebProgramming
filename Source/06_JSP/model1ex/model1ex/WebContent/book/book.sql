
-- DROP & CREATE TABLE, SEQ

DROP SEQUENCE BOOK_SEQ;
DROP TABLE BOOK;

CREATE SEQUENCE BOOK_SEQ 
        MAXVALUE 99999 
        NOCACHE 
        NOCYCLE;

CREATE TABLE BOOK (
    bID NUMBER(5) PRIMARY KEY,     -- 책번호
    bTITLE VARCHAR2(100) NOT NULL, -- 책제목
    bPRICE NUMBER(7) NOT NULL,     -- 책가격
    bIMAGE1 VARCHAR2(30) NOT NULL, -- 책 대표 이미지(첨부 안할 경우 : noImg.png)
    bIMAGE2 VARCHAR2(30) NOT NULL, -- 책 부가 이미지 (첨부 안할 경우 : NOTHING.JPG)
    bCONTENT VARCHAR2(4000),       -- 책 설명(1,333글자 이내)
    bDISCOUNT NUMBER(3) NOT NULL,  -- 할인율(0~100% 이내)
    bRDATE DATE DEFAULT SYSDATE    -- 책 등록일
);

SELECT * FROM BOOK;

-- 책등록
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES(BOOK_SEQ.NEXTVAL, '가나다라', '30000', 'noImg.png', 'NOTHING.JPG', '책설명입니다.', 20);

INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES(BOOK_SEQ.NEXTVAL, '1234', '12000', 'NOTHING.JPG', 'noImg.png', '책설명입니다.222', 5);

INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES(BOOK_SEQ.NEXTVAL, '이것이 책입니까', '45000', 'noImg.png', 'NOTHING.JPG', '책설명입니다.', 35);
        
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES(BOOK_SEQ.NEXTVAL, '보드게임 뱅', '90000', 'NOTHING.JPG', 'noImg.png', '공략집입니다.', 50);

-- 책목록 (전체 LIST) / 신간 도서 순으로 출력
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- 책목록(top-N 구문)
-- : 페이징 처리를 위해
SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;

-- 등록된 책의 개수 
-- : 페이지의 개수를 알기 위해서 (페이징 처리)
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세 보기(PRIMARY KEY(bID)로 DTO 가져오기
SELECT * FROM BOOK WHERE BID = 1;

COMMIT;








