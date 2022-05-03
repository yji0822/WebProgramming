-- [VII] DDL, DML, DCL
-- SQL = DDL (테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거)
--       DML (검색 = SELECT, 추가 = INSERT, 수정 = UPDAATE, 삭제 = DELETE)
--       DCL (사용자계정생성, 사용자권한부여,  권한박탈, 사용자계정삭제, 트랜잭션 명령어 = ROLLBACK, COMMIT)


-- ★★★ DDL ★★★
-- 1. 테이블 생성 (CREATE TABLE) 

CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- 도서번호 BOOKID 필드 타입은 숫자 4자리
    BOOKNAME VARCHAR2(300), -- 책이름   BOOKNAME 필드 타입은 문자 300자리
    PUBLISHER VARCHAR2(300),-- 출판사   PUBLISHER 필드는 문자 300자리
    RDATE     DATE,         -- 출판일   RADTE 필드는 DATE형
    PRICE     NUMBER(8),    -- 가격    PRICE 필드는 숫자 8자리
    PRIMARY KEY(BOOKID) );  -- 테이블 내 주키(PRIMARY KEY) 설정 
                                -- NOT NULL, 유일한 값 입력
    
    SELECT * FROM BOOK;     -- 테이블 생성 확인
    DROP TABLE BOOK;        -- 테이블 삭제
    -- DDL 문장은 취소가 안된다!
    

CREATE TABLE book (
    BOOKID    NUMBER(4) PRIMARY KEY,   -- 필드정의하고 타입 조건 적어도 되고 순서 상관 X
    BOOKNAME  VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE     DATE, 
    PRICE     NUMBER(8)  );
-- PRIMARY KEY 위치 : 오라클은 상관없지만 MYSQL은 보통 아래에 적는다

SELECT * FROM BOOK;

-- ** ROWNUM : 맨 처음 테이블에서 읽어들인 논리적 순서 **
--           : 내가 만들지 않아도 자동적으로 만들어진다.
SELECT * FROM EMP;
DESC EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP ORDER BY ENAME;
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME; 
-- 순서 : FROM > WHERE > ORDER BY > ROWNUM


-- NULL이 들어가면 안되는 필드(BOOKNAME,BOOKID..), 음수가 들어가면 안되는 필드(PRICE)
-- 필드 이름이랑 


-- EX. EMP01: EMP 테이블과 유사한 구조로 
--          : 사원번호(EMPNO - 숫자4), 사원이름(문자 20), 급여(숫자 7,2) 
--          : 3개의 칼럼으로 구성된 EMP01 테이블을 생성해 보자
-- PRIMARY KEY 없음
CREATE TABLE EMP01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL   NUMBER(7,2) -- 5자리에 소수점 2자리
);
DESC EMP01; -- NOT NULL이 안보임. 널? 은 PRIMARY KEY를 뜻한다.
DROP TABLE EMP01;

-- EX. DEPT와 유사한 DEPT01
--     : DEPTNO(숫자2, PK), DNAME(문자14), LOC(문자13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC   VARCHAR2(13),
    PRIMARY KEY(DEPTNO)
    );
DESC DEPT01;
DROP TABLE DEPT01;

