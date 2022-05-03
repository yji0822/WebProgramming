
-- [XII] TRANSACTION ��ɾ� : COMMIT (Ʈ����� �ݿ�); ROLLBACK(Ʈ����� ���); SAVEPOINT (Ʈ����� ����)

DROP TABLE DEPT01;                         -- ���̺� ���� DCL
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; -- CREATE : DDL�� ������ �ʴ´�.
SELECT * FROM DEPT01;                      -- 10,20,30,40 | SELECT : �����Ͱ� �߰��� �� Ȯ�� Ʈ�����X
DELETE FROM DEPT01;                        -- DELETE : Ʈ����ǿ� 1�� ����
SELECT * FROM DEPT01;                      -- �����ʹ� ���������� Ʈ������� ��ɾ �����Ͱ� �׿��ִ� ����.
ROLLBACK;                                  -- Ʈ����� ��� / ���ο� Ʈ����� ����

SELECT * FROM DEPT01;                      -- 10,20,30,40
DELETE FROM DEPT01 WHERE DEPTNO = 40;      -- DELETE : Ʈ����ǿ� ����
COMMIT;                                    -- ���ο� Ʈ����� ����. ���� �Ұ�

SELECT * FROM DEPT01;                      -- 10,20,30
DELETE FROM DEPT01 WHERE DEPTNO = 30;      -- DELETE 30 ����
SELECT * FROM DEPT01;                      -- 10,20
SAVEPOINT C1;                              -- C1 ���� ; 10, 20�� �μ�
DELETE FROM DEPT01 WHERE DEPTNO = 20;      -- DELETE 20 ����
SELECT * FROM DEPT01;                      -- 10
SAVEPOINT C2;                              -- C2���� : 10�� �μ�
DELETE FROM DEPT01 WHERE DEPTNO = 10;      -- DELETE 10 ����
SELECT * FROM DEPT01;                      -- ������ ����
ROLLBACK TO C2;                            -- 
SELECT * FROM DEPT01;                      -- 10    | 20�� �μ� ����  ���·� ���ư�
ROLLBACK TO C1;                            -- 
SELECT * FROM DEPT01;                      -- 10,20 | 30�� �μ� ���� ���·� ���ư�



