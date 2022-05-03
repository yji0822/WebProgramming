-- [iv] 단일행 함수
-- 함수 = 단일행 함수 + 그룹 함수(집계함수)
    -- 단일행 함수 (INPUT 1행 -> OUTPUT 1행) - 한행 받아서 한행 출력하는 것 : 4장
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM"월"DD"일"') FROM EMP; -- 단일행 함수 
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- 단일행 함수

    -- 그룹함수 (INPUT N행 -> OUTPUT 1행) : 5장
SELECT SUM(SAL) FROM EMP; -- INPUT을 여러개를 받아서 하나의 결과로 출력하는 것 // SUM이 그룹함수
SELECT AVG(SAL) FROM EMP;
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO;



-- ★☆ 단일행 함수 종류 : 숫자관련 함수, 문자관련 함수, 날짜 관련 함수(예약어), 형변환 함수, NVL(), ETC. ... ★
-- 1. 숫자관련 함수
SELECT -9, ABS(-9) FROM EMP; -- 아주 부적합함.. 그치만 FROM절은 꼭 들어가야 함!
    -- DUAL 테이블 잠깐 불러올 것! (ORACLE에서 제공하는 1행1열짜리 DUMMY 테이블) (CF) DUMMY
DESC DUAL; 
SELECT * FROM DUAL; -- 함수 테스트 용으로 사용 가능한 테이블
DESC DUMMY;
SELECT * FROM DUMMY; -- 숫자로 들어가고 있는 DUMMY 테이블
SELECT -9, ABS(-9) FROM DUAL; -- ABS() 절대값

-- ** 소수점 내리는 것
-- FLOOR이랑 TRUNC 차이점 
SELECT FLOOR(34.5678) FROM DUAL;           -- 소수점에서 내림 / 34 출력
SELECT FLOOR(34.5678 * 100)/100 FROM DUAL; -- 소수점 두자리 숫자에서 내림 (자바랑 방식 동일)
SELECT TRUNC(34.5678, 2) FROM DUAL;        -- 소수점 두번째 자리에서 내림
SELECT TRUNC(34.5678) FROM DUAL;           -- 소수점에서 내림 OR (34.5678, 0)
SELECT TRUNC(34, -1) FROM DUAL;            -- 1의 자리에서 내림
    -- EX. EMP 테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, TRUNC(SAL, -2), SAL FROM EMP;-- 10의 자리에서 내림

-- 올림
SELECT CEIL(34.5678) FROM DUAL; -- 소수점에서 올림
SELECT CEIL(34.5678*100)/100 FROM DUAL; -- 소수점 두번째 자리에서 올림

-- 반올림
SELECT ROUND(34.5678) FROM DUAL; -- 소수점에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL; -- 소수점 두번째 자리에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL; -- 일의 자리에서 반올림

-- 나머지 연산
SELECT MOD(9,2) FROM DUAL; -- 나머지 연산자 %
    -- EX. 사번이 홀수인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(EMPNO,2) = 1; -- 사번이 양수라는 전제 하에
SELECT * FROM EMP WHERE MOD(EMPNO, 2) != 0;
    -- EX. 홀수 달에 입사한 사원의 모든 필드 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2) = 1;

---------------------------------------------------------------------------------

-- 2. 문자관련 함수
-- (1) 대소문자 관련
SELECT UPPER('abcde') FROM DUAL;
SELECT LOWER('ABCDE') FROM DUAL;
SELECT INITCAP('WELCOME TO ORACLE') FROM DUAL; -- Welcome To Oracle
    -- EX. JOB이 'MANAGER'인 직원의 모든 필드 출력
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager'; -- 첫번째 글자만 대문자

-- (2) 문자 연결 (CONCAT, ||연산자)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL; -- 계속 연결 가능
SELECT CONCAT('AB', 'CD', 'EF', 'GH') FROM DUAL;  -- 반드시 두개만 연결 가능
SELECT CONCAT(CONCAT('AB', 'CD'), CONCAT('EF', 'GH')) FROM DUAL;
    -- EX. 아무개(ENAME)는 XX(JOB)이다" 포맷으로 EMP 테이블 출력