-- 서브쿼리를 이용한 테이블 생성
-- 서브쿼리 결과만 EMP02테이블 생성 후 들어감
-- (제약조건은 들어가지 않는다.) PRIMARY KEY랑
SELECT * FROM TAB; -- SCOTT이 생성한 테이블 리스트
CREATE TABLE EMP02 AS SELECT * FROM EMP; -- EMP테이블이 서브쿼리!
SELECT * FROM EMP02;
DESC EMP02; -- 제약조건 미포함 확인
    
    -- EX. EMP03 : EMP테이블에서 EMPNO, ENAME, DEPTNO만 추출한 데이터로 테이블 생성
    CREATE TABLE EMP03
        AS 
        SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    SELECT * FROM EMP03; 
    -- 테이블 데이터를 백업 받을 때 사용 많이 한다.
    -- 코드체계를 바꿔야 할때 사용하기도 한다.
    
    -- EX. EMP04 : EMP테이블에서 10번 부서만 추출한 데이터로 테이블 생성
    CREATE TABLE EMP04 AS SELECT * FROM EMP WHERE DEPTNO = 10;
    SELECT * FROM EMP04;
    
    -- 구조만 똑같이 따라하고 싶을 때!
    -- EX. EMP05: 데이터는 제외한 EMP테이블 구조만 추출한 테이블 생성
    CREATE TABLE EMP05 AS SELECT * FROM EMP WHERE 1=0; -- 반드시 거짓 조건
    SELECT * FROM EMP05;
    DESC EMP05; -- 오라클에서만 사용하는 명령어 주석을 달고 싶으면 위에다 작성! *


    
-- 2. 테이블 구조 변경 (ALTER TABLE)
-- ALTER TABLE 테이블명 ADD..  || MODIFY || DROP ~ 
-- 필드 추가, 삭제, 타입 변경

-- (1) 필드 추가 (ADD)
-- 추가된 필드의 데이터는 모두 NULL
-- UPDATE해서 하나하나 넣거나 하나의 데이터로 통일시킨다.
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO
ALTER TABLE EMP03 ADD(JOB VARCHAR2(20), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD(COMM NUMBER(7,2));    
SELECT * FROM EMP03;

    
-- (2) 필드 수정 (MODIFY) : 함부로 일어나지 않는다. 형변환을 한다던가..
-- 글자수 늘리는 것 가능. 줄이는 것 불가능
SELECT * FROM EMP03; -- EMPNO(숫4), ENAME(문10), DEPTNO(숫2) / JOB(문20)와 SAL와 COMM(숫7,2)의 데이터는 'NULL'
DESC EMP03;

-- EMPNO
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 숫자 데이터가 들어있는 상태에서는 숫자로만 변경 가능
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- 에러. 숫자를 줄일 수는 없다.
ALTER TABLE EMP04 MODIFY (EMPNO NUMBER(5)); -- 가능
-- ENAME 
ALTER TABLE EMP03 MODIFY(ENAME NUMBER(4)); -- 문자데이터가 들어있는 상태에서는 문자로만 변경 가능    
SELECT MAX(LENGTH(ENAME)) FROM EMP; -- 현재 들어가 있는 글자데이터 최대길이 출력
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000));
DESC EMP03;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(6));    
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 에러(6BYTE 글자 데이터가 있어서)    
-- JOB : 데이터가 없는 상태로, 변경 가능
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2)); 
ALTER TABLE EMP03 MODIFY (JOB NUMBER(4));    
    
    
-- (3) 필드 삭제 (DROP)
-- JOB 필드 완전 삭제 - DDL은 롤백이 안되기 때문에 항상 신중해야 한다.
ALTER TABLE EMP03 DROP COLUMN JOB;
SELECT * FROM EMP03;

