-- 주석[||] SELECT문 - 가장 많이 쓰이는 DML(Data Manipulation Language : 검색 기능)
-- DDL: 테이블생성
-- DML: 입력, 수정, 삭제, 검색**(오늘 하는 것)
-- DCL: 권한부여, 트랜젝션명령

-- 1. SELECT 문장 작성법
-- 현재 계정을 알려주는 것(실행하려면 CTRL + enter KEY)
-- 대문자로 쓰는 습관을 기르자! 대소문자는 인식하지 않지만 그래도!

SHOW USER; 
SELECT * FROM TAB; --*은 모든 것이라는 뜻 / 현 계정(scott)이 가지고 있는 테이블
SELECT * FROM EMP; --EMP테이블의 모든 열(필드), 모든 행을 출력하란 의미
-- ORACLE은 반드시 FROM절이 있어야 한다.
SELECT * FROM DEPT; -- DEPT테이블의 모든 열, 모든 행 출력하란 의미
-- EMP테이블의 구조
DESC EMP;
DESC DEPT;

-- 2. SELECT문 실행(특정 열만 출력)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP; 
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB FROM EMP; -- 별칭 정하는 것
-- SELECT 다음에는 꼭 FROM 절!
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여,  JOB FROM EMP;
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB FROM EMP;
SELECT EMPNO "사번", ENAME "이름", SAL "급여", JOB FROM EMP;
-- 영어로 하는 것이 일반적이다
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; -- TITLE : NO, NAME, SALARY

-- 3. 특정 행 출력 : WHERE절 (조건) - 비교연산자(같다(=), 크거나 같다(>=).... 다르다(!=, ^=, <>)
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000; -- 같다 -- SAL 3000인 애만 나온다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL != 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL ^= 3000; -- 다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL <> 3000; -- 다르다
    -- 비교연산자는 숫자, 문자, 날짜형 모두 가능
    -- EX. 사원이름(ENAME)이 'A','B','C'로 시작하는 사원의 모든 필드 출력
SELECT * FROM EMP WHERE ENAME < 'D'; -- 필드의 별칭을 적을때만 쌍따옴표 쓰고 문자, 문자열 모두 홑따옴표 쓴다.
    -- EX. 81년도 이전에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01'; --81년도 1월 1일보다 전에 입사한 사람 / 혼자서 데이트형으로 변환한 후 비교 진행한다.
    -- EX. 10번 부서번호(DEPTNO)인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO = 10;
    -- EX. 이름(ENAME)이 FORD인 직원의 EMPNO, ENAME, MGR(상사의 사번)을 출력
SELECT * FROM EMP WHERE ENAME = 'FORD';
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; -- 데이터는 대소문자 구분한다. UPPERCASE 사용

-- 4. 논리연산자 : AND, OR
    -- EX. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드 출력
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL <=3000;
    -- EX. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE > '82/01/01' AND HIREDATE <= '82/12/31';
    -- 날짜 표기법 세팅 (현재 : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 한글 윈도우즈 위에 INSTALL
SELECT ENAME, HIREDATE FROM EMP;
    -- EX. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉 출력(연봉 = SAL * 12)
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400;
-- SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE 연봉 > 2400; -- WHERE절에는 별칭 설정 불가. SELECT문에서만 가능.
SELECT ENAME, SAL, SAL*12 "연봉" 
    FROM EMP 
    WHERE SAL*12 > 2400 
    ORDER BY 연봉; -- ORDER BY 절에는 별칭 사용 가능
    -- EX. 10번 부서(DEPTNO)이거나 직책(JOB)이 MANAGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB ='MANAGER';
    -- EX. 부서 번호가 10번이 아닌 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10; -- 이 조건의 반대라는 의미

-- 5. 산술표현식(SELECT나 WHERE, ORDER BY절 모두 사용 가능하다)
SELECT ENAME, SAL "현재급여", SAL+100 "올릴급여" FROM EMP WHERE DEPTNO = 10;
    -- EX. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12_COMM)
    -- 산술 연산의 결과는 NULL을 포함하면 결과도 NULL이다.
    -- NVL(NULL일 수도 있는 필드명, NULL을 대치할 대치값) 반드시 매개변수 둘은 타입이 같아야 함
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP; -- 0이 대치값
    -- 모든 사원의 사원명(ENAME), 상사의 사번(MGR)을 출력,(상사가 없으면 '없음'이라고 출력할 수 없음. 대신에 0으로)
SELECT ENAME, NVL(MGR,0) FROM EMP; --MGR은 숫자고 '없음'은 문자기 때문에 0으로 해주기 // NVL 매개변수 타입 불일치 에러

-- 6. 연결연산자(||) : 열이나 문자를 연결
SELECT ENAME || '은(는) ' || JOB "EMPLOYEES" FROM EMP;
    -- EX. "SMITH : 연봉 = XXX" 과 같이 모든 행 출력(연봉 = SAL*12+C0MM)
SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM,0)) FROM EMP; -- 연결연산자가 더 우선순위에 있다

