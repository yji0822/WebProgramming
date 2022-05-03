
-- [XI] 인덱스 : 조회를 빠르게 하기 위해 사용!!!
--- 인덱스를 만들지 않아도 프라이머리 키를 만들면 자동으로 인덱스로 잡힌다.

SELECT * FROM USER_INDEXES; -- 딕셔너리 뷰에서 SCOTT이 소유한 인덱스 정보
DESC EMP;

DROP TABLE EMP01;                                 -- ★ 전에 생성된 테이블 삭제
CREATE TABLE EMP01 AS SELECT * FROM EMP;          -- ★ EMP과 데이터가 같은 EMP01 생성
SELECT * FROM EMP01;                              -- 14행 모두 복사된 것 확인
INSERT INTO EMP01 SELECT * FROM EMP01;            -- ★ 데이터 늘리는 작업 : 1번 수행 > 28행 / 2번 수행 > 56행
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01; -- 행 개수 확인 (TO_CHAR로 데이터 모양 변형)
INSERT INTO EMP01 SELECT * FROM EMP01;            -- ★ 총 11번 수행으로 데이터 부풀리기 114,688
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40); 
INSERT INTO EMP01 SELECT * FROM EMP01;            -- ★ 3번 실행 917,512 행

-- 인덱스 생성 전 조회
SELECT * FROM EMP01 WHERE ENAME = 'HONG';      -- 0.016초 
-- 인덱스 생성(EMP01테이블의 ENAME)하고 조회
CREATE INDEX IDX_EMP01_ENAME ON EMP01 (ENAME); -- 0.374초
-- 인덱스 생성 후 조회
SELECT * FROM EMP01 WHERE ENAME = 'HONG';      -- 0.001초
-- 데이터 딕셔너리에 인덱스 추가된 것 확인
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP01_ENAME';
-- 인덱스 생성 후 INSERT 속도
COMMIT;                                 -- 90만개 데이터
INSERT INTO EMP01 SELECT * FROM EMP01;  -- 90만개 추가, 22.572초 정도 소요
-- 인덱스 제거
ROLLBACK;                               -- INSERT 한것 제거 90만개로 돌아옴. 취소 속도 10초 소요
DROP INDEX IDX_EMP01_ENAME;             -- 인덱스 제거
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01; -- 행 개수 확인
INSERT INTO EMP01 SELECT * FROM EMP01;  -- 인덱스 제거 후 INSERT 속도 : 2.8초




