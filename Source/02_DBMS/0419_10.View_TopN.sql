--[X] VIEW, INLINE VIEW, TOP-N ����

-- 1. VIEW : ������ ���̺� (1)�ܼ� �� (2)���� ��

-- (1) �ܼ� �� : �ϳ��� ���̺�� ������ ��
-- EMPv0 �̶�� VIEW ���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
-- (�Ϲ� ���̺� ����̶� �ٸ��� �ʴ�!)

SELECT * FROM EMP; -- EMP���̺�
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� �� Ȯ��

-- VIEW CREATE EMPv0
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; 
    -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ����
SELECT * FROM EMPv0; -- SAL, COMM ����� (������ ���̺�)

-- VIEW ���ο� ������ ���� (INSERT)
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40);
SELECT * FROM EMPv0; -- INSERT Ȯ��
SELECT * FROM EMP; -- SAL,COMM NULL ������ ���� 

-- VIEW UPDATE 
UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO = 1111;
SELECT * FROM EMPv0; -- ������Ʈ Ȯ��
SELECT * FROM EMP; -- ������Ʈ Ȯ��

-- VIEW DELETE
DELETE FROM EMPv0 WHERE EMPNO = 1111; -- ���̺�� �����ϰ� ���
SELECT * FROM EMPv0; -- ���� Ȯ��
SELECT * FROM EMP; -- ���� Ȯ��


-- �Ϻ��� ���̳� ���� ���� ���� ��� EX. 30�� ���̺��� 30�� �μ��� �� �� �ְ� �ϰ� ���� ��...
-- �Ϻ��� ���� ���� ���� ���

-- EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30;
-- ���� OR ��ü
DESC EMPv0; -- ��� �ʵ尡 ���� �� Ȯ�� (PK�� ���� ����, �ܷ�Ű ���� ���ǵ� ���� ����)
SELECT * FROM EMPv0; -- 30�� �μ� Ȯ��

INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30);
SELECT * FROM EMPv0;
SELECT * FROM EMP;

-- ����.. 40�� �μ��� �߰��ϰ� �ʹٸ�?
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 8000, 800, 40); -- �Է��� ����
SELECT * FROM EMPv0; -- Ȯ���� �ȵ�..! 30�� �μ��� ����� �س��� �����̱� ������ ������ ����.
SELECT * FROM EMP; -- 40�� �μ��� �߰��� �� Ȯ��

-- 30�� �μ� ȫ��, 40�� �μ� ���� EMPv0 �信�� ����
DELETE FROM EMPv0 WHERE EMPNO IN (1111, 1112); -- 30�� �μ��� ȫ�� ���� O, 40�� �μ��� ���� ���� X
SELECT * FROM EMPv0; -- ȫ ����
SELECT * FROM EMP; -- ȫ�� ����, ���� ����
DELETE FROM EMP WHERE EMPNO = 1112; -- ���� ������ EMP���̺��� ���� ���ֱ�

-- EMPv0 �� ���� : ENAME, JOB, HIREDATE ������ �� ����
CREATE OR REPLACE VIEW EMPv0    
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ', 'SALESMAN', SYSDATE); -- INSERT �ȵ�
-- NOT NULL ������ ���� �ϴ� �ʵ�� �� ���� �信�� ������ ���� ����
-- ���̺��� �� �� �ִ� ���ǵ� ��� ��� ���� ����,,, ����Ʈ...
COMMIT;


-- * VIEW�� ���� ���� (1) ���� ����, (2) �б� ����
--- 40�� �μ��� �Է��ϸ� �ȵǵ��� �������� ���̴� ��
-- 'WITH CHECK OPTION' �� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
-- 'WITH READ ONLY' �� ������ ��� �б� ���� �� (SELECT�� ����)

-- EMPv0 : ����. EMP���̺��� 30�� �μ��� + WITH CHECK OPTION
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION;

INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30); -- O
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 9000, 900, 40); -- X

DELETE FROM EMPv0 WHERE ENAME = 'SMITH'; -- 0�� ����, ���ǺҸ���
DELETE FROM EMPv0 WHERE EMPNO = 1111; -- 1�� ����, ���� ���� (�μ� 30)

SELECT * FROM EMPv0;


-- EMPv0 : �б� ���� �� WITH READ ONLY
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP 
    WITH READ ONLY;

INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, 40); -- ����(�б����� ��)


-- (2) ���պ� : �� 2�� �̻��� ���̺�� ������ ���̰ų� �� ������ �ʵ�� �並 ���� ���.
--             DML ������ ���������� ���(SELECT�� �����ϴ� �ǹ�)

-- �� 2�� �̻��� ���̺�� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
        
SELECT * FROM EMPv0; -- EQUI���ε� VIEW Ȯ��

INSERT INTO EMPv0 VALUES (1111, 'HONG', 'MANAGER', 'RESEARCH', 'DALLAS');
    -- ���պ�� INSERT, UPDATE �Ұ� (���� �Ұ�)

-- �� ������ �ʵ�� �� ���� : �÷��� '��Ī'�� �̿��Ͽ� �� ����
--                  ��Ī�� (�����ڷ� ����, ������, ����, _ AND 30�� �̳�)

CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 10; 
    -- �����߻� (�ʵ��̸��� Ư�����ڰ� �����Ͽ� �Ұ�)

