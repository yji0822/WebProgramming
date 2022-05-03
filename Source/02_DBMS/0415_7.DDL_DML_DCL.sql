-- [VII] DDL, DML, DCL
-- SQL = DDL (���̺� ����, ���̺� ����, ���̺� ���� ����, ���̺� ��� ������ ����)
--       DML (�˻� = SELECT, �߰� = INSERT, ���� = UPDAATE, ���� = DELETE)
--       DCL (����ڰ�������, ����ڱ��Ѻο�,  ���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ� = ROLLBACK, COMMIT)


-- �ڡڡ� DDL �ڡڡ�
-- 1. ���̺� ���� (CREATE TABLE) 

CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- ������ȣ BOOKID �ʵ� Ÿ���� ���� 4�ڸ�
    BOOKNAME VARCHAR2(300), -- å�̸�   BOOKNAME �ʵ� Ÿ���� ���� 300�ڸ�
    PUBLISHER VARCHAR2(300),-- ���ǻ�   PUBLISHER �ʵ�� ���� 300�ڸ�
    RDATE     DATE,         -- ������   RADTE �ʵ�� DATE��
    PRICE     NUMBER(8),    -- ����    PRICE �ʵ�� ���� 8�ڸ�
    PRIMARY KEY(BOOKID) );  -- ���̺� �� ��Ű(PRIMARY KEY) ���� 
                                -- NOT NULL, ������ �� �Է�
    
    SELECT * FROM BOOK;     -- ���̺� ���� Ȯ��
    DROP TABLE BOOK;        -- ���̺� ����
    -- DDL ������ ��Ұ� �ȵȴ�!
    

CREATE TABLE book (
    BOOKID    NUMBER(4) PRIMARY KEY,   -- �ʵ������ϰ� Ÿ�� ���� ��� �ǰ� ���� ��� X
    BOOKNAME  VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE     DATE, 
    PRICE     NUMBER(8)  );
-- PRIMARY KEY ��ġ : ����Ŭ�� ��������� MYSQL�� ���� �Ʒ��� ���´�

SELECT * FROM BOOK;

-- ** ROWNUM : �� ó�� ���̺��� �о���� ���� ���� **
--           : ���� ������ �ʾƵ� �ڵ������� ���������.
SELECT * FROM EMP;
DESC EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP ORDER BY ENAME;
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME; 
-- ���� : FROM > WHERE > ORDER BY > ROWNUM


-- NULL�� ���� �ȵǴ� �ʵ�(BOOKNAME,BOOKID..), ������ ���� �ȵǴ� �ʵ�(PRICE)
-- �ʵ� �̸��̶� 


-- EX. EMP01: EMP ���̺�� ������ ������ 
--          : �����ȣ(EMPNO - ����4), ����̸�(���� 20), �޿�(���� 7,2) 
--          : 3���� Į������ ������ EMP01 ���̺��� ������ ����
-- PRIMARY KEY ����
CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL   NUMBER(7,2) -- 5�ڸ��� �Ҽ��� 2�ڸ�
);
DESC EMP01; -- NOT NULL�� �Ⱥ���. ��? �� PRIMARY KEY�� ���Ѵ�.
DROP TABLE EMP01;

-- EX. DEPT�� ������ DEPT01
--     : DEPTNO(����2, PK), DNAME(����14), LOC(����13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC   VARCHAR2(13),
    PRIMARY KEY(DEPTNO)
    );
DESC DEPT01;
DROP TABLE DEPT01;

