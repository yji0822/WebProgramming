
-- [XI] �ε��� : ��ȸ�� ������ �ϱ� ���� ���!!!
--- �ε����� ������ �ʾƵ� �����̸Ӹ� Ű�� ����� �ڵ����� �ε����� ������.

SELECT * FROM USER_INDEXES; -- ��ųʸ� �信�� SCOTT�� ������ �ε��� ����
DESC EMP;

DROP TABLE EMP01;                                 -- �� ���� ������ ���̺� ����
CREATE TABLE EMP01 AS SELECT * FROM EMP;          -- �� EMP�� �����Ͱ� ���� EMP01 ����
SELECT * FROM EMP01;                              -- 14�� ��� ����� �� Ȯ��
INSERT INTO EMP01 SELECT * FROM EMP01;            -- �� ������ �ø��� �۾� : 1�� ���� > 28�� / 2�� ���� > 56��
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01; -- �� ���� Ȯ�� (TO_CHAR�� ������ ��� ����)
INSERT INTO EMP01 SELECT * FROM EMP01;            -- �� �� 11�� �������� ������ ��Ǯ���� 114,688
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40); 
INSERT INTO EMP01 SELECT * FROM EMP01;            -- �� 3�� ���� 917,512 ��

-- �ε��� ���� �� ��ȸ
SELECT * FROM EMP01 WHERE ENAME = 'HONG';      -- 0.016�� 
-- �ε��� ����(EMP01���̺��� ENAME)�ϰ� ��ȸ
CREATE INDEX IDX_EMP01_ENAME ON EMP01 (ENAME); -- 0.374��
-- �ε��� ���� �� ��ȸ
SELECT * FROM EMP01 WHERE ENAME = 'HONG';      -- 0.001��
-- ������ ��ųʸ��� �ε��� �߰��� �� Ȯ��
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
-- �ε��� ���� �� INSERT �ӵ�
COMMIT;                                 -- 90���� ������
INSERT INTO EMP01 SELECT * FROM EMP01;  -- 90���� �߰�, 22.572�� ���� �ҿ�
-- �ε��� ����
ROLLBACK;                               -- INSERT �Ѱ� ���� 90������ ���ƿ�. ��� �ӵ� 10�� �ҿ�
DROP INDEX IDX_EMP01_ENAME;             -- �ε��� ����
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01; -- �� ���� Ȯ��
INSERT INTO EMP01 SELECT * FROM EMP01;  -- �ε��� ���� �� INSERT �ӵ� : 2.8��




