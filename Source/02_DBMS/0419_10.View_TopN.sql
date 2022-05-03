--[X] VIEW, INLINE VIEW, TOP-N 구문

-- 1. VIEW : 가상의 테이블 (1)단순 뷰 (2)복합 뷰

-- (1) 단순 뷰 : 하나의 테이블로 구성한 뷰
-- EMPv0 이라는 VIEW 생성 또는 수정 = EMP테이블 일부 필드를 갖는 가상의 테이블
-- (일반 테이블 사용이랑 다르지 않다!)

SELECT * FROM EMP; -- EMP테이블
SELECT * FROM USER_VIEWS; -- 데이터 딕셔너리 뷰 확인

-- VIEW CREATE EMPv0
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; 
    -- DDL을 수행하면 데이터 딕셔너리 자동 수정
SELECT * FROM EMPv0; -- SAL, COMM 사라짐 (가상의 테이블)

-- VIEW 새로운 데이터 삽입 (INSERT)
INSERT INTO EMPv0 VALUES (1111, '홍', 'ITMANAGER', 7369, SYSDATE, 40);
SELECT * FROM EMPv0; -- INSERT 확인
SELECT * FROM EMP; -- SAL,COMM NULL 값으로 들어가짐 

-- VIEW UPDATE 
UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO = 1111;
SELECT * FROM EMPv0; -- 업데이트 확인
SELECT * FROM EMP; -- 업데이트 확인

-- VIEW DELETE
DELETE FROM EMPv0 WHERE EMPNO = 1111; -- 테이블과 동일하게 사용
SELECT * FROM EMPv0; -- 삭제 확인
SELECT * FROM EMP; -- 삭제 확인


-- 일부의 행이나 열을 막고 싶을 경우 EX. 30번 테이블은 30번 부서만 볼 수 있게 하고 싶을 때...
-- 일부의 열을 막고 싶은 경우

-- EMPv0이라는 VIEW : EMP테이블의 30번 부서행만
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30;
-- 생성 OR 교체
DESC EMPv0; -- 모든 필드가 들어온 것 확인 (PK도 같이 들어옴, 외래키 제약 조건도 같이 들어옴)
SELECT * FROM EMPv0; -- 30번 부서 확인

INSERT INTO EMPv0 VALUES (1111, '홍', NULL, NULL, SYSDATE, 9000, 900, 30);
SELECT * FROM EMPv0;
SELECT * FROM EMP;

-- 만약.. 40번 부서를 추가하고 싶다면?
INSERT INTO EMPv0 VALUES (1112, '박', NULL, NULL, SYSDATE, 8000, 800, 40); -- 입력은 가능
SELECT * FROM EMPv0; -- 확인이 안됨..! 30번 부서만 보기로 해놓은 상태이기 때문에 보이지 않음.
SELECT * FROM EMP; -- 40번 부서로 추가된 것 확인

-- 30번 부서 홍과, 40번 부서 박을 EMPv0 뷰에서 삭제
DELETE FROM EMPv0 WHERE EMPNO IN (1111, 1112); -- 30번 부서인 홍은 삭제 O, 40번 부서인 박은 삭제 X
SELECT * FROM EMPv0; -- 홍 삭제
SELECT * FROM EMP; -- 홍만 삭제, 박은 존재
DELETE FROM EMP WHERE EMPNO = 1112; -- 박은 별도로 EMP테이블에서 삭제 해주기

-- EMPv0 뷰 생성 : ENAME, JOB, HIREDATE 만으로 뷰 생성
CREATE OR REPLACE VIEW EMPv0    
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
INSERT INTO EMPv0 VALUES ('홍', 'SALESMAN', SYSDATE); -- INSERT 안됨
-- NOT NULL 조건이 들어가야 하는 필드는 다 들어가야 뷰에서 데이터 삽입 가능
-- 테이블에서 할 수 있는 조건들 모두 사용 가능 조인,,, 셀렉트...
COMMIT;


-- * VIEW의 제한 조건 (1) 뷰의 조건, (2) 읽기 전용
--- 40번 부서를 입력하면 안되도록 제한조건 붙이는 것
-- 'WITH CHECK OPTION' 을 설정한 뷰는 뷰의 조건에 해당되는 데이터만 삽입, 수정, 삭제 가능
-- 'WITH READ ONLY' 를 설정한 뷰는 읽기 전용 뷰 (SELECT만 가능)

-- EMPv0 : 조건. EMP테이블에서 30번 부서만 + WITH CHECK OPTION
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION;