-- ���������� �̿��� ���̺� ����
-- �������� ����� EMP02���̺� ���� �� ��
-- (���������� ���� �ʴ´�.) PRIMARY KEY��
SELECT * FROM TAB; -- SCOTT�� ������ ���̺� ����Ʈ
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- EMP���̺��� ��������!
SELECT * FROM EMP02;
DESC EMP02; -- �������� ������ Ȯ��
    
    -- EX. EMP03 : EMP���̺��� EMPNO, ENAME, DEPTNO�� ������ �����ͷ� ���̺� ����
    CREATE TABLE EMP03
        AS 
        SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    SELECT * FROM EMP03; 
    -- ���̺� �����͸� ��� ���� �� ��� ���� �Ѵ�.
    -- �ڵ�ü�踦 �ٲ�� �Ҷ� ����ϱ⵵ �Ѵ�.
    
    -- EX. EMP04 : EMP���̺��� 10�� �μ��� ������ �����ͷ� ���̺� ����
    CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO = 10;
    SELECT * FROM EMP04;
    
    -- ������ �Ȱ��� �����ϰ� ���� ��!
    -- EX. EMP05: �����ʹ� ������ EMP���̺� ������ ������ ���̺� ����
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; -- �ݵ�� ���� ����
    SELECT * FROM EMP05;
    DESC EMP05; -- ����Ŭ������ ����ϴ� ��ɾ� �ּ��� �ް� ������ ������ �ۼ�! *


    
-- 2. ���̺� ���� ���� (ALTER TABLE)
-- ALTER TABLE ���̺�� ADD..  || MODIFY || DROP ~ 
-- �ʵ� �߰�, ����, Ÿ�� ����

-- (1) �ʵ� �߰� (ADD)
-- �߰��� �ʵ��� �����ʹ� ��� NULL
-- UPDATE�ؼ� �ϳ��ϳ� �ְų� �ϳ��� �����ͷ� ���Ͻ�Ų��.
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD(JOB VARCHAR2(20), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD(COMM NUMBER(7,2));    
SELECT * FROM EMP03;

    
-- (2) �ʵ� ���� (MODIFY) : �Ժη� �Ͼ�� �ʴ´�. ����ȯ�� �Ѵٴ���..
-- ���ڼ� �ø��� �� ����. ���̴� �� �Ұ���
SELECT * FROM EMP03; -- EMPNO(��4), ENAME(��10), DEPTNO(��2) / JOB(��20)�� SAL�� COMM(��7,2)�� �����ʹ� 'NULL'
DESC EMP03;

-- EMPNO
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- ���� �����Ͱ� ����ִ� ���¿����� ���ڷθ� ���� ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- ����. ���ڸ� ���� ���� ����.
ALTER TABLE EMP04 MODIFY (EMPNO NUMBER(5)); -- ����
-- ENAME 
ALTER TABLE EMP03 MODIFY(ENAME NUMBER(4)); -- ���ڵ����Ͱ� ����ִ� ���¿����� ���ڷθ� ���� ����    
SELECT MAX(LENGTH(ENAME)) FROM EMP; -- ���� �� �ִ� ���ڵ����� �ִ���� ���
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));    
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- ����(6BYTE ���� �����Ͱ� �־)    
-- JOB : �����Ͱ� ���� ���·�, ���� ����
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2)); 
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));    
    
    
-- (3) �ʵ� ���� (DROP)
-- JOB �ʵ� ���� ���� - DDL�� �ѹ��� �ȵǱ� ������ �׻� �����ؾ� �Ѵ�.
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;

