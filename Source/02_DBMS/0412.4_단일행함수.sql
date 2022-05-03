-- [iv] ������ �Լ�
-- �Լ� = ������ �Լ� + �׷� �Լ�(�����Լ�)
    -- ������ �Լ� (INPUT 1�� -> OUTPUT 1��) - ���� �޾Ƽ� ���� ����ϴ� �� : 4��
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') FROM EMP; -- ������ �Լ� 
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- ������ �Լ�

    -- �׷��Լ� (INPUT N�� -> OUTPUT 1��) : 5��
SELECT SUM(SAL) FROM EMP; -- INPUT�� �������� �޾Ƽ� �ϳ��� ����� ����ϴ� �� // SUM�� �׷��Լ�
SELECT AVG(SAL) FROM EMP;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;



-- �ڡ� ������ �Լ� ���� : ���ڰ��� �Լ�, ���ڰ��� �Լ�, ��¥ ���� �Լ�(�����), ����ȯ �Լ�, NVL(), ETC. ... ��
-- 1. ���ڰ��� �Լ�
SELECT -9, ABS(-9) FROM EMP; -- ���� ��������.. ��ġ�� FROM���� �� ���� ��!
    -- DUAL ���̺� ��� �ҷ��� ��! (ORACLE���� �����ϴ� 1��1��¥�� DUMMY ���̺�) (CF) DUMMY
DESC DUAL; 
SELECT * FROM DUAL; -- �Լ� �׽�Ʈ ������ ��� ������ ���̺�
DESC DUMMY;
SELECT * FROM DUMMY; -- ���ڷ� ���� �ִ� DUMMY ���̺�
SELECT -9, ABS(-9) FROM DUAL; -- ABS() ���밪

-- ** �Ҽ��� ������ ��
-- FLOOR�̶� TRUNC ������ 
SELECT FLOOR(34.5678) FROM DUAL;           -- �Ҽ������� ���� / 34 ���
SELECT FLOOR(34.5678 * 100)/100 FROM DUAL; -- �Ҽ��� ���ڸ� ���ڿ��� ���� (�ڹٶ� ��� ����)
SELECT TRUNC(34.5678, 2) FROM DUAL;        -- �Ҽ��� �ι�° �ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;           -- �Ҽ������� ���� OR (34.5678, 0)
SELECT TRUNC(34, -1) FROM DUAL;            -- 1�� �ڸ����� ����
    -- EX. EMP ���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL, -2), SAL FROM EMP;-- 10�� �ڸ����� ����

-- �ø�
SELECT CEIL(34.5678) FROM DUAL; -- �Ҽ������� �ø�
SELECT CEIL(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �ø�

-- �ݿø�
SELECT ROUND(34.5678) FROM DUAL; -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL; -- ���� �ڸ����� �ݿø�

-- ������ ����
SELECT MOD(9,2) FROM DUAL; -- ������ ������ %
    -- EX. ����� Ȧ���� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(EMPNO,2) = 1; -- ����� ������ ���� �Ͽ�
SELECT * FROM EMP WHERE MOD(EMPNO, 2) != 0;
    -- EX. Ȧ�� �޿� �Ի��� ����� ��� �ʵ� ���
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

---------------------------------------------------------------------------------

-- 2. ���ڰ��� �Լ�
-- (1) ��ҹ��� ����
SELECT UPPER('abcde') FROM DUAL;
SELECT LOWER('ABCDE') FROM DUAL;
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- Welcome To Oracle
    -- EX. JOB�� 'MANAGER'�� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager'; -- ù��° ���ڸ� �빮��

-- (2) ���� ���� (CONCAT, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL; -- ��� ���� ����
SELECT CONCAT('AB', 'CD', 'EF', 'GH') FROM DUAL;  -- �ݵ�� �ΰ��� ���� ����
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT('EF', 'GH')) FROM DUAL;
    -- EX. �ƹ���(ENAME)�� XX(JOB)�̴�" �������� EMP ���̺� ���
SELECT CONCAT(CONCAT(ENAME, '��'), CONCAT(JOB, '�̴�.(��)')) FROM EMP;
SELECT ENAME ||'�� '|| JOB ||'�̴�(��)' FROM EMP;

-- (3) SUBSTR(STR, ���� ��ġ, ���� ����) ù��° ��ġ�� 1, ������ġ ���� ����
--     SUBSTRB(STR, ���� ����Ʈ ��ġ, ���� ����Ʈ ��)
--  O  R  A  C  L  E
--  1  2  3  4  5  6
-- -6 -5 -4 -3 -2 -1
SELECT SUBSTR('ORACLE', 3,2) FROM DUAL;     -- 3��° ���ں��� 2���� ���� // AC
SELECT SUBSTRB('ORACLE', 3,2) FROM DUAL;    -- 3��° ����Ʈ���� 2����Ʈ ���� // AC
SELECT SUBSTR('�����ͺ��̽�', 4,3) FROM DUAL;  -- 4��° ���ں��� 3���� ���� // ���̽�
SELECT SUBSTRB('�����ͺ��̽�', 4,3) FROM DUAL; -- 4��° ����Ʈ���� 3����Ʈ ���� // �� - (XE�������� 1���ڴ� 3BYTE)
SELECT SUBSTRB('ȫ�浿', 3,3) FROM DUAL;      -- 3����Ʈ�� �߶� �����;� �� // ��
SELECT SUBSTR('ABCDXD', -1,1) FROM DUAL;    -- D
-- ��¥�� ���ڿ� ��� ����
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- ���ڵ� ���� // 2
    -- EX. 9���� �Ի��� ����� ��� �ʵ� (��, DATE ��� FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4,2) = '09'; -- HIREDATE���� 4��° ���ڿ� �α��� ����
    -- EX. 9�Ͽ� �Ի��� ����� ��� �ʵ� (��, DATE ��� FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09'; -- �ڿ������� �̴� ���!

-- (4) ���� �� ���� �Լ� (LENGTH) VS ����Ʈ �� (LENGTHB)
SELECT LENGTH('ABC') FROM DUAL; -- ���ڼ� : 3
SELECT LENGTHB('ABC') FROM DUAL; -- ����Ʈ �� : 3
SELECT LENGTH('����Ŭ') FROM DUAL; -- ���� �� : 3
SELECT LENGTHB('����Ŭ') FROM DUAL; -- ����Ʈ �� : 9(���Ĺ����� 6)

-- (5) INSTR(STR, ã������) : STR���� ã�� ������ ��ġ(ù��° 1), ������ 0�� ���� == INDEX OF�� ���� �����ϸ� ��
--     INSTR(STR, ã������, ������ġ) : STR���� ������ġ���� ã�Ƽ� ã�� ������ ��ġ�� ��ȯ. ��ġ�� ���� ���� 
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- ó������ ã�Ƽ� ó�� ������ B�� ��ġ : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; -- �� 3��°���� ã�Ƽ� ó�� ������ B�� ��ġ : 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL; -- �ڿ��� 3��°���� �ڿ��� ������ ã�� ó�� ������ B�� ��ġ : 2
    -- EX. 9���� �Ի��� ����� ��� �ʵ�(INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09') = 4; -- ����, ���� �Ұ�
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4; -- 4��°�� ������!
    -- EX. 9�Ͽ� �Ի��� ����� ��� �ʵ�(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 7; -- 7��°�� ������!
    -- EX. 9���� �ƴ� �� �Ի��� ����� ��� �ʵ�(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 0;
SELECT * FROM EMP WHERE NOT INSTR(HIREDATE, '09', 7) = 7;

-- (6) LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���ڸ� ä���.
--     RPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�� ���� ���
SELECT LPAD('ORACLE', 10, '#') FROM DUAL; -- ####ORACLE
SELECT RPAD('ORACLE', 10, '#') FROM DUAL; -- ORACLE####
SELECT ENAME, SAL, LPAD(SAL, 6, '*') FROM EMP ORDER BY SAL DESC; -- LPAD ���� ����!
    -- EX. ���, �̸�(7788 S****, 7894 S****, �̸��� ��  �ѱ��ڸ� ����ϰ� �������� '*'���� ��� ) 
    -- 7369 S****
    -- 7839 K***
    -- 7934 M*****          RPAD, LENGTH, SUBSTR
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') FROM EMP;

    -- EX. ���, �̸�, �Ի��� (�̸��� 10�ڸ��� Ȯ���ϸ鼭 �̸� ���ڼ���ŭ '*'�� ä������ �Ǹ����� ���ڸ� ���
    --     (7892  _____****H  80/12/**)
    --     (7792  _____****T  81/12/**)
    -- LENGTH, SUBSTR....LENGTH, RAPD, TO_CHAR
SELECT EMPNO,
    LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') AS AFTER_ENAME, 
    RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') AS HIREDATE FROM EMP;
-- �ٸ� ���
SELECT EMPNO,
    LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') AS NAME, 
    TO_CHAR(HIREDATE, 'RR/MM/')||'**' "HIREDATE" FROM EMP;

    -- EX. �̸��� ����° �ڸ��� R�� ����� ��� �ʵ�(LIKE ���, INSTR ���, SUBSTR ���)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3; -- RARA ���� ��츦 ����

-- (7) �������� 
SELECT TRIM('    ORACLE DB      ') FROM DUAL;
SELECT RTRIM('    ORACLE DB      ') FROM DUAL;
SELECT LTRIM('    ORACLE DB      ') FROM DUAL;
-- ���� TRIM�� �ڹٿ��� �۾��� ���� �ڿ� �Ѱ��ش�

-- (8) REPLACE
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', '*') FROM EMP;

-----------------------------------------------------------------------------------

-- 3. ��¥ ���� �Լ� �� ����
-- (1) SYSDATE : ���� 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL; -- ���� ��¥�� �ð�

SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- ���󺹱�

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') AS ���ó�¥ FROM DUAL;
SELECT SYSDATE-1 "�����̽ð�", SYSDATE ����, SYSDATE+1 "�����̽ð�" FROM DUAL; -- ��¥ ��굵 �����ϴ�

-- (2) ��¥ ��� : 14�� ��
SELECT SYSDATE+14 "�ݳ�������" FROM DUAL;
    -- EX. �̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, SYSDATE-HIREDATE "�ٹ��ϼ�" FROM EMP; -- 15�� 22���� �������� �ֱ� ������ �Ҽ��� ����
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE),0) "�ٹ��ϼ�" FROM EMP;
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "�ٹ��ϼ�" FROM EMP;   
    -- EX. �̸�, �Ի���, �ٹ��� �� ��, �ٹ��� �� ��
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) �ٹ��ּ�, FLOOR((SYSDATE-HIREDATE)/365) "�ٹ����"
    FROM EMP;
    
-- (3) MONTHS_BETWEEN(��¥, ��¥) : �� ��¥ ���� ���� ��
    -- EX. �̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS �ٹ����� FROM EMP; -- ���糯¥, ���� ��¥ ���� ��Ű��
    -- EX. �̸�, �Ի��� ���� ���� �޿��� ��(�޿��� �Ŵ� SAL�� �ް�, COMM�� 1�⿡ 2ȸ ����)
SELECT ENAME, 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL + TRUNC((SYSDATE - HIREDATE)/365)*2*NVL(COMM,0) COST
    FROM EMP; -- �޿� + ��

-- (4) ADD_MONTHS(��¥, ���� ��) : Ư�� �������� ��� ���� ��¥ // 6���� �İ� �����̴�?
    -- EX. �̸�, �Ի���, ���� ������ (�����Ⱓ�� �Ի��Ϸκ��� 6������ �Ѵ�)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) AS "6������" FROM EMP;

-- (5) LAST_DAY(��¥) : Ư�� ��¥�� ���� ���� / 1�� 1���̸� 1�� 31�� ����ϴ�
SELECT LAST_DAY(SYSDATE) FROM DUAL; -- �̹����� �������� ���
    -- EX. �̸�, �Ի���, ù���޳�(���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;

-- (6) ROUND(��¥, XX) : ��¥ �ݿø� / TRUNC(��¥, XX) : ��¥ ����
-- ROUND
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL;    -- ��� :  ���� ��¥���� ���� ����� 1�� 1�� ��ȯ
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;   -- ��� : ���� ��¥���� ���� ����� 1�� (1~15���� �̹��� 1��, 16�� ���Ĵ� ������ 1��)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;     -- ��� : ���� ��¥���� ���� ����� �Ͽ���
SELECT ROUND(SYSDATE) FROM DUAL;            --  ��� :���� ����� 0�� (�����̸� ���� 0��, ���ĸ� ���� 0��)
SELECT TO_CHAR(ROUND(SYSDATE), 'RR/MM/DD HH24:MI') FROM DUAL;
-- TRUNC
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL;    -- ��� :  ���� 1�� 1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;   -- ��� : �̹��� 1�� 
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;     -- ��� : ���� �Ͽ���
SELECT TRUNC(SYSDATE) FROM DUAL;            --  ��� : ���� 0��

    -- EX1. �̸�, �Ի���, �Ի��� ���� 5��
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 "�Ի��� ���� 5��" FROM EMP;
    -- EX2. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 16��) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 AS "���޳�" FROM EMP; -- 1�� + 15��
    -- EX3. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 15��) �����޿� �پ�� �Ѵ�.
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "���޳�" FROM EMP; -- 15���� +1 ���༭ �����޿� ���� �� �ֵ��� �Ѵ�. 
    -- EX4. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 5��) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "���޳�" FROM EMP;
    -- EX5. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 20��) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "���޳�" FROM EMP;

-- (7) NEXT_DAY(��¥, '��') : Ư�� ��¥�κ��� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;


-------------------------------------------------------------------------------
-- 4. ����ȯ �Լ� (����, ����, ��¥)
-- (����<->��¥, ����<->����)
-- (1) TO_CHAR(��¥�� ������, '�������') /// SIMPLEDATEFORMAT
    -- YYYY(�⵵ 4�ڸ�) YY(�⵵ 2�ڸ�) RR(���� 2�ڸ�) / MM(��) DD(��) / DAY(����) DY(���� ��� ǥ��)
    -- AM/PM (����/����) / HH12(12�ð�) HH24(24�ð�) / MI(��) SS(��)
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" AM HH12:MI:SS') FROM DUAL;

-- (2) TO_CHAR(���� ������, '�������')
    -- 0 : �ڸ���. ��������� �ڸ����� ������ 0���� ä��
    -- 9 : �ڸ���. ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� ä�� (�Ҽ��� ���� �̾߱�)
    -- , : ���ڸ����� , ����. 
    -- . : �Ҽ���
    -- $ : ��ȭ������ $�� �տ� ���� �� ����
    -- L : (��ҹ��ڱ���X) ������ȭ ������ �տ� ���� �� ����
SELECT TO_CHAR(123456, '9,999,999.99') FROM DUAL; --  123,456.00   �Ҽ��� ���ڸ��� �� ������ ���� ��� ������ ���·� ����
SELECT TO_CHAR(123456, '0,000,000.00') FROM DUAL; --  0,123,456.00 �Ҽ��� ���ڸ��� �� ������ ������ 0���� ���

SELECT TO_CHAR(10000, 'L9999,999') FROM DUAL; -- ��10,000
SELECT TO_CHAR(SAL, '$99,999') FROM EMP;
DESC EMP; -- ���ڿ��� ���缭 ���� �ۼ��� ���־�� �Ѵ�. (DESC�� Ȯ�� �ѹ� �� �ϱ�)

-- (3) TO_DATE(���ڵ�����, '����')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD') FROM DUAL; -- �ð��� �⺻������ 00�� 00������ ����.
    -- EX. 81/5/1 ~ 83/5/1 ���̿� �Ի��� ������ ��� �ʵ� (TO_DATA ���)
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('810501', 'RRMMDD')
        AND TO_DATE('83/05/01', 'RR/MM/DD');

-- (4) TO_NUMBER(����, '����')
SELECT TO_NUMBER('1,234', '9,999')+1 FROM DUAL;

-------------------------------------------------------------------------------
-- 5. NVL(�� �ϼ��� �ִ� ������, ���̸� ����� ��) - �Ű����� 2���� Ÿ�� ��ġ
SELECT ENAME, NVL(COMM, 0) FROM EMP;
    -- EX. �̸�, ����� ���(MGR)�� ����ϵ�, ����� ����� NULL�� ���, 'CEO'�� ��� ���
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;
    

--------------------------------------------------------------------------------    
-- 6. ETC...
-- (1) EXTRACT : ������ ��, ��¥�� ���ڷ� �����ϰ��� �� ��! // ����� �����̴�!
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL; -- 2022
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT(MONTH FROM HIREDATE) FROM EMP; -- ���� �̾Ƽ� ���
SELECT EXTRACT(DAY FROM HIREDATE) FROM EMP;
    -- EX. 8���� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '02';
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
    -- EX. 81�⵵�� �Ի��� ������ ��� �ʵ�
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81';
    SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981; -- 4�ڸ� ��� �����;� �Ѵ�.

-- (2) ������ ���(������ ���) : LEVEL, START WITH ����(MGR IS NULL), CONNECT BY PRIOR ����(EMPNO = MGR)
SELECT LEVEL, LPAD('��', LEVEL*2)||ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR; -- ���������� ����Ѱ� ���� ����
    -- �亯�� ���� �������� ��� / �Ѱ� : �ֽű��� ��ܿ� ���� ó������ ��ܿ� ���� ����
    

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
    -- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, 
    ADD_MONTHS(HIREDATE, 6) "6������", 
    TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY')+8 "���ƿ��� ������" 
    FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�������", 
    TO_CHAR(SAL, '$999,999') "SAL", 
    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL, '$999,999,999') "���ݱ��������޿�"
    FROM EMP;

--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') AS SAL, SAL FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, HIREDATE FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) ���ڼ�, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM,0) FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') "�Ի���" FROM EMP;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') SAL FROM EMP WHERE DEPTNO = 20;
    

-------------------------------------------------------------------------------
    -- <�� ��������> // �ؼ�
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, 
    ADD_MONTHS(HIREDATE, 6) "6������", 
    TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY')+8 "���ƿ��� ������" 
    FROM EMP;
    
    SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6MONTHSLATERMON" FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE,
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�������", 
    TO_CHAR(SAL, '$999,999') "SAL", 
    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL, '$999,999,999') "���ݱ��������޿�"
    FROM EMP;

--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') AS SAL, SAL FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, HIREDATE FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME) ���ڼ�, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM,0) FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12'; 
-- �ý��ۿ� ���� DATE FORMAT�� �ٸ� �� �����Ƿ� �� ��� ��õ!
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '12';
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') "�Ի���" FROM EMP;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)    
DESC EMP; -- ���ڸ����� �ִ��� Ȯ���� ����� �Ѵ�
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') SAL FROM EMP WHERE DEPTNO = 20;
    
    















