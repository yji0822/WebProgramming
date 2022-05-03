
-- [XII] TRANSACTION 명령어 : COMMIT (트랜잭션 반영); ROLLBACK(트랜잭션 취소); SAVEPOINT (트랜잭션 분할)

DROP TABLE DEPT01;                         -- 테이블 삭제 DCL
CREATE TABLE DEPT01 AS SELECT * FROM DEPT; -- CREATE : DDL은 쌓이지 않는다.
SELECT * FROM DEPT01;                      -- 10,20,30,40 | SELECT : 데이터가 추가된 것 확인 트랜잭션X
DELETE FROM DEPT01;                        -- DELETE : 트랜잭션에 1개 쌓임
SELECT * FROM DEPT01;                      -- 데이터는 지워졌지만 트랜잭션의 명령어에 데이터가 쌓여있는 상태.
ROLLBACK;                                  -- 트랜잭션 비움 / 새로운 트랜잭션 시작

SELECT * FROM DEPT01;                      -- 10,20,30,40
DELETE FROM DEPT01 WHERE DEPTNO = 40;      -- DELETE : 트랜잭션에 쌓임
COMMIT;                                    -- 새로운 트랜잭션 시작. 복구 불가

SELECT * FROM DEPT01;                      -- 10,20,30
DELETE FROM DEPT01 WHERE DEPTNO = 30;      -- DELETE 30 삭제
SELECT * FROM DEPT01;                      -- 10,20
SAVEPOINT C1;                              -- C1 지점 ; 10, 20번 부서
DELETE FROM DEPT01 WHERE DEPTNO = 20;      -- DELETE 20 삭제
SELECT * FROM DEPT01;                      -- 10
SAVEPOINT C2;                              -- C2지점 : 10번 부서
DELETE FROM DEPT01 WHERE DEPTNO = 10;      -- DELETE 10 삭제
SELECT * FROM DEPT01;                      -- 데이터 없음
ROLLBACK TO C2;                            -- 
SELECT * FROM DEPT01;                      -- 10    | 20번 부서 지운  상태로 돌아감
ROLLBACK TO C1;                            -- 
SELECT * FROM DEPT01;                      -- 10,20 | 30번 부서 지운 상태로 돌아감



