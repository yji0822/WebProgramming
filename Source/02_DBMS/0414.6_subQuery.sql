
-- [��] SUB QUERY : QUERY �ȿ� QUERY�� ����

-- �� 1. ���� ���� ����(�ʿ伺)
-- ���������� �ʿ伺: �޿� ���� ���� �޴� ����� �̸��� �޿�
-- SELECT EMPNO, MAX(SAL) FROM EMP GROUP BY EMPNO; -- ����
SELECT MAX(SAL) FROM EMP; -- ��������
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) FROM EMP); 
    -- �������� (���������� �ݵ�� ��ȣ�� �����־�� ��) ������ ��������

-- ���������� ����(1) ������ �������� (�������� ����� ������) : =, >, >=, <, <= != ��밡��
    -- EX. SCOTT�� �ٹ��ϴ� �μ� �̸� ���
    -- ��������
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ��������
    SELECT DNAME FROM DEPT 
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    -- EQUI JOIN
    SELECT DNAME FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT';
-- ���������� ����(2) ������ �������� (�������� ��� 2�� �̻�) : IN, ANY, ALL, EXISTS 
-- �ε�ȣ�� �ܵ����� ����� �� ����.
    -- EX. JOB�� MANAGER�� ����� �μ��̸� ���
    SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'; -- ��������
    SELECT DNAME FROM DEPT
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');

-- �� 2. ������ ��������
-- ���������� ����� �����ؼ� �������� ���´ٸ� ������ ��� ����.
    -- �Ʒ� ���� ��ó��
    SELECT * FROM EMP;
    SELECT E.DEPTNO FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- 20
    
    INSERT INTO DEPT VALUES (50,'IT', 'DALLAS');
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES(9999,'ȫ�浿', 50);
    SELECT * FROM DEPT;
    SELECT * FROM EMP WHERE EMPNO = 9999;
    
    -- EX1. SCOTT�� ���� �μ���ȣ�� // ����� �̸��� �޿� ���
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ��������
    SELECT ENAME, SAL FROM EMP 
        WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT'; -- ���� ��� F9Ű ������ �װ͸� ���� �ȴ�!
    -- JOIN
    
    -- EX2. SCOTT�� ���� �ٹ����� // ����� �̸��� �޿�
    SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT'; -- ��������
    SELECT ENAME, SAL
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO 
            AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'SCOTT') AND ENAME != 'SCOTT'; -- ��������
        ROLLBACK; -- ������ �߰��� �� ��� (DML-������ �߰�, ����, ����, �˻�) DML�� ��� ����!
    SELECT * FROM EMP WHERE EMPNO =9999;
    SELECT * FROM DEPT; -- ��ҵ� �� Ȯ��
    
    -- EX. SCOTT�� ���� �μ��� �ٹ��ϴ� // ������� �޿���
    SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ������ ��������
    SELECT SUM(SAL) FROM EMP 
        WHERE DEPTNO =  (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    -- EX. SCOTT�� ������ ��å(JOB)�� ���� ����� ��� �ʵ�
    SELECT JOB FROM EMP WHERE ENAME = 'SCOTT'; -- ������ ,��������
    SELECT * FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'SCOTT');
    -- EX. DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ
    SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'; -- ������, ��������
    SELECT ENAME, DEPTNO FROM EMP 
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'); 
    -- EX. 'KING' �� ���� ����� ����� �̸��� �޿�
    SELECT EMPNO FROM EMP WHERE ENAME = 'KING'; -- ������, ��������
    SELECT ENAME, SAL FROM EMP 
        WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');
    -- SELF JOIN
    SELECT W.ENAME, W.SAL FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO AND M.ENAME = 'KING';
    
    -- źź������ 
    -- EX1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿� ���
    SELECT AVG(SAL) FROM EMP;
    SELECT ENAME, SAL FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX2. ��� �޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿� ���
    SELECT AVG(SAL) FROM EMP;
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP)) avg
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    -- EX3. ��ձ޿� ���Ϸ� �޴� // ����� �̸�, �޿�, ��հ� ���̸� ���
    SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP) - SAL, 1) 
        FROM EMP
        WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
    
-- ������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ� ���
SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ��������(������ ���� ��)
SELECT * FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT')
        AND ENAME != 'SCOTT'; 
         -- ������ �����ؼ� �ۼ��ϱ�
    

    -- ex. ���ʷ� �Ի��� ����� �Ի��ϰ� �̸�, 
    SELECT MIN(HIREDATE) FROM EMP; -- ������. ��������
    SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP); -- ��������
    -- ex. �ֱٿ� �Ի��� ����� �Ի��ϰ� �̸�
    SELECT MAX(HIREDATE) FROM EMP; -- ������, ��������
    SELECT HIREDATE, ENAME FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP); -- ��������
    -- ex. ���ʷ� �Ի��� ����� �Ի��ϰ� �̸�, �ֱٿ� �Ի��� ����� �Ի��ϰ� �̸�    
    SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) 
            AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);


