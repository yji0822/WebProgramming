
-- INSERTDEPT.JAVA
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');

-- �ִ� �μ���ȣ�� ���� ��� �����̸Ӹ�Ű �������� �������� ������ �߻��Ǵ� �� Ȯ��
-- ORA-00001: unique constraint (SCOTT.SYS_C006997) violated
SELECT * FROM DEPT;
ROLLBACK;

DELETE FROM DEPT WHERE DEPTNO = 60 AND DEPTNO = 70;

-- InsertDept2.java
-- �μ���ȣ �ߺ� üũ
-- 1.
SELECT * FROM DEPT WHERE DEPTNO = 70; 
-- rs.next() ����� true (�ߺ� �޼��� ���)/ false : �μ���, �μ���ġ �Է� ����
-- 2.
SELECT COUNT(*) "CNT" FROM DEPT WHERE DEPTNO = 70; -- �ݵ�� 1�� ��� (�������)
-- �Է�
-- INSERT�� �����ϴ�.
INSERT INTO DEPT VALUES (55, 'IT', 'SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;

-- �������� UPDATEDEPT.JAVA
UPDATE DEPT SET DNAME = 'ABC', LOC = 'SEOUL' WHERE DEPTNO = 90;
COMMIT;
SELECT * FROM DEPT;


-- Ex5. DeleteDept.java
SELECT * FROM DEPT;
DELETE FROM DEPT WHERE DEPTNO = 70;
rollback; 
-- ROLLBACK OR COMMIT�� �ݵ�� ����� JAVA���� ������ �������� �ʴ´�.


-- ex6preparedstatement Ex2_select
-- ����ڷκ��� �μ����� �Է¹޾� 
-- �ش� �μ� ����� ���, �̸�, ��å, �޿��� ����Ͻÿ�
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');





