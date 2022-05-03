
-- INSERTDEPT.JAVA
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');

-- 있는 부서번호를 넣을 경우 프라이머리키 제약조건 위반으로 에러가 발생되는 것 확인
-- ORA-00001: unique constraint (SCOTT.SYS_C006997) violated
SELECT * FROM DEPT;
ROLLBACK;

DELETE FROM DEPT WHERE DEPTNO = 60 AND DEPTNO = 70;

-- InsertDept2.java
-- 부서번호 중복 체크
-- 1.
SELECT * FROM DEPT WHERE DEPTNO = 70; 
-- rs.next() 결과가 true (중복 메세지 출력)/ false : 부서명, 부서위치 입력 진행
-- 2.
SELECT COUNT(*) "CNT" FROM DEPT WHERE DEPTNO = 70; -- 반드시 1행 출력 (예제사용)
-- 입력
-- INSERT와 동일하다.
INSERT INTO DEPT VALUES (55, 'IT', 'SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;

-- 수정로직 UPDATEDEPT.JAVA
UPDATE DEPT SET DNAME = 'ABC', LOC = 'SEOUL' WHERE DEPTNO = 90;
COMMIT;
SELECT * FROM DEPT;


-- Ex5. DeleteDept.java
SELECT * FROM DEPT;
DELETE FROM DEPT WHERE DEPTNO = 70;
rollback; 
-- ROLLBACK OR COMMIT을 반드시 해줘야 JAVA에서 동작이 중지되지 않는다.


-- ex6preparedstatement Ex2_select
-- 사용자로부터 부서명을 입력받아 
-- 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');





