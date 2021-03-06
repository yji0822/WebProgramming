-- [Ⅴ] 그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- 단일행 함수(4장)
SELECT MAX(SAL) FROM EMP;              -- 그룹함수(5장) MAX

-- 다중행을 받아서 함수를 출력하는 함수.
-- GROUP BY를 반드시 적어 주어야 한다.

-- 부서별 최대 월급 출력
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO;
-- 이름은 중복된 것이 아니기 때문에 출력이 안된다 
-- 단일행과 다중행을 같이 사용하는 것은 의미가 없다.
-- 최대급여를 받는 사람의 이름(6장, 서브쿼리 - 쿼리 안에 쿼리가 들어감)
SELECT ENAME, MAX(SAL) FROM EMP GROUP BY ENAME; 


-- ★ 1. 그룹함수들 실습

SELECT ROUND(AVG(SAL),2) FROM EMP;
-- EMP 테이블의 행(ROW, 로우) 수
SELECT COUNT(*) FROM EMP; -- 14
SELECT COUNT(EMPNO) FROM EMP; -- 모든 행에 EMPNO가 있으니까 이렇게 써줄 수 있음
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP; -- NULL 을 합하면 NULL값이 나온다.
-- 결과 예상 : SUM : 300+500+1400+0(2200)     AVG :  2200/4 = 550
-- 결과 : 모든 그룹함수는 NULL 값을 제외하고 계산을 진행한다.
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP; -- NULL은 빼놓고 게산을 한다
    
    -- SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 개수
    SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
    SELECT TRUNC(AVG(SAL),0) "평균" ,SUM(SAL), MIN(SAL), MAX(SAL), 
    TRUNC(VARIANCE(SAL),2), TRUNC(STDDEV(SAL),2) 
    FROM EMP;
    -- 2100-1200 ~ 2100+1200 (68%)
    -- 같은지 확인
    SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP;
    -- SQRT : 루트를 씌워주는 함수
    
    -- 그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 사용가능
    -- NULL 값은 제외하고 출력된다
    -- ** 문자형, 숫자형
    -- MIN(ENAME) : 아스키코드가 제일 작은 ENAME 순
    SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME개수, COUNT(COMM) COMM개수 FROM EMP;
    -- ** 날짜형
    -- 최초 구매 등 쓰이는 빈도 좀 있다.
    SELECT MIN(HIREDATE) 최초입사일, MAX(HIREDATE) 최근입사일, COUNT(HIREDATE) FROM EMP;
    
    -- 탄탄1. 가장 최근에 입사한 사원의 입사일과 가장 최초 입사한 사원의 입사일 출력
    SELECT MAX(HIREDATE) 최근입사일, MIN(HIREDATE) 최초입사일 FROM EMP;
    
    -- 탄탄2. 83/01/12 최근입사일 : XX,XXX일 근무, 80/12/17 최초입사일 : XX,XXX일 근무
    SELECT MAX(HIREDATE) ||' 최근입사일 : '|| TO_CHAR(TRUNC((SYSDATE-MAX(HIREDATE))), '999,999')||'일 근무, '||
           MIN(HIREDATE) ||' 최초입사일 : '|| TO_CHAR(TRUNC((SYSDATE-MIN(HIREDATE))), '999,999')||'일 근무' AS "근무일 출력"
        FROM EMP;
        
        -- 다른방법1. TO_CHAR 에서 자르기 때문에 굳이 TRUC 해줄 필요가 없다!
        SELECT MAX(HIREDATE) ||' 최근입사일 : '|| TO_CHAR(SYSDATE-MAX(HIREDATE), '999,999')||'일 근무, '||
               MIN(HIREDATE) ||' 최초입사일 : '|| TO_CHAR(SYSDATE-MIN(HIREDATE), '999,999')||'일 근무' AS "근무일 출력"
        FROM EMP;
        -- 다른방법2. 근무일의 MIN값, 근무일의 MAX값을 받아오는 방식
        SELECT MAX(HIREDATE) ||' 최근입사일 : ' || 
                TO_CHAR(MIN(SYSDATE-HIREDATE), '99,999') ||'일 근무, ' || 
               MIN(HIREDATE) || '최초입사일: ' ||
                TO_CHAR(MAX(SYSDATE-HIREDATE), '99,999') ||'일 근무'
            FROM EMP;

    -- 모든 SAL의 평균
    SELECT AVG(SAL) FROM EMP; 
    -- 10번 부서 소속의 사원 급여 평균  
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 10; -- FROM > WHERE > SELECT
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 20;
    SELECT AVG(SAL) FROM EMP WHERE DEPTNO = 30;
    -- 각 부서마다 사원 급여 평균 >> GROUP BY!!!
    
-- ★ 2. GROUP BY 절
-- 각 부서의 최대급여, 최소급여, 급여 평균, 급여 합
-- DEPTNO 별로 그룹 함수들 수행
SELECT DEPTNO 부서번호, MAX(SAL), MIN(SAL), ROUND(AVG(SAL)) AVG, SUM(SAL) FROM EMP GROUP BY DEPTNO;
-- GROUP BY절에는 별칭 사용 불가, WHERE절 수행 가능  
    -- EX. SAL이 5000미만인 사원에 대하여 부서번호 별 사원수, 최대급여, 최소급여, 평균급여 출력
    --      (순서는 부서번호 순으로 정렬)
    SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), AVG(SAL)   -- 필드 별칭 사용 가능 
        FROM EMP 
        WHERE SAL < 5000                                    -- 필드 별칭 사용 불가
        GROUP BY DEPTNO                                     -- 필드 별칭 사용 불가
        ORDER BY DEPTNO;                                    -- 필드 이름 OR 별칭 사용 가능 
    
    -- EX. 부서명(DANME) 별 사원수, 최대급여, 최소급여, 평균급여(소수점 두자리) 출력
    -- EQUI 조인 활용, 사원수가 많은 곳부터 정렬
    SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;
    -- FROM > WHERE > GROUP BY > ORDER BY 순으로 수행
    
-- ★ 3. HAVING 절 : 그룹함수 결과의 조건
-- 부서번호 별로 평균 급여 출력 (평균 급여가 2000이상인 부서만 출력, 평균 급여 순으로 정렬)
-- GROUP BY 절 앞에 WHERE 이 와야 한다. WHERE 절에는 GROUP함수 사용하지 못한다.
SELECT DEPTNO, AVG(SAL) FROM EMP 
    WHERE AVG(SAL) >= 2000
    GROUP BY DEPTNO;
-- HAVING 절 - 그룹 함수의 조건만 안에 사용 가능, 별칭 사용 불가, 가능한 GROUP BY 다음에 사용 해주자!
SELECT DEPTNO, AVG(SAL) "AVG"
    FROM EMP 
    GROUP BY DEPTNO
    HAVING AVG(SAL) >= 2000        -- 필드 별칭 사용 불가
    ORDER BY AVG;                  -- 필드 별칭 사용 가능!
    
-- 총 응용 연습 문제
    -- SAL이 5000미만인 사원에 대해 부서명 별 최소급여, 최대급여, 평균급여 출력
    -- (단, 평균급여가 1800 이상인 부서명에 대해서 평균급여 순으로 출력)
    SELECT DNAME, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),2) 평균급여
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL < 5000
    GROUP BY DNAME
    HAVING ROUND(AVG(SAL),2) >= 1800    -- 그룹함수에 대한 
    ORDER BY 평균급여;
    
-- ★ 4. 결과 집계합 내 집계값 생성
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;
-- 전체합계 까지 출력
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO) ORDER BY DEPTNO;
    -- 부서별, JOB별 급여합
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO; -- 가독성 떨어져서 ORDER BY로 정렬해주자
    -- 부서별, JOB별 급여 (소계와 전체합 포함)  // 집계를 따로 나누기
    SELECT DEPTNO, JOB, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB); -- 알아서 DEPTNO 마다 합, 전체 합 출력
    SELECT DEPTNO, NVL(JOB, '계'), SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO, JOB);


-- ★ <총 연습문제>
-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL) FROM EMP;

-- 2. 업무별 인원수를 구하여 출력
SELECT DEPTNO COUNT() FROM EMP;

