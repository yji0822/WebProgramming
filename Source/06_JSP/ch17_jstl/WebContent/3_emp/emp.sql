
-- DAO QUERY

-- 1. 전체리스트 출력
-- 테이블 구조와 DTO구조가 동일하다 (아닌 경우에는 JOIN 사용)
SELECT * FROM EMP;

-- 2. 검색 : 이름+직책
-- 쿼리에서 할 수 있는 것은 쿼리에서 적어주자. (자바 코드가 훨씬 간결해진다)
-- 자바에서 UPPER를 넣을지, 자바에서 넣을지는 프로그래머 마음
SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER('A')||'%' AND JOB LIKE '%'||UPPER('E')||'%';

-- 페이징을 하기 위해서는 1번과 2번을 모두 페이징 작업을 해주어야 한다.