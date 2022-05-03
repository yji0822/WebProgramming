
-- MARKET

-- DELETE TABLE & SEQUENCE
DROP TABLE CUSTOMER; -- 참조하는 테이블이 있을 경우 삭제 불가(EX. DEPT)
DROP TABLE CUSTOMER CASCADE CONSTRAINTS; -- 완전 비추 (강제삭제)
DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUSTOMER_SEQ;

-- CREATE CUS_LEVEL
CREATE TABLE CUS_LEVEL(
    LEVELNO     NUMBER(1,0) PRIMARY KEY,
    LEVELNAME   VARCHAR2(30) NOT NULL,
    LOW         NUMBER(9, 0),
    HIGH        NUMBER(9, 0)
);

-- CREATE SEQUENCE
DROP SEQUENCE CUSTOMER_SEQ;
CREATE SEQUENCE CUSTOMER_SEQ;

-- CREATE CUSTOMER
CREATE TABLE CUSTOMER(
    cID     NUMBER(6, 0) PRIMARY KEY,
    cTEL    VARCHAR2(30),
    cNAME   VARCHAR2(40),
    cPOINT  NUMBER(10,0) DEFAULT 1000,
    cAMOUNT NUMBER(10,0) DEFAULT 0,
    LEVELNO NUMBER(1,0) DEFAULT 1 REFERENCES CUS_LEVEL(LEVELNO)
);

