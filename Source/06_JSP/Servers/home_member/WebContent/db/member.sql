
-- TABLE DROP & CREATE
DROP TABLE MEMBER;
DROP TABLE MEMBER CASCADE CONSTRAINTS; -- 강제 삭제

CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY, -- 아이디
    PW VARCHAR2(30) NOT NULL, -- 비밀번호
    NAME VARCHAR2(30) NOT NULL, -- 이름
    PHONE1 VARCHAR2(5), -- 국번
    PHONE2 VARCHAR2(5), -- 중간번호
    PHONE3 VARCHAR2(5), -- 뒷번호
    GENDER VARCHAR(1), -- 성별
    EMAIL VARCHAR2(30), -- 이메일
    BIRTH DATE , -- 생일
    RDATE DATE NOT NULL, -- 가입일
    ADDRESS VARCHAR2(200) -- 주소
);

-- 1. 회원가입 시 ID 중복 체크를 위한 SQL : public int confirmId(String id)
-- 회원가입 가능 시 1, 불가 시 0
SELECT * FROM MEMBER WHERE ID = 'aaa';

-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)
        VALUES ('aaa', '111', '홍길동', '02', '1111', '1111', 'm', 'hong@h.com', '1995-12-12', SYSDATE, '서울');

-- 3. 로그인(id/pw) : public int loginCheck(String id, String pw)
SELECT ID, PW FROM MEMBER WHERE ID = 'aaa';

-- 4. ID로 dto 가져오기(로그인 성공 시) : public MemberDto getMember(String id)
-- 멤버 객체 자체를 넣을 것임
SELECT * FROM MEMBER WHERE ID = 'aaa';

-- 5. 회원정보 수정 : public int memberDto modifyMember(MemberDto dto)
-- 입력한 정보를 가지고 dto를 가지고 오기 - 세션에 있는거 뿌려오기
-- 수정한 후에 update가 가능하도록
UPDATE MEMBER SET PW = '111', 
                  NAME = '신길동', 
                  PHONE1 = '010',
                  PHONE2 = '9999',
                  PHONE3 = '8888',
                  GENDER = 'm',
                  EMAIL = 'a@A.COM',
                  BIRTH = '1990-12-01',
                  ADDRESS = '안양'
        WHERE ID ='aaa';

SELECT * FROM MEMBER;

COMMIT;