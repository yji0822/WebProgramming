-- new > untitled text file
-- Ex1�� ����
-- ������ ����� developer���ٰ� ����

-- EX1. ����ڿ��� �μ���ȣ �Է¹޾� �μ� ���� �Ѹ���
-- ����Ǵ��� �̰����� Ȯ���� �Ŀ� ��Ŭ������ �����ؼ� �Ѿ��
SELECT * FROM DEPT WHERE DEPTNO = 30;

INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
COMMIT;
DELETE FROM DEPT WHERE DEPTNO = 50;
COMMIT;

-- EX2.
SELECT * FROM DEPT WHERE DEPTNO = 30; -- (1-1)
    -- �ش�μ���ȣ ����� ���� (���, �̸�, �޿�, ����) self join
    SELECT W. EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO
            AND W.DEPTNO = 30; -- (1-2)
            
-- EX3.
-- upper : ����ڿ��� � �������� SALES�� �Է� �޴� �빮�ڷ� ��ȯ������. 
-- (1)
SELECT * FROM DEPT WHERE DNAME = UPPER('SALES'); 
-- (2)���, �̸�, �޿�, �޿����
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND E.DEPTNO = D.DEPTNO
        AND DNAME = UPPER('sales'); 
        
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = UPPER('sales'));












