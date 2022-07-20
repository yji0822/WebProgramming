
-- ch14의 예제 
-- xml 파일에서는 sql문 하나당 아이디가 하나씩 생성이 된다.

-- Dept.xml의 id=deptList
SELECT * FROM DEPT;

-- Emp.xml의 id=empList
SELECT * FROM EMP WHERE 1=1
    AND ENAME LIKE '%'||'A'||'%'
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO=20; 

delete from dept where deptno=90;
commit;