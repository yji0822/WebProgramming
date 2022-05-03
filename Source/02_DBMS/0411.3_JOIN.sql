
-- [iii] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
SELECT * FROM EMP; -- �μ� �̸��� ������ ����
SELECT * FROM DEPT;

SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- �μ���ȣ(DEPTNO 20)
SELECT * FROM DEPT; -- SQL���� �ι� �ۼ��ؾ��ϴ� ���ŷο�
-- CROSS JOIN (FROM ���� �׳� �ΰ� �̻��� ���̺��� �����ִ� ��)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';
-------------- 1 -- 4 -------------------------------------
-- 1���� �࿡ DEPT�� 4���� ��� �� ����´�
SELECT * FROM EMP, DEPT; -- 56�����..... CROSS JOIN 14*4�� ���


-- �ڡڡ� 1. EQUI JOIN (��������: �����ʵ忣 DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)�ڡڡ�
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO; -- DEPTNO�� �ߺ��Ǿ� ��µǴ� ���� �� �� �ִ�.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO; -- �ߺ��� �� �����ϰ� ����ϴ� ��

-- FROM���� ���̺� ��Ī�� �ִ� ��
-- ���̺��� ��Ī�� ������ ��Ī���θ� ���̺��� �������� �� �ִ�.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, COMM, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO; -- �ʵ尡 �ƴϱ� ������ �׳� ����� ����
    -- EX. �޿��� 2000�̻��� ������ �̸�, ��å(JOB), �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000; -- ���̺� �������Ǻ��� WHERE�� �����ֱ�!!
    -- EX. LOC�� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ, �ٹ����� ���
SELECT ENAME, JOB, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
    -- EX. �μ���ȣ 10�̰ų� 20���� ����� �̸�, ����, �ٹ���, �޿� (�޿��� ����)
SELECT ENAME, JOB, LOC, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN(10,20) 
    ORDER BY SAL; -- E.DEPTNO = D.DEPTNO �������.
    -- EX. JOB�� SALESMAN �̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM)*12), �μ���
    --     �ٹ����� ���(������ ū ������ ����)
SELECT ENAME, SAL, NVL(COMM,0) ��, (SAL+NVL(COMM,0)*12) AS ����, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN('SALESMAN', 'MANAGER');
    -- EX. COMM�� NULL�̰� �޿��� 1200 �̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ���
    --    (�μ����, �μ����� ���� �ÿ��� �޿� ū �� ����) ***
SELECT * FROM EMP;
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200 ORDER BY DNAME, SAL DESC;
    -- EX. 'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    -- EX. 'ACCOUNTING' �μ� �Ҽ��� ��� �̸��� �Ի��� ���
SELECT ENAME, HIREDATE FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
    -- EX. ����(JOB)�� MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
    -- EX. COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, E.DEPTNO, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;


-- �� 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE; -- �޿� ��� ���� GRADE, LOSAL, HISAL
-- CROSS JOIN = EMP�� 1�� * SALGRADE�� 5��
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN ���ϴ� �������� ��� �������� ������ ����
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL; -- ������ 3000�� ����� ����� ������ִ� ��
    -- EX. ��� ����� ���, �̸�, JOB, �����, �޿�, �޿����(1���,,,2���..)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '���' GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- źź������
--	Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.

--	�̸�, �޿�, �Ի���, �޿����

--	�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���

--	�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���

--	�̸�, �޿�, �޿����, ����, �μ���, �μ��� ���, �μ��� ������ ������. ����=(sal+comm)*12 comm�� null�̸� 0

--	�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. �������� : �μ���, �μ������� ������, ���������� �޿� ū��

--	�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��


-- �� 3. SELF JOIN 
SELECT EMPNO ���, ENAME �̸�, MGR ����� FROM EMP; -- ������̶� ���� 
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH'; -- SMITH ��� 7902
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;  -- ���� ����
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME 
    FROM EMP WORKER, EMP MANAGER  
    WHERE WORKER.ENAME = 'SMITH' AND WORKER.MGR = MANAGER.EMPNO; -- FROM���� ��Ī ���̱� ����
    -- EX. ��� ����� ���, �̸�, �����, ����̸� (13�ุ ��µ� >>> MGR�� NULL�� ģ���� ����
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;


--  �� 4. OUTER JOIN : ���ν� ���ǿ� �������� ���� ����� ��Ÿ���� ���ִ� ��
-- 3.�� �ذ�å
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+); -- ���� �ʿ� (+)�� ���ش�!!!
    
    SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO; -- ���ܻ������ ������δ� �����ϳ�, MGR�δ� �������� �ʴ´�.

-- 1. EQUI JOIN �ذ���
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO;
SELECT * FROM DEPT; -- 40���� ����������. 40�� �μ��� ����� ��� ����� �ȵ�








