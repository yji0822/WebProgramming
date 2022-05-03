-- ** 프로그램을 나왔다가 들어왔을 시에는 무조건 " use kimdb; " 를 해주어야 한다!!!!

-- oracle과 Mysql이랑 차이점 관련해서만 다룰 예정

-- DCL (계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건, FOREIGN KEY 좀 다른 것, SEQUENCE 없음. 해결방법)
-- DML (outer join, AND 연산자 = &&, OR연산자 = ||, 일부단행행함수 차이점

show databases; -- database list 보기

------ ★★★ DCL (계정생성, 권한부여, 권한박탈, 계정제거)
-- 계정생성
-- create user user01 identified by tiger; -- 에러 oracle 방식
create user user01 identified by 'password'; -- pw에만 ''를 붙인다. (계정생성) | user01 (아이디) password(비번)

-- 권한부여
-- grant dba to user01; -- oracle
grant all privileges on *.* to user01; -- 모든 데이터베이스에 대해서 모든 권한을 가지는 것 (권한부여)

-- user01로 접속 > home > 캡처 확인

-- 권한박탈
revoke all on *.* from user01;
-- drop user user01 cascade; -- oracle
-- 계정삭제
drop user user01;



------ ★★★ DDL (테이블생성, 제약조건 차이, 시퀀스x)
-- 1. 데이터 베이스 생성 및 접속
-- 데이터베이스로 들어가는 작업을 먼저 해주어야 한다. 
show databases; 		-- 데이터베이스가 어떤 것이 있는지 확인
create database kimdb; 	-- kimdb라는 데이터베이스 생성
use kimdb; 				-- kimdb 데이터베이스 영역으로 접속
select database();      -- 현재 들어와 있는 데이터베이스 확인
use world;				-- world 데이터베이스 영역으로 접속 (kimdb > world)
use kimdb;				-- kimdb 데이터베이스로 접속 (world > kimdb)

-- 2. 현재 접속된 데이터베이스에 테이블이 존재하는지 확인
-- select * from tab; -- oracle
show tables; 

-- 3. 테이블 생성
create table emp (
	empno 	 numeric(4)   primary key,
    ename    varchar(2)   not null,
    nickname varchar(20)  unique,
    sal	     numeric(7,2) check (sal>0),
    hiredate datetime     default now(),  -- sysdate()
    comm     numeric(7,2) default 0
);
-- date, datetime 차이... date(date) datetime(date+time) time(time)
-- 데이터베이스를 선택해준 다음에 테이블을 생성해주어야 한다!!!

select * from emp;

-- 4. 테이블 삭제
-- drop table emp; -- oracle
drop table if exists emp; -- 있으면 테이블 지워라!


-- Major(mCode(시퀀스 같은 순차번호) : PK, mName, Moffice)
-- Student (sNo:PK, sName, mCode) 
-- mCode는 외래키

-- 부모테이블 major
create table major(
	mCode   int 		primary key auto_increment, -- auto_increment일 경우 int 반드시 int형으로 넣어야 한다.
    mName   varchar(20),
    mOffice varchar(50)
);
-- 자식테이블 student
create table student(
	sNo int primary key,
    sName varchar(20),
    mCode int references major(mCode) -- 외래키 제약조건
);

insert into major (mName, mOffice) values ('컴공', '402호');
insert into major (mName, mOffice) values ('경영', '502호');
insert into major (mName, mOffice) values ('경제', '301호');

select * from major; 

insert into student values(1111, '홍', 1); -- 삽입o
insert into student values(2222, '이', 2); -- o
insert into student values(3333, '사', 3); -- o
insert into student values(3333, '박', 3); -- x
insert into student values(4444, '박', 4); -- 어라...? 들어가지네...? foreign key로 연결이 안되었다....?
-- 외래키 제약조건은 테이블 생성 시에 무조건 밑에다가 써주어야 한다.

select * from student;

-- 테이블 삭제
drop table if exists student;
drop table if exists major;

-- 테이블 재생성
-- 부모테이블 major
create table major(
	mCode   int 		auto_increment, -- auto_increment일 경우 int 반드시 int형으로 넣어야 한다.
    mName   varchar(30) not null,
    mOffice varchar(30),
    primary key (mCode)
);
-- 자식테이블 student
create table student(
	sNo 	int,
    sName 	varchar(30),
    mCode 	int,
    primary key(sNo),
    foreign key(mCode) references major(mCode)
);
insert into major (mName, mOffice) values ('컴공', '402호');
insert into major (mName, mOffice) values ('경영', '502호');
insert into major (mName, mOffice) values ('경제', '301호');

select * from major; 

insert into student values(1111, '홍', 1); -- 삽입o
insert into student values(2222, '이', 2); -- o
insert into student values(3333, '사', 3); -- o
insert into student values(3333, '박', 3); -- x
insert into student values(4444, '박', 4); -- X 외래키 동작 확인


-- equi join
-- 학번, 이름, 학과코드, 학과명, 사무실 출력
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode = m.mCode;
    

-- 자바와 connection을 위한 테이블 생성
-- 자바(JDBC) 수업 시간에 필요한 테이블 생성
drop table if exists personal;	-- emp 테이블과 유사
drop table if exists division;  -- dept 테이블과 유사

create table division(
	dno int, 		   -- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);
insert into division values (10, 'finance', '02-545-5555', '강남');
insert into division values (20, 'research', '02-777-7777', '회현');
insert into division values (30, 'sales', '02-333-3333', '서초');
insert into division values (40, 'marketing', '02-666-6666', '과천');
select * from division;

create table personal(
	pno     int, 				  -- 사번
    pname   varchar(20) not null, -- 사원명
    job     varchar(20) not null, -- 직책
    manager int, 				  -- 상사의 사번
    startdate date,				  -- 입사일
    pay       int,                -- 급여
    bonus     int,                -- 상여
    dno       int,                -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)
);

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from personal;

