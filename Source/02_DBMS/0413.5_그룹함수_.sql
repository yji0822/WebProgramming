-- [��] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- ������ �Լ�(4��)
SELECT MAX(SAL) FROM EMP;              -- �׷��Լ�(5��) MAX

-- �������� �޾Ƽ� �Լ��� ����ϴ� �Լ�.
-- GROUP BY�� �ݵ�� ���� �־�� �Ѵ�.

-- �μ��� �ִ� ���� ���
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- �̸��� �ߺ��� ���� �ƴϱ� ������ ����� �ȵȴ� 
-- ������� �������� ���� ����ϴ� ���� �ǹ̰� ����.
-- �ִ�޿��� �޴� ����� �̸�(6��, �������� - ���� �ȿ� ������ ��)
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; 


-- �� 1. �׷��Լ��� �ǽ�

SELECT ROUND(AVG(SAL),2) FROM EMP;
-- EMP ���̺��� ��(ROW, �ο�) ��
SELECT COUNT(*) FROM EMP; -- 14
SELECT COUNT(EMPNO) FROM EMP; -- ��� �࿡ EMPNO�� �����ϱ� �̷��� ���� �� ����
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; -- NULL �� ���ϸ� NULL���� ���´�.
-- ��� ���� : SUM : 300+500+1400+0(2200)     AVG :  2200/4 = 550
-- ��� : ��� �׷��Լ��� NULL ���� �����ϰ� ����� �����Ѵ�.
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP; -- NULL�� ������ �Ի��� �Ѵ�
    
    -- SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, ����
    SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
    SELECT TRUNC(AVG(SAL),0) "���" ,SUM(SAL), MIN(SAL), MAX(SAL), 
    TRUNC(VARIANCE(SAL),2), TRUNC(STDDEV(SAL),2) 
    FROM EMP;
    -- 2100-1200 ~ 2100+1200 (68%)
    -- ������ Ȯ��
    SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
    -- SQRT : ��Ʈ�� �����ִ� �Լ�
    
    -- �׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ��� ��밡��
    -- NULL ���� �����ϰ� ��µȴ�
    -- ** ������, ������
    -- MIN(ENAME) : �ƽ�Ű�ڵ尡 ���� ���� ENAME ��
    SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME����, COUNT(COMM) COMM���� FROM EMP;
    -- ** ��¥��
    -- ���� ���� �� ���̴� �� �� �ִ�.
    SELECT MIN(HIREDATE) �����Ի���, MAX(HIREDATE) �ֱ��Ի���, COUNT(HIREDATE) FROM EMP;
    
    -- źź1. ���� �ֱٿ� �Ի��� ����� �Ի��ϰ� ���� ���� �Ի��� ����� �Ի��� ���
    SELECT MAX(HIREDATE) �ֱ��Ի���, MIN(HIREDATE) �����Ի��� FROM EMP;
    
    -- źź2. 83/01/12 �ֱ��Ի��� : XX,XXX�� �ٹ�, 80/12/17 �����Ի��� : XX,XXX�� �ٹ�
    SELECT MAX(HIREDATE) ||' �ֱ��Ի��� : '|| TO_CHAR(TRUNC((SYSDATE-MAX(HIREDATE))), '999,999')||'�� �ٹ�, '||
           MIN(HIREDATE) ||' �����Ի��� : '|| TO_CHAR(TRUNC((SYSDATE-MIN(HIREDATE))), '999,999')||'�� �ٹ�' AS "�ٹ��� ���"
        FROM EMP;
        
        -- �ٸ����1. TO_CHAR ���� �ڸ��� ������ ���� TRUC ���� �ʿ䰡 ����!
        SELECT MAX(HIREDATE) ||' �ֱ��Ի��� : '|| TO_CHAR(SYSDATE-MAX(HIREDATE), '999,999')||'�� �ٹ�, '||
               MIN(HIREDATE) ||' �����Ի��� : '|| TO_CHAR(SYSDATE-MIN(HIREDATE), '999,999')||'�� �ٹ�' AS "�ٹ��� ���"
        FROM EMP;
        -- �ٸ����2. �ٹ����� MIN��, �ٹ����� MAX���� �޾ƿ��� ���
        SELECT MAX(HIREDATE) ||' �ֱ��Ի��� : ' || 
                TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') ||'�� �ٹ�, ' || 
               MIN(HIREDATE) || '�����Ի���: ' ||
                TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') ||'�� �ٹ�'
            FROM EMP;

    -- ��� SAL�� ���
    SELECT AVG(SAL) FROM EMP; 
    -- 10�� �μ� �Ҽ��� ��� �޿� ���  
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10; -- FROM > WHERE > SELECT
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 20;
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 30;
    -- �� �μ����� ��� �޿� ��� >> GROUP BY!!!
    
-- �� 2. GROUP BY ��
-- �� �μ��� �ִ�޿�, �ּұ޿�, �޿� ���, �޿� ��
-- DEPTNO ���� �׷� �Լ��� ����
SELECT DEPTNO �μ���ȣ, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)) AVG, SUM(SAL) FROM EMP GROUP BY DEPTNO;
-- GROUP BY������ ��Ī ��� �Ұ�, WHERE�� ���� ����  
    -- EX. SAL�� 5000�̸��� ����� ���Ͽ� �μ���ȣ �� �����, �ִ�޿�, �ּұ޿�, ��ձ޿� ���
    --      (������ �μ���ȣ ������ ����)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)   -- �ʵ� ��Ī ��� ���� 
        FROM EMP 
        WHERE SAL < 5000                                    -- �ʵ� ��Ī ��� �Ұ�
        GROUP BY DEPTNO                                     -- �ʵ� ��Ī ��� �Ұ�
        ORDER BY DEPTNO;                                    -- �ʵ� �̸� OR ��Ī ��� ���� 
    
    -- EX. �μ���(DANME) �� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�Ҽ��� ���ڸ�) ���
    -- EQUI ���� Ȱ��, ������� ���� ������ ����
    SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;
    -- FROM > WHERE > GROUP BY > ORDER BY ������ ����
    
