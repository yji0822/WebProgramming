-- oracle test

SELECT * FROM EMP;

-- SELECT_ALL
-- EX1. EMP 테이블 출력
SELECT * FROM EMP;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP;

SELECT * FROM DEPT;

-- SELECT_DEPTNO : 사용자에게 원하는 부서번호를 입력받아 부서정보 출력
SELECT * FROM DEPT WHERE DEPTNO = 10;

-- SELECT_DEPTNO_EMP
-- 사용자에게 부서번호 입력받아
-- 1-1 해당부서번호가 존재할 경우 : 해당부서정보와 해당부서 사원(사번, 이름, 급여, 상사명)
-- 1-2 해당부서번호가 존재하지 않을 경우 : 없다고 출력

SELECT * FROM DEPT WHERE DEPTNO = 10;

SELECT W.EMPNO, W.ENAME, W.SAL, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO
    AND W.DEPTNO = 30;
    
-- SELECT_DNAME_EMP
-- 1. 사용자에게 부서명을 입력받아
-- * 		1-1. 부서존재하는 경우 : 부서정보와 사원정보(사번, 이름, 급여, 급여등급)를 출력
-- * 		1-2. 부서존재하지 않는 경우 : 없다고 출력

SELECT * FROM DEPT WHERE DNAME = UPPER('SALES');

SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, DEPT D, SALGRADE S
    WHERE E.DEPTNO = D.DEPTNO
    AND E.SAL BETWEEN LOSAL AND HISAL
    AND DNAME = UPPER('SALES');
    
SELECT ENAME, DNAME FROM EMP E, DEPT D
 WHERE E.DEPTNO = D.DEPTNO
 AND DNAME = 'SALES';
 
 -- EX5_insertDept
SELECT * FROM DEPT;
 
INSERT INTO DEPT VALUES (10, 'LOVE', 'SEOUL');

-- Ex6_InsertDept2
-- 부서번호를 입력받아 중복체크 진행 후 부서정보 입력 진행

SELECT * FROM DEPT WHERE DEPTNO = 10;

INSERT INTO DEPT VALUES (10, 'LOVE; 'SEOUL');

SELECT * FROM DETP WH 
 
 
 
 