commit; -- 테이블 데이터베이스에 저장


------ ★★★ DML (outer join, 단일행함수 일부, top-N구문, and=&&, or=|| 연결연산자는 concat!)
-- 연습 문제
-- division : dno dname phone position
-- personal : pno pname job manager statdate pay bonus dno

-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호 in 연산자 
select pno, pname, dno from personal where dno in (10, 20);
select pno, pname, dno from personal where dno=10 or dno=20;
select pno, pname, dno from personal where dno=10 || dno=20;

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬 is null
select pno, pname, pay from personal where bonus is null order by pay desc;

-- 5. 사번, 이름, 부서번호, 급여 출력. 부서번호 순 정렬 같으면 PAY 큰순 order by 
select pno, pname, dno, pay from personal order by dno, pay desc;

-- 6. 사번, 이름, 부서명 equi join
select pno, pname, dname from personal p, division d
	where p.dno = d.dno;

-- 7. 사번, 이름, 상사이름 self join - java에 넣을 경우에는 별칭을 주어서 구분 해주어야 한다.
select w.pno, w.pname "w_name" , m.pname "m_name" from personal w, personal m
	where w.manager = m.pno;
-- arraylist에 넣는 작업 - 금요일

-- ** 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없으면 null 대신 'ceo') - outer join, nvl
select w.pno, w.pname, ifnull(m.pname, 'ceo')
	from personal w left outer join personal m
    on w.manager = m.pno;
-- outer join left outer join, 순서대로 적는 것 / 오른쪽에 데이터가 없어서 left outer join
-- nvl 대신에 ifnull 이란 함수로 대체

select w.pno, w.pname, if(m.pname is null, 'CEO', m.pname) -- NULL이면 CEO를 출력하고 아니면 PNAME 실행 
	from personal w left outer join personal m
    on w.manager = m.pno;
    
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal where pname like 's%';
select pname from personal where substr(pname, 1, 1) = 's';

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pno, w.pname, w.pay, dname, m.pname
	from personal w, division d, personal m
    where w.dno = d.dno and w.manager = m.pno;

select w.pno, w.pname, w.pay, dname, m.pname
	from personal w, division d, personal m
    where w.dno = d.dno && w.manager = m.pno;

-- 11. 부서코드, 급여합계, 최대급여 / 그룹함수
select dno, sum(pay), max(pay) from personal group by dno;

-- 12. 부서명, 급여평균, 인원수 / 그룹함수
select dname, avg(pay), count(pno) from personal p, division d
	where p.dno = d.dno group by dname;

-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력 - having (그룹함수의 조건)
select dno, sum(pay), count(pno) from personal group by dno having count(pno) >= 4;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람 - 단일행 subquery
select pno, pname, pay 
	from personal 
    where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno from personal where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정렬 같으면 급여 큰순
