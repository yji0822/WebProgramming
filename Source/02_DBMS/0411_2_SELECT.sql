SELECT * FROM EMP;

-- *** ### 04-11 �������� ### *** (�� �����ϱ�!!!!)

--1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;

--2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = 7788; -- '7788'�� �ص� �ȴ�.

--3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL FROM EMP 
WHERE (SAL*12+NVL(COMM,0)) >= 24000 ORDER BY SAL;

--4.	�Ի����� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01'
ORDER BY HIREDATE;

SELECT ENAME, JOB, HIREDATE FROM EMP
WHERE HIREDATE BETWEEN TO_DATE('81/02/20', 'RR/MM/DD') AND TO_DATE('81/05/01', 'RR/MM/DD') ORDER BY HIREDATE;
-- ���� ���ڸ��� �� ���� RR, ���� 4�ڸ��� ����ϰ� �������� YYYY �� ���ִ� ���� ����.

--5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20 ORDER BY ENAME;

--6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
-- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME AS employee, SAL as "Monthly Salary" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN(10,30);
SELECT ENAME AS EMPLOYEE, SAL AS "MONTHLY SALARY" FROM EMP WHERE SAL>=1500 AND (DEPTNO=10 OR DEPTNO=30);
-- ��Ī�� ���Ⱑ �����Ѵٸ� �ݵ�� �ֵ���ǥ�� �����־�� �Ѵ�.

--7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE('82/%');
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') LIKE '82';

--8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿��� �޿�, �̸������� ����
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME <> 'Q' ORDER BY SAL, ENAME;

--9.	comm�� sal�� 10% ���� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
--      ����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL*1.1;

--10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP WHERE JOB = 'CLERK' OR JOB = 'ANALYST' AND SAL NOT IN (1000,3000,5000); 
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);

--11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� �����
--      ��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;

--12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81';

--13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
WHERE HIREDATE LIKE '81/%' AND NOT JOB LIKE 'SALESMAN';

--14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
--      �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE ASC;

--15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%'; -- N�� ����°�� ������ _�� �ΰ�!

--16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

--17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 AS ���� FROM EMP WHERE SAL*12 >= 35000;









