
-- MARKET

-- DELETE TABLE & SEQUENCE
DROP TABLE CUSTOMER; -- �����ϴ� ���̺��� ���� ��� ���� �Ұ�(EX. DEPT)
DROP TABLE CUSTOMER CASCADE CONSTRAINTS; -- ���� ���� (��������)
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
-- ������ ����� ���� ������ MAX CAMOUNT���� �Է����ش� / ��� ���� F9Ű
-- ������ ���� ���� ���� ������ �ִ� �� - CUS_LEVEL �� ������ �ʵ� �߰�

SELECT * FROM CUS_LEVEL;

-- INSERT CID CTEL, CNAME CPOINT CAMOUNT LEVELNO
-- �����̵� ��ȭ��ȣ �̸� ����Ʈ �������űݾ� ���� 
INSERT INTO CUSTOMER (CID, CTEL, CNAME) 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-9999-9999', 'ȫ�浿');
INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-8888-9999', 'ȫ�浿', 0, 4000000, 5); -- �ְ���
INSERT INTO CUSTOMER 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-7777-7777', '�ű浿', 0, 100000, 1); 

SELECT * FROM CUSTOMER;

COMMIT;


-- ���α׷��� �ʿ��� ����
-- 0. �����̸��� �˻� : �޺��ڽ�(VECTOR<STRING>) getLevelNames()
SELECT * FROM CUS_LEVEL;

-- 1. ���̵�˻� : public CustomerDto cIdGetCustomer(int cId)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
-- 5�ܰ�� forlevelup�� null�� ��������
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNO, (MAX-CAMOUNT + 1)
SELECT CID FROM CUSTOMER WHERE CID = 99; -- �ƹ��͵� ��µ��� ���� ģ��
-- 5�����̸� ������� �ʵ���
-- �������� �̿� **
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CID = 3;

-- 2. ��4�ڸ� �˻� : public ArrayList<CustomerDto> CTelGetCustomer(String cTel)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
-- �� ��4�ڸ��ε� �˻������ϰ� FULL�� �Է��ص� �˻�����
-- ID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNO, (MAX-CAMOUNT + 1)
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CTEL LIKE '%'||'9999'; 
    -- JAVA������ %�� ����ǥ�� �����ؾ� �ϱ� ������ ���Ῥ���ڸ� �̿��ؼ� 9999�� �Է��ؼ� ã�� �� �ֵ���

-- 3. ���̸� �˻� : ArrayList<CustomerDto> cNameGetCustomer(String cName) 
-- (�Ű������� ���̸��� �޾ƿ;� �ϹǷ�() �ȿ� �־��ֱ�) 
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1)
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND CNAME = 'ȫ�浿'
    ORDER BY CAMOUNT DESC; 

-- 4. ����Ʈ�θ� ���� (1�� id�� 100�� ����) : int buyWithPoint(int cId, int cAmount)
    -- (����Ʈ �ܿ� Ȯ���� �� ����) CID CPOINT AMOUNT
-- cid�� ��ȸ �Ŀ� AMOUNT�� ���� �Է¹��� �Ŀ� AMOUNT�� CPOINT���� ������ ���� ����
-- ����Ʈ�θ� ���� ����
UPDATE CUSTOMER SET CPOINT = CPOINT - 100 WHERE CID = 1;
SELECT * FROM CUSTOMER;
COMMIT;

-- 5. ��ǰ ���� : int buy(cId, int cAmount)
    -- ��ǰ���� update���� cpoint, camount // levelNo�� ����
-- CID, CTEL, CNAME, CPOINT, CAMOUNT, POINT where c
-- (SQL �ϳ��� �ذ��� �� �ֵ��� , ����Ʈ, ���űݾ�, ��������)
-- 1000���� ��� ������ X 

-- 5-1. CPOINT, CAMOUNT ����
UPDATE CUSTOMER SET CPOINT = CPOINT + (1000000 * 0.05),
                    CAMOUNT = CAMOUNT + 1000000
                WHERE CID = 1;
SELECT * FROM CUSTOMER;
-- 5-2. LEVELNO �����ϱ� ��, ��������ȣ�� ������ ������ȣ NONEQUI����
SELECT CID, CNAME, CAMOUNT, C.LEVELNO ������, L.LEVELNO �����ɷ���
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

-- ���� : 5-1 + 5-3 ��ġ��
-- ������ ������ ����� �� �Ŀ� �־��־�� �ϱ� ������ �������� �ȿ��� CID ������ �־��־�� �Ѵ�.
-- ����ǥ�� 5���� ���� �Ѵ�.
UPDATE CUSTOMER SET CPOINT = CPOINT + (1000000 * 0.05),
                    CAMOUNT = CAMOUNT + 1000000,
                    LEVELNO = (SELECT L.LEVELNO
                                FROM CUSTOMER C, CUS_LEVEL L 
                                WHERE (CAMOUNT + 1000000) BETWEEN LOW AND HIGH
                                AND CID =4)    
    WHERE CID = 4; -- DAO�� �� QUERY

SELECT * FROM CUSTOMER;

-- 6. ��޺� ��� : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1) forLevelUp    
-- select ����� ���õǾ�� ��.
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO 
        AND LEVELNAME = 'NORMAL'
    ORDER BY CAMOUNT DESC;

-- 7. ��ü�� ��� (�Ѹ������) : ArrayList<CustomerDto> getCustomers() - ������ ��ü ����̹Ƿ�
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, (MAX-CAMOUNT+1) forLevelUp
-- select
SELECT cID, cTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 
    (SELECT HIGH+1-CAMOUNT FROM CUSTOMER WHERE CID = C.CID AND LEVELNO != 5) forLevelUp
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO
    ORDER BY CAMOUNT DESC;

-- 8. ȸ������: int insertCustomer(CustomerDto dto)
           -- int insertCustomer(String cTel, String cName) -- ���
-- insert ������ 1 ���д� 0
INSERT INTO CUSTOMER (CID, CTEL, CNAME) 
    VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '���浿');

SELECT * FROM CUSTOMER;
-- 9. ��ȣ����: int updateCustomer(int cId, String cTel)
-- update
UPDATE CUSTOMER SET CTEL = '010-5555-5555' WHERE CID = 5;
-- 10. ȸ��Ż�� : int deleteCustomer(String cTel)
-- delete
-- �ʵ带 �ϳ� �� �߰��ؼ� DELETE�� ȸ���� �̸��� �����ϴ� ���̺� �����ϱ⵵...
DELETE FROM CUSTOMER WHERE CTEL = '010-5555-5555';
SELECT * FROM CUSTOMER;
COMMIT;