-- �� 3. HAVING �� : �׷��Լ� ����� ����
-- �μ���ȣ ���� ��� �޿� ��� (��� �޿��� 2000�̻��� �μ��� ���, ��� �޿� ������ ����)
-- GROUP BY �� �տ� WHERE �� �;� �Ѵ�. WHERE ������ GROUP�Լ� ������� ���Ѵ�.
SELECT DEPTNO, AVG(SAL) FROM EMP 
    WHERE AVG(SAL) >= 2000
    GROUP BY DEPTNO;
-- HAVING �� - �׷� �Լ��� ���Ǹ� �ȿ� ��� ����, ��Ī ��� �Ұ�, ������ GROUP BY ������ ��� ������!
SELECT DEPTNO, AVG(SAL) "AVG"
    FROM EMP 
    GROUP BY DEPTNO
    HAVING AVG(SAL) >= 2000        -- �ʵ� ��Ī ��� �Ұ�
    ORDER BY AVG;                  -- �ʵ� ��Ī ��� ����!
    
-- �� ���� ���� ����
    -- SAL�� 5000�̸��� ����� ���� �μ��� �� �ּұ޿�, �ִ�޿�, ��ձ޿� ���
    -- (��, ��ձ޿��� 1800 �̻��� �μ��� ���ؼ� ��ձ޿� ������ ���)
    SELECT DNAME, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),2) ��ձ޿�
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL < 5000
    GROUP BY DNAME
    HAVING ROUND(AVG(SAL),2) >= 1800    -- �׷��Լ��� ���� 
    ORDER BY ��ձ޿�;
    
-- �� 4. ��� ������ �� ���谪 ����
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
-- ��ü�հ� ���� ���
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO) ORDER BY DEPTNO;
    -- �μ���, JOB�� �޿���
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO; -- ������ �������� ORDER BY�� ����������
    -- �μ���, JOB�� �޿� (�Ұ�� ��ü�� ����)  // ���踦 ���� ������
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB); -- �˾Ƽ� DEPTNO ���� ��, ��ü �� ���
    SELECT DEPTNO, NVL(JOB, '��'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);


-- �� <�� ��������>
-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;

-- 2. ������ �ο����� ���Ͽ� ���
SELECT DEPTNO COUNT() FROM EMP;

--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL) - MIN(SAL) FROM EMP; 

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL),2), MIN(SAL), MAX(SAL), SUM(SAL) 
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
FROM EMP 
GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;

-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL) 
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY JOB, DEPTNO;

--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(DEPTNO) 
FROM EMP
GROUP BY DEPTNO 
HAVING COUNT(DEPTNO) >= 5;

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*) COUNT
FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO
GROUP BY DNAME
HAVING COUNT(*) >= 5;

--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, ROUND(AVG(SAL),2) AVG, SUM(SAL) SUM 
FROM EMP
GROUP BY JOB
HAVING ROUND(AVG(SAL),2) >= 3000;

--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL) �޿���
FROM EMP
GROUP BY JOB
HAVING SUM(SAL) > 5000
ORDER BY SUM(SAL) DESC;

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT ROUND(AVG(SAL),2) �޿����, SUM(SAL) �޿��հ�, MIN(SAL) �ּұ޿�
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT ROUND(MAX(AVG(SAL)),2) ����ִ�, MAX(SUM(SAL)) ���ִ�, MAX(MIN(SAL)) �ּ��ִ�
FROM EMP
GROUP BY DEPTNO;

--13. ��� ���̺��� �Ʒ��� ����� ���
--  H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	     1		    800		    800		    800		    800
--	81	     10		    950		    5000	    2282.5	  22825
--	82	     2		    1300	    3000	   2150		   4300
--	83	     1		    1100	    1100	    1100	   1100

SELECT SUBSTR(HIREDATE, 1,2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), 
       ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
FROM EMP
GROUP BY SUBSTR(HIREDATE, 1,2)
ORDER BY H_YEAR;

-- �ٸ� ��� 2
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE), 3,2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), 
       ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
FROM EMP
GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE), 3,2)
ORDER BY H_YEAR;

-- �ٸ� ���
SELECT TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL),
         ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
         FROM EMP
         GROUP BY TO_CHAR(HIREDATE, 'RR')
         ORDER BY H_YEAR;

-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	

SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total') �Ի�⵵, COUNT(*)
FROM EMP
GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY �Ի�⵵;

-- EXTRACT �� ���������� �ٲ�� ������ TO_CHAR�� �ν��� ���� �ʴ´�.

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL),2)
FROM EMP
ORDER BY DEPTNO;

--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >= 6
ORDER BY DEPTNO;

--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
-- ENAME	    ���
--________________________
-- KING		    1
-- SCOTT		2
--����
SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK 
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME
ORDER BY RANK;

-- Ǯ��
SELECT E1.ENAME, E1.SAL, E2.ENAME MANAGER, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+);
    -- E1 �������� ������ ������ �� / 1�ܰ�: SELF JOIN, OUTER JOIN
SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK -- ������ ���� �޴� ��� ��
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK;
    -- GROUP BY COUNT �ϼ��ܰ�
    
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK", 
    DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
    ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW+NUMBER" 
    FROM EMP;
-- RANK() OVER - �Լ� / �ӵ��� �������� ������ �־ 
-- ROW() OVER : ���̴� ��찡 ���� / ���� ����











    
    
    
    
    
    
    
    
    