-- 1��° ��Ī ����
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL" FROM EMP WHERE DEPTNO = 10;
-- 2��° ��Ī ����
CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 10;

SELECT * FROM EMPv0;

-- ���� ��� �����ϰ� INSERT, UPDATE �Ұ�
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 2400);


    -- EX. �μ���ȣ, �μ��� �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ DEPTv1�� ����
    CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MIN_SAL, MAX_SAL, AVG_SAL)
        AS SELECT D.DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM DEPT D, EMP E 
            WHERE D.DEPTNO = E.DEPTNO GROUP BY D.DEPTNO;
    SELECT * FROM DEPTv1;
    
    -- EX. ��å, �μ��� ������ EMPv0 �並 ���� (*�ߺ����� DISTINCT�� ������ ��� �б� ����!)
    CREATE OR REPLACE VIEW EMPv0 
        AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO;
    SELECT * FROM EMPv0;
    -- DISTINCT�� �����ص� INSERT, UPDATE �Ұ�!

    
    
-- 2. INLINE VIEW : FROM�� ���� ���������� INLINE VIEW�� �ϸ�, 
--                  FROM���� ���� ���������� VIEWó�� �ۿ�
        
    -- EX. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿�
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL > 2000);
    
    -- EX. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿� (���������������� 24��, 25��)
    -- ��������
    SELECT EMPNO, ENAME, SAL 
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    -- INLINE VIEW 
    SELECT EMPNO, ENAME, SAL, AVGSAL
        FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVGSAL" FROM EMP GROUP BY DEPTNO) A
        WHERE E.DEPTNO = A.DEPTNO
            AND SAL > AVGSAL;
            
            
            
-- 3. TOP-N ���� (TOP 1~10�� / TOP 11~20�� / TOP 6~10��)
--- ��ŷ�� �ٸ�

-- �� ROWNUM : FROM�� ���̺�κ��� ������ ����
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20; -- �������
-- WHERE ���� �����Ǵ� ���Ǹ� ROWNUM�� ���õȴ�.
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

    -- EX. ���, �̸��� SAL �������� ��ŷ ��� (��ü �࿡ ����)
        SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ROWNUM�� ����� �ƴϰ� ���̺�κ��� ������ ����
        -- FROM������ ORDER BY �� ���·� �����ͺ��� (FROM������ SAL�� �������� ���������Ͽ� ������ ���̺� ���)
        SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- ROWNUM�� ����� �� (��õ)
        -- �Լ��� �̿��� RANK ��� (����)
        SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
            DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
            ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
            ENAME, SAL FROM EMP;

-- SAL �������� 1~5�� ���
SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5; -- ����

SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5; 

-- SAL �������� 6~10�� ���
SELECT ROWNUM, ENAME, SAL  
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10; -- ����� ����� �ȵ�...! ��? 
    -- ROWNUM�� ������ ���� ��쿡 1�� ���� ����� �Ǵµ� 1�� ���ʿ� ����� �ȵǱ� ������ 
    -- ��µǴ� ����� ����.
    
-------------------------------------------------------------------------------
-- �� TOP-N ���� 1�ܰ�
--- ROWNUM�� ��Ī �� �ֱ�!
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);

-- �١� TOP-N ���� 2�ܰ� (�ϼ��� TOP-N ����)
--- ���� ���� �ϱ�!!!!
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) A
    WHERE RN BETWEEN 6 AND 10;

    -- EX. �̸��� ���ĺ� ������� �����ؼ� 6~10������ ��� (���, �̸�, ���, JOB, MGR, HIREDATE)
    SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM(SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
            FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME)) A
        WHERE RN BETWEEN 6 AND 10;
    
    -- 1�ܰ�
    SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME;
    -- 2�ܰ�
    SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME);
    -- 3�ܰ�
    SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
            FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;
    
    
    -- 0419 ��������
    -- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
    CREATE OR REPLACE VIEW DNAME_ENAME_VU 
        AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
    
    SELECT * FROM DNAME_ENAME_VU;
       
    -- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
    CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
        AS SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR = M.EMPNO;
   
    SELECT * FROM WORKER_MANAGER_VU;
    
    -- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). 
    SELECT DEPTNO, SUM, ROWNUM 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);        
    
    -- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�. ? �л� ����
    SELECT DEPTNO, SUM, RN
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN BETWEEN 2 AND 3;
    
    -- �ٸ� ���
    SELECT *
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN BETWEEN 2 AND 3;
    
    SELECT *
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN IN(2,3);
        
    -- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�  
    SELECT EMPNO, ENAME, HIREDATE FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC);
    
    -- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
    SELECT EMPNO, ENAME, HIREDATE, RN 
    FROM(SELECT EMPNO, ENAME, HIREDATE, ROWNUM RN 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 1 AND 5;
    
    SELECT EMPNO, ENAME, HIREDATE
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) WHERE ROWNUM <=5;
    
    SELECT *
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) WHERE ROWNUM <=5;
    
    -- �١� 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
    SELECT EMPNO, ENAME, HIREDATE, RN
    FROM(SELECT EMPNO, ENAME, HIREDATE, ROWNUM RN 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;
    
    -- �ٸ� ���!
    SELECT EMPNO, ENAME, HIREDATE 
    FROM(SELECT ROWNUM RN, A.* 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;
    

    