INSERT INTO EMPv0 VALUES (1111, '홍', NULL, NULL, SYSDATE, 9000, 900, 30); -- O
INSERT INTO EMPv0 VALUES (1112, '박', NULL, NULL, SYSDATE, 9000, 900, 40); -- X

DELETE FROM EMPv0 WHERE ENAME = 'SMITH'; -- 0행 삭제, 조건불만족
DELETE FROM EMPv0 WHERE EMPNO = 1111; -- 1행 삭제, 조건 만족 (부서 30)

SELECT * FROM EMPv0;


-- EMPv0 : 읽기 전용 뷰 WITH READ ONLY
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP 
    WITH READ ONLY;

INSERT INTO EMPv0 VALUES (1111, '홍', NULL, NULL, 40); -- 에러(읽기전용 뷰)


-- (2) 복합뷰 : ① 2개 이상의 테이블로 구성한 뷰이거나 ② 가상의 필드로 뷰를 만들 경우.
--             DML 문장을 제한적으로 사용(SELECT만 가능하단 의미)

-- ① 2개 이상의 테이블로 뷰 생성
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
        
SELECT * FROM EMPv0; -- EQUI조인된 VIEW 확인

INSERT INTO EMPv0 VALUES (1111, 'HONG', 'MANAGER', 'RESEARCH', 'DALLAS');
    -- 복합뷰는 INSERT, UPDATE 불가 (갱신 불가)

-- ② 가상의 필드로 뷰 생성 : 컬럼에 '별칭'을 이용하여 뷰 생성
--                  별칭은 (영문자로 시작, 영문자, 숫자, _ AND 30자 이내)

CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 10; 
    -- 에러발생 (필드이름에 특수문자가 존재하여 불가)

-- 1번째 별칭 사용법
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL" FROM EMP WHERE DEPTNO = 10;
-- 2번째 별칭 사용법
CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)
    AS SELECT EMPNO, ENAME, SAL*12 FROM EMP WHERE DEPTNO = 10;

SELECT * FROM EMPv0;

-- 복합 뷰와 동일하게 INSERT, UPDATE 불가
INSERT INTO EMPv0 VALUES (1111, '홍', 2400);


    -- EX. 부서번호, 부서별 최소급여, 최대급여, 부서평균급여를 포함한 DEPTv1뷰 생성
    CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MIN_SAL, MAX_SAL, AVG_SAL)
        AS SELECT D.DEPTNO, MIN(SAL), MAX(SAL), AVG(SAL) FROM DEPT D, EMP E 
            WHERE D.DEPTNO = E.DEPTNO GROUP BY D.DEPTNO;
    SELECT * FROM DEPTv1;
    
    -- EX. 직책, 부서를 포함한 EMPv0 뷰를 생성 (*중복제거 DISTINCT를 포함한 뷰는 읽기 전용!)
    CREATE OR REPLACE VIEW EMPv0 
        AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO;
    SELECT * FROM EMPv0;
    -- DISTINCT를 포함해도 INSERT, UPDATE 불가!

    
    
-- 2. INLINE VIEW : FROM절 상의 서브쿼리를 INLINE VIEW라 하며, 
--                  FROM절에 오는 서브쿼리는 VIEW처럼 작용
        
    -- EX. 급여가 2000을 초과하는 사원의 평균 급여
    SELECT AVG(SAL) FROM EMP WHERE SAL>2000;
    SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL > 2000);
    
    -- EX. 부서 평균 월급보다 높은 사원을 사번, 이름, 급여 (서브쿼리연습문제 24번, 25번)
    -- 서브쿼리
    SELECT EMPNO, ENAME, SAL 
        FROM EMP E
        WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO = E.DEPTNO);
    -- INLINE VIEW 
    SELECT EMPNO, ENAME, SAL, AVGSAL
        FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVGSAL" FROM EMP GROUP BY DEPTNO) A
        WHERE E.DEPTNO = A.DEPTNO
            AND SAL > AVGSAL;
            
            
            
-- 3. TOP-N 구문 (TOP 1~10등 / TOP 11~20등 / TOP 6~10등)
--- 랭킹과 다름

-- ★ ROWNUM : FROM의 테이블로부터 가져온 순서
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20; -- 순서대로
-- WHERE 절에 만족되는 조건만 ROWNUM이 세팅된다.
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;

    -- EX. 등수, 이름을 SAL 기준으로 랭킹 출력 (전체 행에 대해)
        SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ROWNUM은 등수가 아니고 테이블로부터 가져온 순서
        -- FROM절에서 ORDER BY 한 상태로 가져와보기 (FROM절에서 SAL을 기준으로 내림차순하여 정리된 테이블 사용)
        SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC); -- ROWNUM이 등수가 됨 (추천)
        -- 함수를 이용한 RANK 출력 (비추)
        SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
            DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
            ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
            ENAME, SAL FROM EMP;

