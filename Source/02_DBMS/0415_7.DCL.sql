-- scott2�� ���� ��ųʸ� �� Ȯ��
show user; -- SCOTT2 Ȯ��
SELECT * FROM USER_TABLES; -- SCOTT2�� ������ �ִ� ���̺�
SELECT * FROM ALL_TABLES;  -- SCOTT2�� ACCESS�� �� �ִ� ���̺�
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP'); -- DEPT���̺��̶� EMP���̺� �����ϴ��� 
SELECT * FROM SCOTT.EMP;   -- SCOTT ������ �ִ� EMP���̺��� �ҷ����� ��. (������ �ο��޾ұ� ������!)
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D WHERE E.DEPTNO = D.DEPTNO;
EXIT; -- Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production���� ���� ������ // ���� â������ �������� 




