-- 7. 중복제거 (DISTINCT)
SELECT JOB FROM EMP; -- 중복된 것들 출력
SELECT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP; -- 중복제거
SELECT DISTINCT DEPTNO FROM EMP;

-- ★예제★ 연습문제 꼭 풀기

--1. emp 테이블의 구조 출력
DESC EMP;


--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;


--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB; -- 현재 계정이 가지고 있는 테이블


--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP; 


--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;


--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE > '81/01/31';
-- # 날짜 설정 (YYYY 연도4자리, RR연도 2자리, M월, D일) 
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP WHERE HIREDATE >= '02/01/81';
-- # 날짜형 > 문자형 데이터로 변환하는 함수: TO_CHAR(날짜형, 패턴)
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP
WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01'; -- 단일행함수(4장)
-- # 문자형 > 날짜형 데이터로 변환하는 함수 : TO_DATE(문자형데이터, 패턴)
SELECT EMPNO, ENAME, SAL, HIREDATE FROM EMP
WHERE HIREDATE >= TO_DATE('81/02/01', 'RR/MM/DD'); -- 단일행함수(4장)
-- 날짜형 비교는 함수를 이용해서 비교한다
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
SELECT * FROM EMP WHERE HIREDATE >= '81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE DEPTNO = SALESMAN;
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <=3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은(는) ' || JOB || ' 업무이고, 연봉은 ' || (SAL*12+NVL(COMM,0)) || '다.' FROM EMP;



-- 8. SQL연산자 (BETWEEN, IN, LIKE, IS NULL)
    -- (1) BETWEEN : 데이터 BETWEEN A AND B (A<=B)
        -- EX. SAL이 1500이상 3000이하인 사번 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000 ORDER BY SAL;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500; -- 불가
        -- EX. 1500 미만 3000 초과하는 모든 필드 출력
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000; -- 반대의 의미니까 BETWEEN 앞에 NOT
        -- 날짜랑 문자 모두 가능
        -- EX. 82년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31' ORDER BY HIREDATE;
        -- 단일행 함수 (4장) 응용
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';
        -- EX. 사원 이름이 'A','B'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME!= 'C'; -- B라고 해놓으면 이름은 B이후 이기 때문
-- 이름이 C까지 출력이 되기때문에 C를 제거하고 싶으면 AND ENAME != 'C';
        -- EX. 사원 이름이 'B','C'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME <> 'D'; -- D까지 하고, D는 제외하고!
   
    -- (2) IN : 데이터 IN(A,B,C....) // 동일하게 문자나 데이트 다 사용 가능
        -- EX. 부서번호가 10, 20, 40번인 부서 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN(10,20,40);
        -- EX. 부서번호가 10,20,40번 부서를 제외한 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO!=10 AND DEPTNO<>20 AND DEPTNO^=40;
SELECT * FROM EMP WHERE DEPTNO NOT IN(10,20,40);
        EX. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN(7902,7788,7566) ORDER BY EMPNO;
   
    -- **(3) LIKE 연산 : (문법) 데이터 LIKE 패턴(와일드카드 %: 0글자 이상, _: 한글자) ****
        -- EX. 이름이 M이 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%M%'; -- M 앞에 0글자 이상 들어가고 M 뒤에 0 글자 이상 들어간다
        -- EX. 이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%'; --M앞에는 한글자도 안들어오고 M 뒤에는 글자가 와도 상관 없는.
        -- EX. 이름이 S로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
        -- EX. SAL이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
SELECT * FROM EMP WHERE SAL = '2975'; -- 숫자형과 문자형 비교 가능
        -- EX. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