-- SAL 기준으로 1~5등 출력
SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5; -- 비추

SELECT ROWNUM, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5; 

-- SAL 기준으로 6~10등 출력
SELECT ROWNUM, ENAME, SAL  
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10; -- 결과가 출력이 안됨...! 왜? 
    -- ROWNUM은 조건이 맞을 경우에 1로 적고 출력이 되는데 1이 애초에 출력이 안되기 때문에 
    -- 출력되는 행들이 없음.
    
-------------------------------------------------------------------------------
-- ★ TOP-N 구문 1단계
--- ROWNUM에 별칭 꼭 주기!
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);

-- ☆★ TOP-N 구문 2단계 (완성된 TOP-N 구문)
--- 연습 많이 하기!!!!
SELECT ROWNUM, RN, ENAME, SAL
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) A
    WHERE RN BETWEEN 6 AND 10;

    -- EX. 이름을 알파벳 순서대로 정렬해서 6~10번까지 출력 (등수, 이름, 사번, JOB, MGR, HIREDATE)
    SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM(SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE 
            FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME)) A
        WHERE RN BETWEEN 6 AND 10;
    
    -- 1단계
    SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME;
    -- 2단계
    SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME);
    -- 3단계
    SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
        FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE
            FROM (SELECT ENAME, EMPNO, JOB, MGR, HIREDATE FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;
    
    
    -- 0419 연습문제
    -- 1. 부서명과 사원명을 출력하는 용도의 뷰, DNAME_ENAME_VU 를 작성하시오
    CREATE OR REPLACE VIEW DNAME_ENAME_VU 
        AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;
    
    SELECT * FROM DNAME_ENAME_VU;
       
    -- 2. 사원명과 직속상관명을 출력하는 용도의 뷰,  WORKER_MANAGER_VU를 작성하시오
    CREATE OR REPLACE VIEW WORKER_MANAGER_VU (WORKER, MANAGER)
        AS SELECT W.ENAME, M.ENAME FROM EMP W, EMP M WHERE W.MGR = M.EMPNO;
   
    SELECT * FROM WORKER_MANAGER_VU;
    
    -- 3. 부서별 급여합계 등수를 출력하시오(부서번호, 급여합계, 등수). 
    SELECT DEPTNO, SUM, ROWNUM 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC);        
    
    -- 3-1. 부서별 급여합계 등수가 2~3등인 부서번호, 급여합계, 등수를 출력하시오. ? 학생 질문
    SELECT DEPTNO, SUM, RN
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN BETWEEN 2 AND 3;
    
    -- 다른 방식
    SELECT *
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN BETWEEN 2 AND 3;
    
    SELECT *
    FROM (SELECT DEPTNO, SUM, ROWNUM RN 
        FROM (SELECT DEPTNO, SUM(SAL) SUM FROM EMP GROUP BY DEPTNO ORDER BY SUM(SAL) DESC))
        WHERE RN IN(2,3);
        
    -- 4. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 순으로 정렬하시오  
    SELECT EMPNO, ENAME, HIREDATE FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC);
    
    -- 5. 사원테이블에서 사번, 사원명, 입사일을 입사일이 최신에서 오래된 사원 5명을 출력하시오
    SELECT EMPNO, ENAME, HIREDATE, RN 
    FROM(SELECT EMPNO, ENAME, HIREDATE, ROWNUM RN 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 1 AND 5;
    
    SELECT EMPNO, ENAME, HIREDATE
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) WHERE ROWNUM <=5;
    
    SELECT *
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) WHERE ROWNUM <=5;
    
    -- ☆★ 6. 사원 테이블에서 사번, 사원명, 입사일을 최신부터 오래된 순으로 6번째로 늦은 사원부터 10번째 사원까지 출력
    SELECT EMPNO, ENAME, HIREDATE, RN
    FROM(SELECT EMPNO, ENAME, HIREDATE, ROWNUM RN 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;
    
    -- 다른 방식!
    SELECT EMPNO, ENAME, HIREDATE 
    FROM(SELECT ROWNUM RN, A.* 
        FROM(SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A)
    WHERE RN BETWEEN 6 AND 10;
    

    