select pname, pay, p.dno, dname from personal p, division d
	where p.dno = d.dno
		and pay > (select avg(pay) from personal) 
    order by dname, pay desc;

-- ** 17. 자신이 속한 부서의 평균보다 많이 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select dno, round(avg(pay),2) from personal group by dno;
select dno, avg(pay) from personal group by dno;

-- 서브쿼리
select pname, pay, dno, (select round(avg(pay),2) from personal where p.dno = dno) "avg_pay"
	from personal p
    where pay > (select avg(pay) from personal where p.dno = dno group by dno);
-- 인라인 뷰
select pname, pay, p.dno, avgpay
	from personal p, (select dno, avg(pay) avgpay from personal group by dno) g
    where p.dno=g.dno && 
				pay > (select round(avg(pay)) from personal where dno=p.dno);

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname, startdate from personal p, division d 
	where p.dno = d.dno 
    and startdate = (select min(startdate) from personal);

-- ** 19. 이름, 급여, 해당부서평균
select pname, pay, (select round(avg(pay),2) from personal where p.dno = dno) "avg_pay"
	from personal p;

-- ** 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, d.dno, (select round(avg(pay),2) from personal where p.dno = dno)  "avg_pay"
from personal p, division d
where p.dno = d.dno;



------ Oracle에서의 단일행함수와 MySQL 컬럼 함수의 다른 부분

select round(789.56, 2) from emp; -- orcle
select round(789.56,2); -- from 생략가능

select pname || '은' || job || '이다' from personal; -- X oracle / mysql에서는 or연산자임
select concat(pname, '은 ', job, ' 이다') from personal; -- 연결하고 싶은 것을 괄호안에 넣어주면 됨

-- 날짜 관련 컬럼 함수 (personal table의 startdate 타입: datetime)
-- EXTRACT와 같은 함수
select startdate from personal; 
select startdate, year(startdate), month(startdate), day(startdate), 
			hour(startdate), minute(startdate), second(startdate) from personal; 

-- date_format(날짜 or 시간형데이터, '포맷') : 날짜형을 문자형으로 전환
	-- 포맷글자 : %y 연도2자리   %Y: 연도4자리 
	--         %M 월이름(April)   %b 짧은월이름   %m 04월   %c 4(월수)
    --         %d 20,01,02,03,,, (일2자리)     %e 20,1,2,3
    --         %H 24tlrks   %h 12시간    %p 오전오후    %i분    %s 초
    -- =>>> to_char(날짜형데이터, '포맷') / oracle : yy/mm/dd

-- ex. 시스템으로부터 현재 날짜와 시간
select sysdate(); 
select now();
-- ex. 시스템으로부터 현재 날짜
select current_date();
select curdate();
-- ex. 시스템으로부터 현재 시간 
select current_time();
select curtime();

select date_format(now(), '%Y년%m월%e일 %p %h시%i분');

    
-- format(숫자데이터) : 무조건 3자리마다 ',' 출력
-- format(숫자데이터, 소수점 자릿수) : 소수점 확보되면서 3자리 콤마 추가
select format(pay, 1) from personal;

-- workbench에서 데이터 삭제하고 수정 (where절에 primary key를 이용한 비교)
insert into personal (pno, pname, job, manager, startdate, pay, bonus, dno)
	values (1000, 'hong', 'manager', 1001, curdate(), 9000, 900, 40);
select * from personal;
commit;
set sql_safe_updates = 0; -- 업데이트가 가능하도록 바꾸는 것. workbench 문법
delete from personal where pname = 'hong'; -- 삭제X - workbench에서 못하도록 잠시 막음
select * from personal;
commit;


------ ★★★ TOP-N 구문
select rownum, pno from personal; -- oracle O, mysql은 rownum이 없음
select pname, pay from personal order by pay desc; 

-- limit n (1~n등까지 가지고 오는 것)
-- limit 3,3 (4~6등까지) - 0번부터 인덱스가 시작하므로 3은 4번째를 나타내고 3개 출력한단 의미
-- limit 5,4 (6~9등까지)
select pname, pay from personal order by pay desc limit 5;   -- 1~5등 출력  (1등부터 5개 추출)
select pname, pay from personal order by pay desc limit 3, 3; -- 4~6등 출력 (4등부터 4개 추출)
select pname, pay from personal order by pay desc limit 5, 4; -- 6~9등 출력 (6등부터 4개 추출)