
-- [IV] ???θ? ????
--- ?䱸???? ????

-- MEMBER TABLE 
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mID VARCHAR2(10) PRIMARY KEY,
    mNAME VARCHAR2(30) NOT NULL,
    mADDR VARCHAR2(100) NOT NULL,
    mTEL VARCHAR2(20) NOT NULL,
    mEMAIL VARCHAR2(30)
);

-- PRODUCT TABLE
DROP TABLE PRODUCT;
CREATE TABLE PRODUCT(
    pCODE VARCHAR2(10) PRIMARY KEY,
    pNAME VARCHAR2(50) UNIQUE NOT NULL,
    pPRICE NUMBER(20) NOT NULL,
    pSTOCK NUMBER(4) NOT NULL
);

-- CART
-- SEQUENCE
DROP SEQUENCE CART_SEQ;
CREATE SEQUENCE CART_SEQ
        NOCACHE
        NOCYCLE;
        
DROP TABLE CART;
CREATE TABLE CART (
    cNUM NUMBER(3) PRIMARY KEY,
    mID  REFERENCES MEMBER(mID) NOT NULL,
    pCODE1 VARCHAR2(10) NOT NULL,
    QTY1 NUMBER(3),
    COST1 NUMBER(10)
);

-- ORDERS 
DROP SEQUENCE ORDERS_SEQ;
CREATE SEQUENCE ORDERS_SEQ
        NOCACHE
        NOCYCLE;
DROP TABLE ORDERS;
CREATE TABLE ORDERS(
    oNO VARCHAR2(15) PRIMARY KEY,
    mID REFERENCES MEMBER(mID) NOT NULL,
    oADDR VARCHAR2(100) NOT NULL,
    oTEL VARCHAR2(20) NOT NULL,
    oDATE DATE DEFAULT SYSDATE
);

-- ORDERS_DATAIL
DROP SEQUENCE OD_SEQ;
CREATE SEQUENCE OD_SEQ
        NOCACHE
        NOCYCLE;
DROP TABLE ORDERS_DETAIL;
CREATE TABLE ORDERS_DETAIL(
    odNO NUMBER(9) PRIMARY KEY,
    oNO REFERENCES ORDERS(oNO) NOT NULL,
    pCODE REFERENCES PRODUCT(pCODE) NOT NULL,
    QTY NUMBER(3) NOT NULL,
    COST NUMBER(10)
);


--- INSERT
-- MEMBER
SELECT * FROM MEMBER;
INSERT INTO MEMBER VALUES ('abc', 'ȫ?浿', '???? ??????', '010-1111-1111', NULL);
INSERT INTO MEMBER VALUES ('def', '??????', '???? ???빮??','010-2222-2222', 'jeon@naver.com');

-- PRODUCT 
SELECT * FROM PRODUCT;
INSERT INTO PRODUCT VALUES ('A1', '????', 3000, 100);
INSERT INTO PRODUCT VALUES ('B1', '????', 3500, 100);
INSERT INTO PRODUCT VALUES ('A2', '????', 2000, 100);
INSERT INTO PRODUCT VALUES ('B2', '??¡??', 5000, 100);
INSERT INTO PRODUCT VALUES('C1', '??????', 7000, 100);

-- ORDERS
SELECT * FROM ORDERS;
INSERT INTO ORDERS 
    VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '0000')), 
            'abc', '???? ??????', '010-1111-1111', SYSDATE);
INSERT INTO ORDERS 
    VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '0000')), 
            'def', '???? ???빮??', '010-2222-2222', SYSDATE);
INSERT INTO ORDERS 
     VALUES (TO_CHAR(SYSDATE, 'YYYYMMDD') || TRIM(TO_CHAR(ORDERS_SEQ.NEXTVAL, '0000')), 
            'abc', '???⵵ ??õ', '010-3333-3333', SYSDATE);
           
            
-- ORDERS_DETAIL / oNO, pCODE, QTY, COST
SELECT * FROM ORDERS_DETAIL;
-- ?ֹ?1
INSERT INTO ORDERS_DETAIL 
    VALUES(OD_SEQ.NEXTVAL, 202204190001, 'A1', 3, 3*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'A1'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-3 WHERE pCODE = 'A1'; -- ???? ????

INSERT INTO ORDERS_DETAIL 
    VALUES(OD_SEQ.NEXTVAL, 202204190001, 'B1', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'B1'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE = 'B1';

INSERT INTO ORDERS_DETAIL 
    VALUES(OD_SEQ.NEXTVAL, 202204190001, 'A2', 2, 2*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'A2'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-2 WHERE pCODE = 'A2';

INSERT INTO ORDERS_DETAIL 
    VALUES(OD_SEQ.NEXTVAL, 202204190001, 'B2', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'B2'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE = 'B2';

SELECT * FROM PRODUCT; -- ???? Ȯ??

-- ?ֹ?2
INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190002, 'A2', 2, 2*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'A2'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-2 WHERE pCODE = 'A2';

INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190002, 'B2', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'B2'));
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE = 'B2';

INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190002, 'C1', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'C1'));    
UPDATE PRODUCT SET pSTOCK = pSTOCK-1 WHERE pCODE = 'C1';

SELECT * FROM PRODUCT;

-- ?ֹ?3    
INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190003, 'A1', 2, 2*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'A1'));
INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190003, 'B1', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'B1'));
INSERT INTO ORDERS_DETAIL
    VALUES (OD_SEQ.NEXTVAL, 202204190003, 'C1', 1, 1*(SELECT pPRICE FROM PRODUCT WHERE pCODE = 'C1'));