-- 논리적으로 특정 필드를 접근 못하도록 (낮)
ALTER TABLE EMP03 SET UNUSED (DEPTNO); -- 내 눈에는 안보이도록 잠깐 멈춰주는 것.
SELECT * FROM EMP03;
-- 논리적으로 접근 불가했던 필드를 물리적으로 삭제 (새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS; 
    
    
-- 3. 테이블 삭제 (DROP TABLE)
DROP TABLE EMP01; -- 접속에 새로고침 누르고 삭제 확인
DROP TABLE DEPT;  -- 다른 테이블에서 참조하는 데이터가 있을 경우 DROP X


-- 4. 테이블의 모든 행을 제거 (TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; -- EMP03안의 데이터 제거 (취소불가)


-- 5. 테이블명 변경 (RENAME)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2; -- 이름 변경
SELECT * FROM EMP2;   -- 변경된 이름 확인


-- 6. **** 데이터 딕셔너리(사용자 접근 불가) VS. 데이터 딕셔너리 뷰(사용자 접근용) / 다음주 화요일이나 수요일
-- 종류
-- USER_XXX : 현 계정이 소유하고 있는 데이터 객체들 (테이블, 인덱스, 제약조건, 뷰)
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
-- ALL_XXX : 현 계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    -- EX. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
-- DBA_XXX : DBA 권한자만 접근 가능. DBMS의 모든 객체
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS

-- USER_XXX : 현 계정이 소유하고 있는 데이터 객체들 (테이블, 인덱스, 제약조건, 뷰)
SELECT * FROM USER_TABLES;      -- 내 계정(SCOTT)이 소유한 테이블 객체 정보
SELECT * FROM USER_INDEXES;     -- 내 계정이 소유한 인덱스 정보
SELECT * FROM USER_CONSTRAINTS; -- 내 계정이 소유한 제약 조건들
SELECT * FROM USER_VIEWS;       -- 내 계정이 소유한 뷰 정보

-- DBA_XXX
SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

-- ALL_XXX
SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;




-- ★★★ DCL (사용자 게정 생성, 사용자 권한 부여, 권한 박탈, 사용자 계정 삭제) ★★★
-- scott2 계정 생성
CREATE USER scott2 IDENTIFIED BY 1234; -- scott2 계정 생성

-- 권한 부여 (세션권한, scott.EMP, scott.DEPT 테이블에 대해 모든 권한 
GRANT CREATE SESSION TO scott2; -- 철저히 로그인만 가능 (세션권한)
GRANT ALL ON EMP TO scott2;  -- EMP 테이블에 대한 모든 권한 (검색, 삽입, 수정, 삭제 모두 가능)
GRANT ALL ON DEPT TO scott2;
SHOW USER;  

-- 권한 박탈 (권한 박탈할 사용자 계정이 접속해제)
-- EMP TABLE, DEPT TABLE, SESSION 권한
REVOKE ALL ON EMP FROM scott2; -- scott2의 emp 테이블에 대한 모든 권한 박탈
REVOKE ALL ON DEPT FROM scott2; -- ,,
SHOW USER;

-- 사용자 계정 삭제 (접속 중인 계정 삭제 불가) 
-- 접속해제 후에 밑에 문장 실행
DROP USER scott2 CASCADE;



-- ★★★ DML(SELECT, INSERT, UPDATE, DELETE) ★★★
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3,....);
--    INSERT INTO 테이블명 (필드명1, 필드명2.....) VALUES(값1, 값2...);
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60,'IT','SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION');    -- 묵시적으로 LOC에 NULL로 추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES(80, 'HR', NULL); -- 명시적으로 NULL 추가
INSERT INTO DEPT01 VALUES(90, 'SALES', NULL);                   -- 명시적으로 NULL 추가

-- 서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- 트랜잭션 명령어 (DML 명령어만)  // 연습장 공간에 INSERT해놓는 것 (트랜잭션) 
-- COMMIT을 하면 테이블에 들어가는 것이고. ROLLBACK을 하면 원래대로 되돌리는 것
COMMIT;
ROLLBACK;

-- 연습문제. 다음과 같은 구조로 SAM01테이블을 생성하시오. 
-- SAM01의 구조 (EMPNO를 주키로) EMPNO(사번) ? NUMBER(4) ENAME(이름) ? VARCHAR2(10)
-- JOB(직책) ? VARCHAR2(9), SAL(급여) ? NUMBER(7,2)
CREATE TABLE SAM01(
    EMPNO    NUMBER(4) CONSTRAINTS SAM_PK PRIMARY KEY, -- 프라이머리키의 제약조건 이름 설정    
    ENAME    VARCHAR2(10),
    JOB      VARCHAR2(9),
    SAL      NUMBER(7,2) ); -- DDL이라 취소 안됨

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 VALUES (1030, 'VERY', NULL, 25000);
-- INSERT INTO SAM01 VALUES(EMPNO, ENAME, SAL) VALUES(1030,,' VERY', 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 VALUES (7782, 'CLARK', 'MANAGER', 2450);
INSERT INTO SAM01 VALUES (7839, 'KING', 'PRESIDENT', 5000);
INSERT INTO SAM01 VALUES (7934, 'MILLER', 'CLERK', 1300);

INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB,SAL FROM EMP WHERE DEPTNO = 10;

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS; -- 제약조건 이름 확인 // 잘 만들지는 않는다.
DROP TABLE SAM01;



-- 트랜젝션 명령어
COMMIT;
ROLLBACK;


-- 2. UPDATE 테이블명 SET 필드명1 = 값1  [, 필드명2 = 값2, ...] [WHERE 조건];
-- FROM 없음!!

DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP;

    -- EX. EMP01 테이블의 부서번호를 30으로 수정  (WHERE 절 없이는 모든 행이 수정)
    UPDATE EMP01 SET DEPTNO = 30;
    SELECT * FROM EMP01; -- 아직 데이터베이스로 업데이트 전. 업데이트를 위해서는 COMMIT을 반드시 해주어야 한다.
    ROLLBACK;    -- DML 명령만 취소 / 트랜잭션 취소

    -- EX. EMP01 테이블의 모든 사원의 급여를 10%인상
    UPDATE EMP01 
        SET SAL = SAL*1.1;
-- UPDATE 테이블 SET 바꾸고 싶은것 = 바꿀 것

    -- ** EX. 10번 부서 직원의 입사일을 오늘로, 부서번호는 30번으로 수정 (자주 쓰일 예정)
    UPDATE EMP01
        SET HIREDATE = SYSDATE,
            DEPTNO = '30'
        WHERE DEPTNO = 10;

    -- EX. 급여가 3000 이상인 사원만 급여를 10% 인상
    UPDATE EMP01 
        SET SAL = SAL*1.1
        WHERE SAL >= 3000;
    
    -- EX. (서브쿼리 사용) 'DALLAS'에 근무하는 직원의 급여를 1000$ 씩 인상
    UPDATE EMP01
        SET SAL = SAL+1000
        WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
    
    -- EX. SCOTT의 부서번호를 20으로 JOB을 MANAGER로, SAL과 COMM을 500씩 인상,
    --     상사를 KING으로 수정
    UPDATE EMP01 
        SET DEPTNO = 20, 
            JOB = 'MANAGER',
            SAL = SAL + 500,
            COMM = NVL(COMM, 0) + 500,
            MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING')
            WHERE ENAME = 'SCOTT';
            
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
    
    -- EX. DEPT01에서 20부터의 지역명을 DEPT테이블의 60번 부서의 지역명으로 변경
    SELECT * FROM DEPT01;
    -- DEPT테이블에 60번 부서가 존재하지 않으므로 NULL값으로 변경되어 수정된다.
    UPDATE DEPT01 
        SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 60)
        WHERE DEPTNO >= 20; 
    
    -- EX. EMP01 테이블의 모든 사원의 급여와 입사일을 'KING'의 급여와 입사일로 수정
    COMMIT; -- 업데이트 한 것 세팅 해놓고.
    
    UPDATE EMP01 
        SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
            HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    
    UPDATE EMP01 
        SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING');
    
    SELECT * FROM EMP01;
    ROLLBACK;
    
    -- EX. DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
    UPDATE DEPT01 
        SET (LOC, DNAME) = (SELECT LOC, DNAME FROM DEPT01 WHERE DEPTNO = 40)
        WHERE DEPTNO = 20;
    
    SELECT * FROM DEPT01;
    COMMIT;
    
    
-- 3. DELETE FROM 테이블명 [WHERE 조건]; // ROLLBACK 가능 - 삭제
-- TRUNCATE 랑 같은 느낌 (차이점 : ROLLBACK 불가능) - 제거
-- FROM 주의!!! 

SELECT * FROM EMP01;
DELETE FROM EMP01; -- WHERE절을 안 쓸 경우 전체 행이 모두 삭제
ROLLBACK;          -- 되돌리기!

    -- EX. EMP01 테이블에서 'FORD'인 사원을 삭제
    DELETE FROM EMP01 WHERE ENAME = 'FORD';
    SELECT * FROM EMP01 WHERE ENAME = 'FORD';
    
    -- EX. EMP01 테이블에서 30번 부서 직원을 삭제
    DELETE FROM EMP01 WHERE DEPTNO = 30;
    SELECT * FROM EMP01;

    -- (서브쿼리) EMP01 테이블에서 부서명이 RESEARCH인 직원 삭제 
    DELETE FROM EMP01 
        WHERE DEPTNO = (SELECT DEPNTO = FROM DEPT WHERE DNAME = 'RESEARCH');
    
    -- EX. SAM01 테이블에서 JOB이 정해지지 않은 사원을 삭제
    SELECT * FROM SAM01; 
    DELETE FROM SAM01 WHERE JOB IS NULL;
    
    -- EX. SAM01 테이블에서 ENAME이 ORANGE인 사원을 삭제
    DELETE FROM SAM01 WHERE ENAME = 'ORANGE';
    ROLLBACK;
    COMMIT;
    

-- 연습문제 : PDF 1페이지

    CREATE TABLE MY_DATA (
        ID      NUMBER(4) PRIMARY KEY,
        NAME    VARCHAR2(10),
        USERID  VARCHAR2(30),
        SALARY  NUMBER(10,2)
    );
    
    INSERT INTO MY_DATA VALUES (1, 'Scott', 'sscott', 10000.00);
    INSERT INTO MY_DATA VALUES (2, 'Ford',  'fford',  13000.00);
    INSERT INTO MY_DATA VALUES (3, 'Patel', 'ppatel', 33000.00);
    INSERT INTO MY_DATA VALUES (4, 'Report', 'rreport', 23500.00);
    INSERT INTO MY_DATA VALUES (5, 'Good', 'ggood', 44450.00);
    
    SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.99') FROM MY_DATA;
    COMMIT;
    
    UPDATE MY_DATA SET SALARY = 65000.00 WHERE ID = 3;
    COMMIT;
   
    DELETE FROM MY_DATA WHERE NAME = 'Ford';
    COMMIT;
   
    UPDATE MY_DATA SET SALARY = 15000 WHERE SALARY <= 15000;
    COMMIT;
   
    DROP TABLE MY_DATA; -- 삭제
    
    SELECT * FROM MY_DATA;
    
    -- 04.18 월
    -- ★★★ 제약조건 : 부적합한 데이터가 테이블에 삽입, 수정되는 것을 방지하기 위해
    SELECT * FROM EMP;
    INSERT INTO EMP VALUES (7369, '홍', NULL, NULL, SYSDATE, NULL, NULL, 40); -- SMITH 사번과 중복에러
    UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; -- SMITH 사번과 중복에러
    -- (1) ** PRIMARY KEY : 유일하게 테이블의 각 행을 식별. NOT NULL
    INSERT INTO EMP VALUES (NULL, '홍', NULL, NULL, SYSDATE, NULL, NULL, 40); -- 불가
    
    -- (2) NOT NULL : NULL 값을 포함하지 않음
    
    -- (3) UNIQUE : 모든 행에 대해 유일해야 함. NULL 값 허용 (NULL은 여러 행 입력 가능)
    
    -- (4) ** FOREIN KEY : 테이블의 열은 다른 테이블의 열을 참조 (EX. EMP TABLE의 DEPTNO는 DEPT 테이블의 DEPTNO 참조)
    -- 90번 부서가 FOREIN KEY인 DEPTNO가 없기 때문에 에러
    INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (1111, '홍', 90);
        -- 비식별 관계 : 부모 테이블의 주키(PRIMARY KEY)가 자식 테이블의 일반 속성에 속한 필드로 관게를 맺을 때
                        -- exERD 에서 빨간 점선 화살표
        -- 식별 관계  : 부모 테이블의 주키(PRIMARY KEY)가 자식 테이블의 주키(주키군)에 속한 필드로 관계
                        -- exERD에서 초록 점선 화살표
                        
    -- (5) CHECK(조건) : 해당 조건이 만족해야지 INSERT 됨 (NULL값 허용)
    
    -- (*) ** DEFAULT : 기본 값 설정하는 것 (해당 열의 데이터 입력값이 없으면 NULL이 들어감) 
    
    -- 깃보고 다시 정리하기
    DROP TABLE DEPT1;
    CREATE TABLE DEPT1 (
        DEPTNO NUMBER(2) PRIMARY KEY,
        DNAME VARCHAR2(14) UNIQUE, -- 똑같은 부서이름 입력할 수 없음 
        LOC VARCHAR2(13) NOT NULL -- 같은 지역 들어가도 상관 없음, NULL이면 안됨
    );
    DROP TABLE EMP1;
    CREATE TABLE EMP1 (
        EMPNO   NUMBER(4) PRIMARY KEY,
        ENAME   VARCHAR(10) NOT NULL, -- 반드시 입력해야 함
        JOB     VARCHAR2(9),
        MGR     NUMBER(4),
        HIREDATE DATE DEFAULT SYSDATE, -- 기본값으로 오늘 날짜가 들어오게 됨
        SAL     NUMBER(7,2) CHECK(SAL>0), -- NULL값이 들어가도 되지만 값이 들어가게 될 경우 0보다 큰 값이 들어가야함
        COMM    NUMBER (7,2), 
        DEPTNO REFERENCES DEPT1(DEPTNO) );
   
    DROP TABLE EMP1; -- 자식 테이블(참조하는 테이블) 먼저 drop
    DROP TABLE DEPT1; -- 다른 테이블에서 참조하는 필드가 있을 때(부모 테이블은) 먼저 DROP 되지 않음.
    DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- ※ 비추, 참조하는 테이블이 있어도 무시하고 DROP
    
    -- EXERD 보면서 테이블 작성!~!
    -- EXERD는 테이블 설계에 도움을 주는 프로그램!
    CREATE TABLE DEPT1(
        DEPTNO NUMBER(2),
        DNAME VARCHAR2(14),
        LOC VARCHAR2(13) NOT NULL,
        PRIMARY KEY(DEPTNO),
        UNIQUE(DNAME)
    );
    
    CREATE TABLE EMP1(
    EMPNO   NUMBER(4),
    ENAME   VARCHAR2(10) NOT NULL,
    JOB     VARCHAR2(9),
    MGR     NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL     NUMBER(7,2), 
    COMM    NUMBER(7,2),
    DEPTNO  NUMBER(2),
    PRIMARY KEY(EMPNO), 
    CHECK (SAL>0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO) );
    
    -- UNIQUE NOT NULL 이렇게 할 경우에는 겹치면 안되지만 수정은 할 수 있게 해주는 것
    
    -- DEPT1 >>> DEPT 테이블 데이터 삽입
    SELECT * FROM DEPT1;
    INSERT INTO DEPT1 SELECT * FROM DEPT; -- DEPT 테이블 데이터 삽입 
    INSERT INTO DEPT1 VALUES(40, 'IT', 'SEOUL'); -- PK 제약조건 위반 / DEPTNO에 40번 존재함!
    INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- UNIQUE 제약조건 위배 / SALES 가 이미 존재
    INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL 제약조건 위배

    -- EMP1    
    SELECT * FROM EMP1;
    INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO) 
        VALUES(1001, '홍', 10); -- 정상 삽입 / HIREDATE에 설정된 기본값 입력 (SYSDATE)/ 회원가입할 경우 주로 이용
    INSERT INTO EMP1 (EMPNO, ENAME, DEPTNO)
        VALUES (1001, '김', 10); -- UNIQUE 제약조건 위배
    INSERT INTO EMP1 (EMPNO, DEPTNO)
        VALUES (1002, 20); -- ENAME인 NOT NULL 제약조건 위배
    INSERT INTO EMP1 (EMPNO, ENAME, SAL)
        VALUER (1002, '박', -1); -- CHECK SAL>0 위배
    INSERT INTO EMP1 
        VALUES (1002, '윤', NULL, NULL, TO_DATE('95/01/01', 'YY/MM/DD'), 900, NULL, 99); -- FK 위배
    -- TO_DATE로 나라마다 다른 날짜 형식으로 헷갈리지 않기 위해 지정
    
    -- 자식 클래스부터 지우기!
    
    
    -- 연습문제 (pdf 4,5 page)
    -- eXERD 설계한대로 작성하기
    -- BOOKCATEGORY TABLE
    DROP TABLE BOOKCATEGORY;
    CREATE TABLE BOOKCATEGORY(
        CATEGORY_CODE NUMBER(3) PRIMARY KEY,
        CATEGORY_NAME VARCHAR2(50) UNIQUE,
        OFFICE_LOC    VARCHAR2(50) NOT NULL
    );
    SELECT * FROM BOOKCATEGORY;
    INSERT INTO BOOKCATEGORY VALUES (100, '철학', '3층 인문실');
    INSERT INTO BOOKCATEGORY VALUES (200, '인문', '3층 인문실');
    INSERT INTO BOOKCATEGORY VALUES (300, '자연과학', '4층 과학실');
    INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4층 과학실');
    
    COMMIT;
    
    -- BOOK TABLE 
    CREATE TABLE BOOK(
        CATEGORY_CODE NUMBER(3),
        BOOKNO        VARCHAR2(10) PRIMARY KEY,
        BOOKNAME      VARCHAR2(50),
        PUBLISHER     VARCHAR2(50),
        PUBYEAR       NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE),
        -- TO_CHAR(SYSDATE, 'YYYY') 이렇게 넣어도  알아서 변형된다.
        FOREIGN KEY(CATEGORY_CODE) REFERENCES BOOKCATEGORY(CATEGORY_CODE)
    );
    
    INSERT INTO BOOK VALUES (100, '100A01', '철학자의 삶', '더존출판', 2021);
    INSERT INTO BOOK VALUES (400, '400A01', '이것이 DB다', '더존출판', 2018);
    
    SELECT * FROM BOOK;
    COMMIT;
    
    -- 5페이지
    -- MAJOR TABLE 
    CREATE TABLE MAJOR (
        MAJOR_CODE      NUMBER(1) PRIMARY KEY,
        MAJOR_NAME      VARCHAR2(30) UNIQUE,
        MAJOR_OFFICE_LOC VARCHAR2(40) NOT NULL
    );
    
    INSERT INTO MAJOR VALUES(1, '경영정보', '경영관 305호');
    INSERT INTO MAJOR VALUES(2, '소프트웨어공학', '정보관 808호');
    INSERT INTO MAJOR VALUES(3, '디자인', '예술관 606호');
    INSERT INTO MAJOR VALUES(4, '경제', '경상관 202호');
    
    SELECT * FROM MAJOR;
    COMMIT;
    
    -- STUDENT TABLE
    DROP TABLE STUDENT;
    CREATE TABLE STUDENT(
        STUDENT_CODE VARCHAR2(3) PRIMARY KEY,
        STUDENT_NAME VARCHAR2(10) NOT NULL,
        SCORE        NUMBER(3) CHECK (SCORE>=0 AND SCORE<=100), -- SCORE BETWEEN 0 AND 100;
        MAJOR_CODE   NUMBER(1),
        FOREIGN KEY(MAJOR_CODE) REFERENCES MAJOR(MAJOR_CODE)        
    );
    
    INSERT INTO STUDENT VALUES('A01', '김길동', 100, 1);
    INSERT INTO STUDENT VALUES('A02', '문길동', 90, 2);
    INSERT INTO STUDENT VALUES('A03', '홍길동', 95, 1);    
    
    SELECT * FROM STUDENT;
    COMMIT;
    