-- �������� Ư�� �ʵ带 ���� ���ϵ��� (��)
ALTER TABLE EMP03 SET UNUSED (DEPTNO); -- �� ������ �Ⱥ��̵��� ��� �����ִ� ��.
SELECT * FROM EMP03;
-- �������� ���� �Ұ��ߴ� �ʵ带 ���������� ���� (����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS; 
    
    
-- 3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01; -- ���ӿ� ���ΰ�ħ ������ ���� Ȯ��
DROP TABLE DEPT;  -- �ٸ� ���̺��� �����ϴ� �����Ͱ� ���� ��� DROP X


-- 4. ���̺��� ��� ���� ���� (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03���� ������ ���� (��ҺҰ�)


-- 5. ���̺�� ���� (RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2; -- �̸� ����
SELECT * FROM EMP2;   -- ����� �̸� Ȯ��


-- 6. **** ������ ��ųʸ�(����� ���� �Ұ�) VS. ������ ��ųʸ� ��(����� ���ٿ�) / ������ ȭ�����̳� ������
-- ����
-- USER_XXX : �� ������ �����ϰ� �ִ� ������ ��ü�� (���̺�, �ε���, ��������, ��)
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : �� ������ ���� ������ ��ü(���̺�, �ε���, ��������, ��)
    -- EX. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA �����ڸ� ���� ����. DBMS�� ��� ��ü
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS

-- USER_XXX : �� ������ �����ϰ� �ִ� ������ ��ü�� (���̺�, �ε���, ��������, ��)
SELECT * FROM USER_TABLES;      -- �� ����(SCOTT)�� ������ ���̺� ��ü ����
SELECT * FROM USER_INDEXES;     -- �� ������ ������ �ε��� ����
SELECT * FROM USER_CONSTRAINTS; -- �� ������ ������ ���� ���ǵ�
SELECT * FROM USER_VIEWS;       -- �� ������ ������ �� ����

-- DBA_XXX
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

-- ALL_XXX
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;




-- �ڡڡ� DCL (����� ���� ����, ����� ���� �ο�, ���� ��Ż, ����� ���� ����) �ڡڡ�
-- scott2 ���� ����
CREATE USER scott2 IDENTIFIED BY 1234; -- scott2 ���� ����

-- ���� �ο� (���Ǳ���, scott.EMP, scott.DEPT ���̺� ���� ��� ���� 
GRANT CREATE SESSION TO scott2; -- ö���� �α��θ� ���� (���Ǳ���)
GRANT ALL ON EMP TO scott2;  -- EMP ���̺� ���� ��� ���� (�˻�, ����, ����, ���� ��� ����)
GRANT ALL ON DEPT TO scott2;
SHOW USER;  

-- ���� ��Ż (���� ��Ż�� ����� ������ ��������)
-- EMP TABLE, DEPT TABLE, SESSION ����
REVOKE ALL ON EMP FROM scott2; -- scott2�� emp ���̺� ���� ��� ���� ��Ż
REVOKE ALL ON DEPT FROM scott2; -- ,,
SHOW USER;

-- ����� ���� ���� (���� ���� ���� ���� �Ұ�) 
-- �������� �Ŀ� �ؿ� ���� ����
DROP USER scott2 CASCADE;



-- �ڡڡ� DML(SELECT, INSERT, UPDATE, DELETE) �ڡڡ�
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ��3,....);
--    INSERT INTO ���̺�� (�ʵ��1, �ʵ��2.....) VALUES(��1, ��2...);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION');    -- ���������� LOC�� NULL�� �߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(80, 'HR', NULL); -- ��������� NULL �߰�
INSERT INTO DEPT01 VALUES(90, 'SALES', NULL);                   -- ��������� NULL �߰�

-- ���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- Ʈ����� ��ɾ� (DML ��ɾ)  // ������ ������ INSERT�س��� �� (Ʈ�����) 
-- COMMIT�� �ϸ� ���̺� ���� ���̰�. ROLLBACK�� �ϸ� ������� �ǵ����� ��
COMMIT;
ROLLBACK;

-- ��������. ������ ���� ������ SAM01���̺��� �����Ͻÿ�. 
-- SAM01�� ���� (EMPNO�� ��Ű��) EMPNO(���) ? NUMBER(4) ENAME(�̸�) ? VARCHAR2(10)
-- JOB(��å) ? VARCHAR2(9), SAL(�޿�) ? NUMBER(7,2)
CREATE TABLE SAM01(
    EMPNO    NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY, -- �����̸Ӹ�Ű�� �������� �̸� ����    
    ENAME    VARCHAR2(10),
    JOB      VARCHAR2(9),
    SAL      NUMBER(7,2) ); -- DDL�̶� ��� �ȵ�

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL, 25000);
-- INSERT INTO SAM01 VALUES(EMPNO, ENAME, SAL) VALUES(1030,,' VERY', 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 VALUES (7782, 'CLARK', 'MANAGER', 2450);
INSERT INTO SAM01 VALUES (7839, 'KING', 'PRESIDENT', 5000);
INSERT INTO SAM01 VALUES (7934, 'MILLER', 'CLERK', 1300);

INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB,SAL FROM EMP WHERE DEPTNO = 10;

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS; -- �������� �̸� Ȯ�� // �� �������� �ʴ´�.
DROP TABLE SAM01;



-- Ʈ������ ��ɾ�
COMMIT;
ROLLBACK;


-- 2. UPDATE ���̺�� SET �ʵ��1 = ��1  [, �ʵ��2 = ��2, ...] [WHERE ����];
-- FROM ����!!

DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

    -- EX. EMP01 ���̺��� �μ���ȣ�� 30���� ����  (WHERE �� ���̴� ��� ���� ����)
    UPDATE EMP01 SET DEPTNO = 30;
    SELECT * FROM EMP01; -- ���� �����ͺ��̽��� ������Ʈ ��. ������Ʈ�� ���ؼ��� COMMIT�� �ݵ�� ���־�� �Ѵ�.
    ROLLBACK;    -- DML ��ɸ� ��� / Ʈ����� ���

    -- EX. EMP01 ���̺��� ��� ����� �޿��� 10%�λ�
    UPDATE EMP01 
        SET SAL = SAL*1.1;
-- UPDATE ���̺� SET �ٲٰ� ������ = �ٲ� ��

    -- ** EX. 10�� �μ� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ���� (���� ���� ����)
    UPDATE EMP01
        SET HIREDATE = SYSDATE,
            DEPTNO = '30'
        WHERE DEPTNO = 10;

    -- EX. �޿��� 3000 �̻��� ����� �޿��� 10% �λ�
    UPDATE EMP01 
        SET SAL = SAL*1.1
        WHERE SAL >= 3000;
    
    -- EX. (�������� ���) 'DALLAS'�� �ٹ��ϴ� ������ �޿��� 1000$ �� �λ�
    UPDATE EMP01
        SET SAL = SAL+1000
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
    
    -- EX. SCOTT�� �μ���ȣ�� 20���� JOB�� MANAGER��, SAL�� COMM�� 500�� �λ�,
    --     ��縦 KING���� ����
    UPDATE EMP01 
        SET DEPTNO = 20, 
            JOB = 'MANAGER',
            SAL = SAL + 500,
            COMM = NVL(COMM, 0) + 500,
            MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')
            WHERE ENAME = 'SCOTT';
            
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
    
    -- EX. DEPT01���� 20������ �������� DEPT���̺��� 60�� �μ��� ���������� ����
    SELECT * FROM DEPT01;
    -- DEPT���̺� 60�� �μ��� �������� �����Ƿ� NULL������ ����Ǿ� �����ȴ�.
    UPDATE DEPT01 
        SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 60)
        WHERE DEPTNO >= 20; 
    
    -- EX. EMP01 ���̺��� ��� ����� �޿��� �Ի����� 'KING'�� �޿��� �Ի��Ϸ� ����
    COMMIT; -- ������Ʈ �� �� ���� �س���.
    
    UPDATE EMP01 
        SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
            HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    
    UPDATE EMP01 
        SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
    
    SELECT * FROM EMP01;
    ROLLBACK;
    
    -- EX. DEPT01 ���̺��� 20�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
    UPDATE DEPT01 
        SET (LOC, DNAME) = (SELECT LOC, DNAME FROM DEPT01 WHERE DEPTNO = 40)
        WHERE DEPTNO = 20;
    
    SELECT * FROM DEPT01;
    COMMIT;
    
    
-- 3. DELETE FROM ���̺�� [WHERE ����]; // ROLLBACK ���� - ����
-- TRUNCATE �� ���� ���� (������ : ROLLBACK �Ұ���) - ����
-- FROM ����!!! 

SELECT * FROM EMP01;
DELETE FROM EMP01; -- WHERE���� �� �� ��� ��ü ���� ��� ����
ROLLBACK;          -- �ǵ�����!

    -- EX. EMP01 ���̺��� 'FORD'�� ����� ����
    DELETE FROM EMP01 WHERE ENAME = 'FORD';
    SELECT * FROM EMP01 WHERE ENAME = 'FORD';
    
    -- EX. EMP01 ���̺��� 30�� �μ� ������ ����
    DELETE FROM EMP01 WHERE DEPTNO = 30;
    SELECT * FROM EMP01;

    -- (��������) EMP01 ���̺��� �μ����� RESEARCH�� ���� ���� 
    DELETE FROM EMP01 
        WHERE DEPTNO = (SELECT DEPNTO = FROM DEPT WHERE DNAME = 'RESEARCH');
    
    -- EX. SAM01 ���̺��� JOB�� �������� ���� ����� ����
    SELECT * FROM SAM01; 
    DELETE FROM SAM01 WHERE JOB IS NULL;
    
    -- EX. SAM01 ���̺��� ENAME�� ORANGE�� ����� ����
    DELETE FROM SAM01 WHERE ENAME = 'ORANGE';
    ROLLBACK;
    COMMIT;
    

-- �������� : PDF 1������

    CREATE TABLE MY_DATA (
        ID      NUMBER(4) PRIMARY KEY,
        NAME    VARCHAR2(10),
        USERID  VARCHAR2(30),
        SALARY  NUMBER(10,2)
    );
    
    INSERT INTO MY_DATA VALUES (1, 'Scott', 'sscott', 10000.00);
    INSERT INTO MY_DATA VALUES (2, 'Ford',  'fford',  13000.00);
    INSERT INTO MY_DATA VALUES (3, 'Patel', 'ppatel', 33000.00);
    INSERT INTO MY_DATA VALUES (4, 'Report', 'rreport', 23500.00);
    INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450.00);
    
    SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.99') FROM MY_DATA;
    COMMIT;
    
    UPDATE MY_DATA SET SALARY = 65000.00 WHERE ID = 3;
    COMMIT;
   
    DELETE FROM MY_DATA WHERE NAME = 'Ford';
    COMMIT;
   
    UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;
    COMMIT;
   
    DROP TABLE MY_DATA; -- ����
    
    SELECT * FROM MY_DATA;
    
    -- 04.18 ��
    -- �ڡڡ� �������� : �������� �����Ͱ� ���̺� ����, �����Ǵ� ���� �����ϱ� ����
    SELECT * FROM EMP;
    INSERT INTO EMP VALUES (7369, 'ȫ', NULL, NULL, SYSDATE, NULL, NULL, 40); -- SMITH ����� �ߺ�����
    UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; -- SMITH ����� �ߺ�����
    -- (1) ** PRIMARY KEY : �����ϰ� ���̺��� �� ���� �ĺ�. NOT NULL
    INSERT INTO EMP VALUES (NULL, 'ȫ', NULL, NULL, SYSDATE, NULL, NULL, 40); -- �Ұ�
    
    -- (2) NOT NULL : NULL ���� �������� ����
    
    -- (3) UNIQUE : ��� �࿡ ���� �����ؾ� ��. NULL �� ��� (NULL�� ���� �� �Է� ����)
    
    -- (4) ** FOREIN KEY : ���̺��� ���� �ٸ� ���̺��� ���� ���� (EX. EMP TABLE�� DEPTNO�� DEPT ���̺��� DEPTNO ����)
    -- 90�� �μ��� FOREIN KEY�� DEPTNO�� ���� ������ ����
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1111, 'ȫ', 90);
        -- ��ĺ� ���� : �θ� ���̺��� ��Ű(PRIMARY KEY)�� �ڽ� ���̺��� �Ϲ� �Ӽ��� ���� �ʵ�� ���Ը� ���� ��
                        -- exERD ���� ���� ���� ȭ��ǥ
        -- �ĺ� ����  : �θ� ���̺��� ��Ű(PRIMARY KEY)�� �ڽ� ���̺��� ��Ű(��Ű��)�� ���� �ʵ�� ����
                        -- exERD���� �ʷ� ���� ȭ��ǥ
                        
    -- (5) CHECK(����) : �ش� ������ �����ؾ��� INSERT �� (NULL�� ���)
    
    -- (*) ** DEFAULT : �⺻ �� �����ϴ� �� (�ش� ���� ������ �Է°��� ������ NULL�� ��) 
    
    -- �꺸�� �ٽ� �����ϱ�
    DROP TABLE DEPT1;
    CREATE TABLE DEPT1 (
        DEPTNO NUMBER(2) PRIMARY KEY,
        DNAME VARCHAR2(14) UNIQUE, -- �Ȱ��� �μ��̸� �Է��� �� ���� 
        LOC VARCHAR2(13) NOT NULL -- ���� ���� ���� ��� ����, NULL�̸� �ȵ�
    );
    DROP TABLE EMP1;
    CREATE TABLE EMP1 (
        EMPNO   NUMBER(4) PRIMARY KEY,
        ENAME   VARCHAR(10) NOT NULL, -- �ݵ�� �Է��ؾ� ��
        JOB     VARCHAR2(9),
        MGR     NUMBER(4),
        HIREDATE DATE DEFAULT SYSDATE, -- �⺻������ ���� ��¥�� ������ ��
        SAL     NUMBER(7,2) CHECK(SAL>0), -- NULL���� ���� ������ ���� ���� �� ��� 0���� ū ���� ������
        COMM    NUMBER (7,2), 
        DEPTNO REFERENCES DEPT1(DEPTNO) );
   
    DROP TABLE EMP1; -- �ڽ� ���̺�(�����ϴ� ���̺�) ���� drop
    DROP TABLE DEPT1; -- �ٸ� ���̺��� �����ϴ� �ʵ尡 ���� ��(�θ� ���̺���) ���� DROP ���� ����.
    DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- �� ����, �����ϴ� ���̺��� �־ �����ϰ� DROP
    
    -- EXERD ���鼭 ���̺� �ۼ�!~!
    -- EXERD�� ���̺� ���迡 ������ �ִ� ���α׷�!
    CREATE TABLE DEPT1(
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) NOT NULL,
        PRIMARY KEY(DEPTNO),
        UNIQUE(DNAME)
    );
    
    CREATE TABLE EMP1(
    EMPNO   NUMBER(4),
    ENAME   VARCHAR2(10) NOT NULL,
    JOB     VARCHAR2(9),
    MGR     NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL     NUMBER(7,2), 
    COMM    NUMBER(7,2),
    DEPTNO  NUMBER(2),
    PRIMARY KEY(EMPNO), 
    CHECK (SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO) );
    
    -- UNIQUE NOT NULL �̷��� �� ��쿡�� ��ġ�� �ȵ����� ������ �� �� �ְ� ���ִ� ��
    
    -- DEPT1 >>> DEPT ���̺� ������ ����
    SELECT * FROM DEPT1;
    INSERT INTO DEPT1 SELECT * FROM DEPT; -- DEPT ���̺� ������ ���� 
    INSERT INTO DEPT1 VALUES(40, 'IT', 'SEOUL'); -- PK �������� ���� / DEPTNO�� 40�� ������!
    INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- UNIQUE �������� ���� / SALES �� �̹� ����
    INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL �������� ����

    -- EMP1    
    SELECT * FROM EMP1;
    INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) 
        VALUES(1001, 'ȫ', 10); -- ���� ���� / HIREDATE�� ������ �⺻�� �Է� (SYSDATE)/ ȸ�������� ��� �ַ� �̿�
    INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
        VALUES (1001, '��', 10); -- UNIQUE �������� ����
    INSERT INTO EMP1 (EMPNO, DEPTNO)
        VALUES (1002, 20); -- ENAME�� NOT NULL �������� ����
    INSERT INTO EMP1 (EMPNO, ENAME, SAL)
        VALUER (1002, '��', -1); -- CHECK SAL>0 ����
    INSERT INTO EMP1 
        VALUES (1002, '��', NULL, NULL, TO_DATE('95/01/01', 'YY/MM/DD'), 900, NULL, 99); -- FK ����
    -- TO_DATE�� ���󸶴� �ٸ� ��¥ �������� �򰥸��� �ʱ� ���� ����
    
    -- �ڽ� Ŭ�������� �����!
    
    
    -- �������� (pdf 4,5 page)
    -- eXERD �����Ѵ�� �ۼ��ϱ�
    -- BOOKCATEGORY TABLE
    DROP TABLE BOOKCATEGORY;
    CREATE TABLE BOOKCATEGORY(
        CATEGORY_CODE NUMBER(3) PRIMARY KEY,
        CATEGORY_NAME VARCHAR2(50) UNIQUE,
        OFFICE_LOC    VARCHAR2(50) NOT NULL
    );
    SELECT * FROM BOOKCATEGORY;
    INSERT INTO BOOKCATEGORY VALUES (100, 'ö��', '3�� �ι���');
    INSERT INTO BOOKCATEGORY VALUES (200, '�ι�', '3�� �ι���');
    INSERT INTO BOOKCATEGORY VALUES (300, '�ڿ�����', '4�� ���н�');
    INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4�� ���н�');
    
    COMMIT;
    
    -- BOOK TABLE 
    CREATE TABLE BOOK(
        CATEGORY_CODE NUMBER(3),
        BOOKNO        VARCHAR2(10) PRIMARY KEY,
        BOOKNAME      VARCHAR2(50),
        PUBLISHER     VARCHAR2(50),
        PUBYEAR       NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE),
        -- TO_CHAR(SYSDATE, 'YYYY') �̷��� �־  �˾Ƽ� �����ȴ�.
        FOREIGN KEY(CATEGORY_CODE) REFERENCES BOOKCATEGORY(CATEGORY_CODE)
    );
    
    INSERT INTO BOOK VALUES (100, '100A01', 'ö������ ��', '��������', 2021);
    INSERT INTO BOOK VALUES (400, '400A01', '�̰��� DB��', '��������', 2018);
    
    SELECT * FROM BOOK;
    COMMIT;
    
    -- 5������
    -- MAJOR TABLE 
    CREATE TABLE MAJOR (
        MAJOR_CODE      NUMBER(1) PRIMARY KEY,
        MAJOR_NAME      VARCHAR2(30) UNIQUE,
        MAJOR_OFFICE_LOC VARCHAR2(40) NOT NULL
    );
    
    INSERT INTO MAJOR VALUES(1, '�濵����', '�濵�� 305ȣ');
    INSERT INTO MAJOR VALUES(2, '����Ʈ�������', '������ 808ȣ');
    INSERT INTO MAJOR VALUES(3, '������', '������ 606ȣ');
    INSERT INTO MAJOR VALUES(4, '����', '���� 202ȣ');
    
    SELECT * FROM MAJOR;
    COMMIT;
    
    -- STUDENT TABLE
    DROP TABLE STUDENT;
    CREATE TABLE STUDENT(
        STUDENT_CODE VARCHAR2(3) PRIMARY KEY,
        STUDENT_NAME VARCHAR2(10) NOT NULL,
        SCORE        NUMBER(3) CHECK (SCORE>=0 AND SCORE<=100), -- SCORE BETWEEN 0 AND 100;
        MAJOR_CODE   NUMBER(1),
        FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)        
    );
    
    INSERT INTO STUDENT VALUES('A01', '��浿', 100, 1);
    INSERT INTO STUDENT VALUES('A02', '���浿', 90, 2);
    INSERT INTO STUDENT VALUES('A03', 'ȫ�浿', 95, 1);    
    
    SELECT * FROM STUDENT;
    COMMIT;
    
