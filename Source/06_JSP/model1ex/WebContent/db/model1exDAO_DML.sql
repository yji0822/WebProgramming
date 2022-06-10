
-- 실제로 DAO에 가져다 쓸 쿼리문

-- ★★ 고객(CUSTOMER) 테이블 DAO ★★
-- 1. 회원가입 시 cid 중복 체크
SELECT * FROM CUSTOMER WHERE CID = 'aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
    VALUES('ggg', '111', '홍마동', '010-1234-1234', 'g@naver.com', '서울', 'f', '1995-12-12');
-- 3. 로그인(cid/CPW)
SELECT * FROM CUSTOMER WHERE CID = 'ggg' AND CPW ='111';
-- 4. CID로 DTO 가져오기
SELECT * FROM CUSTOMER WHERE CID = 'ggg';
-- 5. 회원정보 수정
UPDATE CUSTOMER SET CPW = '111',
                    CNAME = '홍홍홍',
                    CTEL = '010-1111-1111',
                    CEMAIL = 'GG@G.COM',
                    CADDRESS = '부산',
                    CGENDER = 'M',
                    CBIRTH = '1999-10-19'
            WHERE CID = 'ggg';
            
-- 6. 회원 리스트 보기 (첫화면 main.jsp에서 사용할 부분 - top-N구문
SELECT * 
    FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS 
            FROM (SELECT * FROM CUSTOMER ORDER BY CID))
    WHERE RN BETWEEN 4 AND 6;

-- 7. 등록된 회원 수 
SELECT COUNT(*) TOTCNT FROM CUSTOMER;


-- ★★ 도서(BOOK) 테이블 DAO ★★
-- 1. 책등록
INSERT INTO BOOK (BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT)
        VALUES(BOOK_SEQ.NEXTVAL, '가나다라', '30000', 'noImg.png', 'NOTHING.JPG', '책설명입니다.', 20);
-- 2. 책목록 (전체 LIST) / 신간 도서 순으로 출력
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- 3. 책목록(top-N 구문)
-- : 페이징 처리를 위해
SELECT * 
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- 4. 등록된 책의 개수 
-- : 페이지의 개수를 알기 위해서 (페이징 처리)
SELECT COUNT(*) CNT FROM BOOK;
-- 5. 책 상세 보기(PRIMARY KEY(bID)로 DTO 가져오기
SELECT * FROM BOOK WHERE BID = 1;



-- ★★ 파일첨부게시판(FILEBOARD) 테이블 DAO ★★
-- 1. 글 목록 (starRow ~ endRow)

-- EQUI JOIN CUSTOMER, FILEBOARD
SELECT F.*, CNAME, CEMAIL 
    FROM FILEBOARD F, CUSTOMER C
    WHERE F.CID = C.CID
    ORDER BY FREF DESC, FRE_STEP;

-- EQUI JOIN을 서브쿼리에 넣은 인라인 뷰!
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT F.*, CNAME, CEMAIL 
                    FROM FILEBOARD F, CUSTOMER C
                    WHERE F.CID = C.CID
                    ORDER BY FREF DESC, FRE_STEP) A)
    WHERE RN BETWEEN 2 AND 3;
    
    
-- 페이징 처리
-- 2. 등록된 글 수 
-- (페이징 처리를 하기 위해서 글의 개수를 알아야 하기 때문)
SELECT COUNT(*) FROM FILEBOARD;

-- 3. 원글 쓰기
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '본문1', NULL, '111', FILEBOARD_SEQ.CURRVAL ,0, 0, '126.12.12.1');
    -- CID는 로그인 한 세션에서 가지고 와서 불러오는 것으로 사용자로부터 입력받는 것이 아니다.
    -- CID를 출력하는 것이 아닌 CNAME, CEMAIL 을 출력해야 하므로 CUSTOMER 테이블과 EQUI JOIN을 해주어야 한다.
    
-- 원글 : 방금 쓴 원글 - 5번 글
SELECT * FROM FILEBOARD ORDER BY FREF DESC;
SELECT * FROM FILEBOARD WHERE FNUM=5;

-- 4. 답변글 쓰기 전 step A : 5번글에 대한 답변글 쓰기 전처리 작업 
-- REF는 같은데 RE_STEP보다 1큰 애가 보인다면 밑으로 내려라
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP + 1 WHERE FREF = 5 AND FRE_STEP > 0; 

-- 5. 답변글 쓰기 : 5번 글의 답변
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1-1', '답변입니다.', NULL, '111', 5 ,1, 1, '192.12.12.1');

SELECT * FROM FILEBOARD WHERE FREF = 5
    ORDER BY FRE_STEP;

-- 6. 글 상세보기 (fnum으로 dto 가져오기)
-- 내가 쓴 글만 수정할 수 있도록 진행
SELECT * FROM FILEBOARD WHERE FNUM = 5;

-- 7. 조회수 올리기 
COMMIT;
UPDATE FILEBOARD SET FHIT = FHIT+1 WHERE FNUM=5;

-- 8. 글 수정하기
UPDATE FILEBOARD SET FSUBJECT = '수정된 제목 입니다..',
                     FCONTENT = '수정된 본문',
                     FFILENAME = NULL,
                     FPW = '111',
                     FIP = '192.168.10.30'
                WHERE FNUM = 1;

-- 9. 글 삭제하기
DELETE FROM FILEBOARD WHERE FNUM = 1 AND FPW = '111';

COMMIT;






