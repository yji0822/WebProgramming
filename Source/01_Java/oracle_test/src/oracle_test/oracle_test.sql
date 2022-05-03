-- oracle test

SELECT * FROM EMP;

-- SELECT_ALL
-- EX1. EMP ���̺� ���
SELECT * FROM EMP;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP;

SELECT * FROM DEPT;

-- SELECT_DEPTNO : ����ڿ��� ���ϴ� �μ���ȣ�� �Է¹޾� �μ����� ���
SELECT * FROM DEPT WHERE DEPTNO = 10;

-- SELECT_DEPTNO_EMP
-- ����ڿ��� �μ���ȣ �Է¹޾�
-- 1-1 �ش�μ���ȣ�� ������ ��� : �ش�μ������� �ش�μ� ���(���, �̸�, �޿�, ����)
-- 1-2 �ش�μ���ȣ�� �������� ���� ��� : ���ٰ� ���

SELECT * FROM DEPT WHERE DEPTNO = 10;

SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO
    AND W.DEPTNO = 30;
    
-- SELECT_DNAME_EMP
-- 1. ����ڿ��� �μ����� �Է¹޾�
-- * 		1-1. �μ������ϴ� ��� : �μ������� �������(���, �̸�, �޿�, �޿����)�� ���
-- * 		1-2. �μ��������� �ʴ� ��� : ���ٰ� ���

SELECT * FROM DEPT WHERE DNAME = UPPER('SALES');

SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO = D.DEPTNO
    AND E.SAL BETWEEN LOSAL AND HISAL
    AND DNAME = UPPER('SALES');
    
SELECT ENAME, DNAME FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
 AND DNAME = 'SALES';
 
 -- EX5_insertDept
SELECT * FROM DEPT;
 
INSERT INTO DEPT VALUES (10, 'LOVE', 'SEOUL');

-- Ex6_InsertDept2
-- �μ���ȣ�� �Է¹޾� �ߺ�üũ ���� �� �μ����� �Է� ����

SELECT * FROM DEPT WHERE DEPTNO = 10;

INSERT INTO DEPT VALUES (10, 'LOVE; 'SEOUL');

SELECT * FROM DETP WH 
 
 
 
 