--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL) - MIN(SAL) FROM EMP; 

-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL),2), MIN(SAL), MAX(SAL), SUM(SAL) 
FROM EMP
GROUP BY DEPTNO
ORDER BY SUM(SAL) DESC;

-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL) 
FROM EMP 
GROUP BY DEPTNO, JOB 
ORDER BY DEPTNO, JOB;

-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*), AVG(SAL), SUM(SAL) 
FROM EMP
GROUP BY JOB, DEPTNO
ORDER BY JOB, DEPTNO;

--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(DEPTNO) 
FROM EMP
GROUP BY DEPTNO 
HAVING COUNT(DEPTNO) >= 5;

-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*) COUNT
FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO
GROUP BY DNAME
HAVING COUNT(*) >= 5;

--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(SAL),2) AVG, SUM(SAL) SUM 
FROM EMP
GROUP BY JOB
HAVING ROUND(AVG(SAL),2) >= 3000;

--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL) 급여합
FROM EMP
GROUP BY JOB
HAVING SUM(SAL) > 5000
ORDER BY SUM(SAL) DESC;

--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT ROUND(AVG(SAL),2) 급여평균, SUM(SAL) 급여합계, MIN(SAL) 최소급여
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT ROUND(MAX(AVG(SAL)),2) 평균최대, MAX(SUM(SAL)) 합최대, MAX(MIN(SAL)) 최소최대
FROM EMP
GROUP BY DEPTNO;

--13. 사원 테이블에서 아래의 결과를 출력
--  H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	     1		    800		    800		    800		    800
--	81	     10		    950		    5000	    2282.5	  22825
--	82	     2		    1300	    3000	   2150		   4300
--	83	     1		    1100	    1100	    1100	   1100

SELECT SUBSTR(HIREDATE, 1,2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), 
       ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
FROM EMP
GROUP BY SUBSTR(HIREDATE, 1,2)
ORDER BY H_YEAR;

-- 다른 방식 2
SELECT SUBSTR(EXTRACT(YEAR FROM HIREDATE), 3,2) H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), 
       ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
FROM EMP
GROUP BY SUBSTR(EXTRACT(YEAR FROM HIREDATE), 3,2)
ORDER BY H_YEAR;

-- 다른 방식
SELECT TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL),
         ROUND(AVG(SAL),2) "AVG(SAL)", SUM(SAL)
         FROM EMP
         GROUP BY TO_CHAR(HIREDATE, 'RR')
         ORDER BY H_YEAR;

-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	

SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total') 입사년도, COUNT(*)
FROM EMP
GROUP BY ROLLUP (TO_CHAR(HIREDATE, 'YYYY'))
ORDER BY 입사년도;

-- EXTRACT 는 숫자형으로 바뀌기 때문에 TO_CHAR에 인식이 되지 않는다.

--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL),2)
FROM EMP
ORDER BY DEPTNO;

--16. 부서별 인원수 출력
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO;

--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO, COUNT(*)
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) >= 6
ORDER BY DEPTNO;

--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
-- ENAME	    등수
--________________________
-- KING		    1
-- SCOTT		2
--……
SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK 
FROM EMP E1, EMP E2
WHERE E1.SAL < E2.SAL(+)
GROUP BY E1.ENAME
ORDER BY RANK;

-- 풀이
SELECT E1.ENAME, E1.SAL, E2.ENAME MANAGER, E2.SAL
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+);
    -- E1 기준으로 데이터 나열된 것 / 1단계: SELF JOIN, OUTER JOIN
SELECT E1.ENAME, COUNT(E2.ENAME)+1 RANK -- 월급을 많이 받는 사람 수
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL(+)
    GROUP BY E1.ENAME
    ORDER BY RANK;
    -- GROUP BY COUNT 완성단계
    
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK", 
    DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
    ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW+NUMBER" 
    FROM EMP;
-- RANK() OVER - 함수 / 속도가 느려지는 단점이 있어서 
-- ROW() OVER : 쓰이는 경우가 있음 / 사용빈도 낮음











    
    
    
    
    
    
    
    
    










