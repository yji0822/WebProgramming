-- scott2로 들어와 딕셔너리 뷰 확인
show user; -- SCOTT2 확인
SELECT * FROM USER_TABLES; -- SCOTT2가 가지고 있는 테이블
SELECT * FROM ALL_TABLES;  -- SCOTT2가 ACCESS할 수 있는 테이블
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP'); -- DEPT테이블이랑 EMP테이블 존재하는지 
SELECT * FROM SCOTT.EMP;   -- SCOTT 계정에 있는 EMP테이블을 불러오는 것. (권한을 부여받았기 때문에!)
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D WHERE E.DEPTNO = D.DEPTNO;
EXIT; -- Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production에서 접속 해제됨 // 접속 창에서도 접속해제 




