-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� // ����� �̸�, �޿�, �Ի���
SELECT MIN(HIREDATE) FROM EMP; -- ��������
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

-- 2. ȸ�翡�� ���� �޿��� ���� // ����� �̸�, �޿�
SELECT MIN(SAL) FROM EMP; -- ��������
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT AVG(SAL) FROM EMP; -- ��������
SELECT ENAME, SAL, DEPTNO 
    FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);
    
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT AVG(SAL) FROM EMP; -- ��������
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT'; -- ��������
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP E, SALGRADE S
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE S, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
        AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
    ORDER BY SAL DESC;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT SAL FROM EMP WHERE ENAME = 'BLAKE'; -- ��������
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER'; -- ��������
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP 
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT AVG(SAL) FROM EMP; -- ��������
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE SAL > (SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK'; -- ��������
SELECT SAL FROM EMP WHERE EMPNO = 7698; --��������
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK')
        AND SAL > (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT DNAME FROM DEPT D, EMP E WHERE D.DEPTNO = E.DEPTNO AND ENAME = 'CLARK';
SELECT SAL FROM EMP WHERE EMPNO = 7698; -- ��������
SELECT EMPNO, ENAME, SAL
    FROM EMP E, DEPT D1
    WHERE E.DEPTNO = D1.DEPTNO
        AND D1.DNAME = (SELECT D1.DNAME FROM DEPT D1, EMP E1 WHERE D1.DEPTNO = E1.DEPTNO AND E1.ENAME = 'CLARK')
        AND E.SAL >= (SELECT SAL FROM EMP WHERE EMPNO = 7698);

--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE';
SELECT ENAME, HIREDATE FROM EMP 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT AVG(SAL) FROM EMP;
SELECT EMPNO, ENAME
    FROM EMP 
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC; 


-- �� 3. ������ �������� : IN, ALL, ANY=SOME, EXISTS
    -- (1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    -- EX. �μ���ȣ ���� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
    SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- �μ���ȣ �� �Ի��� ���� �� -- ��������(������)
    SELECT ENAME, HIREDATE, DEPTNO
        FROM EMP
        WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);
    -- EX. �޿� 3000�̻� �޴� ����� �Ҽӵ� �μ��� �ٹ��ϴ� ����� ��� �ʵ�
    SELECT DEPTNO FROM EMP WHERE SAL >= 3000; -- �������� ������
    SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL >=3000);    

    --(2) ALL : �������� ����� ��� �����ؾ� ��
    -- EX. 30�� �μ� �޿��� ��κ��� ū ��� (= 30�� �μ� �ִ� �޿����� ū ���) ������ ��� �ʵ�
    SELECT SAL FROM EMP WHERE DEPTNO = 30; -- ������  ��������
    SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);
    -- ������ ���������ε� ��� ����
    SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30;
    SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 30);

    -- (3) ANY=SOME : �������� ����� �ϳ��� �����ϸ� ��
    -- EX. 30�� �μ� �޿��� �� �ϳ����̶� ū ���( = 30�� �μ� �ּ� �޿����� ū ���) ������ ��� �ʵ�
    SELECT SAL FROM EMP WHERE DEPTNO = 30; -- ��������(������)
    SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30);
    
    -- (4) EXISTS : �������� ����� �����ϸ� ��
    -- EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�
    SELECT EMPNO, ENAME, SAL
        FROM EMP MANAGER
        WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR); -- �������� �̿�
    -- SELF JOIN
    SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO; -- SELF JOIN �̿�
    
    -- EX. ���ܻ���� ��� �ʵ� ���
    SELECT *
        FROM EMP MANAGER
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
    -- SELF JOIN
    SELECT M.*
        FROM EMP W, EMP M
        WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;

    -- źź1. �μ����� ���� �޿��� ���� �޴� ����� ����(�����ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN�������̿�)
    SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
    SELECT EMPNO, ENAME, SAL, DEPTNO 
        FROM EMP
        WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO); -- ��������
    -- źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
    SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER'; -- ��������
    SELECT DEPTNO, DNAME, LOC
        FROM DEPT
        WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER') ORDER BY DEPTNO;
    -- źź3. �޿��� 3000 �̻��� ����� �� �޿� ����� ����� �ش� ��޺� �ְ� �޿��� �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
    SELECT GRADE, MAX(SAL)
        FROM SALGRADE, EMP
        WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000
        GROUP BY GRADE; -- �������� (4,5)���
    -- �������� 1)
    SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
        FROM SALGRADE, EMP
        WHERE SAL BETWEEN LOSAL AND HISAL
            AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL)
                                  FROM SALGRADE, EMP
                                  WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000
                                  GROUP BY GRADE);
    -- �ٸ� ��� (��)
    
    
    -- źź4. �����ȭ / �Ի��� �б⺰�� ���� ���� �޿��� �޴� ������� 
    --       �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
    -- ���� ����. 123 - 1�б� / 456 - 2�б� / 789 - 3�б� / 10 11 12 - 4�б�
    -- 1.
    SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUATER" FROM EMP;
    -- 2. 
    SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUATER" FROM EMP;
    -- 3. Q�� �̿�
    SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUATER" FROM EMP; 
    -- 1�� �̿��� ��������
    SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
        FROM EMP 
        GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);
    -- ��������
    SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUATER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
        FROM EMP 
        WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3),SAL) IN
                (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
                    FROM EMP 
                    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
        ORDER BY QUATER;
    
    -- źź5. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� 
    --       �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ���(SALESMAN)�� ������� �ʴ´�.(ALL�̿�)
    -- �ִ밪���� ũ�ų� ����
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- ��������
SELECT ENAME, SAL, JOB 
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN') AND JOB != 'SALESMAN'; -- ������ �������� �̿��� ��������
    -- 
    SELECT ENAME, SAL, JOB
        FROM EMP 
        WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB = 'SALESMAN')
            AND JOB != 'SALESMAN';

    -- źź6. SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
    -- �ٽ� �ڵ� Ȯ���ϱ�...
    SELECT ENAME, SAL, JOB 
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
    -- 
    SELECT ENAME, SAL, JOB
        FROM EMP 
        WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB = 'SALESMAN');
    
    -- źź7. ������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
    -- ������ �������� 
    -- ������ ���ϴ����� �ľ��ϴ� ���� �߿�
    SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000;
    SELECT EMPNO, ENAME, SAL, HIREDATE 
        FROM EMP
        WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL < 3000);
        
    -- źź8. ������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� 
    -- �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�
    SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; -- ��������
    SELECT ENAME, SAL, JOB, DEPTNO 
        FROM EMP
        WHERE DEPTNO != 20
            AND SAL > ANY (SELECT SAL FROM EMP WHERE JOB = 'SALESMAN');
  
            
-- �������� 14~27
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
-- ���߿�
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME, SAL
    FROM EMP 
    WHERE DEPTNO = ALL (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT * FROM DEPT WHERE LOC = 'DALLAS';
SELECT ENAME, JOB, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND LOC = (SELECT LOC FROM DEPT WHERE LOC = 'DALLAS');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT M.EMPNO
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO
        AND M.ENAME = 'KING';

SELECT ENAME, SAL
    FROM EMP 
    WHERE MGR IN (SELECT M.EMPNO
                        FROM EMP W, EMP M
                        WHERE W.MGR = M.EMPNO
                        AND M.ENAME = 'KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT DNAME FROM DEPT WHERE DNAME = 'SALES';
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    AND DNAME = (SELECT DNAME FROM DEPT WHERE DNAME = 'SALES');

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30;
SELECT * 
    FROM EMP
    WHERE SAL > ALL (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT JOB FROM EMP WHERE DEPTNO = '10';
SELECT JOB FROM EMP WHERE DEPTNO = '30';
SELECT ENAME, JOB 
    FROM EMP
    WHERE DEPTNO = 30 
        AND JOB = ANY (SELECT JOB FROM EMP WHERE DEPTNO = '10');

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD';
SELECT *
    FROM EMP 
    WHERE (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT JOB FROM EMP WHERE ENAME = 'JONES';
SELECT SAL FROM EMP WHERE ENAME = 'FORD';

SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP 
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES')
        OR SAL >= (SELECT SAL FROM EMP WHERE ENAME = 'FORD');
        
-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD';
SELECT ENAME, JOB, SAL
    FROM EMP 
    WHERE SAL = ANY (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME = 'WARD')
    AND ENAME NOT IN ('SCOTT', 'WARD');

-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
SELECT ENAME, JOB
    FROM EMP 
    WHERE JOB = ANY (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');

-- 24. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT AVG(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
SELECT ENAME, DEPTNO, SAL FROM EMP;

SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE E.DEPTNO = DEPTNO )
    ORDER BY DEPTNO;

-- �߰�����
-- �ش�μ� ��պ��� ���� ����� ���� - ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���(�Ҽ���2�ڸ�)
SELECT EMPNO, ENAME, SAL, DEPTNO, ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO),2) AVG
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);


-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT JOB, ENAME, SAL FROM EMP ORDER BY JOB;
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB ORDER BY JOB;

SELECT DEPTNO, ENAME, SAL, JOB 
    FROM EMP E
    WHERE SAL <  (SELECT AVG(SAL) FROM EMP WHERE JOB = E.JOB )
    ORDER BY JOB;

-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
 SELECT JOB, ENAME, EMPNO, DEPTNO
        FROM EMP MANAGER
        WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR)
        ORDER BY DEPTNO;
        
-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT EMPNO, ENAME, DEPTNO
        FROM EMP MANAGER
        WHERE NOT EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
        
        
        
        
        
        
        
        
        
        
        
        