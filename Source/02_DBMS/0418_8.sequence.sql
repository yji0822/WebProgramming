
 -- [VIII] SEQUENCE :  순차번호 생성기
 --        대부분 인위적인 PK 사용 용도. 의미가 있는건 아님 그냥 순차적으로 사용하는 것
 
 -- 테이블을 만들때 PRIMARY KEY로 사용하기 위함!
 -- FRIEND_SEQ라는 SEQUENCE를 삭제하는 것 / DDL : 취소불가능
 -- DDL은 한번 수행할때마다 사전이 변경된다.
 -- START WITH : 디폴트값 = 1! (선택)
 -- INCREMENT BY : 디폴트값 1, 선택 ** 뜻? 1씩 증가한다.
 -- SEQUENCE의 번호타입을 4자리로 해놓았다면 9999까지만 가능하다
 -- *** NOCACHE : 캐시 메모리에 아무것도 쌓이지 않는 것 / 대개 18개 쌓아놓음 ***
                -- 해놓지 않으면 갑자기 20씩 번호가 튈 수 있음
 -- *** NOCYCLE : MAXVALUE가 다 돌아가고 나면 1로 돌아가는 것이 아니고 에러를 발생하는 것
 -- MAXVALUE : 지정해놓지 않았으면 38자리 숫자까지 계속해서 증가된다.
    DROP SEQUENCE FRIEND_SEQ;
    CREATE SEQUENCE FRIEND_SEQ
        START WITH 1
        INCREMENT BY 1
        MAXVALUE 9999
        MINVALUE 1
        NOCACHE
        NOCYCLE;
    
    CREATE SEQUENCE FRIEND_SEQ 
        MAXVALUE 9999; -- 1부터 1개씩 증가되는데 MAX 숫자는 9999!
    
    SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; -- 실행할때마다 1씩 증가가 되는 것
    
    -- SEQUENCE 삭제 및 생성
    DROP SEQUENCE FRIEND_SEQ;
    CREATE SEQUENCE FRIEND_SEQ
        MAXVALUE 9999
        NOCACHE
        NOCYCLE;
        
    DROP TABLE FRIEND;
    CREATE TABLE FRIEND(
        NUM     NUMBER(4)    PRIMARY KEY, -- 시퀀스 이용 MAXVALUE와 타입을 일치 시켜준다!!
        NAME    VARCHAR2(30) NOT NULL, -- NULL 입력하면 안됨
        TEL     VARCHAR2(30) UNIQUE,  -- 전화번호는 중복이 안됨! NULL 허용
        ADDRESS VARCHAR2(300),
        LAST_MODIFYED DATE DEFAULT SYSDATE -- 최근 수정일 날짜형 디폴트값은 오늘 날짜
        );
    
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
        VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울시 용산구'); -- 3번 실행
        
    SELECT * FROM FRIEND;
    
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
        VALUES (FRIEND_SEQ.NEXTVAL, '박길동', '010-9999-9999', '서울시 강남구 강남대로94길 13 삼겸빌딩 402');
    -- 
    SELECT * FROM FRIEND;
    
    -- NUM으로 6번이 출력이 되게 됨
    INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
        VALUES(FRIEND_SEQ.NEXTVAL, '신길동', '010-8888-8888', '서울시 영등포구');
    
    -- 
    SELECT FRIEND_SEQ.CURRVAL FROM DUAL; -- 현재 시퀀스 값
    COMMIT;
    
    -- EX. 초기값 101부터 최대값 999,999까지 1씩 증가하는 TEST_SEQ 시퀀스를 생성
    CREATE SEQUENCE TEST_SEQ START WITH 101 MAXVALUE 999999 NOCACHE NOCYCLE;
    SELECT TEST_SEQ.CURRVAL FROM DUAL; -- 시퀀스의 현재 값이 없어서 에러
    SELECT TEST_SEQ.NEXTVAL FROM DUAL; 
    -- 다음 값 증가해주는 것 // 하나를 무조건 실행해줘야 위의 값이 출력된다.

    
    -- 연습문제 // SEQUENCE DOC파일 3페이지
    -- MEMBER_LEVEL
    DROP TABLE MEMBER_LEVEL;
    CREATE TABLE MEMBER_LEVEL(
        LEVELNO   NUMBER(1) PRIMARY KEY,
        LEVELNAME VARCHAR2(10) NOT NULL
    );  
    
    INSERT INTO MEMBER_LEVEL VALUES(-1, 'BALCK');
    INSERT INTO MEMBER_LEVEL VALUES(0, '일반');
    INSERT INTO MEMBER_LEVEL VALUES(1, '실버');
    INSERT INTO MEMBER_LEVEL VALUES(2, '골드');
    
    SELECT * FROM MEMBER_LEVEL;
    COMMIT;
    
    -- SEQUENCE 
    DROP SEQUENCE MEMBER_MNO_SQ;
    CREATE SEQUENCE MEMBER_MNO_SQ
        MAXVALUE 9999
        NOCACHE
        NOCYCLE;
    
    -- MEMBER TABLE 
    DROP TABLE MEMBER;
    CREATE TABLE MEMBER(
        mNO    NUMBER(2)    PRIMARY KEY,
        mNAME  VARCHAR2(20) NOT NULL,
        mPW    VARCHAR2(9)  CHECK(LENGTH(mPW)< 9),
        mMAIL  VARCHAR2(30) UNIQUE,
        mPOINT NUMBER(9)    CHECK(mPOINT>=0),
        mRDATE DATE         DEFAULT SYSDATE,
        LEVELNO NUMBER(1),
        FOREIGN KEY(LEVELNO) REFERENCES MEMBER_LEVEL(LEVELNO) 
    );
    
    INSERT INTO MEMBER VALUES(MEMBER_MNO_SQ.NEXTVAL, '홍길동', 'aa', 'hong@hong.com', 0, '22/03/10', 0);
    INSERT INTO MEMBER VALUES(MEMBER_MNO_SQ.NEXTVAL, '신길동', 'bb', 'sin@sin.com', 1000, '22/04/01', 1);    
    
    SELECT * FROM MEMBER;
    
    -- 테스트 출력 내용
    SELECT mNO, mNAME, mRDATE, mMAIL, mPOINT, LEVELNAME || '고객'
        FROM MEMBER M, MEMBER_LEVEL L
        WHERE M.LEVELNO = L.LEVELNO; 
    
    COMMIT;