-- INSERT DUMMY DATA
INSERT INTO CUS_LEVEL VALUES (1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES (2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES (3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES (4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES (5, 'VVIP', 4000000, 999999999); 
-- 마지막 등급은 내가 설정한 MAX CAMOUNT값을 입력해준다 / 모두 실행 F9키
-- 레벨이 높은 고객이 오면 혜택을 주는 것 - CUS_LEVEL 에 할인율 필드 추가

SELECT * FROM CUS_LEVEL;

-- INSERT CID CTEL, CNAME CPOINT CAMOUNT LEVELNO
-- 고객아이디 전화번호 이름 포인트 누적구매금액 레벨 
INSERT INTO CUSTOMER (CID, CTEL, CNAME) 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999', '홍길동');
INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-8888-9999', '홍길동', 0, 4000000, 5); -- 최고레벨
INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777', '신길동', 0, 100000, 1); 

SELECT * FROM CUSTOMER;

COMMIT;


-- 프로그램에 필요한 쿼리
-- 0. 레벨이름들 검색 : 콤보박스(VECTOR<STRING>) getLevelNames()
SELECT * FROM CUS_LEVEL;

-- 1. 아이디검색 : public CustomerDto cIdGetCustomer(int cId)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
-- 5단계면 forlevelup이 null이 나오도록
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNO, (MAX-CAMOUNT + 1)
SELECT CID FROM CUSTOMER WHERE CID = 99; -- 아무것도 출력되지 않은 친구
-- 5레벨이면 출력하지 않도록
-- 서브쿼리 이용 **
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CID = 3;

-- 2. 폰4자리 검색 : public ArrayList<CustomerDto> CTelGetCustomer(String cTel)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
-- 폰 뒤4자리로도 검색가능하고 FULL로 입력해도 검색가능
-- ID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNO, (MAX-CAMOUNT + 1)
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CTEL LIKE '%'||'9999'; 
    -- JAVA에서는 %도 물음표로 포함해야 하기 때문에 연결연산자를 이용해서 9999만 입력해서 찾을 수 있도록

-- 3. 고객이름 검색 : ArrayList<CustomerDto> cNameGetCustomer(String cName) 
-- (매개변수로 고객이름을 받아와야 하므로() 안에 넣어주기) 
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1)
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CNAME = '홍길동'
    ORDER BY CAMOUNT DESC; 

-- 4. 포인트로만 구매 (1번 id가 100원 구매) : int buyWithPoint(int cId, int cAmount)
    -- (포인트 잔여 확인한 후 차감) CID CPOINT AMOUNT
-- cid로 조회 후에 AMOUNT를 먼저 입력받은 후에 AMOUNT가 CPOINT보다 작으면 구매 진행
-- 포인트로만 구매 성공
UPDATE CUSTOMER SET CPOINT = CPOINT - 100 WHERE CID = 1;
SELECT * FROM CUSTOMER;
COMMIT;

-- 5. 물품 구매 : int buy(cId, int cAmount)
    -- 물품구매 update에는 cpoint, camount // levelNo가 수정
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, POINT where c
-- (SQL 하나로 해결할 수 있도록 , 포인트, 구매금액, 레벨조정)
-- 1000원을 사면 레벨업 X 

-- 5-1. CPOINT, CAMOUNT 변경
UPDATE CUSTOMER SET CPOINT = CPOINT + (1000000 * 0.05),
                    CAMOUNT = CAMOUNT + 1000000
                WHERE CID = 1;
SELECT * FROM CUSTOMER;
-- 5-2. LEVELNO 변경하기 전, 현레벨번호와 수정될 레벨번호 NONEQUI조인
SELECT CID, CNAME, CAMOUNT, C.LEVELNO 현레벨, L.LEVELNO 수정될레벨
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE CAMOUNT BETWEEN LOW AND HIGH;

SELECT L.LEVELNO
    FROM CUSTOMER C, CUS_LEVEL L 
    WHERE CAMOUNT BETWEEN LOW AND HIGH
    AND CID = 1;
-- 5-3. LEVELNO
UPDATE CUSTOMER SET LEVELNO = (SELECT L.LEVELNO
                                FROM CUSTOMER C, CUS_LEVEL L 
                                WHERE CAMOUNT BETWEEN LOW AND HIGH
                                AND CID = 1)    
    WHERE CID = 1;
SELECT * FROM CUSTOMER;

-- 최종 : 5-1 + 5-3 합치기
-- 단일행 쿼리로 만들어 준 후에 넣어주어야 하기 때문에 서브쿼리 안에도 CID 조건을 넣어주어야 한다.
-- 물음표가 5개가 들어가야 한다.
UPDATE CUSTOMER SET CPOINT = CPOINT + (1000000 * 0.05),
                    CAMOUNT = CAMOUNT + 1000000,
                    LEVELNO = (SELECT L.LEVELNO
                                FROM CUSTOMER C, CUS_LEVEL L 
                                WHERE (CAMOUNT + 1000000) BETWEEN LOW AND HIGH
                                AND CID =4)    
    WHERE CID = 4; -- DAO에 들어갈 QUERY

SELECT * FROM CUSTOMER;

-- 6. 등급별 출력 : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1) forLevelUp    
-- select 등급이 선택되어야 함.
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND LEVELNAME = 'NORMAL'
    ORDER BY CAMOUNT DESC;

-- 7. 전체고객 출력 (총몇명인지) : ArrayList<CustomerDto> getCustomers() - 무조건 전체 출력이므로
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1) forLevelUp
-- select
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO
    ORDER BY CAMOUNT DESC;

-- 8. 회원가입: int insertCustomer(CustomerDto dto)
           -- int insertCustomer(String cTel, String cName) -- 사용
-- insert 성공은 1 실패는 0
INSERT INTO CUSTOMER (CID, CTEL, CNAME) 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '유길동');

SELECT * FROM CUSTOMER;
-- 9. 번호수정: int updateCustomer(int cId, String cTel)
-- update
UPDATE CUSTOMER SET CTEL = '010-5555-5555' WHERE CID = 5;
-- 10. 회원탈퇴 : int deleteCustomer(String cTel)
-- delete
-- 필드를 하나 더 추가해서 DELETE된 회원의 이름을 저장하는 테이블 생성하기도...
DELETE FROM CUSTOMER WHERE CTEL = '010-5555-5555';
SELECT * FROM CUSTOMER;
COMMIT;