-- ** 아래 3가지가 훨씬 더 많이 쓰인다. ***
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%'; -- 사용자에게 입력을 받을 경우에 이렇게 작성
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;
        -- EX. 1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '_/01/_';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
        -- EX. 82년도가 아닌 연도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') NOT LIKE '82/_' ORDER BY HIREDATE;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') != '82' ORDER BY HIREDATE;
        -- EX. 이름에 S가 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S%';
        -- % 글자를 출력하고 싶을때는 어떻게...? - 불가.
SELECT * FROM EMP WHERE ENAME LIKE '%%%'; -- 불가. 모든필드 출력
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\'; -- % 들어간 것을 출력하고 \는 제거해라
INSERT INTO EMP VALUES (9999, '홍%', NULL, NULL, NULL, 9000, 900, 40); -- 데이터 입력
-- 1 행 이(가) 삽입되었습니다. 출력이 되어야 함
-- 원상복귀 ROLLBACK; -> DML(데이터 추가, 삭제, 수정)로 수정된 데이터 원상복구 (DML 취소한다)
ROLLBACK; -- INSERT, DELETE, UPDATE 만 가능하다
        
    -- (4) IS NULL : 데이터가 없음을 나타내는 데이터
SELECT * FROM EMP;
        -- EX. 상여금이 NULL 인 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL; -- NULL을 검색할때는 무조건 'IS NULL'
SELECT * FROM EMP WHERE COMM = NULL; -- 불가.
        -- EX. 상여금이 없는 사원의 모든 필드(COMM이 NULL이거나 0인 사원 모두 출력)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0; 
        -- NOT IS NULL
        -- EX. 상여금이 있는 사원의 모든 필드 (COMM이 NULL도 아니고 0도 아니고)
SELECT * FROM EMP WHERE NOT COMM IS NULL OR NOT COMM = 0; -- 데이터 앞에 NOT을 붙여야 한다. *
SELECT * FROM EMP WHERE NOT(COMM IS NULL OR COMM =0);


-- 9. 정렬 (오름차순, 내림차순) -- DEFAULT는 오름차순
SELECT ENAME, SAL FROM EMP; -- INSERT한 순서대로 출력이 된다.
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- 급여 오름차순 정렬
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; 
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESX; -- 급여 내림차순 정렬
-- 숫자, 문자, 날짜 모두 정렬 가능
SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- 이름 ABCD 순으로 오름차순 정렬 ***
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- .. 내림차순

SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- 날짜 오래된 순서대로 정렬
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- 최신 날짜 순서대로 정렬 ***
-- 댓글창이랑 대댓글 입력창 최신 순서대로 할지 잘 살펴봐야한다.
    -- 이름, 연봉(SAL*12+COMM)을 출력 (연봉이 높은 순으로 정렬, 연봉이 같을 경우 이름 오름차순 정렬)
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" FROM EMP ORDER BY SAL*12+NVL(COMM,0) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" FROM EMP ORDER BY ANNUAL_SAL DESC, ENAME; 
-- 별칭사용가능 FROM >> WHERE >> SELECT >> ORDER BY 순으로 문장을 읽기 때문에 SELECT 다음인 ORDER BY는 읽을 수 있다. 
    -- EX. 사번, 이름, 입사일, 급여, 부서번호(부서번호 순으로 오름차순, 부서가 같으면 입사일 내림차순 으로 출력)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;


SELECT * FROM EMP;

-- *** ### 04-11 연습문제 ### *** (꼭 연습하기!!!!)
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 3000;
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO FROM EMP WHERE EMPNO = 7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL, SAL*12+NVL(COMM,0) "ANNUAL_SAL" FROM EMP 
WHERE (SAL*12+NVL(COMM,0)) >= 24000 ORDER BY SAL;
--4.	입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01'
ORDER BY HIREDATE;
--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN(10,20) ORDER BY ENAME;
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20 ORDER BY ENAME;
--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME AS employee, SAL as Monthly_Salary FROM EMP WHERE SAL >= 1500 AND DEPTNO IN(10,30);
--7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE('82/%');
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') LIKE '82';
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME <> 'Q' ORDER BY ENAME;
--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
--      출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL*1.1;
--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB = 'CLERK' OR JOB = 'ANALYST' AND SAL NOT IN (1000,3000,5000); 
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') AND SAL NOT IN (1000,3000,5000);
--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의
--      모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;
--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
WHERE HIREDATE LIKE '82/%' AND NOT JOB LIKE 'SALESMAN';
--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
--      급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';
--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, SAL*12 AS ANNUAL_SAL FROM EMP WHERE SAL*12 >= 35000;









