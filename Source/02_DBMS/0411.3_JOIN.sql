
-- [iii] JOIN : 테이블 2개 이상을 연결하여 검색
SELECT * FROM EMP; -- 부서 이름은 나오지 않음
SELECT * FROM DEPT;

SELECT * FROM EMP WHERE ENAME = 'SCOTT'; -- 부서번호(DEPTNO 20)
SELECT * FROM DEPT; -- SQL문을 두번 작성해야하는 번거로움
-- CROSS JOIN (FROM 절에 그냥 두개 이상의 테이블을 적어주는 것)
SELECT * FROM EMP, DEPT WHERE ENAME = 'SCOTT';
-------------- 1 -- 4 -------------------------------------
-- 1개의 행에 DEPT가 4개가 모두 다 따라온다
SELECT * FROM EMP, DEPT; -- 56행출력..... CROSS JOIN 14*4행 출력


-- ★★★ 1. EQUI JOIN (동등조인: 공통필드엔 DEPTNO값이 일치되는 조건만 JOIN)★★★
SELECT * FROM EMP, DEPT WHERE ENAME ='SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO; -- DEPTNO가 중복되어 출력되는 것을 알 수 있다.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO; -- 중복된 것 제거하고 출력하는 것

-- FROM절의 테이블에 별칭을 주는 것
-- 테이블의 별칭이 있으면 별칭으로만 테이블을 엑세스할 수 있다.
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, COMM, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO; -- 필드가 아니기 때문에 그냥 띄어쓰기로 구분
    -- EX. 급여가 2000이상인 직원만 이름, 직책(JOB), 급여, 부서명, 근무지 출력
SELECT ENAME, JOB, SAL, DNAME, LOC 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL >= 2000; -- 테이블 조인조건부터 WHERE에 적어주기!!
    -- EX. LOC이 'CHICAGO'인 사람의 이름, 업무, 급여, 부서번호, 근무지를 출력
SELECT ENAME, JOB, SAL, D.DEPTNO, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';
    -- EX. 부서번호 10이거나 20번인 사원의 이름, 업무, 근무지, 급여 (급여순 정렬)
SELECT ENAME, JOB, LOC, SAL FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO IN(10,20) 
    ORDER BY SAL; -- E.DEPTNO = D.DEPTNO 상관없다.
    -- EX. JOB이 SALESMAN 이거나 MANAGER인 사원의 이름, 급여, 상여, 연봉((SAL+COMM)*12), 부서명
    --     근무지를 출력(연봉이 큰 순으로 정렬)
SELECT ENAME, SAL, NVL(COMM,0) 상여, (SAL+NVL(COMM,0)*12) AS 연봉, DNAME, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN('SALESMAN', 'MANAGER');
    -- EX. COMM이 NULL이고 급여가 1200 이상인 사원의 이름, 급여, 입사일, 부서번호, 부서명 출력
    --    (부서명순, 부서명이 같을 시에는 급여 큰 순 정렬) ***
SELECT * FROM EMP;
SELECT ENAME, SAL, HIREDATE, E.DEPTNO, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >= 1200 ORDER BY DNAME, SAL DESC;
    -- EX. 'NEW YORK'에서 근무하는 사원의 이름과 급여 출력
SELECT ENAME, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    -- EX. 'ACCOUNTING' 부서 소속의 사원 이름과 입사일 출력
SELECT ENAME, HIREDATE FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
    -- EX. 직급(JOB)이 MANAGER인 사원의 이름, 부서명 출력
SELECT ENAME, DNAME FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
    -- EX. COMM이 NULL이 아닌 사원의 이름, 급여, 부서번호, 근무지 출력
SELECT ENAME, E.DEPTNO, LOC FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND NOT COMM IS NULL;


-- ★ 2. NON-EQUI JOIN
SELECT * FROM EMP WHERE ENAME = 'SCOTT';
SELECT * FROM SALGRADE; -- 급여 등급 정보 GRADE, LOSAL, HISAL
-- CROSS JOIN = EMP의 1행 * SALGRADE의 5행
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT'; -- CROSS JOIN 원하는 정보만을 얻고 싶을때가 나오지 않음
SELECT * FROM EMP, SALGRADE WHERE ENAME = 'SCOTT' AND SAL BETWEEN LOSAL AND HISAL; -- 월급이 3000인 경우의 등급을 출력해주는 것
    -- EX. 모든 사원의 사번, 이름, JOB, 상사사번, 급여, 급여등급(1등급,,,2등급..)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE || '등급' GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
-- 탄탄다지기
--	Comm이 null이 아닌 사원의 이름, 급여, 등급, 부서번호, 부서이름, 근무지를 출력하시오.

--	이름, 급여, 입사일, 급여등급

--	이름, 급여, 입사일, 급여등급, 부서명, 근무지

--	이름, 급여, 등급, 부서코드, 근무지. 단 comm 이 null아닌 경우

--	이름, 급여, 급여등급, 연봉, 부서명, 부서별 출력, 부서가 같으면 연봉순. 연봉=(sal+comm)*12 comm이 null이면 0

--	이름, 업무, 급여, 등급, 부서코드, 부서명 출력. 급여가 1000~3000사이. 정렬조건 : 부서별, 부서같으면 업무별, 업무같으면 급여 큰순

--	이름, 급여, 등급, 입사일, 근무지. 81년에 입사한 사람. 등급 큰순


-- ★ 3. SELF JOIN 
SELECT EMPNO 사번, ENAME 이름, MGR 상사사번 FROM EMP; -- 상사사번이랑 같이 
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'SMITH'; -- SMITH 상사 7902
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;  -- 아주 불편
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME 
    FROM EMP WORKER, EMP MANAGER  
    WHERE WORKER.ENAME = 'SMITH' AND WORKER.MGR = MANAGER.EMPNO; -- FROM절은 별칭 붙이기 가능
    -- EX. 모든 사원의 사번, 이름, 상사사번, 상사이름 (13행만 출력됨 >>> MGR이 NULL인 친구가 있음
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;


--  ★ 4. OUTER JOIN : 조인시 조건에 만족하지 않은 행까지 나타나게 해주는 것
-- 3.번 해결책
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+); -- 적은 쪽에 (+)를 해준다!!!
    
    SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO; -- 말단사원들은 사원으로는 존재하나, MGR로는 존재하지 않는다.

-- 1. EQUI JOIN 해결방법
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO(+) = D.DEPTNO;
SELECT * FROM DEPT; -- 40번이 존재하지만. 40번 부서에 사람이 없어서 출력이 안됨








