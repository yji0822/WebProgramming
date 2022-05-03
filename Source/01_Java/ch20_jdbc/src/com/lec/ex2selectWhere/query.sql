-- new > untitled text file
-- Ex1의 쿼리
-- 파일을 끌어다 developer에다가 놓기

-- EX1. 사용자에게 부서번호 입력받아 부서 정보 뿌리기
-- 실행되는지 이곳에서 확인한 후에 이클립스로 복사해서 넘어가기
SELECT * FROM DEPT WHERE DEPTNO = 30;

INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
COMMIT;
DELETE FROM DEPT WHERE DEPTNO = 50;
COMMIT;

-- EX2.
SELECT * FROM DEPT WHERE DEPTNO = 30; -- (1-1)
    -- 해당부서번호 사원의 정보 (사번, 이름, 급여, 상사명) self join
    SELECT W. EMPNO, W.ENAME, W.SAL, M.ENAME MANAGER
        FROM EMP W, EMP M
        WHERE W.MGR = M.EMPNO
            AND W.DEPTNO = 30; -- (1-2)
            
-- EX3.
-- upper : 사용자에게 어떤 형식으로 SALES를 입력 받던 대문자로 변환시켜줌. 
-- (1)
SELECT * FROM DEPT WHERE DNAME = UPPER('SALES'); 
-- (2)사번, 이름, 급여, 급여등급
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP E, SALGRADE, DEPT D
    WHERE SAL BETWEEN LOSAL AND HISAL 
        AND E.DEPTNO = D.DEPTNO
        AND DNAME = UPPER('sales'); 
        
SELECT EMPNO, ENAME, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
        AND DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = UPPER('sales'));












