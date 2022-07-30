
-- id 가지고 dto Member 를 가져오는 것
-- 하나의 아이디로 처리하는 것
-- ★ Member.xml(회원가입, id중복체크, id로 memberDto로 가져오기, 로그인, 정보수정)

-- idConfirm
SELECT COUNT(*) FROM MEMBER WHERE MID='aaa';

-- joinMember
INSERT INTO MEMBER (mID, mPW, mNAME, mEMAIL, mPOST, mADDR) 
    VALUES('bbb', '1', '박길동', 'bbb@naver.com', '04012', '서울시 마포구');
    
SELECT * FROM MEMBER;

-- getDetailMember
SELECT * FROM MEMBER WHERE MID = 'aaa';

-- modifyMember
UPDATE MEMBER SET MPW = '1',
                  MNAME = '김길동',
                  MEMAIL = 'kkk@naver.com',
                  MPOST = '01234',
                  MADDR = '인천시 서구'
            WHERE MID = 'aaa';

-- ★ Book.xml (페이징 없이 신규 순서대로 bookList, 페이징 포함된 도서List(책 이름 순), 
-- 등록된 책 개수, 책번호로 도서 등록, 도서 수정)

-- mainList (신규 도서 순으로 LIST 가져오기)
SELECT * FROM BOOK ORDER BY BRDATE DESC;

-- bookList - 페이징 / 책 이름 오름차순
SELECT * FROM BOOK ORDER BY BTITLE;
SELECT * FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
        WHERE RN BETWEEN 1 AND 3;

-- totCntBook
SELECT COUNT(*) FROM BOOK;

-- getDetailBook
SELECT * FROM BOOK WHERE BNUM = 1;

-- registerBook
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO) 
        VALUES (BOOK_SQ.NEXTVAL, 'MY 스타벅스', '홍매머드', SYSDATE, 'noImg.png', 'noImg.png', '커피의 모든 것');

-- modifyBook
UPDATE BOOK SET BTITLE = '책입니다',
                BWRITER = '왕경영교수',
                BRDATE = '2022-01-29',
                BIMG1 = 'noImg.png',
                BIMG2 = 'noImg.png',
                BINFO = '조수 중에 최고봉조수 조수봉이올시다'
            WHERE BNUM = 1;

SELECT * FROM BOOK;

COMMIT;

-- 검색기능 추가 / 가나다 순으로 정렬, 페이징 처리
-- search  / 책이름+저자
SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'MY'||'%' AND BWRITER LIKE '%'||'홍'||'%' ORDER BY BTITLE; -- 서브쿼리
SELECT * FROM (SELECT ROWNUM RN, A.* 
                FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'MY'||'%' AND BWRITER LIKE '%'||'홍'||'%' ORDER BY BTITLE) A) 
        WHERE RN BETWEEN 1 AND 2;

-- search / 책이름 
SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'MY'||'%' ORDER BY BTITLE; -- 서브쿼리
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK WHERE BTITLE LIKE '%'||'MY'||'%' ORDER BY BTITLE) A) WHERE RN BETWEEN 2 AND 3;

-- search / 저자
SELECT * FROM BOOK WHERE BWRITER LIKE '%'||'홍'||'%' ORDER BY BTITLE; -- 서브쿼리
SELECT * FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM BOOK WHERE BWRITER LIKE '%'||'홍'||'%' ORDER BY BTITLE)A) WHERE RN BETWEEN 1 AND 2;

-- search / 아무것도 선택하지 않았을때 / 그냥 리스트랑 동일
SELECT * FROM BOOK ORDER BY BTITLE; -- 서브쿼리
SELECT * FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT * FROM BOOK ORDER BY BTITLE) A)
        WHERE RN BETWEEN 1 AND 3



