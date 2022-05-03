
-- *���̺� ���� : ���� �̸��� ���̺��� �����Ǿ��� ��� DROP
-- 1. PERSON TABLE
DROP TABLE PERSON;
CREATE TABLE PERSON (
    pNO   NUMBER(3)    PRIMARY KEY,
    pNAME VARCHAR2(30) NOT NULL,
    jNO   NUMBER(3)    REFERENCES JOB(jNO),
    KOR   NUMBER(3),
    ENG   NUMBER(3),
    MAT   NUMBER(3)
    );

-- pNO SEQUENCE ����    
DROP SEQUENCE PERSON_NO_SEQ;
CREATE SEQUENCE PERSON_NO_SEQ NOCYCLE NOCACHE;

-- 2. JOB TABLE 
DROP TABLE JOB;
CREATE TABLE JOB (
    jNO   NUMBER(3)    PRIMARY KEY,
    jNAME VARCHAR2(30) UNIQUE NOT NULL
);

-- *���� ������ ���� ( JOB >> PERSON ������ )
-- JOB INSERT
INSERT INTO JOB VALUES (10, '���');
INSERT INTO JOB VALUES (20, '����');

SELECT * FROM JOB;

-- PERSON INSERT
INSERT INTO PERSON VALUES(PERSON_NO_SEQ.NEXTVAL,'���켺', 10, 90, 80, 81);
INSERT INTO PERSON VALUES(PERSON_NO_SEQ.NEXTVAL,'�ڼ���', 10, 80, 90, 80);
INSERT INTO PERSON VALUES(PERSON_NO_SEQ.NEXTVAL,'�����', 20, 20, 90, 90);
INSERT INTO PERSON VALUES(PERSON_NO_SEQ.NEXTVAL,'����', 20, 95, 95, 100);
INSERT INTO PERSON VALUES(PERSON_NO_SEQ.NEXTVAL,'������', 10, 100, 100, 100);

SELECT * FROM PERSON;


-- 1�� : PNAME, JNAME, KOR, ENG, MAT �Է¹޾� INSERT
-- JNAME�� ���������� �̿��Ͽ� �Է¹��� �� ������ �Ͽ��� �Ѵ�.
SELECT pNAME, jNAME, KOR, ENG, MAT
    FROM PERSON P, JOB J 
    WHERE P.jNO = J.jNO;

INSERT INTO PERSON VALUES 
    (PERSON_NO_SEQ.NEXTVAL, '������', (SELECT jNO FROM JOB WHERE jNAME = '���'), 97, 99, 100);

-- 2�� : ���, �̸�(pNO), ������, ����, ����, ����, ���� ���
-- ORDER BY�� �̿��Ͽ��� ���� ū ������ ����
-- �������� �Է� �޾ƾ� ��
SELECT pNAME ||'('||PNO||'��)' pNAME, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) "SUM"
    FROM PERSON P, JOB J WHERE P.jNO = J.jNO AND JNAME = '���';

SELECT ROWNUM RANK, A.*
    FROM (SELECT pNAME ||'('||PNO||'��)' pNAME, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) "SUM"
    FROM PERSON P, JOB J WHERE P.jNO = J.jNO AND JNAME = '���' ORDER BY SUM DESC) A;

-- 3�� : ��� ���� ���, �̸�, ������, ����, ����, ����, ������ ���
-- (���� �������� �������� ����)

SELECT ROWNUM RANK, A.*
    FROM (SELECT pNAME ||'('||PNO||'��)' pNAME, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) "SUM"
    FROM PERSON P, JOB J WHERE P.jNO = J.jNO) A;
    
    commit;
    
-- 4�� �޺��ڽ��� �� ������ list - VECTOR
SELECT JNAME FROM JOB;
    
    
    
    