SELECT CONCAT(CONCAT(ENAME, '는'), CONCAT(JOB, '이다.(다)')) FROM EMP;
SELECT ENAME ||'는 '|| JOB ||'이다(다)' FROM EMP;

-- (3) SUBSTR(STR, 시작 위치, 문자 개수) 첫번째 위치가 1, 시작위치 음수 가능
--     SUBSTRB(STR, 시작 바이트 위치, 문자 바이트 수)
--  O  R  A  C  L  E
--  1  2  3  4  5  6
-- -6 -5 -4 -3 -2 -1
SELECT SUBSTR('ORACLE', 3,2) FROM DUAL;     -- 3번째 글자부터 2글자 추출 // AC
SELECT SUBSTRB('ORACLE', 3,2) FROM DUAL;    -- 3번째 바이트부터 2바이트 추출 // AC
SELECT SUBSTR('데이터베이스', 4,3) FROM DUAL;  -- 4번째 글자부터 3글자 추출 // 베이스
SELECT SUBSTRB('데이터베이스', 4,3) FROM DUAL; -- 4번째 바이트부터 3바이트 추출 // 이 - (XE버전에서 1글자는 3BYTE)
SELECT SUBSTRB('홍길동', 3,3) FROM DUAL;      -- 3바이트씩 잘라서 가져와야 함 // 길
SELECT SUBSTR('ABCDXD', -1,1) FROM DUAL;    -- D
-- 날짜나 숫자에 모두 가능
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- 숫자도 가능 // 2
    -- EX. 9월에 입사한 사원의 모든 필드 (단, DATE 출력 FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4,2) = '09'; -- HIREDATE에서 4번째 숫자에 두글자 추출
    -- EX. 9일에 입사한 사원의 모든 필드 (단, DATE 출력 FORMAT 'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09'; -- 뒤에서부터 뽑는 방식!

-- (4) 글자 수 세는 함수 (LENGTH) VS 바이트 수 (LENGTHB)
SELECT LENGTH('ABC') FROM DUAL; -- 글자수 : 3
SELECT LENGTHB('ABC') FROM DUAL; -- 바이트 수 : 3
SELECT LENGTH('오라클') FROM DUAL; -- 글자 수 : 3
SELECT LENGTHB('오라클') FROM DUAL; -- 바이트 수 : 9(정식버전은 6)

-- (5) INSTR(STR, 찾을글자) : STR에서 찾을 글자의 위치(첫번째 1), 없으면 0을 리턴 == INDEX OF랑 같다 생각하면 됨
--     INSTR(STR, 찾을글자, 시작위치) : STR에서 시작위치부터 찾아서 찾은 글자의 위치를 반환. 위치는 음수 가능 
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- 처음부터 찾아서 처음 나오는 B의 위치 : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; -- 앞 3번째부터 찾아서 처음 나오는 B의 위치 : 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL; -- 뒤에서 3번째부터 뒤에서 앞으로 찾아 처음 나오는 B의 위치 : 2
    -- EX. 9월에 입사한 사원의 모든 필드(INSTR)
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09') = 4; -- 오류, 추출 불가
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4; -- 4번째에 오는지!
    -- EX. 9일에 입사한 사원의 모든 필드(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 7; -- 7번째에 오는지!
    -- EX. 9일이 아닌 날 입사한 사원의 모든 필드(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 0;
SELECT * FROM EMP WHERE NOT INSTR(HIREDATE, '09', 7) = 7;

-- (6) LPAD(STR, 자리수, 채울문자) STR을 자리수만큼 확보하고 왼쪽 빈자리에 채울 문자를 채운다.
--     RPAD(STR, 자리수, 채울문자) STR을 자리수만큼 확보하고 오른쪽 빈자리에 채울 문자 출력
SELECT LPAD('ORACLE', 10, '#') FROM DUAL; -- ####ORACLE
SELECT RPAD('ORACLE', 10, '#') FROM DUAL; -- ORACLE####
SELECT ENAME, SAL, LPAD(SAL, 6, '*') FROM EMP ORDER BY SAL DESC; -- LPAD 많이 쓴다!
    -- EX. 사번, 이름(7788 S****, 7894 S****, 이름은 앞  한글자만 출력하고 나머지는 '*'으로 출력 ) 
    -- 7369 S****
    -- 7839 K***
    -- 7934 M*****          RPAD, LENGTH, SUBSTR
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') FROM EMP;

    -- EX. 사번, 이름, 입사일 (이름은 10자리를 확보하면서 이름 글자수만큼 '*'로 채워지고 맨마지막 글자만 출력
    --     (7892  _____****H  80/12/**)
    --     (7792  _____****T  81/12/**)
    -- LENGTH, SUBSTR....LENGTH, RAPD, TO_CHAR
SELECT EMPNO,
    LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') AS AFTER_ENAME, 
    RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') AS HIREDATE FROM EMP;
-- 다른 방식
SELECT EMPNO,
    LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') AS NAME, 
    TO_CHAR(HIREDATE, 'RR/MM/')||'**' "HIREDATE" FROM EMP;

    -- EX. 이름의 세번째 자리가 R인 사원의 모든 필드(LIKE 사용, INSTR 사용, SUBSTR 사용)
SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3; -- RARA 같은 경우를 위해

-- (7) 여백제거 
SELECT TRIM('    ORACLE DB      ') FROM DUAL;
SELECT RTRIM('    ORACLE DB      ') FROM DUAL;
SELECT LTRIM('    ORACLE DB      ') FROM DUAL;
-- 보통 TRIM은 자바에서 작업을 해준 뒤에 넘겨준다

-- (8) REPLACE
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', '*') FROM EMP;

-----------------------------------------------------------------------------------

-- 3. 날짜 관련 함수 및 예약
-- (1) SYSDATE : 지금 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL; -- 현재 날짜와 시간

SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- 원상복구

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') AS 오늘날짜 FROM DUAL;
SELECT SYSDATE-1 "어제이시간", SYSDATE 지금, SYSDATE+1 "내일이시간" FROM DUAL; -- 날짜 계산도 가능하다

-- (2) 날짜 계산 : 14일 후
SELECT SYSDATE+14 "반납기한일" FROM DUAL;
    -- EX. 이름, 입사일, 근무일수
SELECT ENAME, HIREDATE, SYSDATE-HIREDATE "근무일수" FROM EMP; -- 15시 22분을 지나가고 있기 때문에 소수점 나옴
SELECT ENAME, HIREDATE, TRUNC((SYSDATE-HIREDATE),0) "근무일수" FROM EMP;
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) "근무일수" FROM EMP;   
    -- EX. 이름, 입사일, 근무한 주 수, 근무한 연 수
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) 근무주수, FLOOR((SYSDATE-HIREDATE)/365) "근무년수"
    FROM EMP;
    
-- (3) MONTHS_BETWEEN(날짜, 날짜) : 두 날짜 간의 개월 수
    -- EX. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) AS 근무월수 FROM EMP; -- 현재날짜, 고용된 날짜 순서 지키기
    -- EX. 이름, 입사한 이후 받은 급여와 상여(급여는 매달 SAL을 받고, COMM은 1년에 2회 받음)
SELECT ENAME, 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL + TRUNC((SYSDATE - HIREDATE)/365)*2*NVL(COMM,0) COST
    FROM EMP; -- 급여 + 상여

-- (4) ADD_MONTHS(날짜, 개월 수) : 특정 시점부터 몇개월 후의 날짜 // 6개월 후가 몇일이니?
    -- EX. 이름, 입사일, 수습 종료일 (수습기간은 입사일로부터 6개월로 한다)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) AS "6개월후" FROM EMP;

-- (5) LAST_DAY(날짜) : 특정 날짜의 달의 말일 / 1월 1일이면 1월 31일 출력하는
SELECT LAST_DAY(SYSDATE) FROM DUAL; -- 이번달의 마지막날 출력
    -- EX. 이름, 입사일, 첫월급날(월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;

-- (6) ROUND(날짜, XX) : 날짜 반올림 / TRUNC(날짜, XX) : 날짜 버림
-- ROUND
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL;    -- 결과 :  현재 날짜에서 제일 가까운 1월 1일 반환
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;   -- 결과 : 현재 날짜에서 제일 가까운 1일 (1~15일은 이번달 1일, 16일 이후는 다음달 1일)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;     -- 결과 : 현재 날짜에서 제일 가까운 일요일
SELECT ROUND(SYSDATE) FROM DUAL;            --  결과 :제일 가까운 0시 (오전이면 오늘 0시, 오후면 내일 0시)
SELECT TO_CHAR(ROUND(SYSDATE), 'RR/MM/DD HH24:MI') FROM DUAL;
-- TRUNC
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL;    -- 결과 :  올해 1월 1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;   -- 결과 : 이번달 1일 
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;     -- 결과 : 지난 일요일
SELECT TRUNC(SYSDATE) FROM DUAL;            --  결과 : 오늘 0시

    -- EX1. 이름, 입사일, 입사한 달의 5일
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 "입사한 달의 5일" FROM EMP;
    -- EX2. 이름, 입사일, 월급날 (월급날은 매달 16일) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 AS "월급날" FROM EMP; -- 1일 + 15일
    -- EX3. 이름, 입사일, 월급날 (월급날은 매달 15일) 다음달에 붙어야 한다.
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "월급날" FROM EMP; -- 15일은 +1 해줘서 다음달에 받을 수 있도록 한다. 
    -- EX4. 이름, 입사일, 월급날 (월급날은 매달 5일) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "월급날" FROM EMP;
    -- EX5. 이름, 입사일, 월급날 (월급날은 매달 20일) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "월급날" FROM EMP;

-- (7) NEXT_DAY(날짜, '수') : 특정 날짜로부터 처음 도래하는 수요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토') FROM DUAL;


-------------------------------------------------------------------------------
-- 4. 형변환 함수 (문자, 숫자, 날짜)
-- (문자<->날짜, 문자<->숫자)
-- (1) TO_CHAR(날짜형 데이터, '출력형식') /// SIMPLEDATEFORMAT
    -- YYYY(년도 4자리) YY(년도 2자리) RR(연도 2자리) / MM(월) DD(일) / DAY(요일) DY(요일 요약 표현)
    -- AM/PM (오전/오후) / HH12(12시간) HH24(24시간) / MI(분) SS(초)
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY"요일" HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY"요일" AM HH12:MI:SS') FROM DUAL;

-- (2) TO_CHAR(숫자 데이터, '출력형식')
    -- 0 : 자릿수. 출력형식의 자릿수가 많으면 0으로 채움
    -- 9 : 자릿수. 출력형식의 자릿수가 많아도 숫자만큼만 채움 (소수점 앞의 이야기)
    -- , : 세자리마다 , 가능. 
    -- . : 소수점
    -- $ : 통화단위의 $가 앞에 붙을 수 있음
    -- L : (대소문자구분X) 지역통화 단위를 앞에 붙일 수 있음
SELECT TO_CHAR(123456, '9,999,999.99') FROM DUAL; --  123,456.00   소수점 앞자리에 빈 공백이 있을 경우 지워진 상태로 나옴
SELECT TO_CHAR(123456, '0,000,000.00') FROM DUAL; --  0,123,456.00 소수점 앞자리에 빈 공백이 있으면 0으로 출력

SELECT TO_CHAR(10000, 'L9999,999') FROM DUAL; -- ￦10,000
SELECT TO_CHAR(SAL, '$99,999') FROM EMP;
DESC EMP; -- 문자열에 맞춰서 위에 작성을 해주어야 한다. (DESC로 확인 한번 더 하기)

-- (3) TO_DATE(문자데이터, '패턴')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD') FROM DUAL; -- 시간은 기본적으로 00시 00분으로 들어간다.
    -- EX. 81/5/1 ~ 83/5/1 사이에 입사한 직원의 모든 필드 (TO_DATA 사용)
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('810501', 'RRMMDD')
        AND TO_DATE('83/05/01', 'RR/MM/DD');

-- (4) TO_NUMBER(문자, '패턴')
SELECT TO_NUMBER('1,234', '9,999')+1 FROM DUAL;

-------------------------------------------------------------------------------
-- 5. NVL(널 일수도 있는 데이터, 널이면 대신할 값) - 매개변수 2개는 타입 일치
SELECT ENAME, NVL(COMM, 0) FROM EMP;
    -- EX. 이름, 상사의 사번(MGR)을 출력하되, 상사의 사번이 NULL일 경우, 'CEO'로 대신 출력
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;
    

--------------------------------------------------------------------------------    
-- 6. ETC...
-- (1) EXTRACT : 연도나 월, 날짜만 숫자로 추출하고자 할 때! // 결과가 숫자이다!
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL; -- 2022
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT(MONTH FROM HIREDATE) FROM EMP; -- 월만 뽑아서 출력
SELECT EXTRACT(DAY FROM HIREDATE) FROM EMP;
    -- EX. 8월에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '02';
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
    -- EX. 81년도에 입사한 직원의 모든 필드
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '81';
    SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981; -- 4자리 모두 가져와야 한다.

-- (2) 계층적 출력(레벨별 출력) : LEVEL, START WITH 조건(MGR IS NULL), CONNECT BY PRIOR 조건(EMPNO = MGR)
SELECT LEVEL, LPAD('└', LEVEL*2)||ENAME 
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR; -- 계층적으로 출력한것 같은 느낌
    -- 답변글 같은 느낌으로 출력 / 한계 : 최신글을 상단에 놓지 처음글을 상단에 놓지 않음
    

-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
    -- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, 
    ADD_MONTHS(HIREDATE, 6) "6개월후", 
    TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY')+8 "돌아오는 월요일" 
    FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무개월수", 
    TO_CHAR(SAL, '$999,999') "SAL", 
    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL, '$999,999,999') "지금까지받은급여"
    FROM EMP;

--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') AS SAL, SAL FROM EMP;

--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, HIREDATE FROM EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME) 글자수, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM,0) FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;

-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') "입사일" FROM EMP;

--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') SAL FROM EMP WHERE DEPTNO = 20;
    

-------------------------------------------------------------------------------
    -- <총 연습문제> // 해설
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, 
    ADD_MONTHS(HIREDATE, 6) "6개월후", 
    TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY')+8 "돌아오는 월요일" 
    FROM EMP;
    
    SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '월') "6MONTHSLATERMON" FROM EMP;

--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE,
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무개월수", 
    TO_CHAR(SAL, '$999,999') "SAL", 
    TO_CHAR(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL, '$999,999,999') "지금까지받은급여"
    FROM EMP;

--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') AS SAL, SAL FROM EMP;

--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, HIREDATE FROM EMP;

--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, LENGTH(ENAME) 글자수, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM, 0), SAL+NVL(COMM,0) FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) FROM EMP;

--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12'; 
-- 시스템에 따라 DATE FORMAT이 다를 수 있으므로 위 방법 추천!
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '12';
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;

-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') "입사일" FROM EMP;

--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)    
DESC EMP; -- 몇자리까지 있는지 확인을 해줘야 한다
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') SAL FROM EMP WHERE DEPTNO = 20;
    
    















